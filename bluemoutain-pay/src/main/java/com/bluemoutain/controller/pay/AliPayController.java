package com.bluemoutain.controller.pay;

import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;

import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.controller.pay.process.VipModePayProcess;
import com.bluemoutain.controller.pay.process.VipNotifyProcess;
import com.bluemoutain.crond.process.NotifyThread;
import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemVip;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付宝 支付 和回调
 */
@Controller
@RequestMapping("/payment")
public class AliPayController {

    private static Logger logger = LoggerFactory.getLogger(AliPayController.class);

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private OrderService orderService;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private UserBalnesChange userBalnesChange;

    @Autowired
    private VipService vipService;

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private UserService userService;

    /**
     * 支付宝
     */
    @RequestMapping("/alipay")
    public String alipay(Integer id, Model model, Boolean isMobile) throws Exception {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单id错误,请返回重试!");
        }
        SystemUser user = userService.findUserById(order.getUid());
        if (order.getPayType() == 2) {
            if (order.getOrderType() == 1 | order.getOrderType() == 3) {
                if (user.getPayAlipay() != 0) {
                    orderService.deleteOrder(order.getId());
                    throw new Exception("您无权使用当前支付接口(支付宝支付),详情联系系统管理员! ");
                }
            }
        }
        if (order.getStatus() == 2) {
            throw new Exception("订单已支付,请勿重复发起支付请求!");
        } else {
            String url = "";
            if (isMobile) {
                url = aliPayFunction.wap_pay(order);
            } else {
                url = aliPayFunction.pc_pay(order);
            }
            model.addAttribute("model", url);
        }
        return "pay/yipay";
    }

    /**
     * 支付宝支付回调
     */
    @RequestMapping("/alipay_notify")
    public void alipay_notify(HttpServletRequest request, HttpServletResponse response, String out_trade_no, String trade_no, String trade_status) throws Exception {
        Map<String, String[]> requestParams = request.getParameterMap();
        logger.info("支付宝支付通知...");
        Map<String, String> params = new HashMap<String, String>();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        PrintWriter writer = response.getWriter();
        SystemWeb systemWeb = webConfigService.find_by_id(1);
        BigDecimal webPayStaff1;
        boolean rsaCheckV2 = AlipaySignature.rsaCheckV1(params, aliPayFunction.getOpen_public_key(), "utf-8", AlipayConstants.SIGN_TYPE_RSA2);
        if (rsaCheckV2 && "TRADE_SUCCESS".equals(trade_status)) {
            SystemOrder order = orderService.findOrderById(new Integer(out_trade_no));
            if (order != null && order.getStatus() != 2) {
                if (order.getOrderType() == 2) {
                    webPayStaff1 = new BigDecimal(0.00);
                } else {
                    SystemUser user = userService.findUserById(order.getUid());
                    SystemVip vip = vipService.find_vip_by_uid(order.getUid());
                    if (vip == null) {
                        webPayStaff1 = user.getPayStaff();
                    } else {
                        if (vip.getStatus() == 1) {
                            webPayStaff1 = user.getVipPayStaff();
                        } else {
                            webPayStaff1 = user.getPayStaff();
                        }
                    }
                }
                BigDecimal total_fee = new BigDecimal(params.get("total_amount"));
                BigDecimal sub = total_fee.multiply(webPayStaff1).setScale(2, BigDecimal.ROUND_HALF_UP);
                order.setPaid(total_fee);
                order.setStatus(2);
                order.setTradeStatus(trade_status);
                order.setTradeNo(trade_no);
                order.setPaidTime(new Date());
                order.setChangeSett(sub);
                order.setIsSett(1);
                orderService.updateOrder(order);
                if (order.getOrderType() == 2) {
                    order.setChangeSett(new BigDecimal("0.00"));
                    orderService.updateOrder(order);
                    logger.info("回调处理注册订单成功:" + order.getOutOrderId());
                } else if (order.getOrderType() == 4 && order.getChType() == 1) {
                    VipNotifyProcess process = new VipNotifyProcess(orderService, order.getId(), vipService, systemWeb.getVipMethod());
                    Thread thread = new Thread(process);
                    thread.setDaemon(true);
                    thread.start();
                    logger.info("回调处理会员购买/续费订单成功:" + order.getOutOrderId());
                } else {
                    BigDecimal final_money = total_fee.subtract(sub).setScale(2, BigDecimal.ROUND_HALF_UP);
                    boolean b = userBalnesChange.addUserBalnes(order.getUid(), final_money);
                    logger.info("回调处理:订单:" + order.getOutOrderId() + " 处理成功,金额:" + final_money.doubleValue() + " 手续费:" + sub.doubleValue() + " 状态:" + b);
                    if (order.getOrderType() == 3) {
                        NotifyThread notifyThread = new NotifyThread(orderService, order.getId(), yiPayFunction);
                        Thread thread = new Thread(notifyThread);
                        thread.setDaemon(true);
                        thread.start();
                    }
                    if (order.getChType() == 2) {
                        VipModePayProcess payProcess = new VipModePayProcess(orderService, userBalnesChange, settLementService, order.getId(),
                                vipService, userService, systemWeb, wxPayFunctionPC, aliPayFunction);
                        Thread thread = new Thread(payProcess);
                        thread.setDaemon(true);
                        thread.start();
                    }
                }
            }
            writer.write("success");
        } else {
            writer.write("failure");
        }
        writer.flush();
        writer.close();
    }

}
package com.bluemoutain.controller.pay;


import com.bluemoutain.controller.pay.process.NotifyThread;
import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.controller.pay.process.VipModePayProcess;
import com.bluemoutain.controller.pay.process.VipNotifyProcess;
import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.QQPayFunction;
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
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.TreeMap;

/**
 * QQ支付 - 相关 api
 */
@Controller
@RequestMapping("/payment")
public class QQPayController {

    private static Logger logger = LoggerFactory.getLogger(QQPayController.class);

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private OrderService orderService;

    @Autowired
    private QQPayFunction qqPayFunction;

    @Autowired
    private UserBalnesChange userBalnesChange;

    @Autowired
    private VipService vipService;

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private UserService userService;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private AliPayFunction aliPayFunction;


    /**
     * qq支付 - 扫码
     */
    @RequestMapping("/qqpayScanCode")
    public String qqpay(Model model, Integer id, HttpServletRequest request) throws Exception {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单id错误,请返回重试!");
        }
        SystemUser user = userService.findUserById(order.getUid());
        if (order.getPayType() == 3) {
            if (order.getOrderType() == 1 | order.getOrderType() == 3) {
                if (user.getPayQqpay() != 0) {
                    orderService.deleteOrder(order.getId());
                    throw new Exception("您无权使用当前支付接口(QQ支付),详情联系系统管理员! ");
                }
            }
        }
        if (order.getStatus() == 2) {
            throw new Exception("订单已支付,请勿重复发起支付请求!");
        } else {
            String codeUrl = qqPayFunction.getScanCodeUrl(order, yiPayFunction.getDomain() + "/payment/qqpay_notify");
            model.addAttribute("model", codeUrl);
            model.addAttribute("order", order);
        }
        return "pay/qqpay";
    }

    /**
     * qq支付回调
     */
    @RequestMapping("/qqpay_notify")
    public void qqpay_notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("QQ支付回调...");
        InputStream inputStream;
        StringBuffer sb = new StringBuffer();
        PrintWriter writer = response.getWriter();
        inputStream = request.getInputStream();
        String s;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null) {
            sb.append(s);
        }
        in.close();
        inputStream.close();
        TreeMap<String, String> param = qqPayFunction.xml2map(sb.toString());
        boolean sign = qqPayFunction.checkSign(param);
        if (sign && "SUCCESS".equals(param.get("trade_state"))) {
            SystemWeb systemWeb = webConfigService.find_by_id(1);
            BigDecimal webPayStaff1;
            SystemOrder order = orderService.findOrderById(new Integer(param.get("out_trade_no")));
            BigDecimal total_fee = new BigDecimal(param.get("total_fee")).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
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
                BigDecimal sub = total_fee.multiply(webPayStaff1).setScale(2, BigDecimal.ROUND_HALF_UP);
                order.setPaid(total_fee);
                order.setStatus(2);
                order.setTradeStatus(param.get("trade_state"));
                order.setTradeNo(param.get("transaction_id"));
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
            writer.write("<xml>\n<return_code>SUCCESS</return_code>\n</xml>");
        } else {
            writer.write("<xml>\n<return_code>FAIL</return_code>\n</xml>");
        }
        writer.flush();
        writer.close();
    }


}

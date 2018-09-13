package com.bluemoutain.controller.pay;

import com.alibaba.fastjson.JSON;

import com.bluemoutain.controller.pay.process.NotifyThread;
import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.controller.pay.process.VipModePayProcess;
import com.bluemoutain.controller.pay.process.VipNotifyProcess;
import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.po.ext.CodePayRetBean;
import com.bluemoutain.service.*;
import com.bluemoutain.utils.HttpClientUtils;
import com.bluemoutain.utils.PayUtils;
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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

@Controller
@RequestMapping({"/payment"})
public class CodePayController {
    private static Logger logger = LoggerFactory.getLogger(CodePayController.class);
    @Autowired
    private YiPayFunction yiPayFunction;
    @Autowired
    private OrderService orderService;
    @Autowired
    private WebConfigService webConfigService;
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
    @Autowired
    private PayConfigService payConfigService;

    public CodePayController() {
    }

    @RequestMapping({"/code_pay"})
    public String codePay(Model model, Integer id) throws Exception {
        SystemWeb web = this.webConfigService.find_by_id(1);
        SystemPayConfigWithBLOBs config = this.payConfigService.getPayConfig(1);
        model.addAttribute("config", web);
        SystemOrder order = this.orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单id错误,请返回重试!");
        } else if (order.getStatus() == 2) {
            throw new Exception("订单已支付,请勿重复发起支付请求!");
        } else {
            LinkedHashMap<String, String> map = new LinkedHashMap();
            map.put("id", config.getCodepayId());
            map.put("type", String.valueOf(PayUtils.switch_pay_type_code_pay(order.getPayType())));
            map.put("price", String.valueOf(order.getPrice()));
            map.put("pay_id", String.valueOf(order.getId()));
            map.put("page", "4");
            map.put("notify_url", this.yiPayFunction.getDomain() + "/payment/code_pay_notify");
            map.put("return_url", this.yiPayFunction.getDomain() + "/payment/return_page");
            map.put("sign", this.yiPayFunction.buildRequestMysign2(map, config.getCodepayKey()));
            String ret = HttpClientUtils.get(config.getCodepayApi() + "?" + this.yiPayFunction.createLinkString(map));
            model.addAttribute("ret_str", ret);
            CodePayRetBean bean = JSON.parseObject(ret, CodePayRetBean.class);
            model.addAttribute("model", bean);
            model.addAttribute("return_url", this.yiPayFunction.getDomain() + "/payment/return_page?out_trade_no=" + order.getId());
            return "pay/code_pay_" + order.getPayType();
        }
    }

    @RequestMapping({"/code_pay_notify"})
    public void codePayNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SystemPayConfigWithBLOBs config = this.payConfigService.getPayConfig(1);
        String codepayKey = config.getCodepayKey();
        PrintWriter writer = response.getWriter();
        logger.info("码支付回调...");
        Map<String, String[]> requestParams = request.getParameterMap();
        Map<String, String> params = new HashMap();
        String valueStr = "";
        Iterator iter = requestParams.keySet().iterator();
        String prestr;
        while (iter.hasNext()) {
            prestr = (String) iter.next();
            String[] values = requestParams.get(prestr);
            valueStr = values[0];
            params.put(prestr, valueStr);
        }
        List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        prestr = "";
        String sign = params.get("sign");
        String key_name;
        for (int i = 0; i < keys.size(); ++i) {
            key_name = keys.get(i);
            String value = params.get(key_name);
            if (value != null && !value.equals("") && !key_name.equals("sign")) {
                if (prestr.equals("")) {
                    prestr = key_name + "=" + value;
                } else {
                    prestr = prestr + "&" + key_name + "=" + value;
                }
            }
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((prestr + codepayKey).getBytes());
        key_name = (new BigInteger(1, md.digest())).toString(16).toLowerCase();
        if (key_name.length() != 32) {
            key_name = "0" + key_name;
        }
        boolean verfy = sign.equals(key_name);
        if (verfy && new Integer(params.get("status")) == 1 &&
                (params.get("trade_status")).equals("TRADE_SUCCESS")) {
            SystemWeb systemWeb = this.webConfigService.find_by_id(1);
            String out_trade_no = request.getParameter("out_trade_no");
            SystemOrder order = this.orderService.findOrderById(new Integer(out_trade_no));
            if (order == null) {
                writer.write("fail");
                writer.flush();
                writer.close();
                return;
            }
            if (order.getStatus() != 2) {
                BigDecimal webPayStaff1;
                if (order.getOrderType() == 2) {
                    webPayStaff1 = new BigDecimal(0.0D);
                } else {
                    SystemUser user = this.userService.findUserById(order.getUid());
                    SystemVip vip = this.vipService.find_vip_by_uid(order.getUid());
                    if (vip == null) {
                        webPayStaff1 = user.getPayStaff();
                    } else if (vip.getStatus() == 1) {
                        webPayStaff1 = user.getVipPayStaff();
                    } else {
                        webPayStaff1 = user.getPayStaff();
                    }
                }
                BigDecimal total_fee = new BigDecimal(params.get("money"));
                BigDecimal sub = total_fee.multiply(webPayStaff1).setScale(2, 4);
                order.setPaid(total_fee);
                order.setStatus(2);
                order.setTradeStatus(params.get("trade_status"));
                order.setTradeNo(params.get("pay_no"));
                order.setPaidTime(new Date());
                order.setChangeSett(sub);
                order.setIsSett(1);
                this.orderService.updateOrder(order);
                if (order.getOrderType() == 2) {
                    order.setChangeSett(new BigDecimal("0.00"));
                    this.orderService.updateOrder(order);
                    logger.info("回调处理注册订单成功:" + order.getOutOrderId());
                } else if (order.getOrderType() == 4 && order.getChType() == 1) {
                    VipNotifyProcess process = new VipNotifyProcess(this.orderService, order.getId(), this.vipService, systemWeb.getVipMethod());
                    Thread thread = new Thread(process);
                    thread.setDaemon(true);
                    thread.start();
                    logger.info("回调处理会员购买/续费订单成功:" + order.getOutOrderId());
                } else {
                    BigDecimal final_money = total_fee.subtract(sub).setScale(2, 4);
                    boolean b = this.userBalnesChange.addUserBalnes(order.getUid(), final_money);
                    logger.info("回调处理:订单:" + order.getOutOrderId() + " 处理成功,金额:" + final_money.doubleValue() + " 手续费:" + sub.doubleValue() + " 状态:" + b);
                    Thread thread;
                    if (order.getOrderType() == 3) {
                        NotifyThread notifyThread = new NotifyThread(this.orderService, order.getId(), this.yiPayFunction);
                        thread = new Thread(notifyThread);
                        thread.setDaemon(true);
                        thread.start();
                    }
                    if (order.getChType() == 2) {
                        VipModePayProcess payProcess = new VipModePayProcess(this.orderService, this.userBalnesChange, this.settLementService, order.getId(), this.vipService, this.userService, systemWeb, this.wxPayFunctionPC, this.aliPayFunction);
                        thread = new Thread(payProcess);
                        thread.setDaemon(true);
                        thread.start();
                    }
                }
            }
            writer.write("success");
        } else {
            writer.write("fail");
        }
        writer.flush();
        writer.close();
    }
}

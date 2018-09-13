package com.bluemoutain.controller.pay;


import com.bluemoutain.controller.pay.process.NotifyThread;
import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.controller.pay.process.VipModePayProcess;
import com.bluemoutain.controller.pay.process.VipNotifyProcess;
import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.service.*;
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
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 易支付 控制层
 */
@Controller
@RequestMapping("/payment")
public class YiPayController {

    private static Logger logger = LoggerFactory.getLogger(YiPayController.class);

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
    private SystemDomainService domainService;


    @Autowired
    private UserService userService;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private PayConfigService payConfigService;


    /**
     * 易支付系统 - 发起支付请求
     */
    @RequestMapping("/yipay")
    public String yipay(Integer id, Model model) throws Exception {
        SystemWeb web = webConfigService.find_by_id(1);
        SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(1);
        model.addAttribute("config", web);
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单id错误,请返回重试!");
        }
        if (order.getStatus() == 2) {
            throw new Exception("订单已支付,请勿重复发起支付请求!");
        } else {
            String pid = "";
            String key = "";
            String gateway = "";
            Integer payType = order.getPayType();
            if (payType == 1) {
                pid = config.getEpayId();
                key = config.getEpayKey();
                gateway = config.getEpayApi();
            } else if (payType == 2) {
                pid = config.getEpayId2();
                key = config.getEpayKey2();
                gateway = config.getEpayApi2();
            } else if (payType == 3) {
                pid = config.getEpayId3();
                key = config.getEpayKey3();
                gateway = config.getEpayApi3();
            }
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("pid", pid);
            map.put("type", PayUtils.switchPayType(order.getPayType()));
            map.put("notify_url", yiPayFunction.getDomain() + "/payment/yipay_notify");
            map.put("return_url", yiPayFunction.getDomain() + "/payment/return_page");
            map.put("out_trade_no", order.getId().toString());
            map.put("name", order.getContext());
            map.put("money", String.valueOf(order.getPrice()));
            map.put("sitename", order.getTitle());
            String s = null;
            try {
                s = yiPayFunction.buildRequest(gateway+"/submit.php", key, map, "post", "正在提交!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("model", s);
        }
        return "pay/yipay";
    }

    /**
     * yipay支付异步通知
     */
    @RequestMapping("/yipay_notify")
    public void payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("易支付通知...");
        SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(1);
        String pid = request.getParameter("pid");
        String trade_no = request.getParameter("trade_no");
        String out_trade_no = request.getParameter("out_trade_no");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String money = request.getParameter("money");
        String trade_status = request.getParameter("trade_status");
        String sign = request.getParameter("sign");
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("trade_no", trade_no);
        map.put("out_trade_no", out_trade_no);
        map.put("type", type);
        map.put("name", name);
        map.put("money", money);
        map.put("trade_status", trade_status);
        PrintWriter writer = response.getWriter();
        SystemWeb systemWeb = webConfigService.find_by_id(1);
        BigDecimal webPayStaff1;
        if ("TRADE_SUCCESS".equals(trade_status)) {
            SystemOrder order = orderService.findOrderById(new Integer(out_trade_no));
            if (order == null) {
                writer.write("fail");
                writer.flush();
                writer.close();
                return;
            }
            String key = "";
            Integer payType = order.getPayType();
            if (payType == 1) {
                key = config.getEpayKey();
            } else if (payType == 2) {
                key = config.getEpayKey2();
            } else if (payType == 3) {
                key = config.getEpayKey3();
            }
            boolean ok = yiPayFunction.verfySign(map, sign, key);
            if (!ok) {
                writer.write("fail");
                writer.flush();
                writer.close();
                return;
            }
            if (order.getStatus() != 2) {
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
                BigDecimal total_fee = new BigDecimal(money);
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
                        VipModePayProcess payProcess = new VipModePayProcess(orderService, userBalnesChange, settLementService,
                                order.getId(), vipService, userService, systemWeb, wxPayFunctionPC, aliPayFunction);
                        Thread thread = new Thread(payProcess);
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

    /**
     * 支付回调页面
     */
    @RequestMapping("/return_page")
    public String retPage(String out_trade_no, Model model) throws Exception {
        SystemOrder order = orderService.findOrderById(new Integer(out_trade_no));
        if (order == null) {
            throw new Exception("order id error!");
        }
        SystemWeb systemWeb = webConfigService.find_by_id(1);
        model.addAttribute("config", systemWeb);
        String url = order.getReturnUrl();
        url += "?";
        url += yiPayFunction.buildRequestParaSign(order);
        model.addAttribute("redirect_url", url);
        return "pay/return";
    }

    /**
     * 选择支付方式
     */
    @RequestMapping("/switch")
    public String switchPay(Integer id, Model model) throws Exception {
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单不存在,请返回重试!");
        }
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        model.addAttribute("order", order);
        return "pay/switch";
    }

    /**
     * 重新支付
     */
    @RequestMapping("/repay")
    public String toPay(Integer id, Integer type, Model model, HttpServletRequest request) throws Exception {
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单不存在,请返回重试!");
        }
        if (type == null) {
            throw new Exception("支付方式错误!");
        }
        if (type < 0) {
            throw new Exception("支付方式错误!");
        }
        if (type > 3) {
            throw new Exception("支付方式错误!");
        }
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        order.setPayType(type);
        orderService.updateOrder(order);
        SystemUser user = userService.findUserById(order.getUid());
//        Integer payType = order.getPayType();
//        if (payType == 1) {
//            if (user.getPayWxpay() == 0) {
//                orderService.deleteOrder(order.getId());
//                throw new Exception("您无权使用当前支付接口(微信支付),详情联系系统管理员! ");
//            }
//        }
//        if (payType == 2) {
//            if (user.getPayAlipay() == 0) {
//                orderService.deleteOrder(order.getId());
//                throw new Exception("您无权使用当前支付接口(支付宝支付),详情联系系统管理员! ");
//            }
//        }
//        if (payType == 3) {
//            if (user.getPayQqpay() == 0) {
//                orderService.deleteOrder(order.getId());
//                throw new Exception("您无权使用当前支付接口(QQ支付),详情联系系统管理员! ");
//            }
//        }
        SystemOrder model1 = orderService.findOrderById(order.getId());
        model.addAttribute("order", model1);
        String domainName = new URL(order.getNotifyUrl()).getHost();
        SystemDomain domain = domainService.findByDomain(domainName);
        String url = PayUtils.switchPayMethod_API(request, model1, user);
        if (web.getShowPayReadme() == 1) {
            if (domain == null) {
                model.addAttribute("url", url);
                model.addAttribute("config", web);
                return "pay/readme";
            } else if (domain.getPayShowInfo() == 1) {
                model.addAttribute("url", url);
                model.addAttribute("config", web);
                return "pay/readme";
            } else {
                return "forward:" + url;
            }
        } else {
            return "forward:" + url;
        }
    }

}

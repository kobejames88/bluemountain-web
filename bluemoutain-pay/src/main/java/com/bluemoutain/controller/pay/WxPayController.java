package com.bluemoutain.controller.pay;

import com.alibaba.fastjson.JSON;

import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.controller.pay.process.VipModePayProcess;
import com.bluemoutain.controller.pay.process.VipNotifyProcess;
import com.bluemoutain.crond.process.NotifyThread;
import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.plugins.pay.utils.WXPayUtil;
import com.bluemoutain.po.*;
import com.bluemoutain.po.ext.WXLoginRet;
import com.bluemoutain.service.*;
import com.bluemoutain.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 微信支付控制器
 */
@Controller
@RequestMapping("/payment")
public class WxPayController {

    private static Logger logger = LoggerFactory.getLogger(WxPayController.class);

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private OrderService orderService;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserBalnesChange userBalnesChange;

    @Autowired
    private VipService vipService;

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private UserService userService;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private PayConfigService payConfigService;

    /**
     * 微信PC扫码支付
     */
    @RequestMapping("/wxspay")
    public String wxScanCodePay(Model model, Integer id) throws Exception {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单id错误,请返回重试!");
        }
        SystemUser user = userService.findUserById(order.getUid());
        if (order.getPayType() == 1) {
            if (order.getOrderType() == 1 | order.getOrderType() == 3) {
                if (user.getPayWxpay() != 0) {
                    orderService.deleteOrder(order.getId());
                    throw new Exception("您无权使用当前支付接口(微信支付),详情联系系统管理员! ");
                }
            }
        }
        if (order.getStatus() == 2) {
            throw new Exception("订单已支付,请勿重复发起支付请求!");
        } else {
            String qrCode = wxPayFunctionPC.getWxPayQRCode(order, yiPayFunction.getDomain() + "/payment/wxpay_notify");
            model.addAttribute("model", qrCode);
            model.addAttribute("order", order);
        }
        return "pay/wxspay";
    }

    /**
     * 微信外 H5支付
     */
    @RequestMapping("/wap_wx_pay")
    public String wxWAPPay(Model model, Integer id) throws Exception {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单id错误,请返回重试!");
        }
        SystemUser user = userService.findUserById(order.getUid());
        if (order.getPayType() == 1) {
            if (order.getOrderType() == 1 | order.getOrderType() == 3) {
                if (user.getPayWxpay() != 0) {
                    orderService.deleteOrder(order.getId());
                    throw new Exception("您无权使用当前支付接口(微信支付),详情联系系统管理员! ");
                }
            }
        }
        if (order.getStatus() == 2) {
            throw new Exception("订单已支付,请勿重复发起支付请求!");
        } else {
            SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(1);
            Integer mode = config.getWxMpayMode();
            if (mode == 0) {
                String url = wxPayFunctionPC.GetWxWAPPayUrl(order, yiPayFunction.getDomain() + "/payment/wxpay_notify");
                String encode = URLEncoder.encode(yiPayFunction.getDomain() +
                        "/payment/return_page?out_trade_no=" + order.getId() +
                        "&t=" + System.currentTimeMillis());
                url += "&redirect_url=" + encode;
                model.addAttribute("redirect_url", url);
                return "pay/wpay_h5";
            } else {
                model.addAttribute("order", order);
                model.addAttribute("model", yiPayFunction.getDomain() + "/payment/payInWeChat?id=" + order.getId() + "&au=" + System.currentTimeMillis());
                return "pay/wap_wxpay";
            }
        }
    }

    /**
     * 微信内支付
     */
    @RequestMapping("/payInWeChat")
    public String wxInPay(Model model, Integer id) throws Exception {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        SystemOrder order = orderService.findOrderById(id);
        if (order == null) {
            throw new Exception("订单id错误,请返回重试!");
        }
        SystemUser user = userService.findUserById(order.getUid());
        if (order.getPayType() == 1) {
            if (order.getOrderType() == 1 | order.getOrderType() == 3) {
                if (user.getPayWxpay() != 0) {
                    orderService.deleteOrder(order.getId());
                    throw new Exception("您无权使用当前支付接口(微信支付),详情联系系统管理员! ");
                }
            }
        }
        if (order.getStatus() == 2) {
            throw new Exception("订单已支付,请勿重复发起支付请求!");
        } else {
            String state_code = UUID.randomUUID().toString().replace("-", "");
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?";
            url += "appid=" + wxPayFunctionPC.getWx_appid_1() + "&";
            url += "redirect_uri=" + yiPayFunction.getDomain() + "/payment/payInWeChat2/&";
            url += "response_type=code&";
            url += "scope=snsapi_base&";
            url += "state=" + state_code + "#wechat_redirect";
            ValueOperations value = redisTemplate.opsForValue();
            value.set("wx_pay_state:" + state_code, order.getOutOrderId());
            redisTemplate.expire("wx_pay_state:" + state_code, 100, TimeUnit.SECONDS);
            return "redirect:" + url;
        }
    }

    /**
     * 微信内支付 - 已获取openid
     */
    @RequestMapping("/payInWeChat2")
    public String wxInPay2(String state, String code, HttpServletRequest request, Model model) throws Exception {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        if (state == null) {
            throw new Exception("订单信息错误,请返回重试!");
        }
        ValueOperations value = redisTemplate.opsForValue();
        String state_code = (String) value.get("wx_pay_state:" + state);
        redisTemplate.delete("wx_pay_state:" + state);
        String openid = null;
        if (code != null && state_code.length() > 0 && code.length() > 0) {
            String token_get_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
            HashMap<String, String> param = new HashMap<>();
            param.put("appid", wxPayFunctionPC.getWx_appid_1());
            param.put("secret", wxPayFunctionPC.getWxappsecrt_1());
            param.put("code", code);
            param.put("grant_type", "authorization_code");
            String ret = HttpClientUtils.postParameters(token_get_url, param);
            WXLoginRet ret_model = JSON.parseObject(ret, WXLoginRet.class);
            if (ret_model.getOpenid() == null) {
                throw new Exception("订单信息错误,请返回重试!");
            }
            openid = ret_model.getOpenid();
        }
        if (state_code == null) {
            throw new Exception("订单信息错误,请返回重试!");
        }
        SystemOrder order = orderService.findOrderByOutOrderId(state_code);
        if (order == null) {
            throw new Exception("订单信息错误,请返回重试!");
        }
        Map map = wxPayFunctionPC.createWeChatPayInfo(order, yiPayFunction.getDomain() + "/payment/wxpay_notify", openid);
        if (map == null) {
            return "redirect:/error";
        } else {
            model.addAttribute("wx_model", map);
            model.addAttribute("order", order);
            return "pay/wpay";
        }
    }

    /**
     * 微信支付 - 异步通知
     */
    @RequestMapping("/wxpay_notify")
    public void wxpay_notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("微信支付通知...");
        InputStream inputStream;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null) {
            sb.append(s);
        }
        in.close();
        inputStream.close();
        Map<String, String> m = WXPayUtil.xmlToMap(sb.toString());
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);
            String v = "";
            if (null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }
        if (wxPayFunctionPC.isTenpaySign(packageParams, wxPayFunctionPC.getPaternerKey_1()) &&
                "SUCCESS".equals(packageParams.get("result_code"))) {
            SystemOrder order = orderService.findOrderById(new Integer(packageParams.get("out_trade_no").toString()));
            SystemWeb systemWeb = webConfigService.find_by_id(1);
            BigDecimal webPayStaff1;
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
                BigDecimal total_fee = new BigDecimal(packageParams.get("total_fee").toString());
                total_fee = total_fee.divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal sub = total_fee.multiply(webPayStaff1).setScale(2, BigDecimal.ROUND_HALF_UP);
                order.setPaid(total_fee);
                order.setStatus(2);
                order.setTradeStatus(packageParams.get("return_code").toString());
                order.setTradeNo(packageParams.get("transaction_id").toString());
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
                    BigDecimal final_money = total_fee.subtract(sub).setScale(2, BigDecimal.ROUND_DOWN);
                    boolean b = userBalnesChange.addUserBalnes(order.getUid(), final_money);
                    logger.info("回调处理:订单:" + order.getOutOrderId() + " 处理成功,金额:" + final_money.doubleValue() + " 手续费:" + sub.doubleValue() + " 状态:" + b);
                    if (order.getOrderType() == 3) {
                        NotifyThread notifyThread = new NotifyThread(orderService, yiPayFunction);
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
            wxPayFunctionPC.ret_success_wxpay(response);
        } else {
            wxPayFunctionPC.ret_error_wxpay(response);
        }
    }

    /**
     * 获取微信扫码支付 - 订单状态
     */
    @RequestMapping("/wx_order_state")
    @ResponseBody
    public Map getOrderStatus(Integer oid) {
        SystemOrder order = orderService.findOrderById(oid);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status", order.getStatus());
        map.put("backurl", "/payment/return_page?out_trade_no=" + order.getId());
        return map;
    }

}

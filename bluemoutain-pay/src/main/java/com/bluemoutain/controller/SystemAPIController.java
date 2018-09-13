package com.bluemoutain.controller;


import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.QQPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.po.ext.SystemOrderExt;
import com.bluemoutain.service.*;
import com.bluemoutain.utils.IpKit;
import com.bluemoutain.utils.MailUtils;
import com.bluemoutain.utils.PageBean;
import com.bluemoutain.utils.PayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

/**
 * 系统api接口
 */
@Controller
public class SystemAPIController {

    private static Logger logger = LoggerFactory.getLogger(SystemAPIController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private SystemDomainService domainService;

    @Autowired
    private UserBalnesChange userBalnesChange;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private QQPayFunction qqPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private VipService vipService;

    @Autowired
    private UserConfigService configService;

    /**
     * 发起支付
     */
    @RequestMapping(value = "/submit.php", method = RequestMethod.POST)
    public String eSystemPay(HttpServletRequest request, String pid, String type,
                             String out_trade_no, String notify_url, String return_url,
                             String name, String money, String sitename, String sign,
                             String sign_type, Model model) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        if (web.getOrderFilter() ==1){
            String disableShopPay = web.getDisableShopPay();
            String[] split = disableShopPay.split(",");
            for (String s : split) {
                if (name.contains(s)) {
                    throw new Exception("商品: " + name + " 禁止出售,请返回修改!");
                }
            }
        }
        if (pid == null) {
            throw new Exception("商户不存在,请检查商户ID填写是否正确!");
        }
        if (pid.trim().length() == 0) {
            throw new Exception("商户不存在,请检查商户ID填写是否正确!");
        }
        SystemUser user = userService.findUserById(new Integer(pid));
        if (user == null) {
            throw new Exception("商户不存在,请检查商户ID填写是否正确!");
        }
        if (user.getIsLocked() == 1) {
            throw new Exception("账户已被禁止交易,请您联系管理员处理!");
        }
        BigDecimal low = new BigDecimal(0.00);
        if (user.getBalnes().compareTo(low) < 0) {
            throw new Exception("当前账户余额为:" + user.getBalnes() + "元,账号已欠费,请到用户中心充值!");
        }
        String domainName = new URL(notify_url).getHost();
        logger.info("RequestPayDomain:" + domainName);
        if (web.getIsApiOpen() == 0) {
            throw new Exception(web.getCloseApiDetial());
        }
        SystemDomain domain = domainService.findByDomain(domainName);
        if (web.getIsVeryDomain() == 1) {
            logger.info("UserSettingDomain:" + user.getUrl());
            if (user.getUrl() == null) {
                throw new Exception("交易域名尚未设置,请登录平台填写完整!");
            }
            if (!domainName.equals(user.getUrl())) {
                throw new Exception("网站域名与平台设置不相同,请登录平台重新设置!");
            }
            if (domain == null) {
                throw new Exception("当前域名未授权,无法进行支付操作!");
            }
            logger.info("QueryDomain:" + domain.getSerach());
            if (domain.getStatus() != 2) {
                throw new Exception("当前域名未授权,无法进行支付操作!");
            }
        }
        int oid;
        map.put("pid", pid);
        map.put("out_trade_no", out_trade_no);
        map.put("type", type);
        map.put("name", name);
        map.put("money", money);
        map.put("return_url", return_url);
        map.put("sitename", sitename);
        map.put("notify_url", notify_url);
        map.put("sign_type", sign_type);
        boolean ok = yiPayFunction.verfySign2(map, sign, user.getAppkey());
        if (ok) {
            SystemOrder systemOrder = orderService.findOrderByOutOrderId(out_trade_no);
            SystemVip vip = vipService.find_vip_by_uid(user.getId());
            if (vip == null) {
                throw new Exception("用户信息正在初始化中,请等一分钟后再试!");
            }
            if (systemOrder == null) {
                SystemOrder order = new SystemOrder();
                order.setOrderType(3);
                order.setOutOrderId(out_trade_no);
                order.setReturnUrl(return_url);
                order.setNotifyUrl(notify_url);
                order.setIpAddr(IpKit.getRealIp(request));
                order.setPayType(PayUtils.switchPayType2(type));
                Integer userQq = web.getUseUserQq();
                if (userQq == 0) {
                    order.setTitle(web.getPayTitle());
                } else {
                    SystemConfigWithBLOBs uid = configService.findConfigByUid(user.getId());
                    order.setTitle(uid.getPanel());
                }
                order.setContext(name);
                order.setPrice(new BigDecimal(money));
                order.setCreateTime(new Date());
                order.setUid(user.getId());
                order.setIsSett(1);
                order.setStatus(1);
                order.setSiteName(sitename);
                order.setChNum(1);
                if (vip.getStatus() == 1) {
                    order.setChType(2);
                } else {
                    order.setChType(0);
                }
                order.setIsNotify(0);
                oid = orderService.createOrder(order);
            } else {
                if (!systemOrder.getUid().equals(user.getId())) {
                    throw new Exception("订单号与平台用户不匹配,请返回重新下单!");
                }
                if (systemOrder.getStatus() == 2) {
                    throw new Exception("该订单已支付,请返回重新下单!");
                }
                if (new BigDecimal(money).compareTo(systemOrder.getPrice()) != 0) {
                    throw new Exception("两次支付单号一致但金额不一致,请返回重新下单!");
                }
                long time = systemOrder.getCreateTime().getTime();
                long now = new Date().getTime() - 600000;
                if (time < now) {
                    throw new Exception("当前订单已存在且支付超时,请返回重新下单!");
                }
                systemOrder.setPayType(PayUtils.switchPayType2(type));
                systemOrder.setIsSett(1);
                systemOrder.setChNum(1);
                Integer userQq = web.getUseUserQq();
                if (userQq == 0) {
                    systemOrder.setTitle(web.getPayTitle() + web.getKfqq());
                } else {
                    SystemConfigWithBLOBs uid = configService.findConfigByUid(user.getId());
                    systemOrder.setTitle(web.getPayTitle() + uid.getKfqq());
                }
                systemOrder.setOrderType(3);
                systemOrder.setIpAddr(IpKit.getRealIp(request));
                systemOrder.setReturnUrl(return_url);
                systemOrder.setNotifyUrl(notify_url);
                systemOrder.setSiteName(sitename);
                systemOrder.setIsNotify(0);
                if (vip.getStatus() == 1) {
                    systemOrder.setChType(2);
                } else {
                    systemOrder.setChType(0);
                }
                orderService.updateOrder(systemOrder);
                oid = systemOrder.getId();
            }
            logger.info("RequestIP:" + IpKit.getRealIp(request) + " OrderId:" + out_trade_no + "  Price:" + money + " 是否存在:" + (systemOrder != null));
        } else {
            throw new Exception("签名验证错误,请返回重试!");
        }

        SystemOrder order = orderService.findOrderById(oid);
        Integer payType = order.getPayType();
        if (payType == 1) {
            if (user.getPayWxpay() == -1) {
                orderService.deleteOrder(order.getId());
                throw new Exception("您无权使用当前支付接口(微信支付),详情联系系统管理员! ");
            }
        }
        if (payType == 2) {
            if (user.getPayAlipay() == -1) {
                orderService.deleteOrder(order.getId());
                throw new Exception("您无权使用当前支付接口(支付宝支付),详情联系系统管理员! ");
            }
        }
        if (payType == 3) {
            if (user.getPayQqpay() == -1) {
                orderService.deleteOrder(order.getId());
                throw new Exception("您无权使用当前支付接口(QQ支付),详情联系系统管理员! ");
            }
        }
        String url = PayUtils.switchPayMethod_API(request, order, user);
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

    /**
     * 系统查询API
     */
    @RequestMapping(value = "/api.php")
    @ResponseBody
    public Map api(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<Object, Object> ret = new HashMap<>();
        String pid = request.getParameter("pid");
        String key = request.getParameter("key");
        String option = request.getParameter("act");
        SystemUser user = userService.findUserById(new Integer(pid));
        SystemWeb web = webConfigService.find_by_id(1);
        if (web.getIsApiOpen() == 0) {
            throw new Exception(web.getCloseApiDetial());
        }
        if (!user.getAppkey().equals(key)) {
            ret.put("msg", "商户秘钥不正确!");
            ret.put("code", -3);
            return ret;
        }
        if (user.getIsLocked() == 1) {
            ret.put("msg", "账户已被禁用!");
            ret.put("code", -2);
        } else {
            switch (option) {
                case "order":
                    String out_trade_no = request.getParameter("out_trade_no");
                    return findOrderByOutTradeNo(out_trade_no);
                case "orders":
                    String limit = request.getParameter("limit");
                    if (limit == null) {
                        limit = "50";
                    }
                    return findOrderList(user.getId(), new Integer(limit));
                case "query":
                    return findUserSett(user.getId());
                case "change":
                    String account = request.getParameter("account");
                    String username = request.getParameter("username");
                    String settType = request.getParameter("sett_type");
                    String bankcode = request.getParameter("bankcode");
                    if (bankcode == null) {
                        bankcode = "";
                    }
                    return changeSettAccount(user.getId(), account, username, new Integer(settType), bankcode);
                case "settle":
                    return queryUserSettRecord(user.getId());
                case "apply":
                    if (user.getUserParent() != 0) {
                        ret.put("msg", "当前为合作商户,无权限操作,谢谢合作!");
                        ret.put("code", -4);
                        return ret;
                    }
                    String email = request.getParameter("email");
                    String remoteAddr = request.getRemoteAddr();
                    return createAccount(email, remoteAddr, user.getId());
                case "refund":
                    String trade_no = request.getParameter("trade_no");
                    return orderRefund(trade_no, user.getId());
                default:
                    ret.put("msg", "操作无效");
                    ret.put("code", -1);
            }
        }
        return ret;
    }

    /**
     * 退款API
     */
    private Map orderRefund(String trade_no, Integer uid) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        SystemOrder order = orderService.findOrderById(new Integer(trade_no));
        if (order == null) {
            map.put("msg", "订单不存在!");
            map.put("code", -1);
            return map;
        } else {
            if (!order.getUid().equals(uid)) {
                map.put("msg", "订单不存在!");
                map.put("code", -1);
                return map;
            }
            if (order.getOrderType() == 4) {
                map.put("msg", "订单不支持退款!");
                map.put("code", -1);
                return map;
            }
            if (order.getOrderType() == 2) {
                map.put("msg", "订单不支持退款!");
                map.put("code", -1);
                return map;
            }
            BigDecimal price = order.getPrice();
            BigDecimal balnes = userBalnesChange.getUserbalnes(order.getUid());
            if (balnes.compareTo(price) < 0) {
                map.put("code", -1);
                map.put("msg", "账户余额不足,请先充值!");
                return map;
            }
            Map ret = new HashMap();
            if (order.getPayType() == 2) {//支付宝退款
                ret = aliPayFunction.refund(order);
            } else if (order.getPayType() == 1) {//微信退款
                ret = wxPayFunctionPC.refund(order);
            } else if (order.getPayType() == 3) {//QQ退款
                ret = qqPayFunction.refund(order);
            }
            String msg = (String) ret.get("msg");
            Integer code = (Integer) ret.get("code");
            if (code == 0) {
                userBalnesChange.subUserBalnes(order.getUid(), price);
                map.put("msg", "提交成功,系统返回:" + msg);
                map.put("code", code);
            } else {
                map.put("msg", "提交失败,系统返回:" + msg);
                map.put("code", code);
            }
        }
        return map;
    }

    /**
     * 查询单个订单
     */
    private Map findOrderByOutTradeNo(String out_trade_no) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemOrder order = orderService.findOrderByOutOrderId(out_trade_no);
        if (order == null) {
            map.put("code", "-21");
            map.put("msg", "订单不存在");
        } else {
            map.put("code", 1);
            map.put("msg", "查询成功!");
            map.put("trade_no", order.getId());
            map.put("out_trade_no", order.getOutOrderId());
            map.put("type", PayUtils.switchPayType(order.getPayType()));
            map.put("pid", order.getUid());
            map.put("addtime", order.getCreateTime());
            map.put("endtime", order.getPaidTime() == null ? order.getCreateTime() : order.getPaidTime());
            map.put("name", order.getContext());
            map.put("money", String.valueOf(order.getPrice()));
            map.put("status", order.getStatus() - 1);
        }
        return map;
    }

    /**
     * 批量查询订单
     */
    private Map findOrderList(Integer uid, Integer limit) {
        HashMap<Object, Object> map = new HashMap<>();
        PageBean<SystemOrderExt> orders = orderService.findByPage2(1, limit, uid, null, null, null, null, null);
        if (orders == null) {
            map.put("code", "1");
            map.put("msg", "查询成功!");
        } else {
            if (orders.getItems() != null) {
                ArrayList<Object> list = new ArrayList<>();
                for (SystemOrderExt order : orders.getItems()) {
                    HashMap<Object, Object> tmp = new HashMap<>();
                    tmp.put("trade_no", order.getId());
                    tmp.put("out_trade_no", order.getOutOrderId());
                    tmp.put("type", PayUtils.switchPayType(order.getPayType()));
                    tmp.put("pid", order.getUid());
                    tmp.put("addtime", order.getCreateTime());
                    tmp.put("endtime", order.getPaidTime() == null ? order.getCreateTime() : order.getPaidTime());
                    tmp.put("name", order.getContext());
                    tmp.put("money", String.valueOf(order.getPrice()));
                    tmp.put("status", order.getStatus() - 1);
                    list.add(tmp);
                }
                map.put("data", list);
            }
            map.put("code", "1");
            map.put("msg", "查询成功!");
        }
        return map;
    }

    /**
     * 商户信息与结算规则
     */
    private Map findUserSett(Integer uid) {
        SystemWeb web = webConfigService.find_by_id(1);
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser user = userService.findUserById(new Integer(uid));
        map.put("code", "1");
        map.put("msg", "查询成功!");
        map.put("pid", user.getId());
        map.put("key", user.getAppkey());
        map.put("type", user.getRole());
        map.put("active", user.getIsLocked() - 1);
        map.put("money", String.valueOf(user.getBalnes()));
        map.put("account", user.getZspayid());
        map.put("username", user.getZsname());
        map.put("settle_money", String.valueOf(web.getSettMin()));
        Double payStaff2 = web.getPayStaff2();
        BigDecimal sett = new BigDecimal(payStaff2);
        sett = new BigDecimal(100.00).subtract(sett.multiply(new BigDecimal(100.00)));
        map.put("settle_fee", String.valueOf(sett));
        Double payStaff1 = web.getPayStaff1();
        BigDecimal free = new BigDecimal(payStaff1);
        free = new BigDecimal(100.00).subtract(free.multiply(new BigDecimal(100.00)));
        map.put("money_rate", String.valueOf(free));
        return map;
    }

    /**
     * 修改结算账号
     */
    private Map changeSettAccount(Integer uid, String account, String username, Integer sett_type, String bankcode) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser user = userService.findUserById(uid);
        if (user == null) {
            map.put("code", "0");
            map.put("msg", "修改失败!");
        } else {
            user.setZspaytype(sett_type);
            user.setZspayid(account);
            user.setCardBankCode(bankcode);
            user.setZsname(username);
            userService.updateUser(user);
            map.put("code", "1");
            map.put("msg", "修改成功!");
        }
        return map;
    }

    /**
     * 查询结算记录
     */
    private Map queryUserSettRecord(Integer uid) {
        HashMap<Object, Object> map = new HashMap<>();
        List<SystemSett> list = settLementService.findsettByUid(uid);
        map.put("data", list);
        map.put("code", "1");
        map.put("msg", "查询成功!");
        return map;
    }

    /**
     * API创建账户
     */
    private Map createAccount(String email, String addr, Integer uid) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser tmp = userService.findUserByEmail(email);
        if (tmp != null) {
            map.put("code", "-1");
            map.put("msg", "Email账户已存在!");
            return map;
        }
        SystemWeb web = webConfigService.find_by_id(1);
        SystemOrder order = new SystemOrder();
        order.setCreateTime(new Date());
        order.setTitle("商户注册");
        order.setContext("商户:" + email + "注册支付!");
        order.setOutOrderId(PayUtils.genOrderId());
        order.setEmail(email);
        order.setPreAccount("请填写");
        order.setPreZsName("请填写");
        order.setPrePayType(1);
        order.setStatus(1);
        order.setOrderType(2);
        order.setReturnUrl(yiPayFunction.getDomain() + "/reg_check");
        order.setPrice(new BigDecimal("0.00"));
        order.setEmail(email);
        order.setPaid(new BigDecimal(0.00));
        order.setTradeStatus("SUCCESS");
        order.setStatus(2);
        order.setPayType(1);
        order.setOrderType(2);
        order.setIsSett(1);
        order.setPaidTime(new Date());
        order.setChangeSett(new BigDecimal("0.00"));
        order.setTradeNo("00000000000");
        SystemUser user = new SystemUser();
        user.setBalnes(new BigDecimal(0));
        user.setUser(UUID.randomUUID().toString().replaceAll("-", "").substring(20, 27));
        user.setPwd(UUID.randomUUID().toString().replaceAll("-", "").substring(13, 27));
        user.setRole(web.getUserCreateRole());
        user.setZsname("请填写");
        user.setZspayid("请填写");
        user.setZspaytype(1);
        user.setPhone("000");
        user.setAge(0);
        user.setShowname("请填写");
        user.setSex(0);
        user.setUserParent(uid);
        user.setEmail(email);
        user.setCreateIp(addr);
        user.setPayStaff(new BigDecimal(web.getPayStaff1()));
        user.setSettStaff(new BigDecimal(web.getPayStaff2()));
        user.setVipPayStaff(web.getVipStaff1());
        user.setVipSettStaff(web.getVipStaff2());
        user.setCresteTime(new Date());
        user.setPayAlipay(web.getRegAlipay());
        user.setPayQqpay(web.getRegQqpay());
        user.setPayWxpay(web.getRegWxpay());
        try {
            int id2 = userService.saveUser(user);
            order.setUid(id2);
            orderService.createOrder(order);
            SystemUser u_model = userService.findUserById(id2);
            String con = "感谢您注册" + web.getSiteName() + "！<br>";
            con += "您的商户ID：" + u_model.getId() + " <br>";
            con += "您的商户秘钥：" + u_model.getAppkey() + "<br>";
            con += "您的登录用户名:" + u_model.getUser() + "<br>";
            con += "您的登录密码:" + u_model.getPwd() + "<br>";
            con += web.getSiteName() + "官网:" + web.getHttpUrl() + "<br>";
            con += "<a href=\" " + web.getHttpUrl() + "/admin/login \"> <br>";
            boolean mail = mailUtils.sendMail(web.getSiteName() + "商户注册成功", con, order.getEmail(), web.getSiteName());
            user = userService.findUserById(id2);
            map.put("send_email", mail);
            map.put("pid", id2);
            map.put("key", user.getAppkey());
            map.put("user", user.getUser());
            map.put("passwd", user.getPwd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("code", "1");
        map.put("msg", "创建成功,邮件已发送至" + email + "的邮箱!");
        return map;
    }

}

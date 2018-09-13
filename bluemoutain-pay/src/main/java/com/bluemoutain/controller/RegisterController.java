package com.bluemoutain.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.service.ExtensionService;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.WebConfigService;
import com.bluemoutain.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 注册控制
 */
@Controller
public class RegisterController {

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private ExtensionService extensionService;

    /**
     * 注册页面
     */
    @RequestMapping("/register")
    public String register(HttpSession session, Model model, String e) throws Exception {
        SystemWeb config = webConfigService.find_by_id(1);
        if (config.getUserReg() == 0) {
            throw new Exception("已关闭用户注册功能!");
        }
        if (e != null && config.getExtenStatus() == 1) {
            byte[] decode = Base64.decode(e);
            if (decode == null) {
                throw new Exception("推广链接解析错误!");
            }
            String exp = new String(decode, "utf-8");
            if (exp.length() < 10) {
                throw new Exception("推广链接解析错误!");
            }
            JSONObject object = JSON.parseObject(exp);
            if (object == null) {
                throw new Exception("推广链接解析错误!");
            }
            Integer u = (Integer) object.get("u");
            if (u == null) {
                throw new Exception("推广链接解析错误!");
            }
            SystemUser user = userService.findUserById(u);
            if (user == null) {
                throw new Exception("推广链接解析错误!");
            }
            String appkey = user.getAppkey();
            appkey = MD5Util.MD5Encode(appkey, "utf8").toLowerCase();
            String k = (String) object.get("k");
            if (k == null) {
                throw new Exception("推广链接解析错误!");
            }
            appkey = appkey.substring(0, 10);
            if (!appkey.equals(k)) {
                throw new Exception("推广链接解析错误!");
            }
            model.addAttribute("e_user", user);
            model.addAttribute("e2", e);
        }
        Object info = session.getAttribute("userInfo");
        if (info != null) {
            return "redirect:/admin?times=" + System.currentTimeMillis();
        } else {
            model.addAttribute("config", config);
            return "register/reg1";
        }
    }

    /**
     * 用户许可条款
     */
    @RequestMapping("/readme")
    public String reg_read(Model model) {
        SystemWeb config = webConfigService.find_by_id(1);
        model.addAttribute("config", config);
        return "register/read";
    }

    /**
     * 发送邮件验证码
     */
    @RequestMapping("/send_vcode")
    @ResponseBody
    public Map send_vcode(String email, HttpServletRequest request, HttpServletResponse response) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser tmp = userService.findUserByEmail(email);
        if (tmp != null) {
            map.put("code", "-1");
            map.put("msg", "Email账户已存在!");
            return map;
        }
        String code = UUID.randomUUID().toString().replaceAll("-", "").substring(5, 20);
        boolean mail = mailUtils.sendMail("注册验证码", "商户注册验证码为:" + code, email, webConfigService.find_by_id(1).getSiteName());
        CookieUtils2.setCookie(request, response, "vcode", code, true);
        if (mail) {
            map.put("msg", "发送成功!");
            map.put("code", "0");
        } else {
            map.put("msg", "发送失败!");
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 检测推广链接是否有效
     */
    private boolean check_exten_key(String key, SystemWebWithBLOBs config) throws Exception {
        if (key != null && config.getExtenStatus() == 1) {
            byte[] decode = Base64.decode(key);
            if (decode == null) {
                return false;
            }
            String exp = new String(decode, "utf-8");
            if (exp.length() < 10) {
                return false;
            }
            JSONObject object = JSON.parseObject(exp);
            if (object == null) {
                return false;
            }
            Integer u = (Integer) object.get("u");
            if (u == null) {
                return false;
            }
            SystemUser user = userService.findUserById(u);
            if (user == null) {
                return false;
            }
            String appkey = user.getAppkey();
            appkey = MD5Util.MD5Encode(appkey, "utf8").toLowerCase();
            String k = (String) object.get("k");
            if (k == null) {
                return false;
            }
            appkey = appkey.substring(0, 10);
            return appkey.equals(k);
        } else {
            return false;
        }
    }

    /**
     * 注册
     */
    @RequestMapping("/reg_save")
    @ResponseBody
    public Map reg_save(HttpServletRequest request, String email, String vcode, String pre_zs_name, String pre_account, Integer pre_pay_type, Integer check, String extenKey) throws Exception {
        SystemWebWithBLOBs webConfig = webConfigService.find_by_id(1);
        if (webConfig.getUserReg() == 0) {
            throw new Exception("已关闭用户注册功能!");
        }
        boolean b = false;
        if (extenKey != null && webConfig.getExtenStatus() == 1) {
            b = this.check_exten_key(extenKey, webConfig);
            if (!b) {
                throw new Exception("推广链接错误!");
            }
        }
        HashMap<Object, Object> map = new HashMap<>();
        String value = CookieUtils2.getCookieValue(request, "vcode");
        if (vcode == null) {
            map.put("msg", "验证码错误!");
            map.put("code", "-1");
            return map;
        }
        if (!value.equals(vcode)) {
            map.put("msg", "验证码错误!");
            map.put("code", "-1");
            return map;
        }
        if (check == null) {
            map.put("msg", "您必须同意用户许可条款后才能继续!");
            map.put("code", "-1");
            return map;
        }
        if (check != 223) {
            map.put("msg", "您必须同意用户许可条款后才能继续!");
            map.put("code", "-1");
            return map;
        }
        SystemUser tmp = userService.findUserByEmail(email);
        if (tmp != null) {
            map.put("code", "-1");
            map.put("msg", "Email账户已存在!");
            return map;
        }
        SystemOrder order = new SystemOrder();
        order.setCreateTime(new Date());
        order.setTitle("注册");
        order.setContext("商户:" + email + "注册支付!");
        order.setOutOrderId(PayUtils.genOrderId());
        order.setEmail(email);
        order.setPreAccount(pre_account);
        order.setPreZsName(pre_zs_name);
        order.setPrePayType(pre_pay_type);
        order.setStatus(1);
        order.setIsNotify(0);
        order.setOrderType(2);
        order.setIsSett(1);
        order.setChNum(1);
        order.setChType(0);
        if (extenKey != null && b) {
            order.setExtenKey(extenKey);
        } else {
            order.setExtenKey(null);
        }
        order.setIpAddr(IpKit.getRealIp(request));
        order.setReturnUrl(yiPayFunction.getDomain() + "/reg_check");
        order.setPrice(webConfig.getRegPrice());
        int oid = orderService.createOrder(order);
        map.put("oid", oid);
        map.put("code", 0);
        map.put("msg", "注册已提交,请稍后!");
        return map;
    }

    /**
     * 支付验证
     */
    @RequestMapping("/pay_check")
    public String pay_check(Integer oid, Model model) throws Exception {
        SystemWeb config = webConfigService.find_by_id(1);
        if (config.getUserReg() == 0) {
            throw new Exception("已关闭用户注册功能!");
        }
        model.addAttribute("config", config);
        SystemOrder order = orderService.findOrderById(oid);
        if (order.getPrice().compareTo(new BigDecimal(0.00)) == 0) {
            order.setPaid(new BigDecimal(0.00));
            order.setTradeStatus("SUCCESS");
            order.setStatus(2);
            order.setPayType(1);
            order.setOrderType(2);
            order.setPaidTime(new Date());
            order.setTradeNo("00000000000");
            order.setChangeSett(new BigDecimal(0.00));
            orderService.updateOrder(order);
            return "redirect:/reg_check?out_trade_no=" + order.getOutOrderId();
        } else {
            model.addAttribute("order", order);
        }
        return "register/pay_check";
    }

    /**
     * 支付
     */
    @RequestMapping("/reg/sub_pay")
    public String pay(Model model, Integer id, Integer pay_type, HttpServletRequest request) throws Exception {
        SystemWebWithBLOBs config = webConfigService.find_by_id(1);
        if (config.getUserReg() == 0) {
            throw new Exception("已关闭用户注册功能!");
        }
        SystemOrder order = orderService.findOrderById(id);
        if (order.getStatus() == 2) {
            model.addAttribute("model", "<h3>订单已支付!</h3>");
            return "register/pay";
        }
        order.setIpAddr(IpKit.getRealIp(request));
        order.setPayType(pay_type);
        orderService.updateOrder(order);
        return "forward:" + PayUtils.switchPayMethod2(request, order, config);
    }


    /**
     * 处理进程
     */
    @RequestMapping("/reg_check")
    public String setp(String out_trade_no, HttpServletRequest request, Model model) throws Exception {
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        if (web.getUserReg() == 0) {
            throw new Exception("已关闭用户注册功能!");
        }
        model.addAttribute("config", web);
        SystemOrder order = orderService.findOrderByOutOrderId(out_trade_no);
        if (order.getOrderType() != 2) {
            throw new Exception("订单类型错误!");
        }
        if (order.getStatus() == 2 && order.getUid() == null) {
            SystemUser user = new SystemUser();
            user.setBalnes(new BigDecimal(0));
            user.setUser(UUID.randomUUID().toString().replaceAll("-", "").substring(20, 27));
            user.setPwd(UUID.randomUUID().toString().replaceAll("-", "").substring(13, 27));
            user.setRole(web.getRegRole());
            user.setZsname(order.getPreZsName());
            user.setZspayid(order.getPreAccount());
            user.setZspaytype(order.getPrePayType());
            user.setPhone("000");
            user.setAge(0);
            user.setShowname(order.getPreZsName());
            user.setSex(0);
            user.setUserParent(1);
            user.setEmail(order.getEmail());
            user.setPayStaff(new BigDecimal(web.getPayStaff1()));
            user.setSettStaff(new BigDecimal(web.getPayStaff2()));
            user.setVipPayStaff(web.getVipStaff1());
            user.setVipSettStaff(web.getVipStaff2());
            String addr = IpKit.getRealIp(request);
            user.setCreateIp(addr);
            user.setIsAutoSett(1);
            user.setCresteTime(new Date());
            user.setPayAlipay(web.getRegAlipay());
            user.setPayQqpay(web.getRegQqpay());
            user.setPayWxpay(web.getRegWxpay());
            try {
                int id2 = userService.saveUser(user);
                order.setUid(id2);
                orderService.updateOrder(order);
                String key = order.getExtenKey();
                if (this.check_exten_key(key, web)) {
                    byte[] decode = Base64.decode(key);
                    String string = new String(decode, "utf-8");
                    JSONObject object = JSON.parseObject(string);
                    Integer uid = (Integer) object.get("u");
                    SystemUser e_user = userService.findUserById(uid);
                    BigDecimal minMoney = web.getExtenMinMoney();
                    BigDecimal maxMoney = web.getExtenMaxMoney();
                    double min = minMoney.doubleValue();
                    double max = maxMoney.doubleValue();
                    SysExtension extension = new SysExtension();
                    BigDecimal db = new BigDecimal(Math.random() * (max - min) + min);
                    extension.setMoney(db.setScale(2, BigDecimal.ROUND_DOWN));
                    extension.seteId(e_user.getId());
                    extension.seteName(e_user.getUser());
                    extension.setrId(id2);
                    extension.setrName(user.getUser());
                    extension.setStatus(0);
                    extension.seteKey(key);
                    extensionService.save_exten(extension);
                }
                SystemUser u_model = userService.findUserById(id2);
                String con = "感谢您注册" + web.getSiteName() + "！<br>";
                con += "您的商户ID：" + u_model.getId() + " <br>";
                con += "您的商户秘钥：" + u_model.getAppkey() + "<br>";
                con += "您的登录用户名:" + u_model.getUser() + "<br>";
                con += "您的登录密码:" + u_model.getPwd() + "<br>";
                con += web.getSiteName() + "官网:" + web.getHttpUrl() + "<br>";
                con += "<a href=\" " + web.getHttpUrl() + "/admin/login \"> <br>";
                boolean mail = mailUtils.sendMail(web.getSiteName() + "商户注册成功", con, order.getEmail(), web.getSiteName());
                model.addAttribute("sendmail", mail);
                model.addAttribute("order", order);
                model.addAttribute("user", user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            model.addAttribute("order", order);
        }
        return "register/reg_final";
    }


}

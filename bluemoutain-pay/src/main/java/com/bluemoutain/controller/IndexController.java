package com.bluemoutain.controller;

import com.alibaba.fastjson.JSON;

import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.SystemDoc;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.po.ext.SysSettExt;
import com.bluemoutain.po.ext.SysUserExt;
import com.bluemoutain.po.ext.WXLoginRet;
import com.bluemoutain.service.*;
import com.bluemoutain.utils.HttpClientUtils;
import com.bluemoutain.utils.MailUtils;
import com.bluemoutain.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 首页控制器
 */
@Controller
public class IndexController {

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private ApiDocService apiDocService;

    @Autowired
    private UserService uservice;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private SystemCountService countService;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 首页
     */
    @RequestMapping("/")
    public String index( Model model) {
        String sid = UUID.randomUUID().toString().replaceAll("-", "");
        model.addAttribute("code", sid);
        return "check";
    }

    /**
     * 首页
     */
    @RequestMapping("/index.do")
    public String home(Model model) {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        PageBean<SysUserExt> page = uservice.findByPage(1, 10, null, null, null, null);
        model.addAttribute("totalUser", page.getTotalNum());
        PageBean<SystemOrder> order = orderService.findByPage(1, 10);
        model.addAttribute("totalOrder", order.getTotalNum());
        PageBean<SysSettExt> sett = settLementService.findByPage(1, 10, null, null, null, null);
        model.addAttribute("tiotalLiushui", sett.getTotalNum());
        model.addAttribute("countMoney", countService.findSettAllCount());
        return "index_" + web.getSysThreams();
    }

    @Autowired
    private UserBalnesChange userBalnesChange;


    /**
     * 开发文档
     */
    @RequestMapping("/doc.do")
    public String doc(Model model) {
        SystemWeb web = webConfigService.find_by_id(1);
        List<SystemDoc> list = apiDocService.findAllDisplayDoc(1);
        model.addAttribute("config", web);
        model.addAttribute("api", list);
        return "doc";
    }

    /**
     * 微信 验证
     */
    @RequestMapping("/MP_verify_nLm1hAJXM24ry2GJ.txt")
    public void verfy(HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();
        writer.write("nLm1hAJXM24ry2GJ");
        writer.flush();
        writer.close();
    }

    /**
     * 爬虫机器人设定
     */
    @RequestMapping("/robots.txt")
    public void robots(HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();
        writer.write("User-agent: * \n");
        writer.write("Crawl-delay: 15 \n");
        writer.write("Disallow: / \n");
        writer.flush();
        writer.close();
    }

    /**
     * 微信扫码 - 绑定用户
     */
    @RequestMapping("/wxScanCode")
    public String wxScanCode(String auth) throws Exception {
        ValueOperations ops = redisTemplate.opsForValue();
        Object o = ops.get("state:" + auth);
        Integer id = (Integer) o;
        if (id == null) {
            throw new Exception("用户识别失败!");
        }
        String ret_url = URLEncoder.encode(yiPayFunction.getDomain() + "/scancode/ret", "UTF-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?";
        url += "appid=" + wxPayFunctionPC.getWx_appid_1() + "&";
        url += "redirect_uri=" + ret_url + "&";
        url += "response_type=code&";
        url += "scope=snsapi_base&";
        url += "state=" + auth + "#wechat_redirect";
        redisTemplate.expire("state:" + auth, 120, TimeUnit.SECONDS);
        return "redirect:" + url;
    }

    /**
     * 微信 - 扫码绑定 - 回调
     */
    @RequestMapping("/scancode/ret")
    public String toWXScancode_ret(String code, String state, Model model) throws Exception {
        ValueOperations ops = redisTemplate.opsForValue();
        Object o = ops.get("state:" + state);
        Integer id = (Integer) o;
        if (id == null) {
            throw new Exception("用户识别失败!");
        }
        String openid = null;
        if (code != null && state.length() > 0 && code.length() > 0) {
            String token_get_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
            HashMap<String, String> param = new HashMap<>();
            param.put("appid", wxPayFunctionPC.getWx_appid_1());
            param.put("secret", wxPayFunctionPC.getWxappsecrt_1());
            param.put("code", code);
            param.put("grant_type", "authorization_code");
            String ret = HttpClientUtils.postParameters(token_get_url, param);
            WXLoginRet ret_model = JSON.parseObject(ret, WXLoginRet.class);
            if (ret_model.getOpenid() == null) {
                throw new Exception("信息错误,请返回重试!");
            }
            openid = ret_model.getOpenid();
        }
        SystemUser user = userService.findUserById(id);
        user.setZspaytype(1);
        user.setZspayid(openid);
        userService.updateUser(user);
        SystemUser user1 = userService.findUserById(user.getId());
        SystemWeb webConfigService_by_id = webConfigService.find_by_id(1);
        model.addAttribute("config", webConfigService_by_id);
        model.addAttribute("user", user1);
        ops.set("state_bind:" + state, 125);
        redisTemplate.expire("state_bind:" + state, 120, TimeUnit.SECONDS);
        ops.set("state_bind_openid:" + state, openid);
        redisTemplate.expire("state_bind_openid:" + state, 120, TimeUnit.SECONDS);
        return "bind_ok";
    }

    /**
     * 微信扫码 - 绑定用户
     */
    @RequestMapping("/wxScanCode2")
    public String wxScanCode2(String auth) throws Exception {
        String ret_url = URLEncoder.encode(yiPayFunction.getDomain() + "/scancode/ret2", "UTF-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?";
        url += "appid=" + wxPayFunctionPC.getWx_appid_1() + "&";
        url += "redirect_uri=" + ret_url + "&";
        url += "response_type=code&";
        url += "scope=snsapi_base&";
        url += "state=" + auth + "#wechat_redirect";
        redisTemplate.expire("state:" + auth, 120, TimeUnit.SECONDS);
        return "redirect:" + url;
    }

    /**
     * 微信 - 扫码绑定 - 回调
     */
    @RequestMapping("/scancode/ret2")
    public String toWXScancode_ret2(String code, String state, Model model) throws Exception {
        ValueOperations ops = redisTemplate.opsForValue();
        String openid = null;
        if (code != null && state.length() > 0 && code.length() > 0) {
            String token_get_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
            HashMap<String, String> param = new HashMap<>();
            param.put("appid", wxPayFunctionPC.getWx_appid_1());
            param.put("secret", wxPayFunctionPC.getWxappsecrt_1());
            param.put("code", code);
            param.put("grant_type", "authorization_code");
            String ret = HttpClientUtils.postParameters(token_get_url, param);
            WXLoginRet ret_model = JSON.parseObject(ret, WXLoginRet.class);
            if (ret_model.getOpenid() == null) {
                throw new Exception("信息错误,请返回重试!");
            }
            openid = ret_model.getOpenid();
        }
        SystemWeb webConfigService_by_id = webConfigService.find_by_id(1);
        model.addAttribute("config", webConfigService_by_id);
        ops.set("state_bind:" + state, 125);
        redisTemplate.expire("state_bind:" + state, 120, TimeUnit.SECONDS);
        ops.set("state_bind_openid:" + state, openid);
        model.addAttribute("openid", openid);
        redisTemplate.expire("state_bind_openid:" + state, 120, TimeUnit.SECONDS);
        return "bind_ok2";
    }

    /**
     * 自动跳转系统浏览器
     */
    @RequestMapping("/open.do")
    public String open(Model model, String url) {
        model.addAttribute("url", url);
        return "open_url";
    }

    /**
     * 绑定成功页面
     */
    @RequestMapping("/bind_ok2")
    public String bind_ok2(String state, Model model) {
        String openid;
        ValueOperations ops = redisTemplate.opsForValue();
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        openid = (String) ops.get("state_bind_openid:" + state);
        redisTemplate.delete("state:" + state);
        model.addAttribute("openid", openid);
        redisTemplate.delete("state_bind:" + state);
        return "bind_ok2";
    }

    /**
     * 绑定成功页面
     */
    @RequestMapping("/bind_ok")
    public String bind_ok(String state, Model model) throws Exception {
        ValueOperations ops = redisTemplate.opsForValue();
        Object o = ops.get("state:" + state);
        Integer id = (Integer) o;
        if (id == null) {
            throw new Exception("用户识别失败!");
        }
        SystemUser user1 = userService.findUserById(id);
        model.addAttribute("user", user1);
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        redisTemplate.delete("state:" + state);
        redisTemplate.delete("state_bind:" + state);
        return "bind_ok";
    }

    /**
     * 忘记密码页面
     */
    @RequestMapping("/re_email")
    public String reset_pw(Model model) {
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        return "admin/re_email";
    }

    /**
     * 重新发送账户信息
     */
    @RequestMapping("/re_email/send")
    @ResponseBody
    public Map send_email(String email) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser user = userService.find_user_by_email(email);
        if (user == null) {
            map.put("msg", "账号不存在,请重新输入!");
            map.put("code", -1);
            return map;
        }
        SystemWeb web = webConfigService.find_by_id(1);
        String con = "感谢您注册" + web.getSiteName() + "！<br>";
        con += "您的商户ID：" + user.getId() + " <br>";
        con += "您的商户秘钥：" + user.getAppkey() + "<br>";
        con += "您的登录用户名:" + user.getUser() + "<br>";
        con += "您的登录密码:" + user.getPwd() + "<br>";
        con += web.getSiteName() + "官网:" + web.getHttpUrl() + "<br>";
        con += "<a href=\" " + web.getHttpUrl() + "/admin/login \"> <br>";
        boolean mail = mailUtils.sendMail(web.getSiteName() + "商户注册成功", con, user.getEmail(), web.getSiteName());
        if (mail) {
            map.put("msg", "账号密码已发送邮箱,请注意查收!");
            map.put("code", 0);
        } else {
            map.put("msg", "账号已找到但邮箱错误,无法发送邮件,请联系管理员处理!");
            map.put("code", -2);
        }
        return map;
    }

}

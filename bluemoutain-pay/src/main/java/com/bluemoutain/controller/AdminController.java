package com.bluemoutain.controller;


import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.po.SystemWebWithBLOBs;
import com.bluemoutain.po.ext.SysFunctionExt;
import com.bluemoutain.service.SysFunctionService;
import com.bluemoutain.service.SystemCountService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.WebConfigService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bluemoutain.utils.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.URL;
import java.util.*;

/**
 * 后台管理
 */
@Controller
public class AdminController {

    @Autowired
    private SystemCountService systemCountService;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private SysFunctionService functionService;

    @Autowired
    private UserService userService;

    /**
     * 管理首页
     */
    @RequestMapping("/admin")
    public String index(HttpSession session, Model model) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        model.addAttribute("user", info);
        List<SysFunctionExt> menu = functionService.findMenuByRoleId(info.getRole());
        model.addAttribute("menu", menu);
        SystemWebWithBLOBs config = webConfigService.find_by_id(1);
        model.addAttribute("config", config);
        return "admin/index";
    }

    /**
     * 首页 - 子页
     */
    @RequiresPermissions("admin_welcome")
    @RequestMapping("/admin/welcomepage")
    public String welcomepage(Model model, HttpServletRequest request, HttpSession session) throws Exception {
        StringBuffer url = request.getRequestURL();
        URL url1 = new URL(url.toString());
        InetAddress addr = InetAddress.getByName(url1.getHost());
        String ip = addr.getHostAddress();
        String hostName = addr.getHostName();
        Properties properties = System.getProperties();
        model.addAttribute("osname", properties.getProperty("os.name"));
        model.addAttribute("osversion", properties.getProperty("os.version"));
        model.addAttribute("ip", ip);
        model.addAttribute("hostname", hostName);
        model.addAttribute("realpath", request.getSession().getServletContext().getRealPath("/"));
        model.addAttribute("javaversion", properties.getProperty("java.version"));
        model.addAttribute("javavendor", properties.getProperty("java.vendor"));
        model.addAttribute("javavmname", properties.getProperty("java.vm.name"));
        model.addAttribute("usercount", systemCountService.countUsers());
        model.addAttribute("maxmemory", Runtime.getRuntime().totalMemory() / 1024 / 1024);
        model.addAttribute("usememory", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
        model.addAttribute("freememory", Runtime.getRuntime().freeMemory() / 1024 / 1024);
        SystemWeb systemWeb = webConfigService.find_by_id(1);
        model.addAttribute("web", systemWeb);
        model.addAttribute("ordercount1", systemCountService.countOrders(null, null));
        model.addAttribute("ordercount2", systemCountService.countOrders(2, null));
        model.addAttribute("ordercount3", systemCountService.countOrders(1, null));
        model.addAttribute("ordercount4", systemCountService.countOrders(3, null));
        return "admin/welcome";
    }


    /**
     * 登录页
     */
    @RequestMapping("/admin/login")
    public String login(HttpSession session) {
        Object info = session.getAttribute("userInfo");
        if (info != null) {
            return "redirect:/admin?times=" + System.currentTimeMillis();
        } else {
            return "admin/login";
        }
    }

    /**
     * 异步登录
     */
    @RequestMapping("/login/ajax")
    @ResponseBody
    public Map loginajax(SystemUser user, HttpSession session) {
        HashMap<Object, Object> map = new HashMap<>();
        String l_user = user.getUser();
        String l_pwd = user.getPwd();
        l_user = new String(Base64.decode(l_user));
        l_pwd = new String(Base64.decode(l_pwd));
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(l_user, l_pwd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            SystemUser user1 = (SystemUser) subject.getPrincipal();
            session.setAttribute("userInfo", user1);
            SystemUser info = new SystemUser();
            info.setId(user1.getId());
            info.setLastLoginTime(new Date());
            userService.updateUser(info);
            map.put("msg", "登录成功!");
            map.put("code", 0);
        } catch (Exception e) {
            map.put("msg", "账号密码错误或该账号已被封停使用!");
            map.put("code", -1);
        }
        return map;
    }

    /**
     * 异步退出登录
     */
    @RequestMapping("/admin/logout/ajax")
    @ResponseBody
    public Map logout() {
        HashMap<Object, Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        map.put("msg", "退出成功!");
        map.put("code", 0);
        return map;
    }

}

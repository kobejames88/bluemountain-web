package com.bluemoutain.controller;

import com.alibaba.fastjson.JSON;

import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.crond.process.SettThread;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.po.ext.SysUserExt;
import com.bluemoutain.service.*;
import com.bluemoutain.utils.IpKit;
import com.bluemoutain.utils.MD5Util;
import com.bluemoutain.utils.MailUtils;
import com.bluemoutain.utils.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bluemoutain.utils.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private WebConfigService webConfigService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private SystemCountService systemCountService;
    @Autowired
    private SystemCountService countService;
    @Autowired
    private YiPayFunction yiPayFunction;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SettLementService settLementService;
    @Autowired
    private UserBalnesChange userBalnesChange;
    @Autowired
    private VipService vipService;
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private ExtensionService extensionService;


    /**
     * 用户列表
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/list")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "20") Integer rows,
                        @RequestParam(defaultValue = "false") Boolean ajax,
                        Model model, Integer pid, String email, Integer role, String user) {
        PageBean<SysUserExt> byPage = userService.findByPage(page, rows, user, pid, role, email);
        model.addAttribute("bean", byPage);
        List<SysRole> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("s", user);
        model.addAttribute("pid", pid);
        model.addAttribute("role", role);
        model.addAttribute("email", email);
        if (ajax) {
            return "admin/user/list#pagenode";
        } else {
            return "admin/user/list";
        }
    }

    /**
     * 用户添加页面
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/add")
    public String add(Model model) {
        List<SysRole> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        String user = UUID.randomUUID().toString().replaceAll("-", "").substring(20, 27);
        String passwd = UUID.randomUUID().toString().replaceAll("-", "").substring(13, 27);
        model.addAttribute("user", user);
        model.addAttribute("pwd", passwd);
        return "admin/user/add";
    }

    /**
     * 新用户保存
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/save")
    @ResponseBody
    public Map save(SystemUser user, HttpServletRequest request, HttpSession session) {
        String addr = IpKit.getRealIp(request);
        SystemWeb web = webConfigService.find_by_id(1);
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        if (info.getRole() == 1) {
            user.setPayAlipay(web.getRegAlipay());
            user.setPayQqpay(web.getRegQqpay());
            user.setPayWxpay(web.getRegWxpay());
            user.setCreateIp(addr);
            user.setUserParent(1);
            user.setRole(2);
            user.setCresteTime(new Date());
            try {
                userService.saveUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "添加成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 编辑页面
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/edit")
    public String toEdit(Integer id, Model model, HttpSession session) {
        List<SysRole> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        SystemUser user = userService.findUserById(id);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        model.addAttribute("model", user);
        return "admin/user/edit";
    }

    /**
     * 用户数据更新
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SystemUser user) {
        userService.updateUser(user);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "更新成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 用户删除
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        userService.deleteUserById(id);
        userConfigService.deleteByUid(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "删除成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 用户重置秘钥
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/re_key")
    @ResponseBody
    public Map re_key(Integer id) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser user = userService.findUserById(id);
        if (user != null) {
            String str = UUID.randomUUID().toString() + UUID.randomUUID().toString();
            String s = Base64.encode(str.getBytes("utf-8"));
            user.setAppkey(s.substring(10, 42));
            userService.updateUser(user);
            map.put("msg", "成功,新秘钥:" + s.substring(10, 42));
            map.put("code", 0);
        } else {
            map.put("msg", "用户不存在!");
            map.put("code", -1);
        }
        return map;
    }


    /**
     * 资料修改
     */
    @RequiresPermissions("user_info_edit")
    @RequestMapping("/edit2")
    public String userEdit(Model model, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        SystemUser user = userService.findUserById(info.getId());
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        model.addAttribute("model", user);
        SysRole role = roleService.findById(user.getRole());
        model.addAttribute("roleName", role.getRoleName());
        SystemVip vip = vipService.find_vip_by_uid(info.getId());
        model.addAttribute("vip", vip);
        return "admin/user/edit2";
    }

    /**
     * 微信 - 扫码绑定
     */
    @RequiresPermissions("user_info_edit")
    @RequestMapping("/scancode/wx")
    public String toWXScancode(Integer id, Model model, HttpSession session) throws Exception {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        if (!info.getId().equals(id)) {
            throw new Exception("只能绑定当前登录的账号!");
        }
        String state = UUID.randomUUID().toString().replaceAll("-", "");
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("state:" + state, id);
        redisTemplate.expire("state:" + state, 120, TimeUnit.SECONDS);
        model.addAttribute("url", yiPayFunction.getDomain() + "/wxScanCode?auth=" + state + "&times=" + System.currentTimeMillis());
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        model.addAttribute("pid", id);
        model.addAttribute("state_bind", state);
        return "qrCode";
    }

    /**
     * 检测绑定状态
     */
    @RequiresPermissions("user_info_edit")
    @RequestMapping("/bind_status")
    @ResponseBody
    public Map bind_status(String state) {
        HashMap<Object, Object> map = new HashMap<>();
        ValueOperations ops = redisTemplate.opsForValue();
        Integer bind = (Integer) ops.get("state_bind:" + state);
        if (bind == null) {
            map.put("code", -1);
            map.put("msg", "绑定失败!");
            return map;
        }
        if (bind == 125) {
            map.put("code", 1);
            map.put("msg", "绑定成功!");
        } else {
            map.put("code", -1);
            map.put("msg", "绑定失败!");
            return map;
        }
        map.put("code", 1);
        map.put("msg", "绑定成功!");
        map.put("backurl", "/bind_ok?state=" + state);
        return map;
    }

    /**
     * 查看用户资料
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/view")
    public String view(Model model, Integer uid) {
        SystemUser user = userService.findUserById(uid);
        SysRole role = roleService.findById(user.getRole());
        model.addAttribute("roleName", role.getRoleName());
        model.addAttribute("model", user);
        Integer order1 = countService.todayCreateOrder(uid, null, null, null);
        Integer order4 = countService.todayCreateOrder(uid, 2, null, null);
        Integer order5 = countService.todayCreateOrder(uid, 1, null, null);
        model.addAttribute("order1", order1);
        model.addAttribute("order4", order4);
        model.addAttribute("order5", order5);
        BigDecimal moneyCount1 = countService.todayOrderMoneyCount(uid, 2, null);
        BigDecimal moneyCount2 = countService.todayOrderMoneyCount(uid, 1, null);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(uid, 3, null);
        model.addAttribute("moneyCount1", moneyCount1);
        model.addAttribute("moneyCount2", moneyCount2);
        model.addAttribute("moneyCount3", moneyCount3);
        BigDecimal count = settLementService.findUserSettPayCount(uid);
        model.addAttribute("pay_count", count);
        SystemVip vip = vipService.find_vip_by_uid(user.getId());
        model.addAttribute("vip", vip);
        return "admin/user/view";
    }

    /**
     * 重新发送邮件
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/re_email")
    @ResponseBody
    public Map re_email(Model model, Integer uid) {
        HashMap<Object, Object> ret = new HashMap<>();
        SystemWeb web = webConfigService.find_by_id(1);
        SystemUser user = userService.findUserById(uid);
        if (user != null) {
            String con = "感谢您注册" + web.getSiteName() + "！<br>";
            con += "您的商户ID：" + user.getId() + " <br>";
            con += "您的商户秘钥：" + user.getAppkey() + "<br>";
            con += "您的登录用户名:" + user.getUser() + "<br>";
            con += "您的登录密码:" + user.getPwd() + "<br>";
            con += web.getSiteName() + "官网:" + web.getHttpUrl() + "<br>";
            con += "<a href=\" " + web.getHttpUrl() + "/admin/login \"> <br>";
            boolean mail = mailUtils.sendMail(web.getSiteName() + "商户注册成功", con, user.getEmail(), web.getSiteName());
            if (mail) {
                ret.put("msg", "发送成功!");
                ret.put("code", 0);
            } else {
                ret.put("msg", "发送失败!");
                ret.put("code", -1);
            }
        } else {
            ret.put("msg", "用户不存在!");
            ret.put("code", -1);
        }
        return ret;
    }

    /**
     * 用户数据更新
     */
    @RequiresPermissions("user_info_edit")
    @RequestMapping("/update2")
    @ResponseBody
    public Map update2(SystemUser user, HttpSession session) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        if (!info.getId().equals(user.getId())) {
            map.put("msg", "更新失败!");
            map.put("code", 0);
        } else {
            user.setRole(null);
            user.setBalnes(null);
            user.setEmail(null);
            userService.updateUser(user);
        }
        map.put("msg", "更新成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 用户自主申请结算
     */
    @RequiresPermissions("user_info_edit")
    @RequestMapping("/req_sett")
    @ResponseBody
    public Map req_sett(HttpSession session) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemWeb web = webConfigService.find_by_id(1);
        if (web.getIsApiOpen() == 0) {
            map.put("msg", web.getCloseApiDetial());
            map.put("code", -1);
            return map;
        }
        Date now = new Date();
        int hours = now.getHours();
        int minutes = now.getMinutes();
        if (!((hours == 8 && minutes >= 30) || (hours >= 9 && hours < 21))) {
            map.put("code", "-1");
            map.put("msg", "超过系统提现时间,系统提现时间为每天8:30到21:00之间!");
            return map;
        }
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        SystemUser user = userService.findUserById(info.getId());
        if (user.getIsLocked() == 1) {
            map.put("msg", "账户已锁定,无法结算!");
            map.put("code", -1);
        } else {
            SystemVip vip = vipService.find_vip_by_uid(user.getId());
            if (vip == null) {
                logger.info("系统数据初始化中...");
                map.put("msg", "系统数据初始化中...");
                map.put("code", -1);
                return map;
            }
            Double min = web.getSettMin();
            BigDecimal userbalnes = userBalnesChange.getUserbalnes(user.getId());
            if (userbalnes.compareTo(new BigDecimal(min)) >= 0) {
                BigDecimal staff2;
                if (vip.getStatus() == 1) {
                    staff2 = user.getVipSettStaff();
                } else {
                    staff2 = user.getSettStaff();
                }
                BigDecimal sub = userbalnes.multiply(staff2.setScale(2, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP);
                if (user.getZspaytype() == 4) {
                    sub = sub.add(new BigDecimal(1.00));
                }
                BigDecimal final_money = userbalnes.subtract(sub).setScale(2, BigDecimal.ROUND_HALF_UP);
                logger.info("提现用户:" + user.getUser() + " ID:" + user.getId() + " 余额:" + user.getBalnes().doubleValue() + " 提现手续费:" + sub + " 提现金额:" + final_money);
                map.put("msg", "提现用户:" + user.getUser() + " ID:" + user.getId() + " 余额:" + user.getBalnes().doubleValue() + " 提现手续费:" + sub + " 提现金额:" + final_money + "<br>提现单已生成,请等待管理员审核通过后打款,谢谢合作!");
                boolean b = userBalnesChange.subUserBalnes(user.getId(), final_money.add(sub));
                if (b) {
                    SystemSett sett = new SystemSett();
                    sett.setCreateTime(new Date());
                    sett.setOptUser(1);
                    sett.setSettPreMoney(userbalnes);
                    sett.setSettSubMoney(sub);
                    sett.setSettFinalMoney(final_money);
                    sett.setSid(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(1, 21));
                    sett.setStatus(1);
                    sett.setPreType(user.getZspaytype());
                    sett.setCtype(2);
                    sett.setIsSett(1);
                    sett.setUid(user.getId());
                    settLementService.saveSettLement(sett);
                    map.put("code", 0);
                } else {
                    map.put("code", -2);
                }
            } else {
                map.put("code", -1);
                map.put("msg", "当前账户余额:" + String.valueOf(user.getBalnes()) + "元,不满足最低提现标准:" + String.valueOf(min) + "元,无法进行提现!");
            }
        }
        return map;
    }

    /**
     * 立即结算所有用户
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/sett_all_user")
    @ResponseBody
    public Map sett_all_user() {
        HashMap<Object, Object> map = new HashMap<>();
        SettThread thread = new SettThread(settLementService, userService, vipService, webConfigService, userBalnesChange);
        Thread thread1 = new Thread(thread);
        thread1.setDaemon(true);
        thread1.start();
        map.put("msg", "请求已提交,请稍后刷新用户余额查看!");
        map.put("code", 0);
        return map;
    }

    /**
     * 我的信息
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/info")
    public String info(Model model, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        SystemUser mm = userService.findUserById(info.getId());
        model.addAttribute("uuser", mm);
        model.addAttribute("model", mm);
        SystemWeb systemWeb = webConfigService.find_by_id(1);
        model.addAttribute("web", systemWeb);
        List<SystemNotice> notices = noticeService.findDisplayNotices();
        model.addAttribute("notices", notices);
        model.addAttribute("ordercount1", systemCountService.countOrders(null, info.getId()));
        model.addAttribute("settcount", countService.findUserSettAllCount(info.getId()));
        SystemVip vip = vipService.find_vip_by_uid(mm.getId());
        model.addAttribute("vip", vip);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(mm.getId(), 3, null);
        model.addAttribute("moneyCount3", moneyCount3);
        model.addAttribute("ex_num", extensionService.count_exten_by_uid(null, info.getId()));
        model.addAttribute("ex_money", extensionService.cout_exten_by_uid(null, info.getId()));
        model.addAttribute("ex_money2", extensionService.cout_exten_by_uid(1, info.getId()));
        HashMap<Object, Object> map = new HashMap<>();
        String appkey = mm.getAppkey();
        appkey = MD5Util.MD5Encode(appkey, "utf8").toLowerCase();
        map.put("u", info.getId());
        map.put("k", appkey.substring(0, 10));
        String key = JSON.toJSONString(map);
        key = Base64.encode(key.getBytes());
        model.addAttribute("ex_key", key);
        return "admin/user/info";
    }
}

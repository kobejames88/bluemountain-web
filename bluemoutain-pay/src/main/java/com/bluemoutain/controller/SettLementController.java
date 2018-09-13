package com.bluemoutain.controller;


import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.ext.SysSettExt;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.utils.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 结算控制
 */
@Controller
@RequestMapping("/admin/sett")
public class SettLementController {

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private UserService userService;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    /**
     * 结算列表
     */
    @RequiresPermissions("user_sett_list")
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "20") Integer rows,
                       @RequestParam(defaultValue = "false") Boolean ajax,
                       Model model, Integer status, HttpSession session, Integer payType, String sid) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        PageBean<SysSettExt> bean = settLementService.findByPage(page, rows, status, sid, payType, info.getId());
        model.addAttribute("bean", bean);
        model.addAttribute("status", status);
        model.addAttribute("payType", payType);
        model.addAttribute("sid", sid);
        if (ajax) {
            return "admin/sett/list#pagenode";
        } else {
            return "admin/sett/list";
        }
    }


    /**
     * 结算列表 - 管理员
     */
    @RequiresPermissions("sys_sett_admin")
    @RequestMapping("/list_admin")
    public String list_admin(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "20") Integer rows,
                             @RequestParam(defaultValue = "false") Boolean ajax, Model model, Integer status, Integer payType, Integer user, String sid) {
        PageBean<SysSettExt> bean = settLementService.findByPage(page, rows, status, sid, payType, user);
        model.addAttribute("bean", bean);
        model.addAttribute("status", status);
        model.addAttribute("payType", payType);
        model.addAttribute("user", user);
        model.addAttribute("sid", sid);
        if (ajax) {
            return "admin/sett_admin/list#pagenode";
        } else {
            return "admin/sett_admin/list";
        }
    }

    /**
     * 查看结算
     */
    @RequiresPermissions("user_sett_list")
    @RequestMapping("/view")
    public String view(Integer id, Model model) {
        SystemSett sett = settLementService.find_sett_byId(id);
        SystemUser user = userService.findUserById(sett.getUid());
        model.addAttribute("user2", user);
        model.addAttribute("model", sett);
        return "admin/sett/view";
    }

    /**
     * 查看结算 -  管理员
     */
    @RequiresPermissions("sys_sett_admin")
    @RequestMapping("/view_admin")
    public String view2(Integer id, HttpSession session, Model model) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        SystemSett sett = settLementService.find_sett_byId(id);
        SystemUser user = userService.findUserById(sett.getUid());
        model.addAttribute("user2", user);
        model.addAttribute("model", sett);
        model.addAttribute("user", info);
        return "admin/sett_admin/view";
    }

    /**
     * 手动打款结算信息
     */
    @RequiresPermissions("sys_sett_admin")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(Integer id) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        SystemSett sett1 = settLementService.find_sett_byId(id);
        SystemUser user = userService.findUserById(sett1.getUid());
        Boolean money = false;
        if (user.getZspaytype() == 2) {//支付宝
            money = aliPayFunction.changeMoneyToAccount(sett1, user);
        } else if (user.getZspaytype() == 1) {//微信
            money = wxPayFunctionPC.changeMoneyToWxAccount(sett1, user);
        } else if (user.getZspaytype() == 4) {
            HashMap<String, String> param = new HashMap<>();
            param.put("str", UUID.randomUUID().toString().replaceAll("-", "").substring(0, 31));
            param.put("sid", sett1.getSid());
            param.put("pid", user.getZspayid());
            param.put("pname", user.getZsname());
            param.put("title", "结算:" + sett1.getSid());
            param.put("bank", user.getCardBankCode());
            param.put("final_money", String.valueOf(sett1.getSettFinalMoney()));
            Map ret = wxPayFunctionPC.payToUserCard(param);
            Object error = ret.get("error");
            Integer status = new Integer(ret.get("status").toString());
            Object tran_no = ret.get("tran_no");
            if (status == 2) {
                sett1.setStatus(2);
                sett1.setTranNo(String.valueOf(tran_no));
                sett1.setSettError(String.valueOf(error));
                money = true;
            } else {
                sett1.setStatus(3);
                sett1.setTranNo(String.valueOf(tran_no));
                sett1.setSettError(String.valueOf(error));
                money = false;
            }
        }
        if (money) {
            sett1.setStatus(2);
            sett1.setOkTime(new Date());
            map.put("code", 0);
            map.put("msg", "打款成功!");
        } else {
            sett1.setStatus(3);
            sett1.setOkTime(new Date());
            map.put("code", 0);
            map.put("msg", "打款失败!");
        }
        settLementService.updateSystemSett(sett1);
        return map;
    }

    /**
     * 删除结算信息
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys_sett_admin")
    @ResponseBody
    public Map delete(Integer id) {
        HashMap<Object, Object> map = new HashMap<>();
        settLementService.deleteSystemSett(id);
        map.put("code", 0);
        map.put("msg", "删除成功!");
        return map;
    }

    /**
     * 设置打款状态
     */
    @RequiresPermissions("sys_sett_admin")
    @RequestMapping("/update2")
    @ResponseBody
    public Map update2(Integer id, Integer type, HttpSession session) {
        SystemSett sett1 = settLementService.find_sett_byId(id);
        HashMap<Object, Object> map = new HashMap<>();
        sett1.setStatus(type);
        sett1.setTranNo("000");
        sett1.setSettError("000");
        sett1.setOkTime(new Date());
        settLementService.updateSystemSett(sett1);
        map.put("code", 0);
        map.put("msg", "设置成功!");
        return map;
    }

}

package com.bluemoutain.controller;


import com.bluemoutain.po.SystemDomain;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.ext.DomainCheckExtQuery;
import com.bluemoutain.service.SystemDomainService;
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

/**
 * 域名备案信息公示
 */
@Controller
@RequestMapping("/admin/domain")
public class SystemDomainController {

    @Autowired
    private SystemDomainService domainService;

    @Autowired
    private UserService userService;

    /**
     * 域名备案列表
     */
    @RequiresPermissions("user_domain_list")
    @RequestMapping("/list")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "20") Integer rows,
                        @RequestParam(defaultValue = "false") Boolean ajax,
                        Model model, Integer status, Integer payShowInfo, String serach, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        PageBean<DomainCheckExtQuery> domainByPage = domainService.findDomainByPage(page, rows, status, payShowInfo, info.getId(), serach);
        model.addAttribute("bean", domainByPage);
        model.addAttribute("status", status);
        model.addAttribute("payShowInfo", payShowInfo);
        model.addAttribute("serach", serach);
        if (ajax) {
            return "admin/domain/list#pagenode";
        } else {
            return "admin/domain/list";
        }
    }

    /**
     * 域名备案列表 - 管理员
     */
    @RequiresPermissions("sys_domain_check_admin")
    @RequestMapping("/list_admin")
    public String index_admin(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "20") Integer rows,
                              @RequestParam(defaultValue = "false") Boolean ajax,
                              Model model, Integer pid, Integer status, Integer payShowInfo, String serach) {
        PageBean<DomainCheckExtQuery> domainByPage = domainService.findDomainByPage(page, rows, status, payShowInfo, pid, serach);
        model.addAttribute("bean", domainByPage);
        model.addAttribute("pid", pid);
        model.addAttribute("status", status);
        model.addAttribute("payShowInfo", payShowInfo);
        model.addAttribute("serach", serach);
        if (ajax) {
            return "admin/domain/list_admin#pagenode";
        } else {
            return "admin/domain/list_admin";
        }
    }

    /**
     * 添加页面
     */
    @RequiresPermissions("sys_domain_check_admin")
    @RequestMapping("/add")
    public String add() {
        return "admin/domain/add";
    }

    /**
     * 保存
     */
    @RequiresPermissions("sys_domain_check_admin")
    @RequestMapping("/save")
    @ResponseBody
    public Map save(SystemDomain domain, HttpSession session, Integer pid) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser user = userService.findUserById(pid);
        if (user == null) {
            map.put("msg", "用户不存在!");
            map.put("code", -1);
            return map;
        }
        domain.setUid(pid);
        domain.setOptTime(new Date());
        domainService.saveDomain(domain);
        map.put("msg", "添加成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 编辑页面
     */
    @RequiresPermissions("sys_domain_check_admin")
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        SystemDomain model1 = domainService.find_by_id(id);
        model.addAttribute("model", model1);
        return "admin/domain/edit";
    }

    /**
     * 更新
     */
    @RequiresPermissions("sys_domain_check_admin")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SystemDomain domain, Integer pid) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser user = userService.findUserById(pid);
        if (user == null) {
            map.put("msg", "用户不存在!");
            map.put("code", -1);
            return map;
        }
        domain.setUid(pid);
        domain.setOptTime(new Date());
        domainService.updateDomain(domain);
        map.put("msg", "更新成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 删除
     */
    @RequiresPermissions("sys_domain_check_admin")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        if (info.getRole() == 1) {
            domainService.deleteById(id);
        }
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "删除成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 查看授权信息
     */
    @RequiresPermissions("user_domain_list")
    @RequestMapping("/view")
    public String view(Integer id, Model model) throws Exception {
        SystemDomain domain = domainService.find_by_id(id);
        if (domain == null) {
            throw new Exception("id error");
        }
        SystemUser user = userService.findUserById(domain.getUid());
        model.addAttribute("model", domain);
        model.addAttribute("user", user);
        return "admin/domain/view";
    }

}

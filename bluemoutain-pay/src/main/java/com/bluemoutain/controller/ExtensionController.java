package com.bluemoutain.controller;


import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.po.SysExtension;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.ExtensionService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * 返利控制
 */
@Controller
@RequestMapping("/admin/extension")
public class ExtensionController {

    @Autowired
    private ExtensionService extensionService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserBalnesChange userBalnesChange;

    /**
     * 返利管理列表
     */
    @RequiresPermissions("sys_extension_list")
    @RequestMapping("/list")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "20") Integer rows,
                        @RequestParam(defaultValue = "false") Boolean ajax,
                        Model model, Integer status, Integer e_id, Integer r_id, Integer id) {
        PageBean<SysExtension> bean = extensionService.find_by_page(page, rows, e_id, r_id, id, status);
        model.addAttribute("bean", bean);
        model.addAttribute("status", status);
        model.addAttribute("e_id", e_id);
        model.addAttribute("r_id", r_id);
        model.addAttribute("id", id);
        if (ajax) {
            return "admin/extension/list#pagenode";
        } else {
            return "admin/extension/list";
        }
    }

    /**
     * 删除 记录
     */
    @RequiresPermissions("sys_extension_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        extensionService.delete(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "删除成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 更新状态
     */
    @RequiresPermissions("sys_extension_list")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SysExtension extension) {
        HashMap<Object, Object> map = new HashMap<>();
        SysExtension exten = extensionService.find_by_id(extension.getId());
        Integer id = exten.geteId();
        Integer status = extension.getStatus();
        if (status == 0 && exten.getStatus() == 1) {
            userBalnesChange.subUserBalnes(id, exten.getMoney());
        } else if (status == 1 && exten.getStatus() == 0) {
            userBalnesChange.addUserBalnes(id, exten.getMoney());
        } else if (status == 2 && exten.getStatus() == 1) {
            userBalnesChange.subUserBalnes(id, exten.getMoney());
        } else if (status == 1 && exten.getStatus() == 2) {
            userBalnesChange.addUserBalnes(id, exten.getMoney());
        }
        exten.setStatus(status);
        extensionService.update(exten);
        map.put("msg", "修改成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 查看 - 管理员
     */
    @RequiresPermissions("sys_extension_list")
    @RequestMapping("/view")
    public String view(Integer id, Model model) {
        SysExtension extension = extensionService.find_by_id(id);
        model.addAttribute("model", extension);
        Integer id1 = extension.geteId();
        SystemUser e_user = userService.findUserById(id1);
        Integer id2 = extension.getrId();
        SystemUser r_user = userService.findUserById(id2);
        model.addAttribute("e_user", e_user);
        model.addAttribute("r_user", r_user);
        return "admin/extension/view";
    }

    /**
     * 返利管理列表
     */
    @RequiresPermissions("user_extension_list")
    @RequestMapping("/list_user")
    public String index2(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "20") Integer rows,
                         @RequestParam(defaultValue = "false") Boolean ajax,
                         Model model, Integer status, Integer r_id, Integer id, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        PageBean<SysExtension> bean = extensionService.find_by_page(page, rows, info.getId(), r_id, id, status);
        model.addAttribute("bean", bean);
        model.addAttribute("status", status);
        model.addAttribute("r_id", r_id);
        model.addAttribute("id", id);
        if (ajax) {
            return "admin/extension/list_user#pagenode";
        } else {
            return "admin/extension/list_user";
        }
    }

    /**
     * 查看 - 用户
     */
    @RequiresPermissions("user_extension_list")
    @RequestMapping("/view_user")
    public String view_user(Integer id, Model model) {
        SysExtension extension = extensionService.find_by_id(id);
        model.addAttribute("model", extension);
        Integer id1 = extension.geteId();
        SystemUser e_user = userService.findUserById(id1);
        Integer id2 = extension.getrId();
        SystemUser r_user = userService.findUserById(id2);
        model.addAttribute("e_user", e_user);
        model.addAttribute("r_user", r_user);
        return "admin/extension/view_user";
    }

}

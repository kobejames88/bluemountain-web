package com.bluemoutain.controller;

import com.alibaba.fastjson.JSON;

import com.bluemoutain.po.SysFunction;
import com.bluemoutain.po.SysRole;
import com.bluemoutain.service.SysFunctionService;
import com.bluemoutain.service.SysRoleService;
import com.bluemoutain.utils.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 */
@Controller
@RequestMapping("/admin/role")
public class SystemRoleController {

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysFunctionService functionService;

    /**
     * 角色列表
     */
    @RequiresPermissions("sys_role_list")
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "20") Integer rows,
                       @RequestParam(defaultValue = "false") Boolean ajax,
                       Model model) {
        PageBean<SysRole> bean = roleService.findByPage(page, rows);
        model.addAttribute("bean", bean);
        if (ajax) {
            return "admin/role/list#pagenode";
        } else {
            return "admin/role/list";
        }
    }

    /**
     * 添加
     */
    @RequiresPermissions("sys_role_list")
    @RequestMapping("/add")
    public String add(Model model) {
        List<SysFunction> list = functionService.findAllFunctions();
        List<Map<String, Object>> menus = new ArrayList<>();
        for (SysFunction menu : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", menu.getId());
            map.put("text", menu.getFunName());
            map.put("icon", null);
            map.put("parent", menu.getParent() == 0 ? "#" : menu.getParent());
            map.put("data", menu.getFunDescp());
            menus.add(map);
        }
        model.addAttribute("menu_all", JSON.toJSONString(menus));
        return "admin/role/add";
    }

    /**
     * 保存新角色
     */
    @RequiresPermissions("sys_role_list")
    @RequestMapping("/save")
    @ResponseBody
    public Map save(SysRole role, String menuIds) {
        HashMap<Object, Object> map = new HashMap<>();
        roleService.save(role, menuIds);
        map.put("msg", "添加成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 删除
     */
    @RequiresPermissions("sys_role_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        HashMap<Object, Object> map = new HashMap<>();
        roleService.delete(id);
        map.put("msg", "删除成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 编辑
     */
    @RequiresPermissions("sys_role_list")
    @RequestMapping("/edit")
    public String edit(Model model, Integer id) {
        SysRole model1 = roleService.findById(id);
        model.addAttribute("model", model1);
        List<SysFunction> list = functionService.findAllFunctions();
        List<Map<String, Object>> menus = new ArrayList<>();
        for (SysFunction menu : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", menu.getId());
            map.put("text", menu.getFunName());
            map.put("icon", null);
            map.put("parent", menu.getParent() == 0 ? "#" : menu.getParent());
            map.put("data", menu.getFunDescp());
            menus.add(map);
            Map<String, Boolean> state = new HashMap<>();
            if (menu.getStatus() != 1) {
                state.put("selected", roleService.roleIsHavingFunction(model1.getId(), menu.getId()));
            } else {
                state.put("selected", false);
            }
            map.put("state", state);
        }
        model.addAttribute("menu_all", JSON.toJSONString(menus));
        return "admin/role/edit";
    }

    /**
     * 更新角色
     */
    @RequiresPermissions("sys_role_list")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SysRole role, String menuIds) {
        HashMap<Object, Object> map = new HashMap<>();
        roleService.update(role, menuIds);
        map.put("msg", "更新成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 查看角色信息
     */
    @RequiresPermissions("sys_role_list")
    @RequestMapping("/view")
    public String view(Integer id, Model model) {
        SysRole model1 = roleService.findById(id);
        model.addAttribute("model", model1);
        List<SysFunction> list = functionService.findAllFunctions();
        List<Map<String, Object>> menus = new ArrayList<>();
        for (SysFunction menu : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", menu.getId());
            map.put("text", menu.getFunName());
            map.put("icon", null);
            map.put("parent", menu.getParent() == 0 ? "#" : menu.getParent());
            map.put("data", menu.getFunDescp());
            menus.add(map);
            Map<String, Boolean> state = new HashMap<>();
            if (menu.getStatus() != 1) {
                state.put("selected", roleService.roleIsHavingFunction(model1.getId(), menu.getId()));
            } else {
                state.put("selected", false);
            }
            state.put("disabled", true);
            map.put("state", state);
        }
        model.addAttribute("menu_all", JSON.toJSONString(menus));
        return "admin/role/view";
    }

}

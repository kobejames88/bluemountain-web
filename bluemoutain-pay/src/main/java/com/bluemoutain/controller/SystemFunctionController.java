package com.bluemoutain.controller;

import com.bluemoutain.po.SysFunction;
import com.bluemoutain.service.SysFunctionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限菜单管理
 */
@Controller
@RequestMapping("/admin/function")
public class SystemFunctionController {

    @Autowired
    private SysFunctionService functionService;

    /**
     * 权限列表
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/list")
    public String list(Model model) {
        List<SysFunction> functions = functionService.findByParentId(0);
        model.addAttribute("model", functions);
        return "admin/function/list";
    }

    /**
     * 加载子菜单
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/child")
    public String child(Integer pid, Model model) {
        List<SysFunction> functions = functionService.findByParentId(pid);
        model.addAttribute("model", functions);
        model.addAttribute("parentid", pid);
        return "admin/function/child";
    }

    /**
     * 添加页面
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/add")
    public String add() {
        return "admin/function/add";
    }

    /**
     * 权限树加载
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/tree")
    @ResponseBody
    public List tree(Integer pid) {
        List<Map<String, Object>> menus = new ArrayList<>();
        List<SysFunction> funs = functionService.findByParentId(pid == null ? 0 : pid);
        for (SysFunction fun : funs) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", fun.getId());
            map.put("text", fun.getFunName());
            map.put("icon", null);
            map.put("children", fun.getStatus() == 1);
            map.put("parent", fun.getParent() == 0 ? "#" : fun.getParent());
            map.put("data", fun.getFunDescp());
            menus.add(map);
        }
        return menus;
    }

    /**
     * 保存新菜单
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/save")
    @ResponseBody
    public Map save(SysFunction function) {
        functionService.saveFunction(function);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "添加成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 编辑页面
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        SysFunction bean = functionService.find_by_id(id);
        model.addAttribute("model", bean);
        return "admin/function/edit";
    }

    /**
     * 数据更新
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SysFunction function) {
        functionService.updateFunction(function);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "更新成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 数据删除
     */
    @RequiresPermissions("sys_function_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        functionService.delete_by_id(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "删除成功!");
        map.put("code", 0);
        return map;
    }


}

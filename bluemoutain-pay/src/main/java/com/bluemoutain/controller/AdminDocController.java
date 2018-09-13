package com.bluemoutain.controller;


import com.bluemoutain.po.SystemDoc;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.ApiDocService;
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
 * api文档管理 - 管理员
 */
@Controller
@RequestMapping("/admin/doc")
public class AdminDocController {

    @Autowired
    private ApiDocService apiDocService;

    /**
     * api 文档分页
     */
    @RequiresPermissions("sys_doc_api_list")
    @RequestMapping("/list")
    public String page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "20") Integer rows,
                       @RequestParam(defaultValue = "false") Boolean ajax,
                       Model model,
                       Integer status) {
        PageBean<SystemDoc> bean = apiDocService.findDocByPage(page, rows, status);
        model.addAttribute("bean", bean);
        model.addAttribute("status", status);//筛选条件回显页面
        if (ajax) {
            return "admin/doc/list#pagenode";
        } else {
            return "admin/doc/list";
        }
    }

    /**
     * 添加页面
     */
    @RequiresPermissions("sys_doc_api_list")
    @RequestMapping("/add")
    public String add() {
        return "admin/doc/add";
    }


    /**
     * 保存新文档
     */
    @RequiresPermissions("sys_doc_api_list")
    @RequestMapping("/save")
    @ResponseBody
    public Map save(SystemDoc doc, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        doc.setOptUser(info.getId());
        doc.setId(null);
        apiDocService.saveDocs(doc);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "添加成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 编辑页面
     */
    @RequiresPermissions("sys_doc_api_list")
    @RequestMapping("/edit")
    public String edit(Model model, Integer id) {
        SystemDoc be = apiDocService.findDocById(id);
        model.addAttribute("model", be);
        return "admin/doc/edit";
    }

    /**
     * 更新数据
     */
    @RequiresPermissions("sys_doc_api_list")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SystemDoc doc, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        doc.setOptUser(info.getId());
        doc.setCreateTime(new Date());
        apiDocService.updateDocById(doc);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "更新成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 删除数据
     */
    @RequiresPermissions("sys_doc_api_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        apiDocService.deleteDocById(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "删除成功!");
        map.put("code", 0);
        return map;
    }

}

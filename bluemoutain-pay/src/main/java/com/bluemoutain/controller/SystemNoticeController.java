package com.bluemoutain.controller;


import com.bluemoutain.po.SystemNotice;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.NoticeService;
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

@Controller
@RequestMapping("/admin/notice")
public class SystemNoticeController {

    @Autowired
    private NoticeService service;

    /**
     * 系统公告 - 管理员
     */
    @RequiresPermissions("sys_notice_list")
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "20") Integer rows,
                       @RequestParam(defaultValue = "false") Boolean ajax,
                       Model model,
                       Integer status) {
        PageBean<SystemNotice> notice = service.findNoticeByPage(page, rows, status);
        model.addAttribute("bean", notice);
        if (ajax) {
            return "admin/notice/list#pagenode";
        } else {
            return "admin/notice/list";
        }
    }

    /**
     * 系统公告 - 添加
     */
    @RequiresPermissions("sys_notice_list")
    @RequestMapping("/add")
    public String add() {
        return "admin/notice/add";
    }

    /**
     * 保存
     */
    @RequiresPermissions("sys_notice_list")
    @RequestMapping("/save")
    @ResponseBody
    public Map save(SystemNotice notice, HttpSession session) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        notice.setUid(info.getId());
        service.saveNotice(notice);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "添加成功");
        map.put("code", 0);
        return map;
    }

    /**
     * 编辑
     */
    @RequiresPermissions("sys_notice_list")
    @RequestMapping("/edit")
    public String edit(Model model, Integer id) {
        SystemNotice model1 = service.findById(id);
        model.addAttribute("bean", model1);
        return "admin/notice/edit";
    }

    /**
     * 更新数据
     */
    @RequiresPermissions("sys_notice_list")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SystemNotice notice) {
        service.updateNotice(notice);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "更新成功");
        map.put("code", 0);
        return map;
    }

    /**
     * 删除数据
     */
    @RequiresPermissions("sys_notice_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        service.deleteNotice(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "更新成功");
        map.put("code", 0);
        return map;
    }

}

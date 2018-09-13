package com.bluemoutain.controller;


import com.bluemoutain.po.SystemConfigWithBLOBs;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.UserConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 页面设置控制器
 */
@Controller
@RequestMapping("/admin/config")
public class SystemConfigController {

    @Autowired
    private UserConfigService service;

    /**
     * 页面设置
     */
    @RequiresPermissions("web_config")
    @RequestMapping("/edit")
    public String edit(HttpSession session, Model model) {
        SystemUser userInfo = (SystemUser) session.getAttribute("userInfo");
        Integer id = userInfo.getId();
        SystemConfigWithBLOBs config = service.findConfigByUid(id);
        model.addAttribute("model", config);
        return "admin/config/edit";
    }

    /**
     * 修改页面设置
     */
    @RequiresPermissions("web_config")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SystemConfigWithBLOBs config, HttpSession session) {
        SystemUser userInfo = (SystemUser) session.getAttribute("userInfo");
        Integer id = userInfo.getId();
        config.setUid(id);
        service.updateVonfig(config);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "修改成功!");
        map.put("code", 0);
        return map;
    }


}

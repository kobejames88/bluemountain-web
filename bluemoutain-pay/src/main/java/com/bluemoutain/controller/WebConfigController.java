package com.bluemoutain.controller;

import com.bluemoutain.plugins.FileManagerUpload;
import com.bluemoutain.plugins.fastdfs.FastDfsUtil;
import com.bluemoutain.po.SysRole;
import com.bluemoutain.po.SystemWebWithBLOBs;
import com.bluemoutain.service.SysRoleService;
import com.bluemoutain.service.WebConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/wconfig")
public class WebConfigController {

    @Autowired
    private WebConfigService service;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private FastDfsUtil fastDfsUtil;

    @Autowired
    private FileManagerUpload manager;

    @Value("${fdfs.enable}")
    private Integer enable;

    /**
     * 网站设置
     */
    @RequiresPermissions("sys_web_config")
    @RequestMapping("/edit")
    public String edit(Model model) {
        SystemWebWithBLOBs web = service.find_by_id(1);
        model.addAttribute("model", web);
        List<SysRole> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        return "admin/wconfig/edit";
    }

    /**
     * 更新网站配置
     */
    @RequiresPermissions("sys_web_config")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SystemWebWithBLOBs web) {
        service.update_web_config(web);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "更新成功!");
        map.put("code", "0");
        return map;
    }

    /**
     * 上传文件
     */
    @RequiresPermissions("sys_web_config")
    @RequestMapping("/img_update")
    @ResponseBody
    public Map imageUpload(MultipartFile picFile, Integer id, Integer type) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        SystemWebWithBLOBs config = service.find_by_id(id);
        if (config == null) {
            map.put("msg", "数据错误!");
            map.put("code", 0);
            return map;
        }
        if (type == null) {
            map.put("msg", "数据错误!");
            map.put("code", 0);
            return map;
        }
        byte[] bytes = picFile.getBytes();
        String fileName = picFile.getOriginalFilename();
        String extentionName = fileName.substring(fileName.lastIndexOf(".") + 1); // 后缀名
        String s;
        if (enable == 0) {
            s = manager.saveFile(bytes, extentionName);
        } else {
            s = fastDfsUtil.uploadFile(bytes, extentionName);
        }
        if (type == 1) {
            config.setHomeLogo("/" + s);
        } else {
            config.setHomeQrcode("/" + s);
        }
        service.update_web_config(config);
        map.put("msg", "保存成功!");
        map.put("code", 0);
        return map;
    }

}

package com.bluemoutain.controller;


import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import com.bluemoutain.service.PayConfigService;
import com.bluemoutain.utils.MailUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付配置
 */
@Controller
@RequestMapping("/admin/payConfig")
public class PayConfigController {

    @Autowired
    private PayConfigService payConfigService;

    @Autowired
    private MailUtils utils;


    /**
     * 获取配置
     */
    @RequiresPermissions("pay_config")
    @RequestMapping("/edit")
    public String edit(Model model) {
        SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(1);
        model.addAttribute("model", config);
        return "admin/pay_config/edit";
    }

    /**
     * 更新配置
     */
    @RequiresPermissions("pay_config")
    @RequestMapping("/update")
    @ResponseBody
    public Map update(SystemPayConfigWithBLOBs config) {
        HashMap<Object, Object> map = new HashMap<>();
        payConfigService.updatePPayConfig(config);
        final Thread thread = new Thread(() -> {
            try {
                utils.reGetSession();
                System.out.println("重新初始化邮件配置成功!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        map.put("msg", "更新成功!");
        map.put("code", "0");
        return map;
    }

    /**
     * 上传文件
     */
    @RequestMapping("/cert_update")
    @ResponseBody
    public Map imageUpload(MultipartFile picFile, Integer id, Integer type) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(id);
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
        if (type == 1) {
            config.setQqpayApiCert(bytes);
        } else {
            config.setWxpayApiCert(bytes);
        }
        payConfigService.updatePPayConfig(config);
        map.put("msg", "保存成功!");
        map.put("code", 0);
        return map;
    }

}

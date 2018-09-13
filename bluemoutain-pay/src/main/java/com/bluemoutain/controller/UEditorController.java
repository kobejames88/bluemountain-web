package com.bluemoutain.controller;


import com.bluemoutain.plugins.FileManagerUpload;
import com.bluemoutain.plugins.fastdfs.FastDfsUtil;
import com.bluemoutain.plugins.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class UEditorController {

    @Autowired
    private FastDfsUtil fastDfsUtil;

    @Autowired
    private FileManagerUpload manager;

    @Value("${fdfs.enable}")
    private Integer enable;

    /**
     * ueditor 初始化
     */
    @RequestMapping(value = "/ueditor/config.php")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getServletContext().getRealPath("");
        try {
            String exec = new ActionEnter(request, fastDfsUtil, rootPath, enable, manager).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

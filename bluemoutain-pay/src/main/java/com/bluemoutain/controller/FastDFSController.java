package com.bluemoutain.controller;


import com.bluemoutain.plugins.FileManagerUpload;
import com.bluemoutain.plugins.fastdfs.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FastDFSController {

    @Autowired
    private FastDfsUtil fastDfsUtil;

    @Autowired
    private FileManagerUpload manager;

    /**
     * 配置 fastdfs 代理程序，实现访问fastdfs
     */
    @RequestMapping("/group{id}/**")
    public void wapper_fastdfs(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
        String type = "";
        String filename = "";
        try {
            String group = "group" + id;
            String uri = request.getRequestURI();
            filename = uri.substring(group.length() + 2, uri.length());
            ServletContext context = request.getSession().getServletContext();
            type = context.getMimeType(filename);
            response.setContentType(type);
            ServletOutputStream stream = response.getOutputStream();
            fastDfsUtil.downloadFileStream(group, filename, stream);
            stream.flush();
            stream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("FastDFS: group:" + id + " file:" + filename + " ContentType:" + type);
        }
    }

    /**
     * 本地文件 - 获取
     */
    @RequestMapping("/file_index")
    public void file_index(HttpServletRequest request, HttpServletResponse response, String n) throws Exception {
        String type;
        ServletContext context = request.getSession().getServletContext();
        type = context.getMimeType(n);
        response.setContentType(type);
        response.setContentType(type);
        ServletOutputStream stream = response.getOutputStream();
        stream.write(manager.getFile(n));
        stream.flush();
        stream.close();
    }


}

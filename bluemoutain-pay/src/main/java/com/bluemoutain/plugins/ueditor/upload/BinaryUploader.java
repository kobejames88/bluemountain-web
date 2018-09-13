package com.bluemoutain.plugins.ueditor.upload;


import com.bluemoutain.plugins.FileManagerUpload;
import com.bluemoutain.plugins.fastdfs.FastDfsUtil;
import com.bluemoutain.plugins.ueditor.define.AppInfo;
import com.bluemoutain.plugins.ueditor.define.BaseState;
import com.bluemoutain.plugins.ueditor.define.State;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BinaryUploader {


    public static final State save(HttpServletRequest request, Map<String, Object> conf, FastDfsUtil fastDfsUtil, Integer type, FileManagerUpload managerUpload) {
        FileItemStream fileStream = null;
        boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;

        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
        }
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        if (isAjaxUpload) {
            upload.setHeaderEncoding("UTF-8");
        }
        try {
            State storageState = null;
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                Iterator<String> it = multiRequest.getFileNames();
                while (it.hasNext()) {
                    MultipartFile file = multiRequest.getFile(it.next());
                    if (file != null) {
                        String fileName = file.getOriginalFilename();
                        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                        String file222;
                        if (type == 0) {
                            file222 = managerUpload.saveFile(file.getBytes(), fileExt);
                        } else {
                            file222 = fastDfsUtil.uploadFile(file.getBytes(), fileExt);
                        }
                        if (file222 != null && file222.trim().length() > 0) {
                            storageState = new BaseState(true);
                        }
                        if (storageState.isSuccess()) {
                            storageState.putInfo("url", "/" + file222);
                            storageState.putInfo("type", fileExt);
                            storageState.putInfo("original", fileName + fileExt);
                        }
                    }
                }
            }
            return storageState;
        } catch (IOException e) {
            return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
        } catch (Exception e) {
        }
        return new BaseState(false, AppInfo.IO_ERROR);
    }

    private static boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);

        return list.contains(type);
    }
}

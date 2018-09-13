package com.bluemoutain.plugins.ueditor.upload;




import com.bluemoutain.plugins.FileManagerUpload;
import com.bluemoutain.plugins.fastdfs.FastDfsUtil;
import com.bluemoutain.plugins.ueditor.define.State;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Uploader {
    private FastDfsUtil fastDfsUtil = null;
    private Integer storage_type;
    private FileManagerUpload fileManager;

    private HttpServletRequest request = null;
    private Map<String, Object> conf = null;

    public Uploader(HttpServletRequest request, Map<String, Object> conf, FastDfsUtil f, Integer type, FileManagerUpload manager) {
        this.fastDfsUtil = f;
        this.request = request;
        this.conf = conf;
        this.storage_type = type;
        this.fileManager = manager;
    }

    public final State doExec() {
        String filedName = (String) this.conf.get("fieldName");
        State state = null;
        if ("true".equals(this.conf.get("isBase64"))) {
            state = Base64Uploader.save(this.request.getParameter(filedName), this.conf, fastDfsUtil, storage_type, fileManager);
        } else {
            state = BinaryUploader.save(this.request, this.conf, fastDfsUtil, storage_type, fileManager);
        }
        return state;
    }
}

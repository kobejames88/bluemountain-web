package com.bluemoutain.plugins.ueditor.upload;



import com.bluemoutain.plugins.FileManagerUpload;
import com.bluemoutain.plugins.fastdfs.FastDfsUtil;
import com.bluemoutain.plugins.ueditor.define.BaseState;
import com.bluemoutain.plugins.ueditor.define.State;
import org.apache.commons.codec.binary.Base64;

import java.util.Map;

public final class Base64Uploader {

    public static State save(String content, Map<String, Object> conf, FastDfsUtil fastDfsUtil, Integer type, FileManagerUpload managerUpload) {

        byte[] data = decode(content);

//        long maxSize = ((Long) conf.get("maxSize")).longValue();
//
//        if (!validSize(data, maxSize)) {
//            return new BaseState(false, AppInfo.MAX_SIZE);
//        }
//
//        String suffix = FileType.getSuffix("JPG");
//
//        String savePath = PathFormat.parse(
//                (String) conf.get("savePath"),
//                (String) conf.get("filename")
//        );
//
//        savePath = savePath + suffix;
//        String physicalPath = conf.get("rootPath") + savePath;
//        State storageState = StorageManager.saveBinaryFile(data, physicalPath);
//
//        if (storageState.isSuccess()) {
//            storageState.putInfo("url", PathFormat.format(savePath));
//            storageState.putInfo("type", suffix);
//            storageState.putInfo("original", "");
//        }

        State storageState = null;
        String fileName = (String) conf.get("filename");
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        String file222;
        if (type == 0) {
            file222 = managerUpload.saveFile(data, fileExt);
        } else {
            file222 = fastDfsUtil.uploadFile(data, fileExt);
        }
        if (file222 != null && file222.trim().length() > 0) {
            storageState = new BaseState(true);
        }
        if (storageState.isSuccess()) {
            storageState.putInfo("url", "/" + file222);
            storageState.putInfo("type", fileExt);
            storageState.putInfo("original", fileName + fileExt);
        }
        return storageState;
    }

    private static byte[] decode(String content) {
        return Base64.decodeBase64(content);
    }

    private static boolean validSize(byte[] data, long length) {
        return data.length <= length;
    }

}
package com.bluemoutain.plugins;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.bluemoutain.utils.Base64;
/**
 * 本地文件存储方案
 */
@Component
@ConfigurationProperties(prefix = "fdfs")
public class FileManagerUpload {

    private static Logger logger = LoggerFactory.getLogger(FileManagerUpload.class);

    private String base_path;

    private Integer enable = 0;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
        if (enable == 0) {
            try {
                this.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void init() {
        logger.info("本地文件服务,初始化...");
        ApplicationHome home = new ApplicationHome(getClass());
        File jarFile = home.getSource();
        String p = jarFile.getParentFile().toString();
        this.setBase_path(p);
        File dir = new File(base_path + "/upload");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        base_path = dir.getAbsolutePath();
        logger.info("文件存储路径:" + base_path);
    }

    public String getBase_path() {
        if (base_path == null) {
            this.init();
        }
        return base_path;
    }

    public void setBase_path(String base_path) {
        this.base_path = base_path;
    }

    /**
     * 保存文件到本地
     */
    public String saveFile(byte[] file, String extentionName) {
        String basePath = null;
        try {
            basePath = this.getBase_path();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String file_md5 = byteArrayToHexString(md.digest(file));
        String fileName = Base64.encode(file_md5.toLowerCase().getBytes());
        fileName = fileName.substring(0, fileName.length() - 1) + "." + extentionName;
        File save = new File(basePath + "/" + fileName);
        if (save.exists()) {
            logger.info("文件:" + fileName + " 已存在,跳过存储...");
            return "file_index?n=" + fileName;
        } else {
            logger.info("文件:" + fileName + " 不存在,正在存储...");
            bytesToFile(file, save.getAbsolutePath());
            return "file_index?n=" + fileName;
        }
    }

    /**
     * 获取文件
     */
    public byte[] getFile(String name) throws Exception {
        String basePath = this.getBase_path();
        File save = new File(basePath + "/" + name);
        if (!save.exists()) {
            throw new Exception("文件:" + name + " 不存在!");
        }
        logger.info("获取文件:" + name);
        return fileToBytes(save.getAbsolutePath());
    }

    private static void bytesToFile(byte[] buffer, final String filePath) {
        File file = new File(filePath);
        OutputStream output = null;
        BufferedOutputStream bufferedOutput = null;
        try {
            output = new FileOutputStream(file);
            bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedOutput) {
                try {
                    bufferedOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static byte[] fileToBytes(String filePath) {
        byte[] buffer = null;
        File file = new File(filePath);
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (null != bos) {
                    bos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (null != fis) {
                        fis.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return buffer;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}

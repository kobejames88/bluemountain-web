package com.bluemoutain.crond.process;



import com.bluemoutain.interceptr.BaseInterceptor;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.jar.JarInputStream;

/**
 * 验证包签名
 */
public class VerfySign implements Runnable {

    /**
     * 调试时 设置为 false 跳过 签名验证
     * 发布时 设置为 true 检测 文件签名
     */
    private static final boolean isVerifyFileSign = false;

    /**
     * 验证 Jar 文件签名,检测文件是否被修改
     */
    @Override
    public void run() {
        String filePath = System.getProperty("java.class.path");
        System.out.println(filePath);
        try {
            if (isVerifyFileSign) {
                InputStream in = new FileInputStream(filePath);
                JarInputStream jarIn = new JarInputStream(in, true);
                while (jarIn.getNextJarEntry() != null) {
                    continue;
                }
            }
        } catch (Exception e) {
            BaseInterceptor.verify = false;
        }
    }

}

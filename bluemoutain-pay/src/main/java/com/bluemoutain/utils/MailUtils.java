package com.bluemoutain.utils;


import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import com.bluemoutain.service.PayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.Security;
import java.util.Properties;

/**
 * 发送邮件
 */
@Component
public class MailUtils {

    @Autowired
    private PayConfigService payConfigService;

    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    private String host;

    private Integer port;

    private String user;

    private String password;

    private Session session = null;

    private void init() throws Exception {
        SystemPayConfigWithBLOBs payConfig = payConfigService.getPayConfig(1);
        if (payConfig == null) {
            throw new Exception("数据错误,请重新导入SQL文件!");
        }
        this.setHost(payConfig.getMailHost());
        this.setPort(payConfig.getMailPost());
        this.setUser(payConfig.getMailUser());
        this.setPassword(payConfig.getMailPw());
    }

    public Session getSession() throws Exception {
        if (session == null) {
            this.init();
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", port.toString());
            props.setProperty("mail.smtp.socketFactory.port", port.toString());
            props.setProperty("mail.smtp.auth", "true");
            session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });
            return session;
        } else {
            return session;
        }
    }

    public Session reGetSession() throws Exception {
        this.init();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", port.toString());
        props.setProperty("mail.smtp.socketFactory.port", port.toString());
        props.setProperty("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        return session;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 发送邮件
     */
    public boolean sendMail(String subject, String content, String to_user_email, String persional) {
        try {
            MimeMessage message = new MimeMessage(this.getSession());
            message.setFrom(new InternetAddress(user, persional, "UTF-8"));
            message.setRecipients(Message.RecipientType.TO, to_user_email);
            message.setSubject(subject, "UTF-8");
            MimeBodyPart mmp = new MimeBodyPart();
            mmp.setContent(content, "text/html;charset=UTF-8");
            MimeMultipart mmp1 = new MimeMultipart();
            mmp1.addBodyPart(mmp);
            mmp1.setSubType("related");
            message.setContent(mmp1);
            message.saveChanges();
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
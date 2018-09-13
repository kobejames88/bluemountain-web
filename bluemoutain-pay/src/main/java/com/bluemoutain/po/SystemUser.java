package com.bluemoutain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SystemUser implements Serializable {
    private Integer id;

    private String user;

    private String pwd;

    private Integer role;

    private String showname;

    private String email;

    private String phone;

    private Integer age;

    private Integer sex;

    private Date cresteTime;

    private String createIp;

    private Date lastLoginTime;

    private String appkey;

    private BigDecimal balnes;

    private String zsname;

    private Integer zspaytype;

    private String zspayid;

    private Integer isLocked;

    private Integer userParent;

    private String url;

    private Integer isAutoSett;

    private String cardBankCode;

    private BigDecimal payStaff;

    private BigDecimal settStaff;

    private BigDecimal vipPayStaff;

    private BigDecimal vipSettStaff;

    private Integer payAlipay;

    private Integer payQqpay;

    private Integer payWxpay;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname == null ? null : showname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCresteTime() {
        return cresteTime;
    }

    public void setCresteTime(Date cresteTime) {
        this.cresteTime = cresteTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    public BigDecimal getBalnes() {
        return balnes;
    }

    public void setBalnes(BigDecimal balnes) {
        this.balnes = balnes;
    }

    public String getZsname() {
        return zsname;
    }

    public void setZsname(String zsname) {
        this.zsname = zsname == null ? null : zsname.trim();
    }

    public Integer getZspaytype() {
        return zspaytype;
    }

    public void setZspaytype(Integer zspaytype) {
        this.zspaytype = zspaytype;
    }

    public String getZspayid() {
        return zspayid;
    }

    public void setZspayid(String zspayid) {
        this.zspayid = zspayid == null ? null : zspayid.trim();
    }

    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getUserParent() {
        return userParent;
    }

    public void setUserParent(Integer userParent) {
        this.userParent = userParent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getIsAutoSett() {
        return isAutoSett;
    }

    public void setIsAutoSett(Integer isAutoSett) {
        this.isAutoSett = isAutoSett;
    }

    public String getCardBankCode() {
        return cardBankCode;
    }

    public void setCardBankCode(String cardBankCode) {
        this.cardBankCode = cardBankCode == null ? null : cardBankCode.trim();
    }

    public BigDecimal getPayStaff() {
        return payStaff;
    }

    public void setPayStaff(BigDecimal payStaff) {
        this.payStaff = payStaff;
    }

    public BigDecimal getSettStaff() {
        return settStaff;
    }

    public void setSettStaff(BigDecimal settStaff) {
        this.settStaff = settStaff;
    }

    public BigDecimal getVipPayStaff() {
        return vipPayStaff;
    }

    public void setVipPayStaff(BigDecimal vipPayStaff) {
        this.vipPayStaff = vipPayStaff;
    }

    public BigDecimal getVipSettStaff() {
        return vipSettStaff;
    }

    public void setVipSettStaff(BigDecimal vipSettStaff) {
        this.vipSettStaff = vipSettStaff;
    }

    public Integer getPayAlipay() {
        return payAlipay;
    }

    public void setPayAlipay(Integer payAlipay) {
        this.payAlipay = payAlipay;
    }

    public Integer getPayQqpay() {
        return payQqpay;
    }

    public void setPayQqpay(Integer payQqpay) {
        this.payQqpay = payQqpay;
    }

    public Integer getPayWxpay() {
        return payWxpay;
    }

    public void setPayWxpay(Integer payWxpay) {
        this.payWxpay = payWxpay;
    }
}
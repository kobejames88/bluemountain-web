package com.bluemoutain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SystemOrder implements Serializable {
    private Integer id;

    private Integer payType;

    private String outOrderId;

    private BigDecimal price;

    private Integer status;

    private Date createTime;

    private Date paidTime;

    private BigDecimal paid;

    private String title;

    private String context;

    private String tradeNo;

    private String tradeStatus;

    private Integer uid;

    private String notifyUrl;

    private String returnUrl;

    private Integer isSett;

    private Integer prePayType;

    private String preAccount;

    private String preZsName;

    private String email;

    private Integer orderType;

    private String ipAddr;

    private BigDecimal changeSett;

    private Integer isNotify;

    private Integer chType;

    private Integer chNum;

    private String siteName;

    private String extenKey;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId == null ? null : outOrderId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    public Integer getIsSett() {
        return isSett;
    }

    public void setIsSett(Integer isSett) {
        this.isSett = isSett;
    }

    public Integer getPrePayType() {
        return prePayType;
    }

    public void setPrePayType(Integer prePayType) {
        this.prePayType = prePayType;
    }

    public String getPreAccount() {
        return preAccount;
    }

    public void setPreAccount(String preAccount) {
        this.preAccount = preAccount == null ? null : preAccount.trim();
    }

    public String getPreZsName() {
        return preZsName;
    }

    public void setPreZsName(String preZsName) {
        this.preZsName = preZsName == null ? null : preZsName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public BigDecimal getChangeSett() {
        return changeSett;
    }

    public void setChangeSett(BigDecimal changeSett) {
        this.changeSett = changeSett;
    }

    public Integer getIsNotify() {
        return isNotify;
    }

    public void setIsNotify(Integer isNotify) {
        this.isNotify = isNotify;
    }

    public Integer getChType() {
        return chType;
    }

    public void setChType(Integer chType) {
        this.chType = chType;
    }

    public Integer getChNum() {
        return chNum;
    }

    public void setChNum(Integer chNum) {
        this.chNum = chNum;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getExtenKey() {
        return extenKey;
    }

    public void setExtenKey(String extenKey) {
        this.extenKey = extenKey == null ? null : extenKey.trim();
    }
}
package com.bluemoutain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PutForward implements Serializable {
    private Integer id;

    private Integer optUser;

    private Date optTime;

    private String psd;

    private String title;

    private String putId;

    private String putName;

    private BigDecimal price;

    private Integer status;

    private String errorInfo;

    private String trano;

    private Integer pType;

    private String ip;

    private String str;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOptUser() {
        return optUser;
    }

    public void setOptUser(Integer optUser) {
        this.optUser = optUser;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd == null ? null : psd.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPutId() {
        return putId;
    }

    public void setPutId(String putId) {
        this.putId = putId == null ? null : putId.trim();
    }

    public String getPutName() {
        return putName;
    }

    public void setPutName(String putName) {
        this.putName = putName == null ? null : putName.trim();
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

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }

    public String getTrano() {
        return trano;
    }

    public void setTrano(String trano) {
        this.trano = trano == null ? null : trano.trim();
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str == null ? null : str.trim();
    }
}
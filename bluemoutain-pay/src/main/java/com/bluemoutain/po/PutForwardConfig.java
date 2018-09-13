package com.bluemoutain.po;

import java.io.Serializable;
import java.util.Date;

public class PutForwardConfig implements Serializable {
    private Integer id;

    private Integer optUser;

    private Date optTime;

    private String alipayName;

    private String alipayId;

    private String wxName;

    private String wxOpenId;

    private String title;

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

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName == null ? null : alipayName.trim();
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId == null ? null : alipayId.trim();
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName == null ? null : wxName.trim();
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}
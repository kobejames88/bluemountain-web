package com.bluemoutain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SystemVip implements Serializable {
    private Integer id;

    private Integer status;

    private Date startTime;

    private Date endTime;

    private Integer uid;

    private Date createTime;

    private Date optTime;

    private Integer experienceNum;

    private BigDecimal experiencePrice;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public Integer getExperienceNum() {
        return experienceNum;
    }

    public void setExperienceNum(Integer experienceNum) {
        this.experienceNum = experienceNum;
    }

    public BigDecimal getExperiencePrice() {
        return experiencePrice;
    }

    public void setExperiencePrice(BigDecimal experiencePrice) {
        this.experiencePrice = experiencePrice;
    }
}
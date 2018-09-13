package com.bluemoutain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SystemSett implements Serializable {
    private Integer id;

    private String sid;

    private Integer uid;

    private BigDecimal settPreMoney;

    private BigDecimal settSubMoney;

    private BigDecimal settFinalMoney;

    private Date createTime;

    private Date okTime;

    private Integer status;

    private Integer optUser;

    private Integer preType;

    private Integer ctype;

    private String tranNo;

    private String settError;

    private Integer isSett;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getSettPreMoney() {
        return settPreMoney;
    }

    public void setSettPreMoney(BigDecimal settPreMoney) {
        this.settPreMoney = settPreMoney;
    }

    public BigDecimal getSettSubMoney() {
        return settSubMoney;
    }

    public void setSettSubMoney(BigDecimal settSubMoney) {
        this.settSubMoney = settSubMoney;
    }

    public BigDecimal getSettFinalMoney() {
        return settFinalMoney;
    }

    public void setSettFinalMoney(BigDecimal settFinalMoney) {
        this.settFinalMoney = settFinalMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOkTime() {
        return okTime;
    }

    public void setOkTime(Date okTime) {
        this.okTime = okTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOptUser() {
        return optUser;
    }

    public void setOptUser(Integer optUser) {
        this.optUser = optUser;
    }

    public Integer getPreType() {
        return preType;
    }

    public void setPreType(Integer preType) {
        this.preType = preType;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo == null ? null : tranNo.trim();
    }

    public String getSettError() {
        return settError;
    }

    public void setSettError(String settError) {
        this.settError = settError == null ? null : settError.trim();
    }

    public Integer getIsSett() {
        return isSett;
    }

    public void setIsSett(Integer isSett) {
        this.isSett = isSett;
    }
}
package com.bluemoutain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysExtension implements Serializable {
    private Integer id;

    private Integer eId;

    private String eName;

    private Integer rId;

    private String rName;

    private Integer status;

    private BigDecimal money;

    private Date createTime;

    private String eKey;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String geteKey() {
        return eKey;
    }

    public void seteKey(String eKey) {
        this.eKey = eKey == null ? null : eKey.trim();
    }
}
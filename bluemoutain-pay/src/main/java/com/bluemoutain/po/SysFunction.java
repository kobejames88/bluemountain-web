package com.bluemoutain.po;

import java.io.Serializable;
import java.util.Date;

public class SysFunction implements Serializable {
    private Integer id;

    private String funName;

    private String funDescp;

    private String funPath;

    private Integer parent;

    private Integer status;

    private Date optTime;

    private Integer isMenu;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

    public String getFunDescp() {
        return funDescp;
    }

    public void setFunDescp(String funDescp) {
        this.funDescp = funDescp == null ? null : funDescp.trim();
    }

    public String getFunPath() {
        return funPath;
    }

    public void setFunPath(String funPath) {
        this.funPath = funPath == null ? null : funPath.trim();
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }
}
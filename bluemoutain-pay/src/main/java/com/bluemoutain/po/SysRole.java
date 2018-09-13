package com.bluemoutain.po;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    private Integer id;

    private String roleName;

    private String roleDescp;

    private Date optTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescp() {
        return roleDescp;
    }

    public void setRoleDescp(String roleDescp) {
        this.roleDescp = roleDescp == null ? null : roleDescp.trim();
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }
}
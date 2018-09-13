package com.bluemoutain.po;

import java.io.Serializable;

public class SystemWebWithBLOBs extends SystemWeb implements Serializable {
    private String userDef;

    private String payReadme;

    private static final long serialVersionUID = 1L;

    public String getUserDef() {
        return userDef;
    }

    public void setUserDef(String userDef) {
        this.userDef = userDef == null ? null : userDef.trim();
    }

    public String getPayReadme() {
        return payReadme;
    }

    public void setPayReadme(String payReadme) {
        this.payReadme = payReadme == null ? null : payReadme.trim();
    }
}
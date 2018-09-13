package com.bluemoutain.po;

import java.io.Serializable;

public class SystemConfigWithBLOBs extends SystemConfig implements Serializable {
    private String keywords;

    private String description;

    private String panel;

    private String copy;

    private String liuyan;

    private static final long serialVersionUID = 1L;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel == null ? null : panel.trim();
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy == null ? null : copy.trim();
    }

    public String getLiuyan() {
        return liuyan;
    }

    public void setLiuyan(String liuyan) {
        this.liuyan = liuyan == null ? null : liuyan.trim();
    }
}
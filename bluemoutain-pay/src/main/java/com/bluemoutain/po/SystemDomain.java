package com.bluemoutain.po;

import java.io.Serializable;
import java.util.Date;

public class SystemDomain implements Serializable {
    private Integer id;

    private String domain;

    private String nature;

    private String icp;

    private String indexUrl;

    private String sitename;

    private String nowIcp;

    private String name1;

    private Integer status;

    private String serach;

    private Date optTime;

    private Integer uid;

    private Integer payShowInfo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp == null ? null : icp.trim();
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl == null ? null : indexUrl.trim();
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }

    public String getNowIcp() {
        return nowIcp;
    }

    public void setNowIcp(String nowIcp) {
        this.nowIcp = nowIcp == null ? null : nowIcp.trim();
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSerach() {
        return serach;
    }

    public void setSerach(String serach) {
        this.serach = serach == null ? null : serach.trim();
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPayShowInfo() {
        return payShowInfo;
    }

    public void setPayShowInfo(Integer payShowInfo) {
        this.payShowInfo = payShowInfo;
    }
}
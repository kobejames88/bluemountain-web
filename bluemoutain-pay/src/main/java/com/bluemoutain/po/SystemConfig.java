package com.bluemoutain.po;

import java.io.Serializable;

public class SystemConfig implements Serializable {
    private Integer id;

    private String sitename;

    private String kfqq;

    private String ym;

    private String gg;

    private String music;

    private Integer uid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }

    public String getKfqq() {
        return kfqq;
    }

    public void setKfqq(String kfqq) {
        this.kfqq = kfqq == null ? null : kfqq.trim();
    }

    public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym == null ? null : ym.trim();
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg == null ? null : gg.trim();
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music == null ? null : music.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
package com.bluemoutain.po.ext;

public class WXLoginRet {

    /**
     * access_token : ACCESS_TOKEN
     * refresh_token : REFRESH_TOKEN
     * openid : OPENID
     * scope : SCOPE
     * expires_in : 7200
     */
    private String access_token;
    private String refresh_token;
    private String openid;
    private String scope;
    private int expires_in;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public String getScope() {
        return scope;
    }

    public int getExpires_in() {
        return expires_in;
    }

    @Override
    public String toString() {
        return "WXLoginRet{" +
                "access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}

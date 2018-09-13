package com.bluemoutain.po;

import java.io.Serializable;

public class SystemPayConfigWithBLOBs extends SystemPayConfig implements Serializable {
    private String alipayOpenPublicKey;

    private String alipayOpenPrivateKey;

    private byte[] wxpayApiCert;

    private byte[] qqpayApiCert;

    private static final long serialVersionUID = 1L;

    public String getAlipayOpenPublicKey() {
        return alipayOpenPublicKey;
    }

    public void setAlipayOpenPublicKey(String alipayOpenPublicKey) {
        this.alipayOpenPublicKey = alipayOpenPublicKey == null ? null : alipayOpenPublicKey.trim();
    }

    public String getAlipayOpenPrivateKey() {
        return alipayOpenPrivateKey;
    }

    public void setAlipayOpenPrivateKey(String alipayOpenPrivateKey) {
        this.alipayOpenPrivateKey = alipayOpenPrivateKey == null ? null : alipayOpenPrivateKey.trim();
    }

    public byte[] getWxpayApiCert() {
        return wxpayApiCert;
    }

    public void setWxpayApiCert(byte[] wxpayApiCert) {
        this.wxpayApiCert = wxpayApiCert;
    }

    public byte[] getQqpayApiCert() {
        return qqpayApiCert;
    }

    public void setQqpayApiCert(byte[] qqpayApiCert) {
        this.qqpayApiCert = qqpayApiCert;
    }
}
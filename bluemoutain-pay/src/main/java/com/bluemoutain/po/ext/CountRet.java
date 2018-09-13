package com.bluemoutain.po.ext;

import java.io.Serializable;
import java.math.BigDecimal;

public class CountRet implements Serializable {

    private BigDecimal price;

    private Integer id;

    private String user;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

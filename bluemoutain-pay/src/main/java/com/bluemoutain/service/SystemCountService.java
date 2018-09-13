package com.bluemoutain.service;




import com.bluemoutain.po.ext.CountRet;

import java.math.BigDecimal;

public interface SystemCountService {

    int countUsers();

    int countOrders(Integer status, Integer uid);

    BigDecimal findUserSettAllCount(Integer uid);

    BigDecimal findSettAllCount();

    BigDecimal todayInMoney(Integer uid, String timelike);

    BigDecimal todayChangeMoneySett(Integer uid, String timelike);

    BigDecimal todaySettMoney(Integer uid, String timelike);

    BigDecimal todayWaitSettMoney(Integer uid, String timelike);

    Integer todayCreateOrder(Integer uid, Integer status, String timelike, Integer otype);

    BigDecimal todayOrderSettMoneyCount(Integer uid, Integer status, String timelike);

    BigDecimal todayOrderMoneyCount(Integer uid, Integer status, String timelike);

    BigDecimal ptMoneyCountByType(Integer ptype, String timelike);

    BigDecimal ptMoneyInByChangeSett(String timelike);

    BigDecimal ptMoneyInByRegister(String timelike);

    BigDecimal ptMoneyInBySettOut(String timelike);

    BigDecimal ptMoneyInByOrderPayType(String timelike, Integer ptype);

    CountRet findUserFirst();
}



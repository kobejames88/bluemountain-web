package com.bluemoutain.mapper.ext;


import com.bluemoutain.po.ext.CountRet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface SystemCountMapper {

    int countUser();

    int countOrder(@Param("status") Integer status, @Param("uid") Integer uid);

    BigDecimal countSettAll(@Param("uid") Integer uid);

    BigDecimal countSettAll2();

    BigDecimal todayInMoney(@Param("uid") Integer uid, @Param("timelike") String timelike);

    BigDecimal todayChangeMoneySett(@Param("uid") Integer uid, @Param("timelike") String timelike);

    BigDecimal todaySettMoney(@Param("uid") Integer uid, @Param("timelike") String timelike);

    BigDecimal todayWaitSettMoney(@Param("uid") Integer uid, @Param("timelike") String timelike);

    Integer todayCreateOrder(@Param("uid") Integer uid, @Param("status") Integer status, @Param("timelike") String timelike, @Param("ordertype") Integer otype);

    BigDecimal todayOrderSettMoneyCount(@Param("uid") Integer uid, @Param("status") Integer status, @Param("timelike") String timelike);

    BigDecimal todayOrderMoneyCount(@Param("uid") Integer uid, @Param("status") Integer status, @Param("timelike") String timelike);

    BigDecimal settPayMoney(@Param("uid") Integer uid, @Param("status") Integer status, @Param("timelike") String timelike);

    BigDecimal settPaySubMoney(@Param("uid") Integer uid, @Param("status") Integer status, @Param("timelike") String timelike);

    BigDecimal ptMoneyCountByType(@Param("ptype") Integer ptype, @Param("timelike") String timelike);

    BigDecimal ptMoneyInByChangeSett(@Param("timelike") String timelike);

    BigDecimal ptMoneyInByRegister(@Param("timelike") String timelike);

    BigDecimal ptMoneyInBySettOut(@Param("timelike") String timelike);

    BigDecimal ptMoneyInByOrderPayType(@Param("timelike") String timelike, @Param("ptype") Integer ptype);

    List<CountRet> find_system_first_change_user();


}

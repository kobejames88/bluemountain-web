package com.bluemoutain.service;


import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.ext.SysSettExt;
import com.bluemoutain.utils.PageBean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SettLementService {

    int saveSettLement(SystemSett sett);

    PageBean<SysSettExt> findByPage(Integer page, Integer rows, Integer status, String sid, Integer type, Integer uid);

    SystemSett find_sett_byId(Integer id);

    SystemSett find_sett_by_uid(Integer uid);

    void updateSystemSett(SystemSett sett);

    void deleteSystemSett(Integer id);

    List<SystemSett> findsettByUid(Integer uid);

    List<SystemSett> findAllSett(Integer status);

    List<SystemSett> findAllSett2(Integer sett);


    Integer settCountAll(Integer uid, Date timelike);

    Integer settPayOkCount(Integer uid, Date timelike);

    Integer settPayFaildCount(Integer uid, Date timelike);

    Integer settCanelCount(Integer uid, Date timelike);

    BigDecimal settPayMoney(Integer uid, Integer status, String timelike);

    BigDecimal settPaySubMoney(Integer uid, Integer status, String timelike);

    BigDecimal findUserSettPayCount(Integer uid);
}

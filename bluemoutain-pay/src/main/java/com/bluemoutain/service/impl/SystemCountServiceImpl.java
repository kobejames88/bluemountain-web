package com.bluemoutain.service.impl;


import com.bluemoutain.mapper.ext.SystemCountMapper;
import com.bluemoutain.po.ext.CountRet;
import com.bluemoutain.service.SystemCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SystemCountServiceImpl implements SystemCountService {

    @Autowired
    private SystemCountMapper systemCountMapper;

    @Override
    public int countUsers() {
        return systemCountMapper.countUser();
    }

    @Override
    public int countOrders(Integer status, Integer uid) {
        return systemCountMapper.countOrder(status, uid);
    }

    @Override
    public BigDecimal findUserSettAllCount(Integer uid) {
        return systemCountMapper.countSettAll(uid);
    }

    @Override
    public BigDecimal findSettAllCount() {
        return systemCountMapper.countSettAll2();
    }

    @Override
    public BigDecimal todayInMoney(Integer uid, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.todayInMoney(uid, timelike);
    }

    @Override
    public BigDecimal todayChangeMoneySett(Integer uid, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.todayChangeMoneySett(uid, timelike);
    }

    @Override
    public BigDecimal todaySettMoney(Integer uid, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.todaySettMoney(uid, timelike);
    }

    @Override
    public BigDecimal todayWaitSettMoney(Integer uid, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.todayWaitSettMoney(uid, timelike);
    }

    @Override
    public Integer todayCreateOrder(Integer uid, Integer status, String timelike, Integer otype) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.todayCreateOrder(uid, status, timelike, otype);
    }

    @Override
    public BigDecimal todayOrderSettMoneyCount(Integer uid, Integer status, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.todayOrderSettMoneyCount(uid, status, timelike);
    }

    @Override
    public BigDecimal todayOrderMoneyCount(Integer uid, Integer status, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.todayOrderMoneyCount(uid, status, timelike);
    }

    @Override
    public BigDecimal ptMoneyCountByType(Integer ptype, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.ptMoneyCountByType(ptype, timelike);
    }

    @Override
    public BigDecimal ptMoneyInByChangeSett(String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.ptMoneyInByChangeSett(timelike);
    }

    @Override
    public BigDecimal ptMoneyInByRegister(String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.ptMoneyInByRegister(timelike);
    }

    @Override
    public BigDecimal ptMoneyInBySettOut(String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.ptMoneyInBySettOut(timelike);
    }

    @Override
    public BigDecimal ptMoneyInByOrderPayType(String timelike, Integer ptype) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return systemCountMapper.ptMoneyInByOrderPayType(timelike, ptype);
    }

    @Override
    public CountRet findUserFirst() {
        List<CountRet> user = systemCountMapper.find_system_first_change_user();
        if (user != null) {
            return user.get(0);
        }
        return null;
    }
}

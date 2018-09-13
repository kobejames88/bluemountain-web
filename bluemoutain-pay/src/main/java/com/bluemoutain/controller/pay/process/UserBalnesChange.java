package com.bluemoutain.controller.pay.process;


import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 用户资金操作
 */
@Component
public class UserBalnesChange {

    private static final Logger logger = LoggerFactory.getLogger(UserBalnesChange.class);

    //多线程锁对象,常量
    private static final Object locked = new Object();

    @Autowired
    private UserService userService;

    /**
     * 获取用户余额
     */
    public BigDecimal getUserbalnes(Integer uid) {
        synchronized (locked) {
            logger.info("线程:" + Thread.currentThread().getName() + " 获取用户余额:" + uid);
            SystemUser user = userService.findUserById(uid);
            if (user != null) {
                return user.getBalnes();
            }
            return null;
        }
    }

    /**
     * 给用户加钱,如果正在减钱就先等等
     */
    public boolean addUserBalnes(Integer uid, BigDecimal add) {
        synchronized (locked) {
            logger.info("线程:" + Thread.currentThread().getName() + " 给用户加钱:" + add);
            SystemUser user = userService.findUserById(uid);
            if (user != null) {
                BigDecimal balnes = user.getBalnes();
                BigDecimal scale = balnes.add(add).setScale(2, BigDecimal.ROUND_HALF_UP);
                user.setBalnes(scale);
                userService.updateUser(user);
                return true;
            }
            return false;
        }
    }

    /**
     * 给用户减钱,如果正在加钱就先等等
     */
    public boolean subUserBalnes(Integer uid, BigDecimal sub) {
        synchronized (locked) {
            logger.info("线程:" + Thread.currentThread().getName() + " 给用户减钱:" + sub);
            SystemUser user = userService.findUserById(uid);
            if (user != null) {
                BigDecimal balnes = user.getBalnes();
                BigDecimal scale = balnes.subtract(sub).setScale(2, BigDecimal.ROUND_HALF_UP);
                user.setBalnes(scale);
                userService.updateUser(user);
                return true;
            }
            return false;
        }
    }

}

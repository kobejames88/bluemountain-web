package com.bluemoutain.crond.process;


import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemVip;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.VipService;
import com.bluemoutain.service.WebConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 结算用户线程
 */
public class SettThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(SettThread.class);

    private SettLementService settLementService;

    private UserService userService;

    private VipService vipService;

    private WebConfigService webConfigService;

    private UserBalnesChange userBalnesChange;

    public SettThread(SettLementService settLementService, UserService userService, VipService vipService, WebConfigService webConfigService, UserBalnesChange userBalnesChange) {
        this.settLementService = settLementService;
        this.userService = userService;
        this.vipService = vipService;
        this.webConfigService = webConfigService;
        this.userBalnesChange = userBalnesChange;
        logger.info("SettThread Init...");
    }

    @Override
    public void run() {
        logger.info("开始结算用户订单...");
        SystemWeb web = webConfigService.find_by_id(1);
        Double min = web.getSettMin();
        List<SystemUser> list = userService.find_user_list();
        if (list != null && list.size() > 0) {
            for (SystemUser user : list) {
                if (user.getIsLocked() == 1) {
                    logger.info("结算用户:" + user.getUser() + " ID:" + user.getId() + " 已被锁定,不予结算!");
                } else {
                    if (user.getIsAutoSett() == 0) {
                        logger.info("用户:" + user.getId() + " 没有开启自动结算功能,跳过该用户结算!");
                    } else {
                        SystemVip vip = vipService.find_vip_by_uid(user.getId());
                        if (vip == null) {
                            logger.info("系统数据初始化中...");
                            continue;
                        }
                        BigDecimal userbalnes = userBalnesChange.getUserbalnes(user.getId());
                        if (userbalnes.compareTo(new BigDecimal(min)) >= 0) {
                            BigDecimal staff2;
                            if (vip.getStatus() == 1) {
                                staff2 = user.getVipSettStaff();
                            } else {
                                staff2 = user.getSettStaff();
                            }
                            BigDecimal sub = userbalnes.multiply(staff2.setScale(2, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP);
                            if (user.getZspaytype() == 4) {
                                sub = sub.add(new BigDecimal(1.00));
                            }
                            BigDecimal final_money = userbalnes.subtract(sub).setScale(2, BigDecimal.ROUND_HALF_UP);
                            logger.info("结算用户:" + user.getUser() + " ID:" + user.getId() + " 余额:" + user.getBalnes().doubleValue() + " 结算手续费:" + sub + " 结算金额:" + final_money);
                            boolean b = userBalnesChange.subUserBalnes(user.getId(), final_money.add(sub));
                            if (b) {
                                SystemSett sett = new SystemSett();
                                sett.setCreateTime(new Date());
                                sett.setOptUser(1);
                                sett.setSettPreMoney(userbalnes);
                                sett.setSettSubMoney(sub);
                                sett.setSettFinalMoney(final_money);
                                sett.setSid(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(1, 21));
                                sett.setStatus(1);
                                sett.setPreType(user.getZspaytype());
                                sett.setCtype(2);
                                sett.setIsSett(1);
                                sett.setUid(user.getId());
                                settLementService.saveSettLement(sett);
                            } else {
                                logger.info("用户:" + user.getId() + " 处理失败,当前余额:" + String.valueOf(userbalnes));
                            }
                        }
                    }
                }
            }
        }
        logger.info("系统订单结算完毕...");
    }
}

package com.bluemoutain.controller.pay.process;


import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.VipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * VIP秒到处理程序
 */
public class VipModePayProcess implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(VipModePayProcess.class);

    private OrderService orderService;

    private UserBalnesChange userBalnesChange;

    private SettLementService settLementService;

    private Integer order_id;

    private VipService vipService;

    private UserService userService;

    private SystemWeb systemWeb;

    private WxPayFunction wxPayFunctionPC;

    private AliPayFunction aliPayFunction;

    public VipModePayProcess(OrderService orderService, UserBalnesChange userBalnesChange, SettLementService settLementService, Integer order_id, VipService service, UserService userService, SystemWeb systemWeb, WxPayFunction wxPayFunctionPC, AliPayFunction aliPayFunction) {
        this.orderService = orderService;
        this.userBalnesChange = userBalnesChange;
        this.settLementService = settLementService;
        this.order_id = order_id;
        this.vipService = service;
        this.userService = userService;
        this.systemWeb = systemWeb;
        this.wxPayFunctionPC = wxPayFunctionPC;
        this.aliPayFunction = aliPayFunction;
    }

    @Override
    public void run() {
        SystemOrder order = orderService.findOrderById(order_id);
        if (order != null) {
            if (order.getStatus() == 2) {
                BigDecimal price = order.getPrice();
                BigDecimal sett = order.getChangeSett();
                price = price.subtract(sett).setScale(2, BigDecimal.ROUND_HALF_UP);
                if (price.compareTo(new BigDecimal(1.00)) < 0) {
                    logger.info("金额太小,存入余额...");
                    return;
                }
                Integer uid = order.getUid();
                SystemVip vip = vipService.find_vip_by_uid(uid);
                SystemUser user = userService.findUserById(uid);
                if (user.getIsAutoSett() == 0) {
                    logger.info("用户未开启自动结算...");
                    return;
                }
                if (vip.getStatus() == 1) {
                    int sett_order = create_sett_order(order, user);
                    if (sett_order > 0) {
                        boolean b = false;
                        try {
                            b = sett_payment(sett_order);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        logger.info("秒到返回:" + b);
                    } else {
                        logger.info("创建结算单失败!");
                    }
                } else {
                    if (vip.getExperienceNum() > 0) {
                        int sett_order = create_sett_order(order, user);
                        if (sett_order > 0) {
                            boolean b = false;
                            try {
                                b = sett_payment(sett_order);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (b) {
                                Integer num = vip.getExperienceNum();
                                num--;
                                vip.setExperienceNum(num);
                                vipService.update_vip_info(vip);
                            }
                            logger.info("秒到返回:" + b);
                        } else {
                            logger.info("创建结算单失败!");
                        }
                    } else {
                        logger.info("次数不足,无法结算!");
                    }
                }
            } else {
                logger.info("VIP秒到处理程序 - 订单未支付!");
            }
        } else {
            logger.info("VIP秒到处理程序 - 订单不存在!");
        }
    }

    /**
     * 创建结算单
     */
    private int create_sett_order(SystemOrder order, SystemUser user) {
        BigDecimal price = order.getPrice();
        BigDecimal tmp = order.getChangeSett();
        price = price.subtract(tmp).setScale(2, BigDecimal.ROUND_HALF_UP);
        boolean b = userBalnesChange.subUserBalnes(order.getUid(), price);
        if (b) {
            BigDecimal staff2 = user.getVipSettStaff();
            BigDecimal sub = price.multiply(staff2).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal final_money = price.subtract(sub).setScale(2, BigDecimal.ROUND_HALF_UP);
            SystemSett sett = new SystemSett();
            String s = UUID.randomUUID().toString().replaceAll("-", "").substring(2, 15);
            sett.setCreateTime(new Date());
            sett.setOptUser(1);
            sett.setSettPreMoney(price);
            sett.setSettSubMoney(sub);
            sett.setSettFinalMoney(final_money);
            sett.setSid("VIP" + s);
            sett.setStatus(1);
            sett.setPreType(user.getZspaytype());
            sett.setCtype(2);
            sett.setIsSett(1);
            sett.setUid(user.getId());
            settLementService.saveSettLement(sett);
            logger.info("创建结算单成功,ID:" + sett.getId());
            return sett.getId();
        }
        return 0;
    }

    /**
     * 结算单打款
     */
    private boolean sett_payment(Integer pay_sett_id) throws Exception{
        SystemSett sett = settLementService.find_sett_byId(pay_sett_id);
        if (sett != null) {
            SystemUser user = userService.findUserById(sett.getUid());
            Integer paytype = user.getZspaytype();
            if (paytype == 1) {
                Boolean money = wxPayFunctionPC.changeMoneyToWxAccount(sett, user);
                logger.info("微信打款:用户:" + user.getUser() + " PID:" + user.getId() +
                        " 金额:" + sett.getSettFinalMoney() + " 状态:" + money);
                return money;
            } else if (paytype == 2) {
                Boolean money = aliPayFunction.changeMoneyToAccount(sett, user);
                logger.info("支付宝打款: 用户:" + user.getUser() + " PID:" + user.getId() +
                        " 金额:" + sett.getSettFinalMoney() + " 状态:" + money);
                return money;
            } else {
                logger.info("其他结算方式,跳过...");
            }
        }
        return false;
    }


}

package com.bluemoutain.crond;


import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemWebWithBLOBs;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.WebConfigService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 自动打款  - 每晚10:00
 */
@Component
public class SettPaymentTask {

    private static Logger logger = LoggerFactory.getLogger(SettPaymentTask.class);

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private UserService userService;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private WebConfigService webConfigService;

    public SettPaymentTask() {
        logger.info("SettPaymentTask Init...");
    }

    /**
     * 自动打款  - 每晚10:00
     */
    @Async
    @Scheduled(cron = "0 00 22 * * ?")
    public void timerToNow() throws Exception {
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        SystemWebWithBLOBs config = webConfigService.find_by_id(1);
        if (config.getAutoSettlePay() == 1) {
            logger.info("开始结算用户打款...");
            List<SystemSett> slist = settLementService.findAllSett(1);
            if (slist != null && slist.size() > 0) {
                for (SystemSett sysSettExt : slist) {
                    SystemUser user = userService.findUserById(sysSettExt.getUid());
                    Integer paytype = user.getZspaytype();
                    if (paytype == 1) {
                        Boolean money = wxPayFunctionPC.changeMoneyToWxAccount(sysSettExt, user);
                        logger.info("微信打款:用户:" + user.getUser() + " PID:" + user.getId() +
                                " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:" + money);
                    } else if (paytype == 2) {
                        Boolean money = aliPayFunction.changeMoneyToAccount(sysSettExt, user);
                        logger.info("支付宝打款: 用户:" + user.getUser() + " PID:" + user.getId() +
                                " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:" + money);
                    } else if (paytype == 4) {
                        HashMap<String, String> param = new HashMap<>();
                        param.put("str", UUID.randomUUID().toString().replaceAll("-", "").substring(0, 31));
                        param.put("sid", sysSettExt.getSid());
                        param.put("pid", user.getZspayid());
                        param.put("pname", user.getZsname());
                        param.put("title", "结算:" + sysSettExt.getSid());
                        param.put("bank", user.getCardBankCode());
                        param.put("final_money", String.valueOf(sysSettExt.getSettFinalMoney()));
                        Map ret = null;
                        try {
                            ret = wxPayFunctionPC.payToUserCard(param);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Object error = ret.get("error");
                        Integer status = new Integer(ret.get("status").toString());
                        Object tran_no = ret.get("tran_no");
                        if (status == 2) {
                            sysSettExt.setStatus(2);
                            sysSettExt.setTranNo(String.valueOf(tran_no));
                            sysSettExt.setSettError(String.valueOf(error));
                            settLementService.updateSystemSett(sysSettExt);
                            logger.info("支付宝打款: 用户:" + user.getUser() + " PID:" + user.getId() +
                                    " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:true");
                        } else {
                            sysSettExt.setStatus(3);
                            sysSettExt.setTranNo(String.valueOf(tran_no));
                            sysSettExt.setSettError(String.valueOf(error));
                            settLementService.updateSystemSett(sysSettExt);
                            logger.info("支付宝打款: 用户:" + user.getUser() + " PID:" + user.getId() +
                                    " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:false");
                        }
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<SystemSett> slist2 = settLementService.findAllSett(3);
            if (slist2 != null && slist2.size() > 0) {
                for (SystemSett sysSettExt : slist2) {
                    SystemUser user = userService.findUserById(sysSettExt.getUid());
                    Integer paytype = user.getZspaytype();
                    if (paytype == 1) {
                        Boolean money = wxPayFunctionPC.changeMoneyToWxAccount(sysSettExt, user);
                        logger.info("微信打款:用户:" + user.getUser() + " PID:" + user.getId() +
                                " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:" + money);
                    } else if (paytype == 2) {
                        Boolean money = aliPayFunction.changeMoneyToAccount(sysSettExt, user);
                        logger.info("支付宝打款: 用户:" + user.getUser() + " PID:" + user.getId() +
                                " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:" + money);
                    } else if (paytype == 4) {
                        HashMap<String, String> param = new HashMap<>();
                        param.put("str", UUID.randomUUID().toString().replaceAll("-", "").substring(0, 31));
                        param.put("sid", sysSettExt.getSid());
                        param.put("pid", user.getZspayid());
                        param.put("pname", user.getZsname());
                        param.put("title", "结算:" + sysSettExt.getSid());
                        param.put("bank", user.getCardBankCode());
                        param.put("final_money", String.valueOf(sysSettExt.getSettFinalMoney()));
                        Map ret = null;
                        try {
                            ret = wxPayFunctionPC.payToUserCard(param);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Object error = ret.get("error");
                        Integer status = new Integer(ret.get("status").toString());
                        Object tran_no = ret.get("tran_no");
                        if (status == 2) {
                            sysSettExt.setStatus(2);
                            sysSettExt.setTranNo(String.valueOf(tran_no));
                            sysSettExt.setSettError(String.valueOf(error));
                            settLementService.updateSystemSett(sysSettExt);
                            logger.info("支付宝打款: 用户:" + user.getUser() + " PID:" + user.getId() +
                                    " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:true");
                        } else {
                            sysSettExt.setStatus(3);
                            sysSettExt.setTranNo(String.valueOf(tran_no));
                            sysSettExt.setSettError(String.valueOf(error));
                            settLementService.updateSystemSett(sysSettExt);
                            logger.info("支付宝打款: 用户:" + user.getUser() + " PID:" + user.getId() +
                                    " 金额:" + sysSettExt.getSettFinalMoney() + " 状态:false");
                        }
                    }
                }
            }
            logger.info("打款结算完毕...");
        }
    }

}

package com.bluemoutain.crond;


import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemVip;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.VipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 会员检测任务 与 数据填充
 */
@Component
public class VipCheckTask {

    private static Logger logger = LoggerFactory.getLogger(VipCheckTask.class);

    public VipCheckTask() {
        logger.info("VipCheckTask Init...");
    }

    @Autowired
    private UserService userService;

    @Autowired
    private VipService vipService;

    /**
     * 会员检测与 数据填充,每分钟执行
     */
    @Async
    @Scheduled(cron = "0 */1 *  * * * ")
    public void timerToNow() {
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("开始查询VIP用户信息...");
        List<SystemUser> list = userService.find_user_list();
        if (list != null && list.size() > 0) {
            for (SystemUser systemUser : list) {
                SystemVip vip = vipService.find_vip_by_uid(systemUser.getId());
                if (vip == null) {//不存在先建立记录
                    SystemVip model = new SystemVip();
                    model.setStartTime(new Date());
                    model.setEndTime(new Date());
                    model.setUid(systemUser.getId());
                    model.setStatus(0);
                    model.setExperiencePrice(new BigDecimal(1.00));
                    model.setExperienceNum(3);
                    Integer id = vipService.save_vip_info(model);
                    logger.info("用户:" + systemUser.getUser() + " PID:" + systemUser.getId() + " 插入新记录ID:" + id);
                } else {//存在就检测是否过期
                    Integer status = vip.getStatus();
                    if (status == 1) {
                        long now = System.currentTimeMillis();
                        long end = vip.getEndTime().getTime();
                        if (end > now) {
                            logger.info("用户:" + systemUser.getUser() + " PID:" + systemUser.getId() + " 已开通VIP,状态正常!");
                        } else {
                            vip.setStatus(0);
                            Integer ret = vipService.update_vip_info(vip);
                            logger.info("用户:" + systemUser.getUser() + " PID:" + systemUser.getId() + " VIP已到期,更新状态:" + ret);
                        }
                    } else {
                        logger.info("用户:" + systemUser.getUser() + " PID:" + systemUser.getId() + " 未开通VIP,跳过检测!");
                    }
                }
            }
        }
        logger.info("查询VIP用户信息完毕...");
    }

}

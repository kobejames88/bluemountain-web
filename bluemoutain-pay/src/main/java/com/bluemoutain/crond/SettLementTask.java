package com.bluemoutain.crond;


import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.crond.process.SettThread;
import com.bluemoutain.po.SystemWebWithBLOBs;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.VipService;
import com.bluemoutain.service.WebConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务 - 结算 - 每晚9:00
 */
@Component
public class SettLementTask {

    private static Logger logger = LoggerFactory.getLogger(SettLementTask.class);

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private UserService userService;

    @Autowired
    private VipService vipService;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private UserBalnesChange userBalnesChange;

    public SettLementTask() {
        logger.info("SettLementTask Init...");
    }

    /**
     * 定时任务 - 结算 - 每晚9:00
     */
    @Async
    @Scheduled(cron = "0 00 21 * * ?")
    public void timerToNow() {
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        SystemWebWithBLOBs config = webConfigService.find_by_id(1);
        if (config.getAutoSett() == 1) {
            SettThread thread = new SettThread(settLementService, userService,
                    vipService, webConfigService, userBalnesChange);
            Thread thread1 = new Thread(thread);
            thread1.setDaemon(true);
            thread1.start();
        }
    }

}

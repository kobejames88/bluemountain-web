package com.bluemoutain.crond;


import com.bluemoutain.crond.process.NotifyThread;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自动通知系统 - 自动通知系统 5分钟一次
 */
@Component
public class SystemOrderNotifyTask {
    private static Logger logger = LoggerFactory.getLogger(SystemOrderNotifyTask.class);

    public SystemOrderNotifyTask() {
        logger.info("SystemOrderNotifyTask Init...");
    }

    @Autowired
    private OrderService service;

    @Autowired
    private YiPayFunction yiPayFunction;

    /**
     * 自动通知下级系统 5分钟一次
     */
    @Async
    @Scheduled(cron = "0 0/5 * * * ?")
    public void timerToNow() {
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        NotifyThread notifyThread = new NotifyThread(service, yiPayFunction);
        Thread thread = new Thread(notifyThread);
        thread.setDaemon(true);
        thread.start();
    }


}

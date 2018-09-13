package com.bluemoutain.crond;



import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时任务 - 清理未支付订单
 */
@Component
public class ClearFaildOrderTask {

    private static Logger logger = LoggerFactory.getLogger(ClearFaildOrderTask.class);

    @Autowired
    private OrderService orderService;

    public ClearFaildOrderTask() {
        logger.info("SettLementTask Init...");
    }

    /**
     * 定时清理无用订单
     */
    @Async
    @Scheduled(cron = "0 0 3 * * ?")
    public void timerToNow() {
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("开始清理未支付订单...");
        Date now_10 = new Date(new Date().getTime() - 600000); //10分钟前的时间
        List<SystemOrder> list = orderService.findOrderByStatus(1);
        if (list != null && list.size() > 0) {
            logger.info("找到" + list.size() + "个未支付订单,准备删除这些订单...");
            for (SystemOrder systemOrder : list) {
                Date createTime = systemOrder.getCreateTime();
                if (createTime.getTime() < now_10.getTime()) {
                    logger.info("删除:" + systemOrder.getOutOrderId());
                    orderService.deleteOrder(systemOrder.getId());
                } else {
                    logger.info("忽略:" + systemOrder.getOutOrderId());
                }
            }
            logger.info("未支付订单清理完毕...");
        } else {
            logger.info("系统当前没有未支付订单...");
        }
    }

}

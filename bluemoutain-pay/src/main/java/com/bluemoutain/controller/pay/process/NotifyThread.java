package com.bluemoutain.controller.pay.process;


import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 回调异步线程
 */
public class NotifyThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(NotifyThread.class);

    private OrderService orderService;

    private Integer order_id;

    private YiPayFunction yiPayFunction;

    public NotifyThread(OrderService orderService, Integer order_id, YiPayFunction yiPayFunction) {
        this.orderService = orderService;
        this.order_id = order_id;
        this.yiPayFunction = yiPayFunction;
    }

    @Override
    public void run() {
        SystemOrder order = orderService.findOrderById(order_id);
        if (order != null) {
            String url = order.getNotifyUrl();
            if (url != null) {
                try {
                    String success = "success";
                    String faild = "fail";
                    Integer is_notify = 0;
                    String uuu = url + "?" + yiPayFunction.buildRequestParaSign(order);
                    String s = HttpClientUtils.get(uuu);
                    if (s != null && s.trim().length() > 0 && s.trim().length() < 15) {
                        if (s.trim().toLowerCase().contains(success)) {
                            is_notify = 1;
                        } else if (s.trim().toLowerCase().contains(faild)) {
                            is_notify = 1;
                        } else {
                            logger.info(s);
                        }
                    } else {
                        logger.info(s);
                    }
                    order.setIsNotify(is_notify);
                    orderService.updateOrder(order);
                    logger.info("异步通知:" + uuu + "  结果:" + s);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                }
            }
        }
    }
}

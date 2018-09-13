package com.bluemoutain.crond.process;


import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 用户数据通知线程
 */
public class NotifyThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(SettThread.class);

    private OrderService service;

    private YiPayFunction yiPayFunction;

    private int orderId;
    public NotifyThread(OrderService service, YiPayFunction yiPayFunction) {
        this.service = service;
        this.yiPayFunction = yiPayFunction;
        logger.info("NotifyThread Init...");
    }
    public NotifyThread(OrderService service,int orderId, YiPayFunction yiPayFunction) {
        this.service = service;
        this.yiPayFunction = yiPayFunction;
        this.orderId=orderId;
        logger.info("NotifyThread Init...");
    }

    @Override
    public void run() {
        logger.info("开始SystemOrderNotifyTask...");
        List<SystemOrder> list = service.findOrderList2(2, 0, 3);
        String success = "success";
        String faild = "fail";
        if (list != null && list.size() > 0) {
            logger.info("共找到:" + list.size() + "个,开始处理...");
            for (SystemOrder order : list) {
                Integer is_notify = 0;
                String url = order.getNotifyUrl();
                if (url != null) {
                    try {
                        String sign = url + "?" + yiPayFunction.buildRequestParaSign(order);
                        logger.info("NotifyThread HttpGet:" + url);
                        String ret = HttpClientUtils.get(sign);
                        if (ret != null && ret.trim().length() > 0 && ret.trim().length() < 15) {
                            if (ret.trim().toLowerCase().contains(success)) {
                                is_notify = 1;
                            } else if (ret.trim().toLowerCase().contains(faild)) {
                                is_notify = 1;
                            } else {
                                logger.info(ret);
                            }
                        } else {
                            logger.info(ret);
                        }
                    } catch (Exception e) {
                        logger.info(e.getMessage());
                    }
                }
                if (is_notify == 1) {
                    order.setIsNotify(is_notify);
                    service.updateOrder(order);
                }
                logger.info("SystemOrderNotifyTask   OrderId:" + order.getId() + "   OutOrderId:" + order.getOutOrderId() + "   IsNotify:" + is_notify);
            }
        }
        logger.info("SystemOrderNotifyTask结束...");
    }
}

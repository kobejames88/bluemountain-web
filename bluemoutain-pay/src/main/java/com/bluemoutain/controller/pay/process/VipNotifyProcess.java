package com.bluemoutain.controller.pay.process;


import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemVip;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.VipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 开通VIP线程
 */
public class VipNotifyProcess implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(VipNotifyProcess.class);

    private OrderService orderService;

    private Integer order_id;

    private VipService vipService;

    private Integer vipMethod;

    public VipNotifyProcess(OrderService orderService, Integer order_id, VipService vipService, Integer vipMethod) {
        this.orderService = orderService;
        this.order_id = order_id;
        this.vipService = vipService;
        this.vipMethod = vipMethod;
    }

    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SystemOrder order = orderService.findOrderById(order_id);
        if (order != null) {
            SystemVip vip = vipService.find_vip_by_uid(order.getUid());
            if (vip == null) {
                logger.info("VIP信息为空,请等一分钟后,重新开通!");
                return;
            }
            Integer num = order.getChNum();
            if (vipMethod == 0) {//按天收费
                Calendar cal = Calendar.getInstance();
                if (vip.getStatus() == 1) {
                    cal.setTime(vip.getEndTime());
                } else {
                    cal.setTime(new Date());
                }
                cal.add(Calendar.DAY_OF_YEAR, num);
                vip.setEndTime(cal.getTime());
                vip.setStatus(1);
                vipService.update_vip_info(vip);
                logger.info("开通会员 -- 按天收费,用户PID:" + vip.getUid() + " 数量:" + num + " 到期时间:" + format.format(vip.getEndTime()));
            } else {//按月收费
                Calendar cal = Calendar.getInstance();
                if (vip.getStatus() == 1) {
                    cal.setTime(vip.getEndTime());
                } else {
                    cal.setTime(new Date());
                }
                cal.add(Calendar.DAY_OF_YEAR, num * 30);
                vip.setEndTime(cal.getTime());
                vip.setStatus(1);
                vipService.update_vip_info(vip);
                logger.info("开通会员 -- 按月收费,用户PID:" + vip.getUid() + " 数量:" + num + " 到期时间:" + format.format(vip.getEndTime()));
            }
        } else {
            logger.info("订单不存在,无法处理...");
        }
    }

}

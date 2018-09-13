package com.bluemoutain.crond;


import com.bluemoutain.po.PutForward;
import com.bluemoutain.po.PutForwardConfig;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemSett;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.PutForwardService;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.utils.PayUtils;
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
import java.util.UUID;

/**
 * 自动算出平台盈利 - 每晚22:15
 */
@Component
public class PTSettTask {

    private static Logger logger = LoggerFactory.getLogger(PTSettTask.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private PutForwardService forwardService;

    @Autowired
    private SettLementService settLementService;


    public PTSettTask() {
        logger.info("PTSettTask Init...");
    }

    /**
     * 自动算出平台盈利 - 每晚22:15
     */
    @Async
    @Scheduled(cron = "0 15 22 * * ?")
    public void timerToNow() {
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("开始计算平台盈利信息...");
        PutForwardConfig config = forwardService.findConfig(1);
        BigDecimal zero = new BigDecimal("0.00");
        BigDecimal all_wxpay = new BigDecimal("0.00");
        BigDecimal all_alipay = new BigDecimal("0.00");
        BigDecimal all_qqpay = new BigDecimal("0.00");
        List<SystemOrder> orders = orderService.findOrderByStatus(2, 1);
        if (orders != null && orders.size() > 0) {
            for (SystemOrder order : orders) {
                if (order.getOrderType() == 2 && order.getIsSett() == 1) {
                    Integer payType = order.getPayType();
                    if (payType == 1) {
                        all_wxpay = all_wxpay.add(order.getPrice());
                    } else if (payType == 2) {
                        all_alipay = all_alipay.add(order.getPrice());
                    } else {
                        all_qqpay = all_qqpay.add(order.getPrice());
                    }
                } else if (order.getOrderType() == 1) {
                    Integer payType = order.getPayType();
                    if (payType == 1) {
                        all_wxpay = all_wxpay.add(order.getChangeSett());
                    } else if (payType == 2) {
                        all_alipay = all_alipay.add(order.getChangeSett());
                    } else {
                        all_qqpay = all_qqpay.add(order.getChangeSett());
                    }
                } else if (order.getOrderType() == 3) {
                    Integer payType = order.getPayType();
                    if (payType == 1) {
                        all_wxpay = all_wxpay.add(order.getChangeSett());
                    } else if (payType == 2) {
                        all_alipay = all_alipay.add(order.getChangeSett());
                    } else {
                        all_qqpay = all_qqpay.add(order.getChangeSett());
                    }
                }
                order.setIsSett(2);
                orderService.updateOrder(order);
            }
            List<SystemSett> setts = settLementService.findAllSett2(1);
            if (setts != null && setts.size() > 0) {
                for (SystemSett sett : setts) {
                    if (sett.getIsSett() == 1) {
                        Integer type = sett.getPreType();
                        if (type == 1) {
                            all_wxpay = all_wxpay.add(sett.getSettSubMoney());
                        } else if (type == 2) {
                            all_alipay = all_alipay.add(sett.getSettSubMoney());
                        } else {
                            all_qqpay = all_qqpay.add(sett.getSettSubMoney());
                        }
                    }
                    sett.setIsSett(2);
                    settLementService.updateSystemSett(sett);
                }
            }
            if (all_alipay.compareTo(zero) > 0) {
                String psd = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
                String strReq = PayUtils.getStrReq();
                PutForward forward = new PutForward();
                forward.setOptTime(new Date());
                forward.setOptUser(1);
                forward.setPsd(psd);
                forward.setStatus(1);
                forward.setStr(strReq);
                forward.setTitle(config.getTitle());
                forward.setPutId(config.getAlipayId());
                forward.setPutName(config.getAlipayName());
                forward.setPrice(all_alipay);
                forward.setpType(2);
                forward.setIp("192.168.1.4");
                forwardService.savePF(forward);
                logger.info("支付宝收入:" + all_alipay);
            }
            if (all_wxpay.compareTo(zero) > 0) {
                String psd = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
                String strReq = PayUtils.getStrReq();
                PutForward forward = new PutForward();
                forward.setOptTime(new Date());
                forward.setOptUser(1);
                forward.setPsd(psd);
                forward.setStatus(1);
                forward.setStr(strReq);
                forward.setTitle(config.getTitle());
                forward.setPutId(config.getWxOpenId());
                forward.setPutName(config.getWxName());
                forward.setPrice(all_wxpay);
                forward.setpType(1);
                forward.setIp("192.168.1.4");
                forwardService.savePF(forward);
                logger.info("微信收入:" + all_wxpay);
            }
            if (all_qqpay.compareTo(zero) > 0) {
                String psd = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
                String strReq = PayUtils.getStrReq();
                PutForward forward = new PutForward();
                forward.setOptTime(new Date());
                forward.setOptUser(1);
                forward.setPsd(psd);
                forward.setStatus(1);
                forward.setStr(strReq);
                forward.setTitle(config.getTitle());
                forward.setPutId("QQ暂无");
                forward.setPutName("QQ暂无");
                forward.setPrice(all_qqpay);
                forward.setpType(3);
                forward.setIp("192.168.1.4");
                forwardService.savePF(forward);
                logger.info("QQ收入:" + all_wxpay);
            }
        }
        logger.info("计算平台盈利信息完毕...");
    }


}

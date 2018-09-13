package com.bluemoutain.crond;


import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.po.PutForward;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.service.PutForwardService;
import com.bluemoutain.service.WebConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 平台利润  - 自动打款
 */
@Component
public class PTSettPaymentTask {

    private static Logger logger = LoggerFactory.getLogger(PTSettPaymentTask.class);

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private PutForwardService service;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private AliPayFunction aliPayFunction;

    public PTSettPaymentTask() {
        logger.info("PTSettPaymentTask Init...");
    }

    /**
     * 平台利润  - 自动打款
     */
    @Async
    @Scheduled(cron = "0 20 22 * * ?")
    public void timerToNow() throws Exception{
        logger.info("当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("开始自动提现...");
        SystemWeb web = webConfigService.find_by_id(1);
        Integer pay = web.getAutoSettPay();
        if (pay == 2) {
            List<PutForward> fs = service.find_by_status(1);
            if (fs != null && fs.size() > 0) {
                for (PutForward f : fs) {
                    HashMap<String, String> param = new HashMap<>();
                    param.put("final_money", String.valueOf(f.getPrice()));
                    param.put("sid", f.getPsd());
                    param.put("pname", f.getPutName());
                    param.put("ip", f.getIp());
                    param.put("title", f.getTitle());
                    param.put("str", f.getStr());
                    param.put("pid", f.getPutId());
                    Integer type = f.getpType();
                    if (type == 1) {
                        Map money = wxPayFunctionPC.changeMoneyToWxAccountMap(param);
                        if (money == null) {
                            continue;
                        }
                        Object error = money.get("error");
                        Integer status = new Integer(money.get("status").toString());
                        Object tran_no = money.get("tran_no");
                        if (status == 2) {
                            f.setStatus(2);
                            f.setTrano(String.valueOf(tran_no));
                            f.setErrorInfo(String.valueOf(error));
                            service.updatePF(f);
                        } else {
                            f.setStatus(3);
                            f.setTrano(String.valueOf(tran_no));
                            f.setErrorInfo(String.valueOf(error));
                            service.updatePF(f);
                        }
                    } else {
                        Map money = aliPayFunction.changeMoneyToAccountMap(param);
                        if (money == null) {
                            continue;
                        }
                        Object error = money.get("error");
                        Integer status = (Integer) money.get("status");
                        Object tran_no = money.get("tran_no");
                        if (status == null) {
                            continue;
                        }
                        if (status == 2) {
                            f.setStatus(2);
                            f.setTrano(String.valueOf(tran_no));
                            f.setErrorInfo(String.valueOf(error));
                            service.updatePF(f);
                        } else {
                            f.setStatus(3);
                            f.setTrano(String.valueOf(tran_no));
                            f.setErrorInfo(String.valueOf(error));
                            service.updatePF(f);
                        }
                    }

                }
            }
        }
        logger.info("自动提现完毕...");
    }


}

package com.bluemoutain.plugins.pay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;

import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.PayConfigService;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.utils.PayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
public class AliPayFunction {

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayConfigService payConfigService;

    private static final String openApi = "https://openapi.alipay.com/gateway.do";

    private String open_app_id;

    private String open_public_key;

    private String open_private_key;

    private String partner;

    public String getPartner() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getOpen_app_id() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return open_app_id;
    }

    public void setOpen_app_id(String open_app_id) {
        this.open_app_id = open_app_id;
    }

    public String getOpen_public_key() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return open_public_key;
    }

    public void setOpen_public_key(String open_public_key) {
        this.open_public_key = open_public_key;
    }

    public String getOpen_private_key() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return open_private_key;
    }

    public void setOpen_private_key(String open_private_key) {
        this.open_private_key = open_private_key;
    }

    /**
     * 支付宝 - 向个人用户转账
     */
    public Boolean changeMoneyToAccount(SystemSett sett, SystemUser user) throws Exception {
        this.init();
        BigDecimal money = sett.getSettFinalMoney();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
        AlipayClient alipayClient = new DefaultAlipayClient(openApi, getOpen_app_id(), getOpen_private_key(), "json", "utf-8", getOpen_public_key(), "RSA2");
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        TreeMap<Object, Object> bie_con = new TreeMap<>();
        bie_con.put("out_biz_no", sett.getSid());
        bie_con.put("payee_type", "ALIPAY_LOGONID");
        bie_con.put("payee_account", user.getZspayid());
        bie_con.put("amount", String.valueOf(money));
        bie_con.put("payer_show_name", "统一结算:" + time.format(sett.getCreateTime()));
        bie_con.put("payee_real_name", user.getZsname());
        bie_con.put("remark", "结算:" + sett.getSid());
        request.setBizContent(JSON.toJSONString(bie_con));
        AlipayFundTransToaccountTransferResponse response;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return false;
        }
        if (response.getCode().equals("10000")) {
            sett.setSettError("SUCCESS");
            sett.setTranNo(response.getOrderId());
            sett.setStatus(2);
            sett.setOkTime(new Date());
            settLementService.updateSystemSett(sett);
            return true;
        } else {
            String subCode = response.getSubCode();
            sett.setSettError(PayUtils.getSettPayErrorDeitl(subCode));
            sett.setStatus(3);
            sett.setOkTime(new Date());
            sett.setTranNo("000");
            settLementService.updateSystemSett(sett);
            return false;
        }
    }

    /**
     * 支付宝 - 向个人用户转账
     */
    public Map changeMoneyToAccountMap(Map sett) throws Exception {
        this.init();
        HashMap<Object, Object> map = new HashMap<>();
        BigDecimal money = new BigDecimal(String.valueOf(sett.get("final_money")));
        AlipayClient alipayClient = new DefaultAlipayClient(openApi, getOpen_app_id(), getOpen_private_key(), "json", "utf-8", getOpen_public_key(), "RSA2");
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        TreeMap<Object, Object> bie_con = new TreeMap<>();
        bie_con.put("out_biz_no", sett.get("sid"));
        bie_con.put("payee_type", "ALIPAY_LOGONID");
        bie_con.put("payee_account", sett.get("pid"));
        bie_con.put("amount", String.valueOf(money));
        bie_con.put("payer_show_name", sett.get("title"));
        bie_con.put("payee_real_name", sett.get("pname"));
        bie_con.put("remark", sett.get("title"));
        request.setBizContent(JSON.toJSONString(bie_con));
        AlipayFundTransToaccountTransferResponse response;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return null;
        }
        if (response.getCode().equals("10000")) {
            map.put("error", "Success");
            map.put("status", 2);
            map.put("tran_no", response.getOrderId());
            return map;
        } else {
            String subCode = response.getSubCode();
            map.put("error", PayUtils.getSettPayErrorDeitl(subCode));
            map.put("status", 3);
            map.put("tran_no", "000");
            return map;
        }
    }

    /**
     * 支付宝退款
     */
    public Map refund(SystemOrder order) throws Exception {
        this.init();
        HashMap<Object, Object> map = new HashMap<>();
        AlipayClient alipayClient = new DefaultAlipayClient(openApi, getOpen_app_id(), getOpen_private_key(), "json", "utf-8", getOpen_public_key(), AlipayConstants.SIGN_TYPE_RSA2);
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        TreeMap<Object, Object> bie_con = new TreeMap<>();
        bie_con.put("out_trade_no", order.getId());
        bie_con.put("trade_no", order.getTradeNo());
        bie_con.put("refund_amount", order.getPrice());
        bie_con.put("refund_reason", "退款:" + order.getOutOrderId());
        request.setBizContent(JSON.toJSONString(bie_con));
        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        String code = response.getCode();
        if (code == null) {
            map.put("code", -1);
            map.put("msg", "操作失败!");
        } else {
            if (code.equals("10000") && response.getMsg().equals("Success")) {
                order.setStatus(3);
                orderService.updateOrder(order);
                map.put("code", 0);
                map.put("msg", response.getMsg());
            } else {
                String msg = response.getSubMsg();
                map.put("msg", msg);
                map.put("code", -1);
            }
        }
        return map;
    }

    /**
     * 支付宝 - 电脑网站支付
     */
    public String pc_pay(SystemOrder order) throws Exception {
        this.init();
        AlipayClient alipayClient = new DefaultAlipayClient(openApi, getOpen_app_id(), getOpen_private_key(), "json", "utf-8", getOpen_public_key(), AlipayConstants.SIGN_TYPE_RSA2);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(yiPayFunction.getDomain() + "/payment/return_page");
        alipayRequest.setNotifyUrl(yiPayFunction.getDomain() + "/payment/alipay_notify");
        HashMap<Object, Object> param = new HashMap<>();
        param.put("subject", order.getTitle());
        param.put("body", order.getContext());
        param.put("out_trade_no", order.getId());
        param.put("total_amount", order.getPrice());
        param.put("product_code", "FAST_INSTANT_TRADE_PAY");


//        HashMap<Object, Object> ext = new HashMap<>();
//        ext.put("hb_fq_num", 3);
//        ext.put("hb_fq_seller_percent", 0);
//        ext.put("sys_service_provider_id",getPartner());
//        param.put("extend_params", JSON.toJSONString(ext));
//        param.put("enable_pay_channels", "pcreditpayInstallment");


        alipayRequest.setBizContent(JSON.toJSONString(param));
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }

    /**
     * 支付宝 - 手机网站支付
     */
    public String wap_pay(SystemOrder order) throws Exception {
        this.init();
        AlipayClient alipayClient = new DefaultAlipayClient(openApi, getOpen_app_id(), getOpen_private_key(), "json", "utf-8", getOpen_public_key(), AlipayConstants.SIGN_TYPE_RSA2);
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        alipayRequest.setReturnUrl(yiPayFunction.getDomain() + "/payment/return_page");
        alipayRequest.setNotifyUrl(yiPayFunction.getDomain() + "/payment/alipay_notify");
        HashMap<Object, Object> param = new HashMap<>();
        param.put("subject", order.getTitle());
        param.put("body", order.getContext());
        param.put("out_trade_no", order.getId());
        param.put("total_amount", order.getPrice());
        param.put("product_code", "FAST_INSTANT_TRADE_PAY");
        alipayRequest.setBizContent(JSON.toJSONString(param));
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }

    /**
     * 初始化支付信息
     */
    private void init() throws Exception {
        SystemPayConfigWithBLOBs payConfig = payConfigService.getPayConfig(1);
        if (payConfig == null) {
            throw new Exception("数据错误,请重新导入SQL文件!");
        }
        this.setPartner(payConfig.getAlipayParther());
        this.setOpen_app_id(payConfig.getAlipayOpenAppId());
        this.setOpen_private_key(payConfig.getAlipayOpenPrivateKey());
        this.setOpen_public_key(payConfig.getAlipayOpenPublicKey());
    }

}

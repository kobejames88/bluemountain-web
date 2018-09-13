package com.bluemoutain.plugins.pay;


import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.PayConfigService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.utils.MD5Util;
import com.bluemoutain.utils.PayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.*;

/**
 * 易支付接口相关
 */
@Component
public class YiPayFunction {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayConfigService payConfigService;

    private void init() throws Exception {
        SystemPayConfigWithBLOBs payConfig = payConfigService.getPayConfig(1);
        if (payConfig == null) {
            throw new Exception("数据错误,请重新导入SQL文件!");
        }
        this.setCharset("utf-8");
        this.setDomain(payConfig.getRetDomain());
    }

    private String charset;

    private String sign_type = "MD5";

    private String domain;

    public String getCharset() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }


    public String getDomain() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 除去数组中的空值和签名参数
     */
    public Map<String, String> paraFilter(Map<String, String> sArray) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     */
    public String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }

    /**
     * 生成签名结果
     */
    public String buildRequestMysign2(Map<String, String> sPara, String pkey_user) {
        String prestr = createLinkString(sPara);
        prestr += pkey_user;
        return MD5Util.MD5Encode(prestr, "utf-8").toLowerCase();
    }

    /**
     * 生成要请求给支付宝的参数数组
     */
    public Map<String, String> buildRequestPara(Map<String, String> sParaTemp, String key) {
        Map<String, String> sPara = paraFilter(sParaTemp);
        String mysign = buildRequestMysign2(sPara, key);
        sPara.put("sign", mysign);
        if (sPara.get("pid") != null) {
            sPara.put("sign_type", sign_type);
        }
        return sPara;
    }

    /**
     * 建立请求，以表单HTML形式构造（默认）
     */
    public String buildRequest(String gateway1, String key, Map<String, String> sParaTemp, String strMethod, String strButtonName) throws Exception {
        //待请求参数数组
        this.init();
        Map<String, String> sPara = buildRequestPara(sParaTemp, key);
        List<String> keys = new ArrayList<String>(sPara.keySet());
        StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway1
                + "\" method=\"" + strMethod
                + "\">");
        for (int i = 0; i < keys.size(); i++) {
            String name = keys.get(i);
            String value = sPara.get(name);
            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
        return sbHtml.toString();
    }

    /**
     * 校验签名
     */
    public boolean verfySign(Map<String, String> sParaTemp, String sign, String key) throws Exception {
        this.init();
        boolean siok = false;
        Map<String, String> sPara = paraFilter(sParaTemp);
        String mysign = buildRequestMysign2(sPara, key);
        if (mysign.equals(sign)) {
            siok = true;
        }
        return siok;
    }

    /**
     * 校验签名
     */
    public boolean verfySign2(Map<String, String> sParaTemp, String sign, String key) {
        boolean siok = false;
        Map<String, String> sPara = paraFilter(sParaTemp);
        String mysign = buildRequestMysign2(sPara, key);
        if (mysign.equals(sign)) {
            siok = true;
        }
        return siok;
    }




    /**
     * 生成 异步通知请求参数
     */
    public String buildRequestParaSign(SystemOrder order) throws Exception {
        SystemOrder order_model = orderService.findOrderById(order.getId());
        if (order_model == null) {
            throw new Exception("处理订单通知时出错,订单不存在!");
        }
        if (order.getOrderType() == 2) {
            HashMap<String, String> map = new HashMap<>();
            map.put("trade_no", order_model.getId().toString());
            map.put("out_trade_no", order_model.getOutOrderId());
            map.put("type", PayUtils.switchPayType(order_model.getPayType()));
            map.put("name", URLEncoder.encode(order.getContext()));
            map.put("money", String.valueOf(order.getPrice()));
            map.put("trade_status", order_model.getStatus() == 2 ? "TRADE_SUCCESS" : "TRADE_FAILED");
            Map<String, String> paraFilter = paraFilter(map);
            return this.createLinkString(paraFilter);
        } else {
            Integer uid = order_model.getUid();
            if (uid == null) {
                throw new Exception("处理订单通知时出错,订单不存在!");
            }
            SystemUser user = userService.findUserById(uid);
            if (user == null) {
                throw new Exception("处理订单通知时出错,订单不存在!");
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("pid", user.getId().toString());
            map.put("trade_no", order_model.getId().toString());
            map.put("out_trade_no", order_model.getOutOrderId());
            map.put("type", PayUtils.switchPayType(order_model.getPayType()));
            map.put("name", order.getContext());
            map.put("money", String.valueOf(order.getPrice()));
            map.put("trade_status", order_model.getStatus() == 2 ? "TRADE_SUCCESS" : "TRADE_FAILED");
            Map<String, String> paraFilter = paraFilter(map);
            String s = buildRequestMysign2(paraFilter, user.getAppkey());
            paraFilter.put("sign", s);//订单时间戳
            paraFilter.put("sign_type", "MD5");
            paraFilter.remove("name");
            paraFilter.put("name", URLEncoder.encode(order.getContext()));
            return this.createLinkString(paraFilter);
        }
    }


}

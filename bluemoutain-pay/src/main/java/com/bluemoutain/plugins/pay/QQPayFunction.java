package com.bluemoutain.plugins.pay;


import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.PayConfigService;
import com.bluemoutain.utils.HttpClientUtils;
import com.bluemoutain.utils.MD5Util;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.util.*;

/**
 * qq钱包支付相关
 */
@Component
public class QQPayFunction {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayConfigService payConfigService;

    private final String unified_order = "https://qpay.qq.com/cgi-bin/pay/qpay_unified_order.cgi";

    private String mch_id;

    private String key;

    private String refund_pw;

    private static final String SunX509 = "SunX509";
    private static final String JKS = "JKS";
    private static final String PKCS12 = "PKCS12";
    private static final String TLS = "TLS";

    private static final String JKS_CA_ALIAS = "tenpay";

    private static final String JKS_CA_PASSWORD = "";

    public String getRefund_pw() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return refund_pw;
    }

    public void setRefund_pw(String refund_pw) {
        this.refund_pw = refund_pw;
    }

    public String getMch_id() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getKey() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 解析返回数据
     */
    public TreeMap<String, String> xml2map(String response) throws Exception {
        TreeMap<String, String> responseMap = new TreeMap<String, String>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)));
        NodeList nodeList = doc.getChildNodes().item(0).getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            responseMap.put(n.getNodeName(), n.getTextContent());
        }
        return responseMap;
    }

    /**
     * 编译请求数据
     */
    private String map2xml(TreeMap<String, String> map) throws Exception {
        map.put("sign", generateSign(map, getKey()));
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Iterator<String> ite = map.keySet().iterator();
        while (ite.hasNext()) {
            String tmpKey = ite.next();
            if (map.get(tmpKey).isEmpty()) {
                continue;
            }
            sb.append("<" + tmpKey + ">");
            sb.append(map.get(tmpKey));
            sb.append("</" + tmpKey + ">");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 检查签名
     */
    public boolean checkSign(TreeMap<String, String> responseMap) throws Exception {
        this.init();
        String responseSign = responseMap.get("sign");
        String calSign = generateSign(responseMap, getKey());
        return responseSign.equalsIgnoreCase(calSign);
    }

    /**
     * 生成商户签名
     */
    private String generateSign(TreeMap<String, String> srcMap, String key) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] inputByteArray = (generateSignSrc(srcMap) + key).getBytes(StandardCharsets.UTF_8);
        messageDigest.update(inputByteArray);
        byte[] resultByteArray = messageDigest.digest();
        return byteArrayToHex(resultByteArray);
    }

    /**
     * byteArrayToHex
     */
    private String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArray);
    }

    /**
     * 生成签名原串。
     */
    private String generateSignSrc(TreeMap<String, String> srcMap) {
        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, String>> ite = srcMap.entrySet().iterator();
        while (ite.hasNext()) {
            Map.Entry<String, String> tmpEntry = ite.next();
            if ("sign".equalsIgnoreCase(tmpEntry.getKey()) //
                    || tmpEntry.getValue().isEmpty()) {
                continue;
            }
            sb.append(tmpEntry.getKey()).append("=").append(tmpEntry.getValue()).append("&");
        }
        sb.append("key=");
        return sb.toString();
    }

    /**
     * QQ获取扫码支付url
     */
    public String getScanCodeUrl(SystemOrder order, String notify_url) throws Exception {
        this.init();
        String notice_str = WxPayFunction.getRandomStringByLength(32);
        BigDecimal price = order.getPrice();
        Double v = price.doubleValue() * 100;
        TreeMap<String, String> map = new TreeMap<>();
        map.put("mch_id", getMch_id());
        map.put("nonce_str", MD5Util.MD5Encode(notice_str, "utf-8"));
        map.put("body", order.getTitle());
        map.put("out_trade_no", order.getId().toString());
        map.put("fee_type", "CNY");
        map.put("total_fee", String.valueOf(v.intValue()));
        map.put("spbill_create_ip", order.getIpAddr());
        map.put("trade_type", "NATIVE");
        map.put("notify_url", notify_url);
        String request_string = map2xml(map);
        String tmp = HttpClientUtils.postParameters(unified_order, request_string);
        TreeMap<String, String> resp = xml2map(tmp);
        boolean sign = checkSign(resp);
        if (sign && "SUCCESS".equals(resp.get("result_code"))) {
            return resp.get("code_url");
        } else {
            return resp.get("err_code_des");
        }
    }


    /**
     * QQ钱包退款接口
     */
    public Map refund(SystemOrder order) throws Exception {
        this.init();
        HashMap<Object, Object> map = new HashMap<>();
        String api = "https://api.qpay.qq.com/cgi-bin/pay/qpay_refund.cgi";
        BigDecimal price = order.getPrice();
        BigDecimal scale = price.multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP);
        TreeMap<String, String> param = new TreeMap<>();
        param.put("op_user_id", getMch_id());
        param.put("op_user_passwd", MD5Util.MD5Encode(getRefund_pw(), "utf-8"));
        param.put("out_refund_no", order.getOutOrderId());
        param.put("nonce_str", UUID.randomUUID().toString().replaceAll("-", "").toLowerCase().substring(0, 31));
        param.put("transaction_id", order.getTradeNo());
        param.put("mch_id", getMch_id());
        param.put("refund_fee", String.valueOf(scale));
        String data;
        String ret;
        Map<String, String> ret_map = null;
        try {
            data = map2xml(param);
            // System.out.println(data);
            ret = post_data_api_cert(api, data);
            ret_map = xml2map(ret);
            if (ret_map == null) {
                map.put("code", -1);
                map.put("msg", "返回数据错误");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "提交失败");
            return map;
        }
        String return_code = ret_map.get("return_code");
        String result_code = ret_map.get("result_code");
        if ("SUCCESS".equals(result_code) && "SUCCESS".equals(return_code)) {
            order.setStatus(3);
            orderService.updateOrder(order);
            map.put("code", 0);
            map.put("msg", result_code);
        } else {
            String err_code_des = ret_map.get("err_code_des");
            map.put("msg", err_code_des);
            map.put("code", -1);
        }
        return map;
    }

    /**
     * 带证书请求QQ服务器
     */
    private String post_data_api_cert(String url, String data) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(1);
        byte[] cert = config.getQqpayApiCert();
        keyStore.load(new ByteArrayInputStream(cert), getMch_id().toCharArray());
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, getMch_id().toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        HttpPost httpost = new HttpPost(url);
        httpost.addHeader("Connection", "keep-alive");
        httpost.addHeader("Accept", "*/*");
        httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpost.addHeader("X-Requested-With", "XMLHttpRequest");
        httpost.addHeader("Cache-Control", "max-age=0");
        httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
        httpost.setEntity(new StringEntity(data, "UTF-8"));
        CloseableHttpResponse response = httpclient.execute(httpost);
        return EntityUtils.toString(response.getEntity());
    }


    private void init() throws Exception {
        SystemPayConfigWithBLOBs payConfig = payConfigService.getPayConfig(1);
        if (payConfig == null) {
            throw new Exception("数据错误,请重新导入SQL文件!");
        }
        this.setRefund_pw(payConfig.getQqpayPw());
        this.setMch_id(payConfig.getQqpayMchId());
        this.setKey(payConfig.getQqpayPrivateKey());
    }

}

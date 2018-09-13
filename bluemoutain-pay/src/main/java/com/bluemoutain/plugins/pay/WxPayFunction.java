package com.bluemoutain.plugins.pay;


import com.bluemoutain.plugins.pay.utils.WXPayUtil;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.PayConfigService;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.utils.*;
import com.bluemoutain.utils.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
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

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 微信支付相关
 */
@Component
public class WxPayFunction {

    private static String unifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayConfigService payConfigService;

    private void init() throws Exception {
        SystemPayConfigWithBLOBs payConfig = payConfigService.getPayConfig(1);
        if (payConfig == null) {
            throw new Exception("数据错误,请重新导入SQL文件!");
        }
        this.setMch_id_1(payConfig.getWxpayMchId());
        this.setPaternerKey_1(payConfig.getWxpayPaternerKey());
        this.setWx_appid_1(payConfig.getWxpayAppId());
        this.setWxappsecrt_1(payConfig.getWxpayAppsecrt());
    }

    private String wx_appid_1;

    private String mch_id_1;

    private String paternerKey_1;

    private String wxappsecrt_1;

    public String getWxappsecrt_1() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wxappsecrt_1;
    }

    public void setWxappsecrt_1(String wxappsecrt_1) {
        this.wxappsecrt_1 = wxappsecrt_1;
    }

    public String getWx_appid_1() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wx_appid_1;
    }

    public void setWx_appid_1(String wx_appid_1) {
        this.wx_appid_1 = wx_appid_1;
    }

    public String getMch_id_1() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mch_id_1;
    }

    public void setMch_id_1(String mch_id_1) {
        this.mch_id_1 = mch_id_1;
    }

    public String getPaternerKey_1() {
        try {
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paternerKey_1;
    }

    public void setPaternerKey_1(String paternerKey_1) {
        this.paternerKey_1 = paternerKey_1;
    }

    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public String getSign(Map<String, String> map, String key) {
        StringBuffer sb = new StringBuffer();
        String[] keyArr = map.keySet().toArray(new String[map.keySet().size()]);//获取map中的key转为array
        Arrays.sort(keyArr);//对array排序
        for (int i = 0, size = keyArr.length; i < size; ++i) {
            if ("sign".equals(keyArr[i])) {
                continue;
            }
            sb.append(keyArr[i] + "=" + map.get(keyArr[i]) + "&");
        }
        sb.append("key=" + key);
        String sign = string2MD5(sb.toString());
        return sign;
    }

    public String string2MD5(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf).toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    public void ret_success_wxpay(HttpServletResponse response) throws Exception {
        String xml = "<xml>" +
                "<return_code><![CDATA[SUCCESS]]></return_code>" +
                "<return_msg><![CDATA[OK]]></return_msg>" +
                "</xml>";
        PrintWriter writer = response.getWriter();
        writer.write(xml);
        writer.flush();
        writer.close();
    }

    public void ret_error_wxpay(HttpServletResponse response) throws Exception {
        String xml = "<xml>" +
                "<return_code><![CDATA[FAIL]]></return_code>" +
                "<return_msg><![CDATA[签名失败]]></return_msg>" +
                "</xml>";
        PrintWriter writer = response.getWriter();
        writer.write(xml);
        writer.flush();
        writer.close();
    }

    private String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return outFormat.format(now);
    }

    public int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    private String createSign(SortedMap<String, String> packageParams) {
        StringBuilder sb = new StringBuilder();
        Set es = packageParams.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(this.getPaternerKey_1());
        return MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
    }

    private String buildParamMap(SortedMap<String, String> packageParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        Set es = packageParams.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            sb.append("<").append(k).append(">").append(v).append("</").append(k).append(">");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    private String payToAccount(String url, String data) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        InputStream inputStream = this.getClass().getResourceAsStream("/cert/wx_api.p12");
        SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(1);
        byte[] cert = config.getWxpayApiCert();
        keyStore.load(new ByteArrayInputStream(cert), getMch_id_1().toCharArray());
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, getMch_id_1().toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        HttpPost httpost = new HttpPost(url);
        httpost.addHeader("Connection", "keep-alive");
        httpost.addHeader("Accept", "*/*");
        httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpost.addHeader("Host", "api.mch.weixin.qq.com");
        httpost.addHeader("X-Requested-With", "XMLHttpRequest");
        httpost.addHeader("Cache-Control", "max-age=0");
        httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
        httpost.setEntity(new StringEntity(data, "UTF-8"));
        CloseableHttpResponse response = httpclient.execute(httpost);
        return EntityUtils.toString(response.getEntity());
    }

    private String getRSA(String str, String publicKeyPKCS8) {
        PublicKey publicKey = RSAUtil.getPublicKey(publicKeyPKCS8, "RSA");
        if (publicKey == null) {
            return null;
        }
        String rsa = "RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING";
        try {
            byte[] encrypt = RSAUtil.encrypt(str.getBytes(), publicKey, 2048, 11, rsa);
            return Base64.encode(encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPublicKey() throws Exception {
        String api = "https://fraud.mch.weixin.qq.com/risk/getpublickey";
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        String nonce_str = StringUtils.getStrRandom(28);
        parameters.put("mch_id", getMch_id_1());
        parameters.put("nonce_str", nonce_str);
        parameters.put("sign_type", "MD5");
        String sign = creatSign("utf-8", parameters);
        System.out.println(sign);
        TreeMap<String, String> tmap = new TreeMap<String, String>();
        tmap.put("mch_id", getMch_id_1());
        tmap.put("nonce_str", nonce_str);
        tmap.put("sign_type", "MD5");
        tmap.put("sign", sign);
        String xml = WXPayUtil.mapToXml(tmap);
        String xml1 = httpClientResultGetPublicKey(xml);
        Map<String, String> map = WXPayUtil.xmlToMap(xml1);
        String return_code = map.get("return_code");
        String result_code = map.get("result_code");
        if ("SUCCESS".equals(result_code) && "SUCCESS".equals(return_code)) {
            return map.get("pub_key");
        } else {
            return map.get("err_code_des");
        }
    }

    private String creatSign(String characterEncoding, SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + this.getPaternerKey_1());
        String sign = MD5Utils.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        System.out.println(sign);
        return sign;
    }

    private String httpClientResultGetPublicKey(String xml) throws Exception {
        StringBuffer reultBuffer = new StringBuffer();
        SSLConnectionSocketFactory sslsf = readCustomSSL();
        HttpPost httpPost = new HttpPost("https://fraud.mch.weixin.qq.com/risk/getpublickey");
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        StringEntity myEntity = new org.apache.http.entity.StringEntity(xml, "utf-8");
        myEntity.setContentType("text/xml;charset=UTF-8");
        myEntity.setContentEncoding("utf-8");
        httpPost.setHeader("Content-Type", "text/xml; charset=UTF-8");
        httpPost.setEntity(myEntity);
        CloseableHttpResponse response = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                inputStream = entity.getContent();
                inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                bufferedReader = new BufferedReader(inputStreamReader);
                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                    reultBuffer.append(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
            response.close();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }
        return reultBuffer.toString();
    }

    public String httpClientResultPANK(String xml) throws Exception {
        StringBuffer reultBuffer = new StringBuffer();
        SSLConnectionSocketFactory sslsf = readCustomSSL();
        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaysptrans/pay_bank");
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        StringEntity myEntity = new org.apache.http.entity.StringEntity(xml, "utf-8");
        myEntity.setContentType("text/xml;charset=UTF-8");
        myEntity.setContentEncoding("utf-8");
        httpPost.setHeader("Content-Type", "text/xml; charset=UTF-8");
        httpPost.setEntity(myEntity);
        CloseableHttpResponse response = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                inputStream = entity.getContent();
                inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                bufferedReader = new BufferedReader(inputStreamReader);
                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                    reultBuffer.append(str);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
            response.close();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
        }
        return reultBuffer.toString();
    }

    private SSLConnectionSocketFactory readCustomSSL() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        InputStream instream = this.getClass().getResourceAsStream("/cert/wx_api.p12");
        SystemPayConfigWithBLOBs config = payConfigService.getPayConfig(1);
        byte[] cert = config.getWxpayApiCert();
        keyStore.load(new ByteArrayInputStream(cert), getMch_id_1().toCharArray());
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, getMch_id_1().toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        return sslsf;
    }

    public static String substring(String str, int f, int t) {
        if (f > str.length())
            return null;
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }

    public static List<String> getStrList(String inputString, int length, int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }

    private String pc1_to_pc8(String in) {
        StringBuilder builder = new StringBuilder();
        String start = "-----BEGIN RSA PUBLIC KEY-----";
        String end = "-----END RSA PUBLIC KEY-----";
        String key_tmp = in.replace(start, "").replace(end, "");
        builder.append(start);
        builder.append("\n");
        List<String> strList = getStrList(key_tmp, 60);
        for (String s : strList) {
            builder.append(s);
            builder.append("\n");
        }
        builder.append(end);
        in = builder.toString();
        System.out.println(in);
        String file_name = System.currentTimeMillis() + "";
        String ret = "";
        try {
            FileWriter writer = new FileWriter(new File("/tmp/" + file_name + "_in.pem"));
            writer.write(in, 0, in.length());
            writer.close();
            File file = new File("/tmp/" + file_name + "_in.pem");
            if (!file.exists()) {
                throw new Exception("文件不存在!");
            }
            String cmd = "openssl rsa -RSAPublicKey_in -in " + file.getAbsolutePath() +
                    " -pubout -out /tmp/" + file_name + "_out.pem";
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            file.delete();
            if (p.exitValue() != 0) {
                throw new Exception("转换错误");
            }
            File out = new File("/tmp/" + file_name + "_out.pem");
            if (!out.exists()) {
                throw new Exception("转换错误");
            }
            FileReader reader1 = new FileReader(out);
            int flen = (int) out.length();
            char[] strBuffer = new char[flen];
            reader1.read(strBuffer, 0, flen);
            ret = new String(strBuffer);
            System.gc();
            out.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println(ret);
        return ret;
    }

    /**
     * 微信请求退款
     */
    public Map refund(SystemOrder order) throws Exception {
        this.init();
        HashMap<Object, Object> map = new HashMap<>();
        String api = "https://api.mch.weixin.qq.com/secapi/pay/refund";
        BigDecimal price = order.getPrice();
        Double price_wx = price.doubleValue() * 100;
        String currTime = getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = buildRandom(4) + "";
        String strReq = strTime + strRandom;
        HashMap<String, String> param = new HashMap<>();
        param.put("appid", getWx_appid_1());
        param.put("mch_id", getMch_id_1());
        param.put("nonce_str", strReq);
        param.put("transaction_id", order.getTradeNo());
        param.put("out_refund_no", order.getOutOrderId());
        param.put("total_fee", price_wx.intValue() + "");
        param.put("refund_fee", price_wx.intValue() + "");
        param.put("sign", getSign(param, this.getPaternerKey_1()));
        String data;
        String ret;
        Map<String, String> ret_map = null;
        try {
            data = WXPayUtil.mapToXml(param);
            ret = payToAccount(api, data);
            ret_map = WXPayUtil.xmlToMap(ret);
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
     * 微信付款到个人
     */
    public Map changeMoneyToWxAccountMap(Map sett) throws Exception {
        this.init();
        HashMap<Object, Object> ret_map_sc = new HashMap<>();
        String api = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        BigDecimal price = new BigDecimal(sett.get("final_money").toString());
        Double v = price.doubleValue() * 100;
        HashMap<String, String> map = new HashMap<>();
        map.put("mch_appid", getWx_appid_1());
        map.put("mchid", getMch_id_1());
        map.put("nonce_str", sett.get("str").toString());
        map.put("partner_trade_no", sett.get("sid").toString());
        map.put("openid", sett.get("pid").toString());
        map.put("check_name", "FORCE_CHECK");
        map.put("re_user_name", sett.get("pname").toString());
        map.put("amount", String.valueOf(v.intValue()));
        map.put("desc", sett.get("title").toString());
        map.put("spbill_create_ip", sett.get("ip").toString());
        map.put("sign", getSign(map, this.getPaternerKey_1()));
        String data;
        String ret;
        Map<String, String> ret_map = null;
        try {
            data = WXPayUtil.mapToXml(map);
            ret = payToAccount(api, data);
            ret_map = WXPayUtil.xmlToMap(ret);
            if (ret_map == null) {
                throw new Exception("返回数据错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        String return_code = ret_map.get("return_code");
        String result_code = ret_map.get("result_code");
        if ("SUCCESS".equals(result_code) && "SUCCESS".equals(return_code)) {
            ret_map_sc.put("error", result_code);
            ret_map_sc.put("status", "2");
            ret_map_sc.put("tran_no", ret_map.get("payment_no"));
            return ret_map_sc;
        } else {
            String err_code_des = ret_map.get("err_code_des");
            ret_map_sc.put("error", err_code_des);
            ret_map_sc.put("status", "3");
            ret_map_sc.put("tran_no", "000");
            return ret_map_sc;
        }
    }

    /**
     * 微信转账到银行卡
     */
    public Map payToUserCard(Map sett) throws Exception {
        this.init();
        HashMap<Object, Object> ret_map_sc = new HashMap<>();
        String key = this.getPublicKey();
        key = pc1_to_pc8(key);
        if (key == null) {
            ret_map_sc.put("error", "key conver error!");
            ret_map_sc.put("status", "3");
            ret_map_sc.put("tran_no", "000");
            return ret_map_sc;
        }
        BigDecimal price = new BigDecimal(sett.get("final_money").toString());
        Double v = price.doubleValue() * 100;
        String pid = getRSA(sett.get("pid").toString(), key);
        if (pid == null) {
            ret_map_sc.put("error", "pid encrypt error!");
            ret_map_sc.put("status", "3");
            ret_map_sc.put("tran_no", "000");
            return ret_map_sc;
        }
        String pname = getRSA(sett.get("pname").toString(), key);
        if (pname == null) {
            ret_map_sc.put("error", "pname conver error!");
            ret_map_sc.put("status", "3");
            ret_map_sc.put("tran_no", "000");
            return ret_map_sc;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mch_id", getMch_id_1());
        map.put("nonce_str", sett.get("str").toString());
        map.put("partner_trade_no", sett.get("sid").toString());
        map.put("enc_bank_no", pid);
        map.put("enc_true_name", pname);
        map.put("bank_code", sett.get("bank").toString());
        map.put("amount", String.valueOf(v.intValue()));
        map.put("desc", sett.get("title").toString());
        map.put("sign", getSign(map, this.getPaternerKey_1()));
        String data;
        String ret1;
        Map<String, String> ret_map = null;
        try {
            data = WXPayUtil.mapToXml(map);
            ret1 = httpClientResultPANK(data);
            ret_map = WXPayUtil.xmlToMap(ret1);
            if (ret_map == null) {
                throw new Exception("返回数据错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        String return_code = ret_map.get("return_code");
        String result_code = ret_map.get("result_code");
        if ("SUCCESS".equals(result_code) && "SUCCESS".equals(return_code)) {
            ret_map_sc.put("error", result_code);
            ret_map_sc.put("status", "2");
            ret_map_sc.put("tran_no", ret_map.get("payment_no"));
            ret_map_sc.put("cmms_amt", ret_map.get("cmms_amt"));
            return ret_map_sc;
        } else {
            String err_code_des = ret_map.get("err_code_des");
            ret_map_sc.put("error", err_code_des);
            ret_map_sc.put("status", "3");
            ret_map_sc.put("tran_no", "000");
            return ret_map_sc;
        }

    }

    /**
     * 微信扫码支付 模式二
     */
    public String getWxPayQRCode(SystemOrder order, String notify_domain) throws Exception {
        this.init();
        BigDecimal price = order.getPrice();
        Double v = price.doubleValue() * 100;
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", this.getWx_appid_1());
        map.put("mch_id", this.getMch_id_1());
        map.put("nonce_str", getRandomStringByLength(32));
        map.put("body", order.getTitle());
        map.put("out_trade_no", order.getId().toString());
        map.put("total_fee", String.valueOf(v.intValue()));
        map.put("spbill_create_ip", order.getIpAddr());
        map.put("notify_url", notify_domain);
        map.put("trade_type", "NATIVE");
        map.put("product_id", order.getId().toString());
        map.put("sign", getSign(map, this.getPaternerKey_1()));
        String data = WXPayUtil.mapToXml(map);
        String ret = HttpClientUtils.postParameters(unifiedOrderUrl, data);
        Map<String, String> map1 = WXPayUtil.xmlToMap(ret);
        String code_url = map1.get("code_url");
        if (!map1.get("result_code").equals("SUCCESS")) {
            return map1.get("result_code");
        } else {
            return code_url;
        }
    }

    /**
     * 微信内支付 - 公众号/小程序
     */
    public Map createWeChatPayInfo(SystemOrder order, String domain, String openid) throws Exception {
        this.init();
        String currTime = getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = buildRandom(4) + "";
        String strReq = strTime + strRandom;
        BigDecimal price = order.getPrice();
        Double v = price.doubleValue() * 100;
        SortedMap<String, String> map = new TreeMap<>();
        map.put("appid", getWx_appid_1());
        map.put("mch_id", getMch_id_1());
        map.put("nonce_str", strReq);
        map.put("body", order.getTitle());
        map.put("out_trade_no", order.getId().toString());
        map.put("total_fee", String.valueOf(v.intValue()));
        map.put("spbill_create_ip", order.getIpAddr());
        map.put("notify_url", domain);
        map.put("trade_type", "JSAPI");
        map.put("openid", openid);
        map.put("sign", createSign(map));
        String req_xml = this.buildParamMap(map);
        String resp = HttpClientUtils.postParameters(unifiedOrderUrl, req_xml);
        Map model = WXPayUtil.xmlToMap(resp);
        if (model != null && "SUCCESS".equals(model.get("return_code"))) {
            long time = System.currentTimeMillis();
            SortedMap<String, String> map2 = new TreeMap<>();
            map2.put("appId", this.getWx_appid_1());
            map2.put("timeStamp", String.valueOf(time));
            map2.put("nonceStr", UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
            map2.put("package", "prepay_id=" + model.get("prepay_id"));
            map2.put("signType", "MD5");
            String sign = createSign(map2);
            map2.put("sign", sign);
            return map2;
        }
        return null;
    }

    /**
     * 微信外支付 - H5
     */
    public String GetWxWAPPayUrl(SystemOrder order, String domain) throws Exception {
        this.init();
        String currTime = getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = this.buildRandom(4) + "";
        String strReq = strTime + strRandom;
        BigDecimal price = order.getPrice();
        Double v = price.doubleValue() * 100;
        SortedMap<String, String> paramap = new TreeMap<>();
        paramap.put("appid", getWx_appid_1());
        paramap.put("mch_id", getMch_id_1());
        paramap.put("device_info", "WEB");
        paramap.put("nonce_str", strReq);
        paramap.put("body", order.getTitle());
        paramap.put("out_trade_no", order.getId().toString());
        paramap.put("total_fee", String.valueOf(v.intValue()));
        paramap.put("spbill_create_ip", order.getIpAddr());
        paramap.put("notify_url", domain);
        paramap.put("trade_type", "MWEB");
        paramap.put("scene_info", "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"" + domain + "\",\"wap_name\": \"" + order.getTitle() + "\"}}");
        paramap.put("sign", this.createSign(paramap));
        String req_xml = WXPayUtil.mapToXml(paramap);
        String resp = HttpClientUtils.postParameters(unifiedOrderUrl, req_xml);
        Map<String, String> map1 = WXPayUtil.xmlToMap(resp);
        String code_url = map1.get("mweb_url");
        if (!map1.get("result_code").equals("SUCCESS")) {
            return map1.get("result_code");
        } else {
            return code_url;
        }
    }

    /**
     * 微信付款到个人2
     */
    public Boolean changeMoneyToWxAccount(SystemSett sett, SystemUser user) throws Exception {
        this.init();
        String api = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        String currTime = getCurrTime();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = buildRandom(4) + "";
        String strReq = strTime + strRandom;
        BigDecimal price = sett.getSettFinalMoney();
        Double v = price.doubleValue() * 100;
        HashMap<String, String> map = new HashMap<>();
        map.put("mch_appid", getWx_appid_1());
        map.put("mchid", getMch_id_1());
        map.put("nonce_str", strReq);
        map.put("partner_trade_no", sett.getSid());
        map.put("openid", user.getZspayid());
        map.put("check_name", "FORCE_CHECK");
        map.put("re_user_name", user.getZsname());
        map.put("amount", String.valueOf(v.intValue()));
        map.put("desc", "统一结算:" + time.format(sett.getCreateTime()) + " SID:" + sett.getSid());
        map.put("spbill_create_ip", user.getCreateIp());
        map.put("sign", getSign(map, this.getPaternerKey_1()));
        String data;
        String ret;
        Map<String, String> ret_map = null;
        try {
            data = WXPayUtil.mapToXml(map);
            ret = payToAccount(api, data);
            ret_map = WXPayUtil.xmlToMap(ret);
            if (ret_map == null) {
                throw new Exception("返回数据错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String return_code = ret_map.get("return_code");
        String result_code = ret_map.get("result_code");
        if ("SUCCESS".equals(result_code) && "SUCCESS".equals(return_code)) {
            sett.setSettError(result_code);
            sett.setTranNo(ret_map.get("payment_no"));
            sett.setStatus(2);
            sett.setOkTime(new Date());
            settLementService.updateSystemSett(sett);
            return true;
        } else {
            String err_code_des = ret_map.get("err_code_des");
            sett.setSettError(err_code_des);
            sett.setStatus(3);
            sett.setOkTime(new Date());
            sett.setTranNo("000");
            settLementService.updateSystemSett(sett);
            return false;
        }
    }

    /**
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     */
    public boolean isTenpaySign(SortedMap<Object, Object> packageParams, String API_KEY) throws Exception {
        this.init();
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);
        String mysign = string2MD5(sb.toString()).toLowerCase();
        String tenpaySign = ((String) packageParams.get("sign")).toLowerCase();
        return tenpaySign.equals(mysign);
    }

}

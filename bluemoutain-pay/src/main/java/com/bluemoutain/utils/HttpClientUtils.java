package com.bluemoutain.utils;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author jdh
 * @date   2016年11月14日13:45:13
 * <p>
 * HTTP 请求工具类
 * <p>
 * 依赖的jar包有：commons-lang-2.6.jar、httpclient-4.3.2.jar、httpcore-4.3.1.jar、commons-io-2.4.jar
 */
public class HttpClientUtils {

    static final int connTimeout = 3000;
    static final int readTimeout = 3000;
    static final String charset = "UTF-8";
    private static HttpClient client = null;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(512);
        cm.setDefaultMaxPerRoute(512);
        client = HttpClients.custom().setConnectionManager(cm).build();

    }

    public static Map getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    public static String postParameters(String url, String parameterStr) throws Exception {
        return post(url, parameterStr, "application/x-www-form-urlencoded", charset, connTimeout, readTimeout);
    }

    public static String postParameters(String url, String parameterStr, String charset, Integer connTimeout, Integer readTimeout) throws Exception {
        return post(url, parameterStr, "application/x-www-form-urlencoded", charset, connTimeout, readTimeout);
    }

    public static String postParameters(String url, Map<String, String> params) throws Exception {
        return postForm(url, params, null, connTimeout, readTimeout);
    }

    public static String postParameters(String url, Map<String, String> params, Integer connTimeout, Integer readTimeout) throws Exception {
        return postForm(url, params, null, connTimeout, readTimeout);
    }

    public static String get(String url) throws Exception {
        return get(url, charset, null, null);
    }

    public static String get(String url, String charset) throws Exception {
        return get(url, charset, connTimeout, readTimeout);
    }

    /**
     * 发送一个 Post 请求, 使用指定的字符集编码.
     */
    public static String post(String url, String body, String mimeType, String charset, Integer connTimeout, Integer readTimeout) throws Exception {
        HttpClient client = null;
        HttpPost post = new HttpPost(url);
        post.addHeader("accept", "*/*");
        post.addHeader("connection", "Keep-Alive");
        post.addHeader("Cache-Control", "max-age=0");
        post.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        String result = "";
        try {
            if (StringUtils.isNotBlank(body)) {
                HttpEntity entity = new StringEntity(body, ContentType.create(mimeType, charset));
                post.setEntity(entity);
            }
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            customReqConf.setConnectTimeout(8000);
            customReqConf.setSocketTimeout(8000);
            customReqConf.setCircularRedirectsAllowed(true);
            customReqConf.setRelativeRedirectsAllowed(true);
            customReqConf.setConnectionRequestTimeout(8000);
            post.setConfig(customReqConf.build());
            HttpResponse res;
            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
                res = client.execute(post);
            }
            result = IOUtils.toString(res.getEntity().getContent(), charset);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            post.releaseConnection();
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * 提交form表单
     */
    private static String postForm(String url, Map<String, String> params, Map<String, String> headers, Integer connTimeout, Integer readTimeout) throws Exception {
        HttpClient client = null;
        HttpPost post = new HttpPost(url);
        post.addHeader("accept", "*/*");
        post.addHeader("connection", "Keep-Alive");
        post.addHeader("Cache-Control", "max-age=0");
        post.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> formParams = new ArrayList<NameValuePair>();
                Set<Entry<String, String>> entrySet = params.entrySet();
                for (Entry<String, String> entry : entrySet) {
                    formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
                post.setEntity(entity);
            }

            if (headers != null && !headers.isEmpty()) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            customReqConf.setConnectTimeout(8000);
            customReqConf.setSocketTimeout(8000);
            customReqConf.setCircularRedirectsAllowed(true);
            customReqConf.setRelativeRedirectsAllowed(true);
            customReqConf.setConnectionRequestTimeout(8000);
            post.setConfig(customReqConf.build());
            HttpResponse res = null;
            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
                res = client.execute(post);
            }
            return IOUtils.toString(res.getEntity().getContent(), "UTF-8");
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            post.releaseConnection();
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
    }

    /**
     * 发送一个 GET 请求
     */
    public static String get(String url, String charset, Integer connTimeout, Integer readTimeout) throws Exception {
        HttpClient client = null;
        HttpGet get = new HttpGet(url);
        get.addHeader("accept", "*/*");
        get.addHeader("connection", "Keep-Alive");
        get.addHeader("Cache-Control", "max-age=0");
        get.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        String result = "";
        try {
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            customReqConf.setConnectTimeout(8000);
            customReqConf.setSocketTimeout(8000);
            customReqConf.setCircularRedirectsAllowed(true);
            customReqConf.setRelativeRedirectsAllowed(true);
            customReqConf.setConnectionRequestTimeout(8000);
            get.setConfig(customReqConf.build());
            HttpResponse res = null;
            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(get);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
                res = client.execute(get);
            }
            result = IOUtils.toString(res.getEntity().getContent(), charset);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            get.releaseConnection();
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * 从 response 里获取 charset
     */
    @SuppressWarnings("unused")
    private static String getCharsetFromResponse(HttpResponse ressponse) {
        if (ressponse.getEntity() != null && ressponse.getEntity().getContentType() != null && ressponse.getEntity().getContentType().getValue() != null) {
            String contentType = ressponse.getEntity().getContentType().getValue();
            if (contentType.contains("charset=")) {
                return contentType.substring(contentType.indexOf("charset=") + 8);
            }
        }
        return null;
    }


    /**
     * 创建 SSL连接
     */
    private static CloseableHttpClient createSSLInsecureClient() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] chain, String authType) {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) {
                }

                @Override
                public void verify(String host, X509Certificate cert) {
                }

                @Override
                public void verify(String host, String[] cns,
                                   String[] subjectAlts) {
                }
            });
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println(get("http://lil6.cc/other/epay_notify.php?money=0.01&order_time=1526796933000&out_trade_no=20180520141524183&pid=84&sign=b1c9b49d3b2f835df110d173f9f56dcf&sign_type=MD5&trade_no=5892&trade_status=TRADE_SUCCESS&type=wxpay"));
//    }


}
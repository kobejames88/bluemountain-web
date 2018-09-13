package com.bluemoutain.utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Cookie 工具类
 */
public final class CookieUtils2 {
    /**
     * 得到Cookie的值, 不编码
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
     * 得到Cookie的值,
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8");
                    } else {
                        retValue = cookieList[i].getValue();
                    }
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 得到Cookie的值,
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     */
    public static void setCookie(
            HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue
    ) {
        setCookie(request, response, cookieName, cookieValue, -1);
    }

    /**
     * 设置Cookie的值 在指定时间内生效,但不编码
     */
    public static void setCookie(
            HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage
    ) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 设置Cookie的值 不设置生效时间,但编码
     */
    public static void setCookie(
            HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, boolean isEncode
    ) {
        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数
     */
    public static void setCookie(
            HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, boolean isEncode
    ) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数(指定编码)
     */
    public static void setCookie(
            HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, String encodeString
    ) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
     * 删除Cookie带cookie域名
     */
    public static void deleteCookie(
            HttpServletRequest request, HttpServletResponse response,
            String cookieName
    ) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }


    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(
            HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, boolean isEncode
    ) {
//        Boolean isSetCookie = PropKit.use("config.properties").getBoolean("isSetCookie", true);
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {
                // 设置域名的cookie
                String domainName = getDomainName(request);
                if (domainName != null) {
                    cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(
            HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, String encodeString
    ) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {// 设置域名的cookie
                String domainName = getDomainName(request);
                if (domainName != null) {
                    cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到cookie的域名
     */
    private static String getDomainName(HttpServletRequest request) throws Exception {
        String name = request.getServerName();
        boolean b = isIp(name);
        if (!b && !"localhost".equals(name)) {
            return getDomainName(request.getRequestURL().toString());
        } else {
            return null;
        }
    }

    private static String trimSpaces(String IP) {//去掉IP字符串前后所有的空格
        while (IP.startsWith(" ")) {
            IP = IP.substring(1, IP.length()).trim();
        }
        while (IP.endsWith(" ")) {
            IP = IP.substring(0, IP.length() - 1).trim();
        }
        return IP;
    }

    public static boolean isIp(String IP) {//判断是否是一个IP
        boolean b = false;
        IP = trimSpaces(IP);
        if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
            String s[] = IP.split("\\.");
            if (Integer.parseInt(s[0]) < 255)
                if (Integer.parseInt(s[1]) < 255)
                    if (Integer.parseInt(s[2]) < 255)
                        if (Integer.parseInt(s[3]) < 255)
                            b = true;
        }
        return b;
    }

    private final static Set<String> PublicSuffixSet = new HashSet<String>(Arrays.asList(new String("com|org|net|gov|edu|co|tv|mobi|info|asia|xxx|onion|cn|com.cn|edu.cn|gov.cn|net.cn|org.cn|jp|kr|tw|com.hk|hk|com.hk|org.hk|se|com.se|org.se").split("\\|")));
    private static Pattern IP_PATTERN = Pattern.compile("(\\d{1,3}\\.){3}(\\d{1,3})");

    /**
     * 获取url的顶级域名
     *
     * @param url
     * @return
     */
    private static String getDomainName(URL url) {
        String host = url.getHost();
        if (host.endsWith("."))
            host = host.substring(0, host.length() - 1);
        if (IP_PATTERN.matcher(host).matches())
            return host;

        int index = 0;
        String candidate = host;
        for (; index >= 0; ) {
            index = candidate.indexOf('.');
            String subCandidate = candidate.substring(index + 1);
            if (PublicSuffixSet.contains(subCandidate)) {
                return candidate;
            }
            candidate = subCandidate;
        }
        return candidate;
    }

    /**
     * 获取url的顶级域名
     *
     * @param url
     * @return
     * @throws MalformedURLException
     */
    public static String getDomainName(String url) throws MalformedURLException {
        return getDomainName(new URL(url));
    }

    /**
     * 判断两个url顶级域名是否相等
     *
     * @param url1
     * @param url2
     * @return
     */
    public static boolean isSameDomainName(URL url1, URL url2) {
        return getDomainName(url1).equalsIgnoreCase(getDomainName(url2));
    }

    /**
     * 判断两个url顶级域名是否相等
     *
     * @param url1
     * @param url2
     * @return
     * @throws MalformedURLException
     */
    public static boolean isSameDomainName(String url1, String url2)
            throws MalformedURLException {
        return isSameDomainName(new URL(url1), new URL(url2));
    }
}

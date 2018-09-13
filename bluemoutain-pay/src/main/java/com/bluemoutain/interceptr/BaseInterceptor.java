package com.bluemoutain.interceptr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基础拦截器
 */
public class BaseInterceptor implements HandlerInterceptor {

    public static boolean verify = true;

    private static Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI().toLowerCase();
        //String user_agent = request.getHeader("user-agent");
       // logger.info(user_agent);
        if (uri != null && !uri.contains("/static/")) {
            logger.info("RequestURL:" + uri);
        }
        if (!verify) {
            throw new Exception("程序被修改,签名验证错误,请到 http://dl.206so.com 重新下载!");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

}

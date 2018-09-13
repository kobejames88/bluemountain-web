package com.bluemoutain.config;


import com.bluemoutain.interceptr.BaseInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置自定义拦截器
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {


    private static Logger logger = LoggerFactory.getLogger(WebAppConfigurer.class);

    public WebAppConfigurer() {
        logger.info("加载自定义拦截器...");
    }


    /**
     * 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**");
    }

    /**
     * 添加静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


}

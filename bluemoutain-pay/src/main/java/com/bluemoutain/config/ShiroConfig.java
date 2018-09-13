package com.bluemoutain.config;


import com.bluemoutain.security.CredentialsMatcher;
import com.bluemoutain.security.MyShiroRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * Shiro 权限控制集成
 */
@Configuration
public class ShiroConfig {

    private static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    public ShiroConfig() {
        logger.info("ShiroConfig Init...");
    }

    /**
     * 将自己的验证方式加入容器
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    /**
     * 权限管理，配置主要是Realm的管理认证
     */
    @Bean
    public SecurityManager securityManager() {
   DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
   securityManager.setRealm(myShiroRealm());
    return  securityManager;
    }

    /**
     * 加入注解的使用，不加入这个注解不生效
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 配置自定义的密码比较器
     */
    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new CredentialsMatcher();
    }


    /**
     * Filter工厂，设置对应的过滤条件和跳转条件
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, String> map = new HashMap<>();
        //对所有用户认证
        map.put("/admin/**", "authc");
        //不拦截URL
        map.put("/login/ajax", "anon");
        map.put("/static/**", "anon");
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

}

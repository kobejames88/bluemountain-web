package com.bluemoutain.config;

import com.bluemoutain.crond.process.VerfySign;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 系统基础配置
 */
@Configuration
public class SystemConfig {

    private static Logger logger = LoggerFactory.getLogger(SystemConfig.class);

    private static final String templatesPath = "/templates";

    private static final String resroot = "/templates";

    public SystemConfig() {
        VerfySign sign = new VerfySign();
        Thread thread = new Thread(sign);
        thread.setDaemon(true);
        thread.start();
        logger.info("初始化系统基本配置...");
    }

    @Bean(name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = SystemConfig.class.getClassLoader();
        }
        Properties properties = new Properties();
        properties.setProperty("FNP.myutils", "com.so206.utils.MyBeetlUtils");
        properties.setProperty("RESOURCE.ROOT", resroot);
        properties.setProperty("beetlsql.enabled", "false");
        properties.setProperty("beetl.enabled", "true");
        beetlGroupUtilConfiguration.setConfigProperties(properties); //额外的配置，可以覆盖默认配置，一般不需要
        ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader, templatesPath);
        beetlGroupUtilConfiguration.setResourceLoader(cploder);
        beetlGroupUtilConfiguration.init();
        beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
        return beetlGroupUtilConfiguration;

    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setPrefix("/");
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        logger.info("beetlViewResolver Init...");
        return beetlSpringViewResolver;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(om);
        template.setValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }


}

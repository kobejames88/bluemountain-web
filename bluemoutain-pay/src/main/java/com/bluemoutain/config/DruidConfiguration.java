package com.bluemoutain.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DruidConfiguration {

    private static Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    public DruidConfiguration() {
        logger.info("配置Druid数据源...");
    }

    /**
     * MyBatis 分页插件
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        logger.info("PageHelper Init...");
        return pageHelper;
    }

    /**
     * 创建数据源,可省略
     */
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }


}

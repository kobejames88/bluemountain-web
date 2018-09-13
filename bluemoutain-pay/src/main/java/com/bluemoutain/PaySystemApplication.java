package com.bluemoutain;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan
@EnableWebMvc
@EnableScheduling
@EnableAsync
@MapperScan("com.so206.mapper")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class PaySystemApplication {

    private static Logger logger = LoggerFactory.getLogger(PaySystemApplication.class);

    public PaySystemApplication() {
        logger.info("应用程序启动...");
    }

    public static void main(String[] args) {
        SpringApplication.run(PaySystemApplication.class, args);
    }

}

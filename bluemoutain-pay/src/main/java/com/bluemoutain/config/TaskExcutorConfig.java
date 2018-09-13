package com.bluemoutain.config;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 定时任务多线程和异常处理
 */
@EnableAsync
@Configuration
public class TaskExcutorConfig implements AsyncConfigurer {

    private static Logger logger = LoggerFactory.getLogger(TaskExcutorConfig.class);

    public TaskExcutorConfig() {
        logger.info("TaskExcutorConfig Init...");
    }

    @NotNull
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(150);
        threadPoolTaskExecutor.setMaxPoolSize(300);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @NotNull
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

}

class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(MyAsyncExceptionHandler.class);

    MyAsyncExceptionHandler() {
        logger.info("MyAsyncExceptionHandler Init...");
    }

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        logger.error("Exception occurs in async method:" + method.getName(), throwable.getMessage());
    }

}


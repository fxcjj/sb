package com.vic.sb12.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 * @author Victor
 * date: 2019/5/29 19:24
 */
@Configuration
public class ThreadPoolTaskExecutorConfig {

    //线程池维护线程的最少数量
    @Value("${async.task.minSize:5}")
    private int minPoolSize;

    //线程池维护线程的最大数量
    @Value("${async.task.maxSize:30}")
    private int maxPoolSize;

    //缓存队列数量
    @Value("${async.task.queues:8}")
    private int queueCapacity;

    //允许的空闲时间
    @Value("${async.task.keepAlive:60}")
    private int keepAlive;

    //任务名称前缀
    @Value("${async.task.namePrefix:taskExecutor-}")
    private String namePrefix;

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(minPoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setThreadNamePrefix(namePrefix);
        /** rejection-policy：当pool已经达到max size的时候，如何处理新任务
         *  CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
         */
        //对拒绝task的处理策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setKeepAliveSeconds(keepAlive);
        taskExecutor.initialize();
        return taskExecutor;
    }

}

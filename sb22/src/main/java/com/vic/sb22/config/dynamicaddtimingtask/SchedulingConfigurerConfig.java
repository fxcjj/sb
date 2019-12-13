package com.vic.sb22.config.dynamicaddtimingtask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 罗利华
 * date: 2019/12/4 17:47
 */
//@Configuration
public class SchedulingConfigurerConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskExecutor());
        taskRegistrar.getScheduler().schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("SchedulingConfigurer定时任务：" + new Date());
            }
        }, new CronTrigger("0/3 * * * * ?")); //每3秒执行一次
    }

    /**
     * 有两个，不能同时使用
     * @return
     */
    @Bean
    public TaskScheduler taskExecutor() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setPoolSize(20);
        executor.setThreadNamePrefix("diana-Executor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //调度器shutdown被调用时等待当前被调度的任务完成
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //等待时长
        executor.setAwaitTerminationSeconds(60);
        return executor;
    }

}
package com.vic.sb22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolTaskScheduler测试
 * @author Victor
 * date: 2019/12/3 19:34
 */
@RestController
@RequestMapping("test3")
public class Test3Controller {

    @Autowired
    TaskScheduler taskScheduler;

    @GetMapping("poolTask")
    public String threadPoolTaskScheduler() {

        taskScheduler.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("ThreadPoolTaskScheduler定时任务：" + new Date());
            }

        }, new CronTrigger("0/3 * * * * ?"));//每3秒执行一次

        return "ThreadPoolTaskScheduler!";
    }
}

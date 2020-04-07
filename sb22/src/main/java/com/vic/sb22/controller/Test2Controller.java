package com.vic.sb22.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService测试
 * @author Victor
 * date: 2019/12/3 19:34
 */
@RestController
@RequestMapping("test2")
public class Test2Controller {

    @GetMapping("exec")
    public String exec() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("ScheduledExecutorService定时任务执行：" + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS); //首次延迟1秒，之后每1秒执行一次
        return "ScheduledExecutorService!";
    }


}

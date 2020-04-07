package com.vic.sb22.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer类测试
 * @author Victor
 * date: 2019/12/3 19:34
 */
@RestController
@RequestMapping("test1")
public class Test1Controller {

    @GetMapping("doTimer")
    public String doTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer定时任务启动：" + new Date());
            }
        }, 1000, 1000); // 延迟1秒启动，每1秒执行一次

        return "timer";
    }


}

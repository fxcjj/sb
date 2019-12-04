package com.vic.sb22.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 罗利华
 * date: 2019/12/3 19:45
 */
//@Component
public class ScheduledTask1 {

    /**
     * 自动扫描，启动时间点之后3秒执行一次
     * 使用线程池执行
     */
    @Async("scheduledPoolTaskExecutor")
    @Scheduled(fixedRate = 3000)
    public void getCurrentDate() {
        System.out.println(Thread.currentThread().getName() + " Scheduled定时任务执行：" + new Date());
    }

}

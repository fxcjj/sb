package com.vic.sb22.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Victor
 * date: 2019/12/3 19:45
 */
@Component
public class ScheduledTask {

    /**
     * 自动扫描
     */
//    @Scheduled(fixedRate = 3000) // 启动时间点之后3秒执行一次
    @Scheduled(cron="0 0/1 * * * ?") // 从第1分钟开始，每1分钟执行一次
    public void getCurrentDate() {
        System.out.println("ScheduledTask Scheduled定时任务执行：" + new Date());
    }

}

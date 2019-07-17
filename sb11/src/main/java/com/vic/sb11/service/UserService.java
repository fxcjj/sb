package com.vic.sb11.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * @author 罗利华
 * date: 2019/7/16 20:18
 */
@Service
public class UserService {

    @Async
    public void sendSms() {
        System.out.println("2 Start sendSms");
        IntStream.range(0, 5).forEach(d -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("3 End sendSms");
    }
}

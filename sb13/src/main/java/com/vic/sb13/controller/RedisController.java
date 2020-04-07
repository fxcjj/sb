package com.vic.sb13.controller;

import com.vic.sb13.component.RedisComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 测试Redis相关
 * @author Victor
 * date: 2020/4/7 16:14
 */
@Slf4j
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    RedisComponent redisComponent;

    @GetMapping("a")
    public String a() {
        String key = "123";
        String value = UUID.randomUUID().toString().replaceAll("-", "");
//        String value = String.valueOf(System.currentTimeMillis());
        // redis分布式锁
        boolean lock = redisComponent.lock(key, value, 10L, TimeUnit.SECONDS);
        if(!lock) {
            return "locked";
        }
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(lock) {
                redisComponent.releaseLock(key, value);
            }
        }
        return "a";
    }

    @GetMapping("b")
    public String b() {
        String key = "123";
        /**
         * Could not read JSON: Unexpected character ('d' (code 100)): Expected space separating root-level values
         */
        String value = (String)redisComponent.get(key);
        return value;
    }

}

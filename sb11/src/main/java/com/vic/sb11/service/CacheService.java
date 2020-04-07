package com.vic.sb11.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Victor
 * date: 2019/7/21 22:29
 */
@Slf4j
@Service
public class CacheService {

    static Map<String, String> map = new HashMap<>();

    public String get(String key) {
        return map.get(key);
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public void expire(String userIdKey, String expireSecond) {

    }

    public void set(String key, String value, int minutes) {
        set(key, value);
    }

    public void remove(String key) {
        map.remove(key);
    }
}

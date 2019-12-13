package com.vic.sb10.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * jwt的配置
 */
@Slf4j
@Component
@Data
@ConfigurationProperties(prefix = "audience")
public class Audience {

    private String clientId;
    private String base64Secret;
    private String name;
    private int expireSecond;

    @PostConstruct
    public void aa() {
        // init: Audience(clientId=123, base64Secret=aSBhbSB5b3VyIGRhZHk=, name=victor, expireSecond=172800)
        log.info("init: {}", this);
    }
}

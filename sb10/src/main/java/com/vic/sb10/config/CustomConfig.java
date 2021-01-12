package com.vic.sb10.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 */
@Slf4j
@Component
@Data
@ConfigurationProperties(prefix = "custom")
public class CustomConfig {

    private List<Student> students;

    private List<Student> studentList;

    @PostConstruct
    public void aa() {
        // init: Audience(clientId=123, base64Secret=aSBhbSB5b3VyIGRhZHk=, name=victor, expireSecond=172800)
        log.info("init: {}", this);
    }
}

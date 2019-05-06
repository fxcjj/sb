package com.vic.sb05.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * 指定不同的环境不同的bean
 * @author 罗利华
 * date: 2019/5/5 16:02
 */
@Profile("dev")
@Slf4j
@Configuration
public class ProfileBean {

    @PostConstruct
    public void init() {
        log.info("dev环境下激活");
    }

}

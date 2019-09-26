package com.vic.sb05.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗利华
 * date: 2019/9/5 15:43
 */
@Data
@Configuration
public class TestConfig {

    @Value("${victor.name}")
    private String name;

}

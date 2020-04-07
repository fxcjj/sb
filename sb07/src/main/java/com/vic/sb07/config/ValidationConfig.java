package com.vic.sb07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author Victor
 * date: 2019/5/11 12:33
 */
//@Configuration
public class ValidationConfig {

    /**
     * 校验单个参数，不用配置下面的bean照样可以呀
     * @return
     */
//    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}

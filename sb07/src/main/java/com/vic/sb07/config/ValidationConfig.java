package com.vic.sb07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author 罗利华
 * date: 2019/5/11 12:33
 */
//@Configuration
public class ValidationConfig {

    /**
     * 处理单个参数，不用配置下面的bean
     * @return
     */
//    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}

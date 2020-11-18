package com.vic.sb14.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbit相关配置
 * @author 罗利华
 * date: 2020/11/17 17:04
 */
@Configuration
public class RabbitConfig {

    /**
     * 定义一个myQueue队列
     * @return
     */
    @Bean
    public Queue myQueue() {
        return new Queue("myQueue");
    }


}

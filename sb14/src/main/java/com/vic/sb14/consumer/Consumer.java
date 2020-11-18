package com.vic.sb14.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 罗利华
 * date: 2020/11/17 17:06
 */
@Component
// @RabbitListener 监听 myQueue 队列
@RabbitListener(queues = "myQueue")
@Slf4j
public class Consumer {

    /**
     * 指定消息的处理方法
     * @param message
     */
    @RabbitHandler
    public void process(String message) {
        log.info("接收的消息为: {}", message);
    }
}

package com.vic.sb14.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送和接收队列消息
 * @author 罗利华
 * date: 2020/11/17 17:09
 */
@RestController
public class DemoController {

    //AmqpTemplate接口定义了发送和接收消息的基本操作,目前spring官方也只集成了Rabbitmq一个消息队列。。
    @Autowired
    AmqpTemplate rabbitmqTemplate;

    @GetMapping("send")
    public String send(String msg) {
        // 发送消息
        rabbitmqTemplate.convertAndSend("myQueue ", msg);
        return "消息：" + msg + ",已发送";
    }
}

package com.vic.sb03.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rdm")
public class RandomController {

    //#随机字符串
    @Value("${random.value}")
    private String secret;

    //随机int值
    @Value("${random.int}")
    private String number;

    //随机uuid
    @Value("${random.uuid}")
    private String uuid;

    //随机long值
    @Value("${random.long}")
    private String bignumber;

    //10以内的数
    @Value("${random.int(10)}")
    private String lessThanTen;

    //1-20的随机数
    @Value("${random.int[1,20]}")
    private String range;


    @RequestMapping("/rdmNum")
    public String rdmNum() {
        return "secret: " + secret + ", number: " + number + ", bignumber: "
                + bignumber + ", uuid: " + uuid + ", lessThanTen: " + lessThanTen + ", range: " + range;
    }


    @RequestMapping("/uuid")
    public String uuid() {
        return "uuid: " + uuid;
    }

}

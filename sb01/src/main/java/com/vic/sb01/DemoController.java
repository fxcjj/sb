package com.vic.sb01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2019/4/16 16:03
 */
@RestController //@Controller + ResponseBody 默认返回json格式数据
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() {
        return "hello,SpringBoot!";
    }

}

package com.vic.sb40;

import com.alibaba.fastjson.JSON;
import com.vic.sb40.dao.master.UserMapper;
import com.vic.sb40.entity.User;
import com.vic.sb40.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Test
    public void testMethod01() {
        userService.method01();
    }

    @Test
    public void testMethod02() {
        userService.method02();
    }

    @Test
    public void testMethod03() {
        userService.method03();
    }

    @Test
    public void testMethod05() {
        userService.method05();
    }


}
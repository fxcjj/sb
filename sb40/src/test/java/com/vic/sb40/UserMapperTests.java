package com.vic.sb40;

import com.alibaba.fastjson.JSON;
import com.vic.sb40.dao.master.UserMapper;
import com.vic.sb40.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testFindById() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }

}
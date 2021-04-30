package com.vic.sb35;

import com.vic.sb35.entity.User;
import com.vic.sb35.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Sb35ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void testFindById() {
        User user = userService.findById(1);
        System.out.println(user.getName());
    }

}

package com.vic.sb08;

import com.vic.sb08.entity.User;
import com.vic.sb08.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb08ApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByName() {
        String name = "张三";
        List<User> list = userRepository.findByName(name);
        list.forEach(ele -> System.out.println(ele));

    }

}

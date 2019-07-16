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


    @Test
    public void testInsert() {
        /**
         * 当前编码为uft-8
         */
        String name = "张三";
//        System.out.println(name.length()); //2
//        System.out.println(name.getBytes().length); //6

        User u = new User();
        /**
         * 指的是字符长度，而非字节数
         * `name` varchar(20) DEFAULT NULL COMMENT '名称',
         * 以下报错（Data too long for column 'name' at row 1）
         * 123456789012345678901
         * 一二三四五六七八九十一二三四五六七八九十中
         * 原因是数据库长度为20，这里的字符长度为21
         */
        u.setName("123456789012345678901");
        userRepository.save(u);

    }

}

package com.vic.sb40;

import com.vic.sb40.entity.Student;
import com.vic.sb40.entity.User;
import com.vic.sb40.service.StudentService;
import com.vic.sb40.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Sb40ApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    /**
     * 读取 master 数据源
     */
    @Test
    public void testFindUserById() {
        User user = userService.findById(1L);
        System.out.println(user.getName());
    }

    /**
     * 读取 slave 数据源
     */
    @Test
    public void testFindStudentById() {
        Student student = studentService.findById(1L);
        System.out.println(student.getName());
    }

}
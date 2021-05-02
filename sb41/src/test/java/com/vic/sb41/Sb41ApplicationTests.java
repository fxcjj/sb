package com.vic.sb41;

import com.github.pagehelper.PageHelper;
import com.vic.sb41.entity.Student;
import com.vic.sb41.entity.User;
import com.vic.sb41.service.StudentService;
import com.vic.sb41.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Sb41ApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;


    @Test
    public void testPage1() {
        PageHelper.startPage(1, 2);
        User user = userService.findById(1L);
        System.out.println(user.getName());
    }

    @Test
    public void testFindUserById() {
        User user = userService.findById(1L);
        System.out.println(user.getName());
    }

    @Test
    public void testFindStudentById() {
        Student student = studentService.findById(1L);
        System.out.println(student.getName());
    }

}
package com.vic.sb41.controller;

import com.vic.sb40.entity.Student;
import com.vic.sb40.entity.User;
import com.vic.sb40.service.StudentService;
import com.vic.sb40.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("multiDb")
public class MultiDbController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @GetMapping("findUserById")
    public User findUserById(@RequestParam("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("findStudentById")
    public Student findStudentById(@RequestParam("id") Long id) {
        return studentService.findById(id);
    }

}

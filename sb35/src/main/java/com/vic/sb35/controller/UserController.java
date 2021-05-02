package com.vic.sb35.controller;

import com.vic.sb35.entity.User;
import com.vic.sb35.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findById")
    public User findById(@RequestParam("id") Integer id) {
        return userService.findById(id);
    }

}

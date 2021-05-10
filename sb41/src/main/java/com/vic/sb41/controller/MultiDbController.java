package com.vic.sb41.controller;

import com.vic.sb41.entity.Order;
import com.vic.sb41.entity.User;
import com.vic.sb41.service.OrderService;
import com.vic.sb41.service.UserService;
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
    OrderService orderService;

    @GetMapping("findUserById")
    public User findUserById(@RequestParam("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("findStudentById")
    public Order findStudentById(@RequestParam("id") Long id) {
        return orderService.findById(id);
    }

}

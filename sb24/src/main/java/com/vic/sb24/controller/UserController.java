package com.vic.sb24.controller;

import com.vic.sb24.entity.User;
import com.vic.sb24.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试高并发下幂等问题
 * @author 罗利华
 * date: 2019/5/6 15:56
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 插入或更新
     * @param user
     * @return
     */
    @PostMapping("insertOrUpdate")
    public String insertOrUpdate(@RequestBody User user){
        try {
            userService.insertOrUpdate(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 直接插入
     * @param user
     * @return
     */
    @PostMapping("save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    /**
     * 先查询,存在返回,不存在插入
     * @param user
     * @return
     */
    @PostMapping("save1")
    public User save1(@RequestBody User user){
        return userService.save1(user);
    }

}

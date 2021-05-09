package com.vic.sb39.controller;

import com.github.pagehelper.PageInfo;
import com.vic.sb39.bo.PageBo;
import com.vic.sb39.bo.UserBo;
import com.vic.sb39.entity.User;
import com.vic.sb39.service.UserService;
import com.vic.sb39.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("findById")
    public User findById(@RequestParam("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping("page")
    public PageInfo<UserVo> page(@RequestBody PageBo<UserBo> pageBo) {
        return userService.page(pageBo);
    }

    @PostMapping("list")
    public List<UserVo> list(@RequestBody UserBo userBo) {
        return userService.list(userBo);
    }

}

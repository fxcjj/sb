package com.vic.sb10.controller;

import com.vic.sb10.config.Audience;
import com.vic.sb10.entity.User;
import com.vic.sb10.enums.ResultEnum;
import com.vic.sb10.exception.BusinessException;
import com.vic.sb10.resp.ResponseResult;
import com.vic.sb10.service.UserService;
import com.vic.sb10.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 * @author Victor
 * date: 2019/5/22 16:23
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    private Audience audience;

    @GetMapping("beam")
    public String beam() {
        String [] a = {"a", "c", "c"};
        return "beam";
    }

    /**
     * 登录
     * @param request
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public ResponseResult login(HttpServletRequest request, String username, String password) {
        User user = userService.queryUserByUsernameAndPassword(username, password);
        if(user == null) {
            throw new BusinessException(ResultEnum.USER_NOT_EXISTS);
        }

        String jwtToken = JwtHelper.createJWT(user.getUsername(),
                user.getId(),
                user.getRole(),
                audience.getClientId(),
                audience.getName(),
                audience.getExpireSecond() * 1000,
                audience.getBase64Secret());
        // 固定格式
        String token = "bearer;" + jwtToken;
        return success(token);
    }

}

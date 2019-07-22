package com.vic.sb11.controller;

import com.vic.sb11.annotation.CheckToken;
import com.vic.sb11.entity.User;
import com.vic.sb11.enums.ResultEnum;
import com.vic.sb11.exception.BusinessException;
import com.vic.sb11.jwt.JWTInfo;
import com.vic.sb11.resp.ResponseResult;
import com.vic.sb11.service.CacheService;
import com.vic.sb11.service.UserService;
import com.vic.sb11.utils.DateUtils;
import com.vic.sb11.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 用户控制器
 * @author 罗利华
 * date: 2019/5/22 16:23
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    CacheService cacheService;

    /**
     * 私钥加密（签名）
     */
    @Value("${sys.security.privateKey}")
    private String privateKey;

    /**
     * 令牌过期时间
     */
    @Value("${jwt.token-expire-second}")
    private Integer tokenExpireSecond;

    @CheckToken
    @GetMapping("beam")
    public String beam() {
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

        // token过期时间
        Date expireDate = DateUtils.plusSeconds(new Date(), tokenExpireSecond);
        JWTInfo jwtInfo = new JWTInfo(user.getId(), user.getUsername(), user.getEmail());
        String token = JWTHelper.encodeToken(jwtInfo, privateKey, expireDate);

        String key = "user-token-" + user.getId();
        cacheService.set(key, token, tokenExpireSecond / 60);
        return success(token);
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    public ResponseResult logout() {
        String key = "user-token-" + getUserId();
        cacheService.remove(key);
        return success("success");
    }
}

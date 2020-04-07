package com.vic.sb11.controller;

import com.vic.sb11.enums.ResultEnum;
import com.vic.sb11.jwt.JWTInfo;
import com.vic.sb11.resp.ResponseResult;
import com.vic.sb11.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Victor
 * date: 2019/5/22 16:23
 */
@RestController
public class BaseController {


    @Autowired(required = false)
    protected HttpServletRequest request;

    @Autowired(required = false)
    protected HttpServletResponse response;

    /**
     * header中token名称
     */
    @Value("${jwt.token-header-name}")
    private String tokenHeaderName;

    /**
     * 公钥解密（验签）
     */
    @Value("${sys.security.publicKey}")
    private String publicKey;

    public ResponseResult success(String data) {
        return new ResponseResult(ResultEnum.SUCCESS, data);
    }

    public ResponseResult fail(String data) {
        return new ResponseResult(ResultEnum.FAIL, data);
    }


    public String getToken() {
//        String token = (String) BaseContext.get("token");
        String token = request.getHeader(tokenHeaderName);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(tokenHeaderName);
        }
        return token;
    }

    public Long getUserId() {
        try {
            String token = getToken();
            JWTInfo jwtInfo = JWTHelper.parseToken(token, publicKey);
//            BaseContext.set("userId", userId);
            return jwtInfo.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户登录信息
     * @return
     */
    public JWTInfo getUser() {
        try {
            return JWTHelper.parseToken(getToken(), publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

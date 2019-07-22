package com.vic.sb11.interceptor;

import com.vic.sb11.annotation.CheckToken;
import com.vic.sb11.enums.ResultEnum;
import com.vic.sb11.exception.BusinessException;
import com.vic.sb11.jwt.JWTInfo;
import com.vic.sb11.service.CacheService;
import com.vic.sb11.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * check token interceptor
 */
public class CheckTokenInterceptor extends HandlerInterceptorAdapter {

    /**
     * header中token名称
     */
    @Value("${jwt.token-header-name}")
    private String tokenHeaderName;

    /**
     * token过期时间
     */
    @Value("${jwt.token-expire-second}")
    private String expireSecond;

    /**
     * 公钥解密（验签）
     */
    @Value("${sys.security.publicKey}")
    private String publicKey;

    /**
     * 登录页面
     */
//    @Value("${jwt.token-expire-second}")
//    private String loginPageUri;

    @Autowired
    private CacheService cacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }

        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final Method method = handlerMethod.getMethod();
        final Class<?> clazz = method.getDeclaringClass();

        // 存在CheckToken
        if(clazz.isAnnotationPresent(CheckToken.class)
            || method.isAnnotationPresent(CheckToken.class)) {

            // 从请求头中取得令牌
            String token = request.getHeader(tokenHeaderName);
            if(StringUtils.isEmpty(token)) {
                token = request.getParameter(tokenHeaderName);
            }
            // token is empty
            if(StringUtils.isEmpty(token)) {
                throw new BusinessException(ResultEnum.TOKEN_EMPTY);
//                response.sendRedirect(loginPageUri);
            }

            JWTInfo jwtInfo = JWTHelper.parseToken(token, publicKey);

            String userIdKey = "user-token-" + jwtInfo.getUserId();
            String userId = cacheService.get(userIdKey);
            if(StringUtils.isEmpty(userId)) {
                // 需要登录
                throw new BusinessException(ResultEnum.TOKEN_EXPIRE);
            }

            // 重新设置缓存过期时间
            cacheService.expire(userIdKey, expireSecond);
            return true;
        }
        return true;
    }

}
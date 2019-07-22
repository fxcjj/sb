package com.vic.sb11.utils;

import com.vic.sb11.jwt.JWTInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;

/**
 * JWT工具类
 */
@Slf4j
public class JWTHelper {

    public static final String JWT_KEY_NAME = "name";
    public static final String JWT_KEY_EMAIL = "email";

    /**
     * 私钥加密token
     * @param jwtInfo
     * @param privateKey
     * @return token
     */
    public static String encodeToken(JWTInfo jwtInfo, String privateKey) {
        try {
            Key key = RSAUtils.buildPrivateKey(privateKey);
            String compactJws = Jwts.builder()
                    .setSubject(jwtInfo.getUserId().toString())
                    .claim(JWT_KEY_NAME, jwtInfo.getName())
                    .claim(JWT_KEY_EMAIL, jwtInfo.getEmail())
                    .signWith(SignatureAlgorithm.RS256, key)
                    .compact();
            return compactJws;
        } catch (Exception e) {
            log.error("私钥加密token异常: {}", e);
        }
       return "";
    }

    /**
     * 私钥加密token
     * @param jwtInfo
     * @param privateKey
     * @param expireDate
     * @return
     * @throws Exception
     */
    public static String encodeToken(JWTInfo jwtInfo, String privateKey, Date expireDate) {
        try {
            Key key = RSAUtils.buildPrivateKey(privateKey);
            String compactJws = Jwts.builder()
                    .setSubject(jwtInfo.getUserId().toString())
                    .claim(JWT_KEY_NAME, jwtInfo.getName())
                    .claim(JWT_KEY_EMAIL, jwtInfo.getEmail())
                    .setExpiration(expireDate)
                    .signWith(SignatureAlgorithm.RS256, key)
                    .compact();
            return compactJws;
        } catch (Exception e) {
            log.error("私钥加密token异常: {}", e);
        }
        return "";

    }

    /**
     * 公钥解析token
     * @param token
     * @param publicKey
     * @return
     * @throws Exception
     */
    private static Jws<Claims> decodeToken(String token, String publicKey) {
        try {
            Key key = RSAUtils.buildPublicKey(publicKey);
//            JwtParser parser = Jwts.parser();
//            JwtParser jwtParser = Jwts.parser().setSigningKey(key);
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return claimsJws;
        } catch (Exception e) {
            log.error("私钥加密token异常: {}", e);
        }
       return null;
    }

    /**
     * 获取token中的用户信息
     * @param token
     * @param publicKey
     * @return
     */
    public static JWTInfo parseToken(String token, String publicKey) {
        try {
            log.info("parseToken token:{}", token);
            Jws<Claims> claimsJws = decodeToken(token, publicKey);
            Claims body = claimsJws.getBody();
            return new JWTInfo(Long.valueOf(body.getSubject()), body.get(JWT_KEY_NAME).toString(), body.get(JWT_KEY_EMAIL).toString());
        } catch (Exception e) {
            log.error("获取token中的用户信息:{}", e);
        }
       return null;
    }

}
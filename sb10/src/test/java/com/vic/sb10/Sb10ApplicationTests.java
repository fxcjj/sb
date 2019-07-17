package com.vic.sb10;

import com.vic.sb10.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb10ApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void createJWT(){

        String jwt = JWTUtils.createJWT("1", "111", "admin", JWTUtils.DAY_TTL);
        System.out.println(jwt);
    }

    @Test
    public void parseJWT(){
        Claims claims = JWTUtils.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNTYxNjA0NzkwLCJzdWIiOiJhZG1pbiIsImlzcyI6IjExMSIsImV4cCI6MTU2MjIwOTU5MH0.wXCdn3Zdw0xIJsazHqRHz8eplV3oHCA0CnjnWRwjNj4");
        System.out.println(claims);
    }
}

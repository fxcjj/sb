package com.vic.sb03.controller;

import com.vic.sb03.conf.Shaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    Shaver shaver;

    @RequestMapping("/shaver")
    public String sha() {

        return shaver.getName() + ", " + shaver.getSize();
    }


    @RequestMapping("/req")
    public String test(HttpServletRequest request, HttpServletResponse response) {

//        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpServletResponse response1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

//        System.out.println(request.getParameter("name")); //king
//        System.out.println(request1.getParameter("name")); //king


        System.out.println(request.getRequestURI()); ///user/req
        System.out.println(request.getRequestURL()); //http://localhost:8099/user/req
        System.out.println(request.getContextPath()); //
        System.out.println(request.getQueryString()); //



        return shaver.getName() + ", " + shaver.getSize();
    }

}

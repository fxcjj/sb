package com.vic.sb07.controller;

import com.vic.sb07.vo.UserVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 * @author 罗利华
 * date: 2019/5/6 15:56
 */
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("addUser")
    public String addUser(@Validated({UserVo.Add.class}) UserVo userVo, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            for(FieldError fe : bindingResult.getFieldErrors()) {
                errorMsg.append(fe.getDefaultMessage());
                break;
            }

            //java8 for循环不能break
            /*bindingResult.getFieldErrors().forEach(error -> {
                errorMsg.append(error.getField()).append(error.getDefaultMessage()).append("\r\n");
                return;
            });*/
            return errorMsg.toString();
        }

        System.out.println("保存成功");
        return "ok";
    }

    @PostMapping("updateUser")
    public String updateUser(@Validated({UserVo.Update.class}) UserVo userVo, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            for(FieldError fe : bindingResult.getFieldErrors()) {
                errorMsg.append(fe.getDefaultMessage());
                break;
            }

            return errorMsg.toString();
        }

        System.out.println("保存成功");
        return "ok";
    }



}

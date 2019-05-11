package com.vic.sb07.controller;

import com.vic.sb07.vo.UserVo;
import lombok.ToString;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * 测试类
 * @author 罗利华
 * date: 2019/5/6 15:56
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("single")
    public String addUser(@NotEmpty(message = "姓名不能为空") String name, BindingResult bindingResult) {
        System.out.println(name);
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMsg.append(error.getField()).append(error.getDefaultMessage()).append("\r\n");
            });
            return errorMsg.toString();
        }
        return "omg";
    }


    /**
     * 添加用户
     * @param userVo
     * @param bindingResult
     * @return
     */
    @PostMapping("addUser")
    public String addUser(@RequestBody @Validated({UserVo.Add.class}) UserVo userVo, BindingResult bindingResult) {

        System.out.println(userVo);
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            /*for(FieldError fe : bindingResult.getFieldErrors()) {
                errorMsg.append(fe.getDefaultMessage());
                break;
            }*/

            //java8 for循环不能break
            bindingResult.getFieldErrors().forEach(error -> {
                errorMsg.append(error.getField()).append(error.getDefaultMessage()).append("\r\n");
            });
            return errorMsg.toString();
        }

        System.out.println("保存成功");
        return "ok";
    }

    /**
     * 更新用户
     * @param userVo
     * @param bindingResult
     * @return
     */
    @PostMapping("updateUser")
    public String updateUser(@RequestBody @Validated({UserVo.Update.class}) UserVo userVo, BindingResult bindingResult) {

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

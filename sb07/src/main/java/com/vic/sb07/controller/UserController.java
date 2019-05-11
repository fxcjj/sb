package com.vic.sb07.controller;

import com.vic.sb07.vo.UserVo;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 测试类
 * @author 罗利华
 * date: 2019/5/6 15:56
 */
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * name不能为空且长度在2~10之间
     * age允许为空（即不传参数名age），如果传递age，则必须大于3岁
     *
     * 校验失败会抛出 ConstraintViolationException，定义全局异常处理类（个人推荐）
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("single")
    public String addUser(@NotEmpty(message = "姓名不能为空") @Length(min = 2, max = 20, message = "姓名长度在2-10位之间") String name,
                          @Min(value = 3, message = "年龄必须大于3岁") String age) {
        System.out.println(name);
        System.out.println(age);
        return "omg";
    }

    /**
     * 添加用户
     * 不使用BindingResult
     *
     * 校验失败会抛出 MethodArgumentNotValidException，定义全局异常处理类（个人推荐）
     * @param userVo
     * @param bindingResult
     * @return
     */
    @PostMapping("addUser1")
    public String addUser1(@RequestBody @Validated({UserVo.Add.class}) UserVo userVo) {
        System.out.println(userVo);
        return "ok";
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

package com.vic.sb07.controller;

import com.vic.sb07.vo.UserVo;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author 罗利华
 * date: 2019/5/13 11:43
 */
@Validated
@RestController
@RequestMapping("ge")
public class GlobalExceptionHandlerController {

    /**
     * name不能为空且长度在2~10之间
     * age允许为空（即不传参数名age），如果传递age，则必须大于3岁
     *
     * 校验失败会抛出 ConstraintViolationException，定义全局异常处理类（个人推荐）
     * 单个参数校验必须配合在类上声明@Validated！！！！
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
     * @return
     */
    @PostMapping("addUser")
    public String addUser1(@RequestBody @Validated({UserVo.Add.class}) UserVo userVo) {
        System.out.println(userVo);
        return "ok";
    }

}

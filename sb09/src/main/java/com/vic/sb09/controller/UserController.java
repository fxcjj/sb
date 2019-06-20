package com.vic.sb09.controller;

import com.vic.sb09.vo.UserReq;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户
 */
@Api(tags = {"用户操作接口"}/*value = "用户API"*/, description = "这是用户API的描述")
@RestController
@RequestMapping("v1/users")
public class UserController {

    /**
     * 新增用户
     * @param userReq
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "根据UserVo对象创建对象")
    @PostMapping
    public String addUser(@Validated({UserReq.Add.class}) @RequestBody UserReq userReq) {
        System.out.println(userReq);
        return "ok";
    }

    /**
     * 更新用户
     * @param userReq
     * @return
     */
    @ApiOperation(value = "更新用户", notes = "根据UserReq对象更新对象")
    @PutMapping
    public String updateUser(@Validated({UserReq.Update.class}) @RequestBody UserReq userReq) {
        System.out.println(userReq);
        return "ok";
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID查询用户"/*, notes = "根据UserReq对象更新对象"*/)
    @ApiImplicitParam(name = "id", value = "用户ID的值", dataType = "Long", required = true) //描述单个方法参数
    @GetMapping("/{id}")
    public String queryById(@PathVariable("id") Long id) {
        System.out.println(id);
        return "ok";
    }

    /**
     * 根据手机号和姓名查询用户
     * @param phone
     * @param name
     * @return
     */
    @ApiOperation(value = "根据手机号和姓名查询用户"/*, notes = "根据UserReq对象更新对象"*/)
    //描述多个方法参数
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", required = true),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", required = true)
    })
    @GetMapping("queryByPhoneAndName")
    public String queryByPhoneAndName(String phone, String name) {
        System.out.println("phone=" + phone + ", name=" + name);
        return "ok";
    }

    /**
     * ApiParam 表示参数放在body部分
     *
     * 下面这行ApiParam和RequestParam不应该同时出现在一行！推荐使用ApiImplicitParams
     * @ApiParam(name = "phone", value = "手机号", required = true) @RequestParam
     *
     * @param phone
     * @param name
     * @return
     */
    @ApiOperation(value = "根据手机号和姓名查询用户"/*, notes = "根据UserReq对象更新对象"*/)
    @GetMapping("queryByPhoneAndName1")
    public String queryByPhoneAndName1(
            @ApiParam(name = "phone", value = "手机号", required = true) @RequestParam String phone,
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam String name) {
        System.out.println("phone=" + phone + ", name=" + name);
        return "ok";
    }

    /**
     * 使用该注解忽略这个API
     * @return
     */
    @ApiIgnore
    @GetMapping("hi")
    public String jsonTest() {
        return "impossible!";
    }


}

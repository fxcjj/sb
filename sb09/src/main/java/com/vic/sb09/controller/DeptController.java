package com.vic.sb09.controller;

import com.vic.sb09.vo.DeptReq;
import com.vic.sb09.vo.UserReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 部门
 */
@Api(value = "部门API", description = "这是部门API的描述")
@RestController
@RequestMapping("v1/depts")
public class DeptController {

    /**
     * 新增部门
     * @param deptReq
     * @return
     */
    @ApiOperation(value = "新增部门", notes = "根据DeptReq对象创建对象")
    @PostMapping
    public String addDept(@Validated @RequestBody DeptReq deptReq) {
        System.out.println(deptReq);
        return "ok";
    }

}

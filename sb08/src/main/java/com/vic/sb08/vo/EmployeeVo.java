package com.vic.sb08.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 罗利华
 * date: 2021/2/28 16:33
 */
@Data
public class EmployeeVo implements Serializable {

    String deptCode;
    String deptName;

    String code;
    String name;

    public EmployeeVo(String deptCode, String deptName, String code, String name) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.code = code;
        this.name = name;
    }
}

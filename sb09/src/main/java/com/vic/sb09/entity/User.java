package com.vic.sb09.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author Victor
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 7746297563607997685L;

	// id
	private Integer id;
	// 姓名
	private String name;
	// 年龄
	private Integer age;
	// 出生日期
	private Date birthday;
	// 地址
	private String address;
	// 删除 1正常 2删除
	private Integer deleteFlag;

}

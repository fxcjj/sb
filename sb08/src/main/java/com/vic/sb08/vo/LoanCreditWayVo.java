package com.vic.sb08.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证方式表VO
 * @since jdk1.8
 */
@Data
public class LoanCreditWayVo implements Serializable {

     private Long id;


     private Date gmtCreated;


     private Date gmtModified;


     private Long createBy;


     private Long updateBy;


     private Byte dflag;


     private Integer code;


     private String name;


     private Integer status;

}
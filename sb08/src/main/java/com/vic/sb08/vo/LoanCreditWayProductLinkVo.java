package com.vic.sb08.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品与认证方式关联表VO
 * @since jdk1.8
 */
@Data
public class LoanCreditWayProductLinkVo implements Serializable {

     private Long id;


     private Date gmtCreated;


     private Date gmtModified;


     private Long createBy;


     private Long updateBy;


     private Byte dflag;


     private Long productId;

     private Long creditWayLinkId;

     private Integer status;

     private Byte optionType;

}
package com.vic.sb08.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证方式和认证三方关联表VO
 * @since jdk1.8
 */
@Data
@ToString
public class LoanCreditWayThirdLinkVo implements Serializable {

     private Long id;


     private Date gmtCreated;


     private Date gmtModified;


     private Long createBy;


     private Long updateBy;


     private Byte dflag;


     private Long thirdId;


     private String thirdName;


     private Long creditWayId;

     private String creditWayName;

     private Integer status;

     public LoanCreditWayThirdLinkVo(Long id, Long thirdId, String thirdName, Long creditWayId, String creditWayName, Integer status) {
          this.id = id;
          this.thirdId = thirdId;
          this.thirdName = thirdName;
          this.creditWayId = creditWayId;
          this.creditWayName = creditWayName;
          this.status = status;
     }
}
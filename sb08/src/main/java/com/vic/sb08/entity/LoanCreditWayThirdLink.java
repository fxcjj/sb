package com.vic.sb08.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 认证方式和认证三方关联表实体类
 * @since jdk1.8
 */
@Data
@Entity
@Table(name = "loan_credit_way_third_link")
@DynamicUpdate
public class LoanCreditWayThirdLink implements Serializable {
    /**
     *主键
     */
    @Id//主键标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
     @Column(name = "id")
     private Long id ;

    /**
     *建立时间
     */
     @Column(name = "gmt_created")
     private Date gmtCreated ;

    /**
     *修改时间
     */
     @Column(name = "gmt_modified")
     private Date gmtModified ;

    /**
     *创建者ID
     */
     @Column(name = "create_by")
     private Long createBy ;

    /**
     *更新者ID
     */
     @Column(name = "update_by")
     private Long updateBy ;

    /**
     *是否有效（1：有效 0：无效）
     */
     @Column(name = "dflag")
     private Byte dflag ;

    /**
     *三方id
     */
     @Column(name = "third_id")
     private Long thirdId ;

    /**
     *认证方式id
     */
     @Column(name = "credit_way_id")
     private Long creditWayId ;

    /**
     *1启用 2禁用
     */
     @Column(name = "status")
     private Integer status ;

}
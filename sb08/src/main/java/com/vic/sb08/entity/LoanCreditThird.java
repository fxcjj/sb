package com.vic.sb08.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 认证三方表实体类
 * @since jdk1.8
 */
@Data
@Entity
@Table(name = "loan_credit_third")
@DynamicUpdate
public class LoanCreditThird implements Serializable {
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
     *标识 1:商汤 2:腾讯云 3:融360 4:魔方 5:公信宝
     */
     @Column(name = "code")
     private Integer code ;

    /**
     *对接三方名称，如：商汤、公信宝
     */
     @Column(name = "name")
     private String name ;

    /**
     *1启用 2禁用
     */
     @Column(name = "status")
     private Integer status ;

}
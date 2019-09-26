package com.vic.sb08.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 认证方式表实体类
 * @since jdk1.8
 */
@Data
@Entity
@Table(name = "loan_credit_way")
public class LoanCreditWay implements Serializable {
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
     *标识 1:运营商 2:个人信息 3:身份认证 4:芝麻信用 5:社保 6:公积金 7:邮箱 8:淘宝 9:京东 10:单位信息  11:用款确认 12:支付宝 13:滴滴 14:美团 15:学生
     */
     @Column(name = "code")
     private Integer code ;

    /**
     *名称，如：运营商、身份认证
     */
     @Column(name = "name")
     private String name ;

    /**
     *1启用 2禁用
     */
     @Column(name = "status")
     private Integer status ;

}
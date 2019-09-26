package com.vic.sb08.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品与认证方式关联表实体类
 * @since jdk1.8
 */
@Data
@Entity
@Table(name = "loan_credit_way_product_link")
public class LoanCreditWayProductLink implements Serializable {
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
     *产品id
     */
     @Column(name = "product_id")
     private Long productId ;

    /**
     *认证方式与三方关联id
     */
     @Column(name = "credit_way_link_id")
     private Long creditWayLinkId ;

    /**
     *1启用 2禁用
     */
     @Column(name = "status")
     private Integer status ;

    /**
     *选项类型 1必选 2可选
     */
     @Column(name = "option_type")
     private Byte optionType ;

}
package com.vic.sb24.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Victor
 * date: 2019/5/13 19:06
 */
@Data
@Entity
@Table(name = "v_goods")
@DynamicUpdate
@ToString
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 状态 1启用 0 停用
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 版本号
     */
    @Column(name = "version")
    private Long version = 1L;

}

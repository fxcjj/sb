package com.vic.sb38.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity extends IdEntity {

    @Column(name = "create_by")
    Long createBy;

    @Column(name = "create_time")
    Date createTime;

    @Column(name = "update_by")
    Long updateBy;

    @Column(name = "update_time")
    Date updateTime;

    @Column(name = "delete_flag")
    Integer deleteFlag;


}

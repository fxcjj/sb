package com.vic.sb47.entity;

import lombok.Data;

import java.util.Date;

/**
 * 秒杀商品
 */
@Data
public class Seckill {
    // 商品id
    private Long seckillId;
    // 商品名称
    private String name;
    // 库存
    private Long inventory;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    private Date createTime;
    // 版本号，用于实现乐观锁
    private Long version;

}

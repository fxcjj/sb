package com.vic.sb47.entity;

import lombok.Data;

import java.util.Date;

/**
 * 秒杀订单
 */
@Data
public class SeckillOrder {
    private Long id;
    private Long seckillId;
    private String userPhone;

    /**
     * 状态 -1:无效 0:成功 1:已付款 2:已发货
     */
    private Integer status;
    private Date createTime;
}

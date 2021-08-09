package com.vic.sb47.service;

import com.vic.sb47.entity.SeckillOrder;
import com.vic.sb47.mapper.SeckillOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillOrderService {

    @Autowired
    SeckillOrderMapper seckillOrderMapper;

    // 生成秒杀订单
    public int insertOrder(SeckillOrder order) {
        return seckillOrderMapper.insertOrder(order);
    }

}

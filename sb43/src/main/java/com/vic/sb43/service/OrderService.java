package com.vic.sb43.service;

import com.alibaba.fastjson.JSON;
import com.vic.sb43.consts.DBConsts;
import com.vic.sb43.dao.orders.OrderMapper;
import com.vic.sb43.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Transactional
    public void add(Order order) {
        // 试探性读一下，id为null
        Order order1 = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order1));

        // 插入订单
        orderMapper.insertAndGetId1(order);
        System.out.println(JSON.toJSONString(order));
    }
}

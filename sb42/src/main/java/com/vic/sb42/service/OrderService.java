package com.vic.sb42.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.vic.sb42.consts.DBConsts;
import com.vic.sb42.dao.orders.OrderMapper;
import com.vic.sb42.dao.uesrs.UserMapper;
import com.vic.sb42.entity.Order;
import com.vic.sb42.entity.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Transactional
    @DS(DBConsts.DATASOURCE_ORDER_MASTER)
    public void add(Order order) {
        // 试探性读一下，id为null
        Order order1 = orderMapper.findById0(1L);
        System.out.println(JSON.toJSONString(order1));

        // 插入订单
        orderMapper.insertAndGetId1(order);
        System.out.println(JSON.toJSONString(order));
    }
}

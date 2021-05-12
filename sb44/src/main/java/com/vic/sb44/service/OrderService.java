package com.vic.sb44.service;

import com.alibaba.fastjson.JSON;
import com.vic.sb44.dao.orders.OrderMapper;
import com.vic.sb44.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Transactional
    public void add(Order order) {
        // 试探性读一下，读取从库
        Order order1 = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order1));

        // 插入订单，主库
        // 读写分离约定：同一线程且同一数据库连接内，如有写入操作，以后的读操作均从主库读取，用于保证数据一致性
        orderMapper.insertAndGetId1(order);
        System.out.println(JSON.toJSONString(order));

        // 试探性读一下，读取主库
        Order order2 = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order2));
    }

    /**
     * 读取从库
     * @param id
     * @return
     */
    public Order findById(Long id) {
        return orderMapper.findById(id);
    }
}

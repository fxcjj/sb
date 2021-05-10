package com.vic.sb41.service;

import com.vic.sb41.dao.orders.OrderMapper;
import com.vic.sb41.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public Order findById(Long id){
        return orderMapper.findById(id);
    }
}

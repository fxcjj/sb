package com.vic.sb44.dao.orders;

import com.vic.sb44.entity.Order;

public interface OrderMapper {

    Order findById(Long id);

    int insertAndGetId1(Order order);
}
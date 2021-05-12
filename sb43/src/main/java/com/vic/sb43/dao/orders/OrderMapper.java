package com.vic.sb43.dao.orders;

import com.vic.sb43.entity.Order;

public interface OrderMapper {

    Order findById(Long id);

    int insertAndGetId1(Order order);
}
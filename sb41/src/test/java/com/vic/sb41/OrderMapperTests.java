package com.vic.sb41;

import com.vic.sb41.dao.orders.OrderMapper;
import com.vic.sb41.entity.Order;
import com.vic.sb41.entity.User;
import com.vic.sb41.service.OrderService;
import com.vic.sb41.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTests {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void testFindOrderById() {
        Order order = orderMapper.findById(1L);
        System.out.println(order.getName());
    }

}
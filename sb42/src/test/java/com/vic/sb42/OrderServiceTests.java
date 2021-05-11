package com.vic.sb42;

import com.vic.sb42.entity.Order;
import com.vic.sb42.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {

    @Autowired
    OrderService orderService;

    @Test
    public void testAdd() {
        Order order = new Order();
        order.setName("key");
        order.setUserId(5L);
        orderService.add(order);
    }

}
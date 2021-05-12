package com.vic.sb44;

import com.alibaba.fastjson.JSON;
import com.vic.sb44.entity.Order;
import com.vic.sb44.service.OrderService;
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
        order.setName("paper");
        order.setUserId(9L);
        orderService.add(order);
    }


    @Test
    public void testFindById() {
        Order order = orderService.findById(1L);
        System.out.println(JSON.toJSONString(order));
    }



}
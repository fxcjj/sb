package com.vic.sb42;

import com.alibaba.fastjson.JSON;
import com.vic.sb42.dao.orders.OrderMapper;
import com.vic.sb42.entity.Order;
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
    public void testFindById() {
        for(int i = 0; i < 5; i++) {
            Order order0 = orderMapper.findById0(1L);
            System.out.println(JSON.toJSONString(order0));
        }
//        Order order1 = orderMapper.findById1(1L);
//        System.out.println(JSON.toJSONString(order1));
//
//        Order order2 = orderMapper.findById2(1L);
//        System.out.println(JSON.toJSONString(order2));

    }

    @Test
    public void testInsert() {
        Order order = new Order();
        order.setName("computer");
        order.setUserId(333L);
        int i = orderMapper.insertAndGetId1(order);
        System.out.println(i);
    }


}
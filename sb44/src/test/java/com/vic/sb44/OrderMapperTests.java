package com.vic.sb44;

import com.alibaba.fastjson.JSON;
import com.vic.sb44.dao.orders.OrderMapper;
import com.vic.sb44.entity.Order;
import org.apache.shardingsphere.api.hint.HintManager;
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

    /**
     * 测试从库的负载均衡，结果正常
     */
    @Test
    public void testFindById() {
        for(int i = 0; i < 5; i++) {
            Order order = orderMapper.findById(1L);
            System.out.println(JSON.toJSONString(order));
        }
    }

    /**
     * 测试强制访问主库
     */
    @Test
    public void testSelectById02() {
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            Order order = orderMapper.findById(1L);
            System.out.println(JSON.toJSONString(order));
        }
    }


    @Test
    public void testInsert() {
        Order order = new Order();
        order.setName("milk");
        order.setUserId(33L);
        int i = orderMapper.insertAndGetId1(order);
        System.out.println(i);
    }


}
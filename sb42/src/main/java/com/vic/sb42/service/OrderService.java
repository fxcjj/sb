package com.vic.sb42.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.vic.sb42.component.SpringUtil;
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

    @Autowired
    UserMapper userMapper;

    public OrderService self() {
        /*
        使用下面获取代理对象，报错如下
        java.lang.IllegalStateException: Cannot find current proxy: Set 'exposeProxy' property
        on Advised to 'true' to make it available, and ensure that AopContext.currentProxy()
        is invoked in the same thread as the AOP invocation context.

        解决方案：
        在启动类上添加 @EnableAspectJAutoProxy(exposeProxy = true)
         */
        return (OrderService) AopContext.currentProxy();

        // 返回代理对象
//        return SpringUtil.getBean(this.getClass());

        // 返回真实对象
//        return this;
    }

    public Order findById(Long id){
        return orderMapper.findById(id);
    }

    /**
     * 没有加 @Transactional 注解，正常
     */
    public void method01() {
        Order order = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order));

        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }


    /**
     * 添加了 @Transactional 注解，获取代理对象，创建事务，获取数据源，这里取的是默认数据源users
     */
    @Transactional
    public void method02() {
        /**
         * 这里报错: java.sql.SQLSyntaxErrorException: Table 'sb41_user.t_order' doesn't exist
         */
        Order order = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order));

        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }

    /**
     * 与 method02 方法同理.
     * 如果 self() 换成this的话，this不是代理对象，
     * method031和method032方法上的 @Transactional直接没有作用，Spring事务根本没有生效。
     * 所以，最终结果和method01是等价的。
     */
    public void method03() {
        // 查询订单
        self().method031();
        // 查询用户
        self().method032();
    }

    /**
     * java.sql.SQLSyntaxErrorException: Table 'sb41_user.t_order' doesn't exist
     */
    @Transactional // 报错，因为此时获取的是 primary 对应的 DataSource ，即 users 。
    public void method031() {
        Order order = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order));
    }

    @Transactional
    public void method032() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }

    /**
     * 会取方法上的DS对应的Connection
     */
    public void method04() {
        // 查询订单
        self().method041();
        // 查询用户
        self().method042();
    }

    /**
     * 这里的 @DS 起作用了，但是orderMapper上的 @DS 就不起作用了
     */
    @Transactional
    @DS(DBConsts.DATASOURCE_ORDERS)
    public void method041() {
        Order order = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order));
    }

    @Transactional
    @DS(DBConsts.DATASOURCE_USERS)
    public void method042() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }


    /**
     * 创建事务
     */
    @Transactional
    @DS(DBConsts.DATASOURCE_ORDERS)
    public void method05() {
        // 查询订单
        Order order = orderMapper.findById(1L);
        System.out.println(JSON.toJSONString(order));
        // 查询用户
        self().method052();
    }

    /**
     * 如果存在一个事务，挂起当前事务，重新创建一个事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DS(DBConsts.DATASOURCE_USERS)
    public void method052() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }
}

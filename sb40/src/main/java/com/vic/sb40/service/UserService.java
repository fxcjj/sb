package com.vic.sb40.service;

import com.alibaba.fastjson.JSON;
import com.vic.sb40.dao.master.UserMapper;
import com.vic.sb40.dao.slave1.StudentMapper;
import com.vic.sb40.entity.Student;
import com.vic.sb40.entity.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    StudentMapper studentMapper;

    public User findById(Long id){
        return userMapper.findById(id);
    }

    public UserService self() {
        /*
        使用下面获取代理对象，报错如下
        java.lang.IllegalStateException: Cannot find current proxy: Set 'exposeProxy' property
        on Advised to 'true' to make it available, and ensure that AopContext.currentProxy()
        is invoked in the same thread as the AOP invocation context.
        解决方案：
        在启动类上添加 @EnableAspectJAutoProxy(exposeProxy = true)
         */
        return (UserService) AopContext.currentProxy();

        // 返回代理对象
//        return SpringUtil.getBean(this.getClass());

        // 返回真实对象
//        return this;
    }


    /**
     * 没有加 @Transactional 注解，正常
     */
    public void method01() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));

        Student student = studentMapper.findById(1L);
        System.out.println(JSON.toJSONString(student));
    }

    /**
     * 加 @Transactional 注解，报错
     */
    @Transactional
    public void method02() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));

        Student student = studentMapper.findById(1L);
        System.out.println(JSON.toJSONString(student));
    }

    public void method03() {
        // 查询订单
        self().method031();
        // 查询用户
        self().method032();
    }

    @Transactional
    public void method031() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }

    @Transactional
    public void method032() {
        Student student = studentMapper.findById(1L);
        System.out.println(JSON.toJSONString(student));
    }

    @Transactional //(transactionManager = DBConstants.TX_MANAGER_ORDERS)
    public void method05() {
        // 查询
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
        // 查询
        self().method052();
    }

    @Transactional
            (
//                    transactionManager = DBConstants.TX_MANAGER_USERS,
                    propagation = Propagation.REQUIRES_NEW
            )
    public void method052() {
        Student student = studentMapper.findById(1L);
        System.out.println(JSON.toJSONString(student));
    }
}

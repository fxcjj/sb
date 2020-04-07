package com.vic.sb24.service;

import com.vic.sb24.entity.User;
import com.vic.sb24.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Victor
 * date: 2020/4/3 11:29
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    /**
     * 插入或更新
     * @param user
     * @throws InterruptedException
     */
    public void insertOrUpdate(User user) throws InterruptedException {

        user.setGmtCreated(new Date());
        user.setGmtModified(new Date());

        User dbUser = userRepository.findByPhone(user.getPhone());
        // 多个线程未查询到dbUser，都到这里了，就会出现插入多条相同记录
//        Thread.sleep(100);
        if(dbUser == null) {
            dbUser = new User();
            dbUser.setGmtCreated(new Date());
            dbUser.setGmtModified(new Date());
        }
        user.setId(dbUser.getId());
        BeanUtils.copyProperties(user, dbUser);
        userRepository.save(dbUser);
    }

    /**
     * 直接插入
     * @param user
     * @throws InterruptedException
     */
    public User save(User user) {
        user.setGmtCreated(new Date());
        user.setGmtModified(new Date());
        try {
            // 这里如果插入违反唯一索引，会抛出异常，不会插入数据，但主键会出现跳跃,主键取auto_increment当前值
            userRepository.save(user);
        } catch (Exception e) {
            // 异常处理
            // 1 打印消息
            /*
            output:
            error msg: could not execute statement; SQL [n/a]; constraint [idx_phone]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
             */
//            System.out.println("error msg: " + e.getMessage());

            // 2 jpa要匹配 DataIntegrityViolationException
            if(e instanceof DataIntegrityViolationException) {
                log.warn("用户手机号已存在:{}", user.getPhone());
                return userRepository.findByPhone(user.getPhone());
            }

            // 3 匹配ConstraintViolationException异常不行
            /**
             * 条件返回false
             * 不能使用这个
             */
            if(e instanceof ConstraintViolationException) {

            }
        }
        return null;
    }

    /**
     * 先查询，存在返回，不存在插入
     * 第1次试验
     * 500并发,出现7次
     * 1000并发,出现1次
     * 2000并发,出现4次
     * 3000并发,出现7次
     * 4000并发,出现2次
     *
     * 第2次试验
     * 500并发,出现0次
     * 1000并发,出现2次
     * 2000并发,出现1次
     * 3000并发,出现4次
     * 4000并发,出现3次
     * 5000并发,出现2次
     * 6000并发,出现3次
     * 7000并发,出现3次
     * 8000并发,出现1次
     * 9000并发,出现3次
     * 10000并发,出现2次
     * @param user
     */
    public User save1(User user) {
        user.setGmtCreated(new Date());
        user.setGmtModified(new Date());
        // 查询是否已存在
        User dbUser = userRepository.findByPhone(user.getPhone());
        // 已存在，则返回
        if(dbUser != null) {
            return dbUser;
        }
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) { // 这种写法和save方法一样
            log.warn("用户手机号已存在, phone:{}", user.getPhone());
            return userRepository.findByPhone(user.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

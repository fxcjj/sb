package com.vic.sb41.service;

import com.vic.sb41.dao.uesrs.UserMapper;
import com.vic.sb41.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findById(Long id){
        return userMapper.findById(id);
    }
}

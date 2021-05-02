package com.vic.sb37.service;

import com.vic.sb37.entity.User;
import com.vic.sb37.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findById(Integer id){
        return userMapper.findById(id);
    }
}

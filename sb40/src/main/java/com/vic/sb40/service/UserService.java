package com.vic.sb40.service;

import com.vic.sb40.dao.master.UserMapper;
import com.vic.sb40.entity.User;
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

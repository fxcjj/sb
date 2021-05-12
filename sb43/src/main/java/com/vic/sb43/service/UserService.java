package com.vic.sb43.service;

import com.vic.sb43.dao.uesrs.UserMapper;
import com.vic.sb43.entity.User;
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

package com.vic.sb42.service;

import com.vic.sb42.dao.uesrs.UserMapper;
import com.vic.sb42.entity.User;
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

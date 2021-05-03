package com.vic.sb39.service;

import com.vic.sb39.entity.User;
import com.vic.sb39.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> findAll(){
        List<User> users = userMapper.selectAll();
        return users;
    }
}

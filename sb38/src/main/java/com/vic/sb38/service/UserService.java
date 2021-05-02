package com.vic.sb38.service;

import com.vic.sb38.entity.User;
import com.vic.sb38.mapper.UserMapper;
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

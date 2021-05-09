package com.vic.sb39.service;

import com.vic.sb39.bo.UserBo;
import com.vic.sb39.entity.User;
import com.vic.sb39.mapper.UserMapper;
import com.vic.sb39.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements BasePageService<UserBo, UserVo> {

    @Autowired
    UserMapper userMapper;

    public User findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserVo> list(UserBo userBo){
        List<User> users = userMapper.selectAll();
        if(CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }
        return users.stream().map(e -> {
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}

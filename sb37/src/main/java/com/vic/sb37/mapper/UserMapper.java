package com.vic.sb37.mapper;

import com.vic.sb37.entity.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserMapper {
    User findById(Integer id);
}
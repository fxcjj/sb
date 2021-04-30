package com.vic.sb35.mapper;

import com.vic.sb35.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findById(Integer id);
}
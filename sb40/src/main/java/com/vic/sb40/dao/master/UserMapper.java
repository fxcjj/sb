package com.vic.sb40.dao.master;

import com.vic.sb40.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {
    User findById(Long id);
}

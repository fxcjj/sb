package com.vic.sb42.dao.uesrs;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vic.sb42.consts.DBConsts;
import com.vic.sb42.entity.User;

//@DS(DBConsts.DATASOURCE_USER_MASTER)
public interface UserMapper {
    User findById(Long id);
}

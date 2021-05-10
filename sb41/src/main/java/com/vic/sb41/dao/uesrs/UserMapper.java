package com.vic.sb41.dao.uesrs;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vic.sb41.consts.DBConsts;
import com.vic.sb41.entity.User;

@DS(DBConsts.DATASOURCE_USERS)
public interface UserMapper {
    User findById(Long id);
}

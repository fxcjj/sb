package com.vic.sb09.dao;

import com.vic.sb09.entity.User;

/**
 * @author 罗利华
 * date: 2019/5/14 12:06
 */
public interface UserDao {

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    User queryById(int id);

}

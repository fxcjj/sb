package com.vic.sb11.service;

import com.vic.sb11.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 罗利华
 * date: 2019/6/27 19:55
 */
@Service
public class UserService {

    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1L, "u1", "e1", "p1", "role1"));
        userList.add(new User(2L, "u2", "e2", "p2", "role2"));
        userList.add(new User(3L, "u3", "e3", "p3", "role3"));
    }

    /**
     * 通过用户和密码查询
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password) {

        for(User ele : userList) {
            if(ele.getUsername().equals(username) && ele.getPassword().equals(password)) {
                return ele;
            }
        }
        return null;

    }

}

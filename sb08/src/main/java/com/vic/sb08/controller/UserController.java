package com.vic.sb08.controller;

import com.vic.sb08.entity.User;
import com.vic.sb08.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 罗利华
 * date: 2019/5/6 15:56
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("saveUser")
    public String saveUser(/*@RequestBody User user*/){

        for(int i = 0; i < 30; i++) {
            User u = new User();
            u.setGmtCreate(new Date());
            u.setGmtModified(new Date());
            u.setName("name"+i);
            u.setPassword("p"+i);
            u.setStatus("1");
            u.setPhone("phone"+i);
            int random = new Random().nextInt(20);
            if(random < 26)
                u.setUserType(1);
            else
                u.setUserType(2);
            userRepository.save(u);
        }
        return "ok";
    }

    @GetMapping("findByName")
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }

    @GetMapping("findByNameLike")
    public List<User> findByNameLike(String name){
        return userRepository.findByNameLike(name);
    }

    @GetMapping("findByPage")
    public Page<User> findByPage(Integer userType){
        return userRepository.findByUserType(userType, new PageRequest(1, 5));
    }

}

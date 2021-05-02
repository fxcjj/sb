package com.vic.sb38;

import com.alibaba.fastjson.JSON;
import com.vic.sb38.entity.User;
import com.vic.sb38.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Sb38ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testFindById() {
        User conUser = new User();
        conUser.setId(1L);

        /**
         * 使用 selectByPrimaryKey 方法，实体类（或者说PO/Entity类）中的主键属性上必须加 @Id 注解。
         * 传参可以使用User对象或主键属性类型，这里即 conUser 或者 1L
         */
        User user = userMapper.selectByPrimaryKey(conUser);
        System.out.println(user.getName());
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(JSON.toJSONString(users));
    }

    @Test
    public void testInsert() {
        User u = new User();
        u.setName("martin");
        u.setAge(29);
        int insert = userMapper.insert(u);
        System.out.println(insert);
    }

}

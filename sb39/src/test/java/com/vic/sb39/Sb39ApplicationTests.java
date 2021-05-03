package com.vic.sb39;

import com.alibaba.fastjson.JSON;
import com.vic.sb39.entity.User;
import com.vic.sb39.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Sb39ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @org.junit.Test
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

    @org.junit.Test
    public void testFindAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(JSON.toJSONString(users));
    }

    @org.junit.Test
    public void testInsert() {
        User u = new User();
        u.setName("martin");
        u.setAge(29);
        int insert = userMapper.insert(u);
        System.out.println(insert);
    }

    /**
     * 分页查询
     */
    @org.junit.Test
    public void testSelectByRowBounds() {
        User u = new User();
//        u.setName("martin");
        u.setAge(18);

        RowBounds rowBounds = new RowBounds(1, 10);
        List<User> users = userMapper.selectByRowBounds(u, rowBounds);

        System.out.println(JSON.toJSONString(users));
    }

    /**
     * 分页查询
     */
    @Test
    public void testSelectByExampleAndRowBounds() {

        // 查询条件
        Example example = new Example(User.class);

        // 排序
        example.orderBy("age").desc();

        // 过滤条件
        example.createCriteria()
                .andGreaterThan("age", 20);

        // 分页
        RowBounds rowBounds = new RowBounds(0, 5);
        List<User> users = userMapper.selectByExampleAndRowBounds(example, rowBounds);

        System.out.println(JSON.toJSONString(users));
    }

}
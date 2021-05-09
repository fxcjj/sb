package com.vic.sb39;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vic.sb39.bo.PageBo;
import com.vic.sb39.bo.UserBo;
import com.vic.sb39.entity.User;
import com.vic.sb39.mapper.UserMapper;
import com.vic.sb39.service.UserService;
import com.vic.sb39.vo.UserVo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Sb39ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

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
    @Test
    public void testPage() {

        PageBo pageBo = new PageBo();
        pageBo.setPageNum(1);
        pageBo.setPageSize(3);

        UserBo userBo = new UserBo();
//        userBo.setName("martin");
        userBo.setAge(18);

        pageBo.setParam(userBo);

        // 设置分页参数
        PageInfo<UserVo> pageInfo = userService.page(pageBo);
        System.out.println(JSON.toJSONString(pageInfo));
    }

}
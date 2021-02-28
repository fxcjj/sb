package com.vic.sb08;

import com.vic.sb08.entity.User;
import com.vic.sb08.repository.UserRepository;
import com.vic.sb08.vo.SimpleUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb08ApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testExist() {
        Boolean aBoolean = userRepository.existsByPhoneEquals("12361188181B");
        System.out.println(aBoolean);


        boolean b = userRepository.existsByPhone("12361188181c");
        System.out.println(b);



    }


    @Test
    public void testFirst() {
        User martin = userRepository.findFirstByNameAndPasswordOrderByGmtCreatedAsc("martin", "123");
        System.out.println(martin);

        User martin1 = userRepository.findFirstByNameAndPasswordOrderByGmtCreatedDesc("martin", "123");
        System.out.println(martin1);
    }

    @Test
    public void testCustomeVo() {
        SimpleUserVo vo = userRepository.testCustomeVo(1L);
        System.out.println(vo);
    }

    //转换实体类
    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) throws Exception {
        List<T> returnList = new ArrayList<>();
        if(CollectionUtils.isEmpty(list)){
            return returnList;
        }
        Object[] co = list.get(0);
        Class[] c2 = new Class[co.length];
        //确定构造方法
        for (int i = 0; i < co.length; i++) {
            if(co[i]!=null){
                c2[i] = co[i].getClass();
            }else {
                c2[i]=String.class;
            }
        }
        for (Object[] o : list) {
            Constructor<T> constructor = clazz.getConstructor(c2);
            returnList.add(constructor.newInstance(o));
        }
        return returnList;
    }

    @Test
    public void testUseEntity() {
        List<User> list = userRepository.testUseEntity(1);
        list.forEach(ele -> {
            System.out.println(ele);
        });
    }

    @Test
    public void testInb() {
        String name = "cc";
        String status = "1";
        List<Integer> userTypes = new ArrayList<>();
        userTypes.add(1);
        userTypes.add(2);
        List<User> list = userRepository.testInb(name, status, userTypes);
        list.forEach(ele -> {
            System.out.println(ele);
        });
    }

    /**
     * ok
     */
    @Test
    public void testIna() {
        String name = "cc";
        String status = "1";
        List<Integer> userTypes = new ArrayList<>();
        userTypes.add(1);
        userTypes.add(2);
        List<User> list = userRepository.findByNameAndStatusAndUserTypeIn(name, status, userTypes);
        list.forEach(ele -> {
            System.out.println(ele);
        });
    }

    @Test
    public void testSort() {
        List<User> list = userRepository.findByUserType(1, new Sort(Sort.Direction.DESC, "gmtCreate"));
        list.forEach(ele -> {
            System.out.println(ele.getName());
        });
    }

    @Test
    public void testNotEqualsAndIsNull() {
        List<User> users = userRepository.testNotEqualsAndIsNull((byte)3);
        System.out.println(users.size());
    }

    @Test
    public void testNotEquals() {
        List<User> users = userRepository.testNotEquals((byte)3);
        System.out.println(users.size());
    }

    @Test
    public void testParamNullc() {
        List<User> users = userRepository.testParamNullc((byte)3);
        System.out.println(users.size());
    }

    @Test
    public void testParamNullb() {
        List<User> users = userRepository.testParamNullb(null);
        System.out.println(users.size());
    }

    @Test
    public void testParamNulla() {
        List<User> users = userRepository.testParamNulla((byte)3);
        System.out.println(users.size());
    }

    /**
     * 1. 实体类上未加@DynamicUpdate注解
     * User user = userRepository.findOne(x)
     * user.setName("xxx");
     * userRepository.save(user);
     *
     * sql打印如下：
     * update v_user set gmt_create=?, gmt_modified=?, name=?, password=?, phone=?, status=?, user_type=? where id=?
     *
     * 2. 实体类上加@DynamicUpdate注解
     * User user = userRepository.findOne(x)
     * user.setName("xxx");
     * userRepository.save(user);
     *
     * sql打印如下：
     * update v_user set password=? where id=?
     */

    @Test
    public void testUpdate2() {
        String phone = "13611884695";
        User u = userRepository.findByPhone(phone);
        if(u == null) {
            u = new User();
        }
        u.setPassword("p1");
        u.setPhone("13611884695");
        u.setStatus(7);
        u.setName("satan111");
        u.setUserType(9);
        u.setGmtCreated(new Date());
        u.setGmtModified(new Date());
        userRepository.save(u);

    }

    /**
     * 查出实体后，显式地设置属性为null
     * 则会执行更新将对应字段置为null。
     * 如：
     * user.setName(null);
     *
     */
    @Test
    public void testUpdate1() {
        Optional<User> optional = userRepository.findById(2L);
        User user = optional.get();
        user.setName("beverly");
        user.setPhone("13611884691");
        user.setStatus(1);
        user.setPassword(null);
        userRepository.save(user);
    }

    @Test
    public void testFindByName() {
        String name = "张三";
        List<User> list = userRepository.findByName(name);
        list.forEach(ele -> System.out.println(ele));
    }


    @Test
    public void testInsert1() {
        User u = new User();
        u.setName("victor");
        u.setPassword("123");
        u.setPhone("123611881818");
        u.setStatus(1);
        u.setUserType(1);
        u.setGmtCreated(new Date());
        userRepository.save(u);
    }

    @Test
    public void testInsert() {
        /**
         * 当前编码为uft-8
         */
        String name = "张三";
//        System.out.println(name.length()); //2
//        System.out.println(name.getBytes().length); //6

        User u = new User();
        /**
         * 指的是字符长度，而非字节数
         * `name` varchar(20) DEFAULT NULL COMMENT '名称',
         * 以下报错（Data too long for column 'name' at row 1）
         * 123456789012345678901
         * 一二三四五六七八九十一二三四五六七八九十中
         * 原因是数据库长度为20，这里的字符长度为21
         */
        u.setName("123456789012345678901");
        userRepository.save(u);

    }

}

package com.vic.sb40;

import com.alibaba.fastjson.JSON;
import com.vic.sb40.dao.master.UserMapper;
import com.vic.sb40.dao.slave1.StudentMapper;
import com.vic.sb40.entity.Student;
import com.vic.sb40.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testFindById() {
        Student student = studentMapper.findById(1L);
        System.out.println(JSON.toJSONString(student));
    }

}
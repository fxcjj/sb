package com.vic.sb40.service;

import com.vic.sb40.dao.slave1.StudentMapper;
import com.vic.sb40.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public Student findById(Long id){
        return studentMapper.findById(id);
    }
}

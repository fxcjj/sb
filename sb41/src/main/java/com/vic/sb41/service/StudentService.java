package com.vic.sb41.service;

import com.vic.sb41.dao.slave1.StudentMapper;
import com.vic.sb41.entity.Student;
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

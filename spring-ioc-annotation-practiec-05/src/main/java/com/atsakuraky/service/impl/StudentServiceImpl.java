package com.atsakuraky.service.impl;

import com.atsakuraky.dao.StudentDao;
import com.atsakuraky.pojo.Student;
import com.atsakuraky.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.qurryStudents();
        return studentList;
    }
}

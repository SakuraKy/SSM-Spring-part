package com.atsakuraky.pojo.impl;

import com.atsakuraky.dao.StudentDao;
import com.atsakuraky.dao.impl.StudentDaoImpl;
import com.atsakuraky.pojo.Student;
import com.atsakuraky.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("StudentService:" + studentList);
        return studentList;

    }
}

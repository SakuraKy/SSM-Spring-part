package com.atsakuraky.service;

import com.atsakuraky.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有学生数据接口
     * @return
     */
    List<Student> findAll();
}

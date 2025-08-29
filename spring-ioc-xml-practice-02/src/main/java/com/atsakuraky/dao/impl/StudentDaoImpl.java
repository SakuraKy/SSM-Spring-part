package com.atsakuraky.dao.impl;

import com.atsakuraky.dao.StudentDao;
import com.atsakuraky.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {

        //jdbcTemplate进行数据库的查询 -> 需要ioc容器进行装配，不要自己实例化
        String sql = "select id,name,gender,age,class as classes from students";

        List<Student> students = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));

        System.out.println("StudentDao:" + students);

        return students;
    }
}

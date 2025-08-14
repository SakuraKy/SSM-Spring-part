package com.atsakuraky.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atsakuraky.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    public void testForJava() {

        /*
          JdbcTemplate 简化数据库的crud 不提供连接池
          DummyDataSource 负责连接的创建和数据库驱动的注册等等
         */

        //0.创建连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb"); //url地址
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //jdbc驱动
        dataSource.setUsername("root"); //账号
        dataSource.setPassword("12345678"); //密码


        //1.实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);
        //2.调用方法
        //jdbcTemplate.update() DDL DML DCL ... 非查询语句
        //jdbcTemplate.queryForObject() DQL 查询单个对象
        //jdbcTemplate.query() DQL 查询集合
    }


    @Test
    /**
     * 通过ioc容器读取配置的JdbcTemplate组件
     */
    public void testForIoc() {
        //1.创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        //2.获取JdbcTemplate组件

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        //3.进行数据库的curd动作
        //3.1 插入 删除 修改 DML 有update方法
        String sql = "insert into students (id ,name, gender, age, class) values (?, ?, ?, ?, ?)";
        /*
          参数一：String sql 可以带占位符？ ？只能替代值，不能替代关键字
          参数二：Object... args 占位符对应的值 顺序：从左开始对应
          返回值：int 影响函数
         */
        int rows = jdbcTemplate.update(sql, "9","二狗子", "男", 18, "三年二班");
        System.out.println("rows = " + rows);

        //3.2 查询单个对象 DQL 有queryForObject方法
        //根据id查询学生数据 返回对应的一个实体对象
        sql = "select * from students where id = ?";

        /*
          参数一：String sql 可以带占位符？ ？只能替代值，不能替代关键字
          参数二：rowMapper 列名和属性名的映射器接口
          参数三：Object... args 占位符对应的值 顺序：从左开始对应
         */
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {

            //rs 结果集
            //rowNum 当前行的索引
            //rs结果集中获取列的值 赋值给实体类对象即可
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setClasses(rs.getString("class"));
            return student;

        }, 1);
        System.out.println("student1 = " + student1);

        //3.3 查询所有学生数据
        sql = "select id, name, gender, age, class as classes from students;";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        //TODO: BeanPropertyRowMapper帮助我们自动映射列和属性值，要求列名和属性名一致，不一致请别名
        System.out.println("studentList = " + studentList);

    }
}

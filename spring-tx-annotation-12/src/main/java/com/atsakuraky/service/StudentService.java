package com.atsakuraky.service;

import com.atsakuraky.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;

    /*
    添加事务：@Transactional
    位置：方法 / 类
    方法：当前方法有事务
    类：当前类的所有方法都有事务


    1.只读模式
    只读模式可以提升查询事务的效率，推荐事务只有查询代码时使用
    默认：boolen readOnly() default false;
    解释：一般情况下，都是通过类添加注解添加事务
         类下的所有方法都有事务
         查询方法可以通过再次添加注解，设置为只读模式


     */
    @Transactional
    public void changeInfo(){
        studentDao.updateAgeById(100,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }

    @Transactional(readOnly = true)
    public void getStudent(){
        //获取学生信息

    }
}

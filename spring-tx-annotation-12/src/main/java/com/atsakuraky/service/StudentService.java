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
     */
    @Transactional
    public void changeInfo(){
        studentDao.updateAgeById(100,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
}

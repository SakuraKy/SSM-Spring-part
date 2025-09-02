package com.atsakuraky.service;

import com.atsakuraky.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.lang.module.FindException;

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


2.超时时间
  默认：int timeout() default -1;  永远不超时
  设置：timeout = 时间（秒） 超过时间就会回滚事务和释放异常
  如果类上设置事务属性，方法也设置事务注解！方法会不会生效？
  不会生效，类上设置的事务属性会覆盖方法上的事务属性


3.指定异常回滚和指定异常不会滚
默认：指定发生运行时异常事务回滚
     我们可以指定Exception异常来控制所有异常都回滚
     rollbackFor = Exception.class
     noRollbackFor = 回滚异常范围内，控制某个异常不回滚


4.隔离级别
    默认：Isolation.DEFAULT  使用数据库默认的隔离级别
    推荐设置第二个级别
    isolation = Isolation.READ_COMMITTED


     */


    /*
    声明两个独立修改数据库的事务业务方法
    propagation = Propagation.REQUIRES 父类有事务，我们就加入到父方法的事务中
          最终是同一个事务[比如：事务a的代码有异常进行回滚，但是事务b的代码并没有错误；在运行代码的时候，因为都是Propagation.REQUIRES所以事务b也跟着回滚了]
    propagation = Propagation.REQUIRES_NEW 不管父方法有没有事务，我都是一个独立的事务
          两个事务或者三个事务

     */
    @Transactional(readOnly = false,timeout = 3,rollbackFor = Exception.class,noRollbackFor = FileNotFoundException.class,isolation = Isolation.READ_COMMITTED)
    public void changeInfo(){
        studentDao.updateAgeById(100,1);
        System.out.println("-----------");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentDao.updateNameById("test1",1);
    }

    @Transactional(readOnly = true)
    public void getStudent(){
        //获取学生信息

    }
}

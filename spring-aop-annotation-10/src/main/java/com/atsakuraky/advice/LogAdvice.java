package com.atsakuraky.advice;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
增强类的内部存储增强代码

五、
spring aop重点是配置 -> jdk / cglib
 */


/*
四、
加入注解
    @Component 加入ioc容器
    @Aspect 作为切面类使用 = 切点+增强
 */
@Component
@Aspect
public class LogAdvice {

    /*
    一、
    增强代码 = 增强类的方法
    根据插入位置选择创建几个方法

    二、
    使用注解配置，指定插入目标方法的位置
    前置  @Before
    后置  @AfterReturning
    异常  @AfterThrowing
    最后  @After
    环绕  @Around


    try{
        //前置
        //目标
        //后置
    }catch(Exception e){
        //异常
    }finally{
        //最后
    }


    三、
    配置切点表达式[选中插入方法的    切点]
    "execution(* com.atsakuraky.service.impl.*.*(..))"
     */

    @Before("execution(* com.atsakuraky.service.impl.*.*(..))")
    public void start(){
        System.out.println("LogAdvice...start...");
    }
    @After("execution(* com.atsakuraky.service.impl.*.*(..))")
    public void after(){
        System.out.println("LogAdvice...after...");
    }
    @AfterThrowing("execution(* com.atsakuraky.service.impl.*.*(..))")
    public void error(){
        System.out.println("LogAdvice...error...");
    }
}

package com.atsakuraky.advice;

/*
1.定义方法 - 增强代码
2.使用注解指定对应的位置
3.配置切点表达式选中方法
4.切面和ioc配置
5.开启aspectj注解自动代理功能


ToDo:增强方法中获取目标方法信息
    1.全部增强方法中，获取目标方法信息(方法名/参数/访问修饰符/所属类的信息...)
    JoinPoint joinPoint   joinPoint包含目标方法的信息
    2.返回的结果 - @AfterReturning
    (Object result) 目标方法的返回值
    @AfterReturning(value = "execution(* com.atsakuraky.service.impl.*.*(..))",returning = "形参名")
    3.获取异常信息 - @AfterThrowing
    (Throwable throwable) 目标方法抛出的异常
    @AfterThrowing(value = "execution(* com.atsakuraky.service.impl.*.*(..))",throwing = "形参名")
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Before("execution(* com.atsakuraky.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint){
        //获取方法属于类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();

        //获取方法名称
        String name = joinPoint.getSignature().getName();

        //获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("MyAdvice...before...");
    }

    @AfterReturning(value = "com.atsakuraky.pointcut.MyPointCut.myPc()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("MyAdvice...end...");
    }

    @After("com.atsakuraky.pointcut.MyPointCut.myPc()")
    public void after(){

    }

    @AfterThrowing(value = "com.atsakuraky.pointcut.MyPointCut.myPc()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable){

    }
}

package com.atsakuraky.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAdvice {

    @Before("com.atsakuraky.pointcut.MyPointCut.pc()")
    public void begin(){
        System.out.println("begin tx");
    }

    @AfterReturning("com.atsakuraky.pointcut.MyPointCut.pc()")
    public void commit(){
        System.out.println("commit tx");
    }

    @AfterThrowing("com.atsakuraky.pointcut.MyPointCut.pc()")
    public void rollback(){
        System.out.println("rollback tx");
    }
}

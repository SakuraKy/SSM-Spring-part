package com.atsakuraky.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointCut {

    @Pointcut("execution(* com.atsakuraky.service.impl.*.*(..))")
    public void pc(){}

    @Pointcut("execution(* com.atsakuraky.service.impl.*.*(..))")
    public void myPc(){

    }
}

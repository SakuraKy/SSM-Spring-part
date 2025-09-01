package com.atsakuraky.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {

    /*
    环绕通知，需要你在通知中，定义目标方法的执行
    joinPoint:目标方法
    return:目标方法的返回值
     */

    @Around("com.atsakuraky.pointcut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint) {

        //保证目标方法执行
        Object[] args = joinPoint.getArgs();
        Object proceed = null;
        try {
            //增强代码 -> before
            System.out.println("开启事务");
            proceed = joinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
            throw new RuntimeException(e);
        }
        return proceed;
    }
}

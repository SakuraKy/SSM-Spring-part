package com.atsakuraky.advice;


import org.aspectj.lang.annotation.*;
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
    固定语法：execution(切点表达式[1,2,3,4,5(6)])
    1.访问修饰符
        public/private
    2.方法的返回参数类型
        String/int/void/...
    如果不考虑访问修饰符和返回值类型，可以使用*代替[如果不考虑，则两个都不考虑]
    3.包的位置
        具体包：com.atsakuraky.service.impl
        单层模糊：com.atsakuraky.service.*
        多层模糊：com.atsakuraky.service..*  .. 任意层的模糊[细节：..不能开头，但可以*..impl]
    4.类名
        具体：CalculatorPureImpl
        模糊：*
        部分模糊：*Impl
    5.方法名:方法和类名一致
    6.参数列表
        没有参数：()
        有具体参数：(int,String)
        模糊参数：(..)
        部分模糊：(int..)int后面无所谓
                   例子：(..int)最后一个参数是int
                         (String..int)

     */

    /*
    ToDo:切点表达式的提取和复用
        1.当前类中提取
        定以一个空方法
        注解@Pointcut("切点表达式")
        增强注解中引用切点表达式的方法即可  直接调用方法
        2.创建一个存储切点的类
        单独维护切点表达式
        其他类的切点方法 类的全限定符.方法名()
     */




    @Before("com.atsakuraky.pointcut.MyPointCut.pc()")
    public void start(){
        System.out.println("LogAdvice...start...");
    }
    @After("com.atsakuraky.pointcut.MyPointCut.pc()")
    public void after(){
        System.out.println("LogAdvice...after...");
    }
    @AfterThrowing("com.atsakuraky.pointcut.MyPointCut.pc()")
    public void error(){
        System.out.println("LogAdvice...error...");
    }
}

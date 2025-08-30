package com.atsakuraky.test;

import com.atsakuraky.config.JavaConfiguration;
import com.atsakuraky.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void  test() {

        //1.创建ioc容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
        applicationContext1.register(JavaConfiguration.class);
        applicationContext1.refresh();

        //2.获取bean

        StudentController bean = applicationContext.getBean(StudentController.class);
        System.out.println("bean = "+ bean);
    }
}

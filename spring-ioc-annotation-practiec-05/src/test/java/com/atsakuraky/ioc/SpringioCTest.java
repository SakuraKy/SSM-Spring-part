package com.atsakuraky.ioc;

import com.atsakuraky.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringioCTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        StudentController controller = context.getBean(StudentController.class);

        controller.findAll();


    }
}

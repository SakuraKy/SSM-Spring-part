package com.atsakuraky.test;

import com.atsakuraky.ioc_01.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void testIoc_01() {

        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");


        //2.获取组件
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean:" + bean);


        //添加ioc注解，默认组件名为 类名首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println("xxxService:" + xxxService);



        //3.close容器


    }
}

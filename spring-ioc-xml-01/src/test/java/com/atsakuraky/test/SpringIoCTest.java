package com.atsakuraky.test;

import com.atsakuraky.ioc_03.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    /**
     * 讲解如何创建ioc容器并且读取配置文件
     */
    public void createIoC() {
        //1. 创建一个Spring容器 选择合适的容器
        //方式1.直接创建容器，指定配置文件[推荐]
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //方式2.先创建ioc容器，再指定配置文件，再刷新
        //源码的配置过程     创建容器[spring]  和      配置文件[自己指定]分开
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh();


    }


    /**
     * 讲解如何在ioc容器中获取组件bean
     */
    @Test
    public void getBeanFromIoC() {
        //1.创建容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        //2.从容器中获取组件
        //方式1.通过id获取 默认返回值类型是Object 需要强转[不推荐]
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");
        //方式2.通过类型获取 需要指定类型[推荐]
        //TODO：根据bean类型获取，同一个类型，在ioc容器里只能有一个bean！报错：NoUniqueBeanDefinitionException: No qualifying bean of type 'com.atsakuraky.test.ioc_03.HappyComponent' available
        //TODO:ioc的配置一定是实现类，但是可以根据接口类型获取值
        HappyComponent happyComponent1 = applicationContext.getBean(HappyComponent.class);
        //方式3.通过id和类型获取 需要指定类型[推荐]
        HappyComponent happyComponent2 = applicationContext.getBean("happyComponent", HappyComponent.class);
        happyComponent1.doWork();

        System.out.println(happyComponent == happyComponent1); // true
        System.out.println(happyComponent1 == happyComponent2); // true
        System.out.println(happyComponent2 == happyComponent); // true
    }

    /**
     * 测试ioc配置和销毁方法的触发
     */
    @Test
    public void test_04() {
        //1.创建容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        //2.正常结束ioc容器
        applicationContext.close();

    }
}

package com.atsakuraky.test;

import com.atsakuraky.ioc_01.XxxDao;
import com.atsakuraky.ioc_02.JavaBean;
import com.atsakuraky.ioc_03.UserController;
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

    @Test
    public void testIoc_02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        JavaBean bean = applicationContext.getBean(JavaBean.class);

        JavaBean bean1 = applicationContext.getBean(JavaBean.class);

        System.out.println(bean == bean1);

        applicationContext.close();
    }

    @Test
    public void testIoc_03() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //获取controller
        //调用show方法

        UserController userController = applicationContext.getBean(UserController.class);

        //1.场景一：ioc容器中有一个UserService接口对应的实现类对象
        userController.show();

        //2.场景二：ioc容器没有默认类型如何处理
        //@Autowired 使用它进行装配，【默认】情况下至少需要一个bean，否则报错

        //3.场景三：ioc容器中有多个接口对应的实现类对象 @Autowired也会报错！无法选择
        //解决方案1：@Qualifier("newUserServiceImpl") 指定bean的id 不能单独使用必须配合@Autowired
        //解决方案2：@Primary 让spring进行优先选择

        //优化点：@Autowired(required = true)+@Qualifier(value = "UserServiceImpl") = @Resource(name = "UserServiceImpl")既可以自动装配又可以指定bean名称
    }
}

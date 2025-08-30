package com.atsakuraky.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class JavaBean {


    /*
    之前的做法 xml配置
    <bean id class
        <property name="" value=""
     */

    //方案一：直接赋值
    //方案二：注解赋值 @Value 一般用于读取外部配置
    //一般情况下使用直接赋值 默认值：value("key:name") 如果外部文件中没有key则使用name
    private String name = "小白";

    @Value("19")
    private int age;


    /*
    读取外部配置
    1.在类路径下创建一个jdbc.properties文件
    2.在文件中添加配置项
    3.在类上添加@PropertySource注解，指定外部配置文件
    4.使用@Value读取配置项
     */
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private int password;

    public String toString() {
        return "JavaBean{name='" + name + "', age=" + age + ", username='" + username + "', password=" + password + "}";
    }

}

package com.atsakuraky.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
java的配置类，替代xml配置文件
1.包扫描注解配置  @ComponentScan(value = "com.atsakuraky.ioc_01")
2.引用外部配置文件
3.声明第三方依赖的bean组件

步骤：
1.添加@Configuration 代表是配置类
2.实现上面三个功能注解
 */
@ComponentScan(value = "com.atsakuraky.ioc_01") //包扫描注解配置
@PropertySource(value = "classpath:jdbc.properties") //引用外部配置文件
@Configuration
public class JavaConfiguration {
}

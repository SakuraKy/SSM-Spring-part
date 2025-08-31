package com.atsakuraky.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// Import注解： 用于导入其他配置类，作用相当于xml配置文件中的<import resource=""/>
// 可以导入多个配置类
// 被导入的配置类中的bean组件会被当前配置类所在的ioc容器进行管理
// 也就是被导入的配置类中的bean组件可以被当前配置类所在的ioc容器进行获取
// 可以解决配置类过多的问题
// 也可以解决配置类之间的依赖问题
@Import({JavaConfigurationB.class})
@Configuration
public class JavaConfigurationA {
}

package com.atsakuraky.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    @Value("${atsakuraky.url}")
    private String url;
    @Value("${atsakuraky.driver}")
    private String driver;
    @Value("${atsakuraky.username}")
    private String username;
    @Value("${atsakuraky.password}")
    private String password;


    /*
    第三方bean标签
    <bean id="" class=""> 在配置类就是一个方法
    方法返回值类型就是bean组件的类型或者它的接口和父类
    方法名称 = <bean id="">
    方法体可以自定义实现过程
    最重要的一步：在方法上添加注解@bean 会真正让配置类方法创建的组件存储到ioc容器中

     */
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}

package com.atsakuraky.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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



    问题一：beanName的问题
        默认： 方法名
        指定： name/value属性起名，覆盖方法名
    问题二：周期方法如何指定
        原有注解方案：PostConstruct/PreDestroy
        bean注解属性： initMethod/destroyMethod
    问题三：作用域
        和以前一样@Scope注解，默认单例
    问题四：如何引用其他ioc组件
        1.直接调用对方的bean方法
        2.直接形参变量进行引用，要求必须有对应的组件，如果有多个，形参名 = 组件id标识


     */
    @Bean(name = "dataSource") //第三方bean标签
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        //需要DataSource组件 需要ioc容器的其他组件
        //方案一：如果其他组件也是@Bean方法，可以直接调用|从ioc容器获取组件

        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;

    }
    @Bean
    public JdbcTemplate jdbcTemplate2(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        //需要DataSource组件 需要ioc容器的其他组件
        //方案二：形参列表声明想要的组件类型，可以是一个也可以是多个 ioc容器也会注入
        //如果没有：形参变量注入，要求必须有对应的类型组件，如果没有则抛出异常
        //如果有多个：可以使用形参名称等同于对应的bean的id
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;

    }
}

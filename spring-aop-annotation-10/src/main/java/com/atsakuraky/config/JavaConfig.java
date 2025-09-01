package com.atsakuraky.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.atsakuraky")
@EnableAspectJAutoProxy //开启aspectj自动代理功能
public class JavaConfig {

}

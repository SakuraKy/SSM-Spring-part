package com.atsakuraky.test;

import com.atsakuraky.components.A;
import com.atsakuraky.components.B;
import com.atsakuraky.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

//让 Spring 测试环境自动创建和管理 IoC 容器。
@SpringJUnitConfig(classes = {JavaConfig.class})
public class SpringIoCTest {

    @Autowired
    private A a;
    @Autowired
    private B b;


    @Test
    public void test() {

        System.out.println(a);
        System.out.println(b);
    }
}

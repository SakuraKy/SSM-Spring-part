package com.atsakuraky.test;

import com.atsakuraky.config.JavaConfig;
import com.atsakuraky.service.Calculator;
import com.atsakuraky.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }

}

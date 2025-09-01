package com.atsakuraky;

import com.atsakuraky.statics.StaticProxyCalculator;

public class UseAop {

    public static void main(String[] args) {
        //房东 目标
        Calculator calculator = new CalculatorPureImpl();

        //中介 代理
        Calculator proxy = new StaticProxyCalculator(calculator);

        //调用
        int result = proxy.add(1, 1);
        System.out.println("result = " + result);

    }
}

package com.atsakuraky.ioc_04;

public class JavaBean {


    /**
     * 必须是public的,void的返回参数的无参构造方法
     * 命名随意
     */

    public void init() {
        System.out.println("JavaBean init method called");
    }


    /**
     * 销毁方法
     */
    public void  destroy() {
        System.out.println("JavaBean destroy method called");
    }
}

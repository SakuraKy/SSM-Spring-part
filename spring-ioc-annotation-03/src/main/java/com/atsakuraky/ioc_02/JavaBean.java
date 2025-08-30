package com.atsakuraky.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) //单例（默认值）单例可以管理destroy，但是多例默认不管理`
// @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //多例
@Component
public class JavaBean {
    //周期方法起名随意，格式：public void 没有形参
    @PostConstruct //实例化后调用init方法
    public void init(){
        System.out.println("JavaBean.init");

    }

    @PreDestroy //在销毁前调用
    public void destroy(){
        System.out.println("JavaBean.destroy");

    }
}

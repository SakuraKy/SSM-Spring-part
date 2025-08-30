package com.atsakuraky.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Controller
public class UserController {
    // 自动注入 1.ioc容器查找符合类型的bean 2.设置给当前属性(di)
    //<property userService -> 对应类型的bean装配
    @Autowired(required = true) //boolean required() default true; 必须要有对应类型的bean，默认true
                //佛系装配，可以没有，值为空 false
                //不推荐使用佛系装配，因为装配的数据，后期都会有装配！后面会出现空指针异常
    @Qualifier(value = "userServiceImpl") //指定装配的bean名称
    private UserService userService;

    @Resource(name = "userServiceImpl") //既可以自动装配又可以指定bean名称
    private UserService userService1;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void show() {
        //调用业务层的show方法
        String show = userService.show();
        System.out.println("show:" + show);

    }
}

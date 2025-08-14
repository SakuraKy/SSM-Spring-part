package com.atsakuraky.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * 步骤：
 * 1. 实现 FactoryBean 接口，指定泛型为要创建的对象类型
 * 2.
 */

public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    /**
     * 如果想要给JavaBean里的属性赋值，可以在这里定义一个属性，
     * 然后在 getObject() 方法中使用这个属性来设置 JavaBean 的属性值
     * 例如，这里定义了一个 value 属性，
     * 在 getObject() 方法中将其设置为 JavaBean 的 name 属性值。
     * 这样就可以通过 FactoryBean 来创建一个 JavaBean 对象，
     *
     *
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public JavaBean getObject() throws Exception {
        //使用自己的方式实例化对象
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}

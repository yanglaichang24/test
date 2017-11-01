package com.ylch.test.spring_test.factoryBean;

import com.ylch.test.spring_test.Test;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglaichang1 on 2017/7/17.
 */
public class FactoryBeanTest2 implements FactoryBean<Test>, InitializingBean, DisposableBean {

    public Test getObject() throws Exception {
        return new Test();
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("--------------------- init ----------------");
    }

    public void destroy() throws Exception {
        System.out.println("--------------------- destroy----------------");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-factoryBean.xml");

        for (int i = 0; i<10; i++){
            Object text = classPathXmlApplicationContext.getBean("testDto2");
            System.out.println(text);
        }
    }

}

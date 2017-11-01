package com.ylch.test.spring_test.factoryBean;

import com.ylch.test.spring_test.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Created by yanglaichang1 on 2017/7/17.
 */
public class FactoryBeanTest implements FactoryBean<Test>,InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(FactoryBeanTest.class);

    private Test test;

    public Test getObject() throws Exception {
        System.out.println("--------------------- 获取实例 --------------");
        return test;
    }

    public Class<?> getObjectType() {
        return Test.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void destroy() throws Exception {
        //logger.info(" ------------------- ## destory ...--------------");
        System.out.println(" ------------------- ## destory ...-------------- ");
        test = null;
    }

    public void afterPropertiesSet() throws Exception {
        //logger.info(" ------------------- ## init method --------------");
        System.out.println(" ------------------- ## init method --------------");
        test = new Test();
    }

    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-factoryBean.xml");

        for (int i = 0; i<10; i++){
            Object text = classPathXmlApplicationContext.getBean("testDto");
            System.out.println(text);
        }
    }

}

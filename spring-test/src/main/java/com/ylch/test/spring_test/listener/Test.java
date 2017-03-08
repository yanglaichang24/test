package com.ylch.test.spring_test.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglaichang1 on 2017/3/1.
 */
public class Test {
    public static void main(String[] args) {
        AbstractXmlApplicationContext ac
                =new ClassPathXmlApplicationContext("spring-listener.xml");
        //ac.addApplicationListener((ApplicationListener) ac.getBean("ApplicationEventListener"));
                ac.refresh(); //触发ContextRefreshedEvent事件
                ac.start();   //触发ContextStartedEvent事件
                ac.stop();    //触发ContextStoppedEvent事件
                ac.close();   //关闭容器，触发ContextClosedEvent事件
    }

}

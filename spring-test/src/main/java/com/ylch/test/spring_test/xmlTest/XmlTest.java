package com.ylch.test.spring_test.xmlTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglaichang1 on 2017/1/19.
 */
public class XmlTest {

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-test.xml");
        Object text = classPathXmlApplicationContext.getBean("text");
        XmlDto dto  = (XmlDto)text;

    }

}

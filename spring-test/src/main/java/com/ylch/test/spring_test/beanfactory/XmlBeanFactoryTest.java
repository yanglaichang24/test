package com.ylch.test.spring_test.beanfactory;

import com.ylch.test.spring_test.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by yanglaichang1 on 2017/2/27.
 */
public class XmlBeanFactoryTest {

    public void test(){

    }

    public static void main(String[] args){
        ClassPathResource classPathResource = new ClassPathResource("/spring-config-elastic.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        Test testDto = (Test)xmlBeanFactory.getBean("testDto");
        System.out.println(testDto.getId()   +  testDto.getName());

    }

}

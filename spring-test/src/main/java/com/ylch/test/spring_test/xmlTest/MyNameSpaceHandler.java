package com.ylch.test.spring_test.xmlTest;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by yanglaichang1 on 2017/1/19.
 */
public class MyNameSpaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("service", new XmlBeanDefinitionParser());
        registerBeanDefinitionParser("controller",new XmlBeanDefinitionParser2());
    }

}

package com.ylch.test.spring_test.xmlTest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by yanglaichang1 on 2017/6/19.
 */
public class XmlBeanDefinitionParser2 implements BeanDefinitionParser{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(XmlDto.class);
        rootBeanDefinition.setLazyInit(false);
        return rootBeanDefinition;
    }

}

package com.ylch.test.spring_test.xmlTest;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by yanglaichang1 on 2017/1/19.
 */
public class XmlBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return XmlDto.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String id    = element.getAttribute("id");
        String name  = element.getAttribute("name");
        String email = element.getAttribute("email");

       /* if (StringUtils.hasText(id)){
            builder.addPropertyValue("id",id);
        }*/
        if (StringUtils.hasText(name)){
            builder.addPropertyValue("name",name);
        }

        if (StringUtils.hasText(email)){
            builder.addPropertyValue("telephone",email);
        }

    }


}

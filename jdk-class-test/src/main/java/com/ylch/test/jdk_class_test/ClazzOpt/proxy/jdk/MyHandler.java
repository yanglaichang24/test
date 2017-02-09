package com.ylch.test.jdk_class_test.ClazzOpt.proxy.jdk;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanglaichang1 on 2017/2/9.
 */
public class MyHandler implements InvocationHandler {

    private Object target;

    public MyHandler(Object target){
       this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("  ----before---   ");
        System.out.println("name " + method.getName());

        Annotation[] annotations = method.getAnnotations();

        Object invoke = method.invoke(target, args);

        System.out.println("  ----after---   ");
        return invoke;
    }

}

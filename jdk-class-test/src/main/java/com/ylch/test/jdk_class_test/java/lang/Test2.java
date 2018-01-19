package com.ylch.test.jdk_class_test.java.lang;

import java.lang.reflect.Method;

/**
 * Created by yanglaichang1 on 2017/4/17.
 */
public class Test2 implements TestDomain {

    @Deprecated
    public void test(){

    }

    public void test1(){

    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        Method[] methods = test2.getClass().getMethods();
        for(Method method : methods){
            Deprecated annotation = method.getAnnotation(Deprecated.class);
            if(null != annotation){
                System.out.println("method"+ method.getName() );
            }
        }


    }


}

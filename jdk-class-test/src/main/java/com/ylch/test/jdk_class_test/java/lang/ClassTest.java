package com.ylch.test.jdk_class_test.java.lang;

import org.junit.Test;

/**
 * Created by yanglaichang1 on 2017/4/17.
 */
public class ClassTest {

    @Test
    public void isAssignableFromTest(){
        //System.out.println(TestDomain.class.isAssignableFrom(TestDomail2.class));

        //System.out.println(Test1.class.isAssignableFrom(TestDomain.class));

        //System.out.println(TestDomain.class.isAssignableFrom(Test2.class));

        System.out.println(TestDomain.class.isAssignableFrom(Test1.class));
    }

    public void asSubclass(){

    }


}

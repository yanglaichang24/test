package com.ylch.test.jdk_class_test.hashcode_equal;

import org.junit.Test;

/**
 * Created by yanglaichang1 on 2018/4/13.
 */
public class EqualTest {


    @Test
    public void test(){
        Integer integer = new Integer(1000);
        Integer integer2 = new Integer(1000);
        System.out.println(integer==integer2);
        System.out.println(integer.equals(integer2));
    }



}

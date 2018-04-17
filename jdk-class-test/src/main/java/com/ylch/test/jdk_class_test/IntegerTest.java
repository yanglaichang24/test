package com.ylch.test.jdk_class_test;

import org.junit.Test;

/**
 * Created by yanglaichang1 on 2018/3/23.
 */
public class IntegerTest {


    @Test
    public void test(){
        Integer integer = new Integer(20654466);
        integer.toString();
    }

    @Test
    public void test2(){
        int i = 988745;
        int q = i / 100;
        // really: r = i - (q * 100);
        int r = i - ((q << 6) + (q << 5) + (q << 2));
        //int r2 = i - q *(Math.pow(2, 6) +  Math.pow(2, 5) +  Math.pow(2, 2));
        //System.out.println(r2);
        System.out.println(r);

        System.out.println(Math.pow(2, 6));
        System.out.println(Math.pow(2, 5));
        System.out.println(Math.pow(2, 2));


    }




}

package com.ylch.test.jdk_class_test.Io;

import org.junit.Test;

/**
 * Created by yanglaichang1 on 2017/4/18.
 */
public class CommonTest {

    @Test
    public void test(){
        int v = 129;
       // System.out.println((v >>> 8) & 0xFF);
        //System.out.println((v >>> 0) & 0xFF);

        //int bt = 536870911;
        //String s = Integer.toBinaryString(bt);
        //String s2 = Integer.toBinaryString(-1);
        //String s2  = Long.toBinaryString(-5);
        //System.out.println(s);
        //System.out.println(s2);
        //System.out.println((-5 >> 2));

        //System.out.println(5 & 3);
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(~5);

    }

    @Test
    public void test2(){
        Integer maxValue = Integer.MAX_VALUE + 1;
        System.out.println(maxValue);
    }


    @Test
    public void test3(){
        int v = 1000;
        System.out.println((v >>> 24) & 0xFF);
        System.out.println((v >>> 16) & 0xFF);
        System.out.println((v >>>  8) & 0xFF);
        System.out.println((v >>>  0) & 0xFF);
    }

    @Test
    public void test4(){
        System.out.println((byte) 156);
        System.out.println(Integer.toBinaryString(156));
    }

    @Test
    public void test05(){
        int x = 1;
        int y = 2;

        int temp = x;
        x    = y ;
        y = temp;

        System.out.println(x + " " + y);

        x=x+y;
        y=x-y;
        x=x-y;

        x=x^y;
        y=y^x;
        x=x^y;

        x^=y;
        y^=x;
        x^=y;

    }

    @Test
    public void test06(){

        boolean flag  = false;
        boolean flag1 = true;

        boolean flag2  = flag ^ flag1;
        boolean flag3  = flag & flag1;
        boolean flag4  = flag | flag1;

        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);

    }


    @Test
    public void test6(){



    }



}

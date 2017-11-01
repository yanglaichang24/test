package com.ylch.test.jdk_class_test.gc;

/**
 * Created by yanglaichang1 on 2017/7/17.
 * -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails
 *
 * -XX:PretenureSizeThreshold=3145728
 *
 *
 */
public class GcTest2 {
    private static final int  _1MB = 1024 * 1024;


    public static void main(String[] args) {
        byte[] bt1,bt2,bt3,bt4;
        bt1 = new byte[2 * _1MB];
        System.out.println("-----------bt1------------------");
        bt2 = new byte[2 * _1MB];
        System.out.println("-----------bt2------------------");
        bt3 = new byte[2 * _1MB];
        bt3 = null;
        bt2 = null;
        System.out.println("-----------bt3------------------");
        bt4 = new byte[3 * _1MB];
        System.out.println("-----------bt4------------------");
       /* bt4 = new byte[10* _1MB];*/
    }

}

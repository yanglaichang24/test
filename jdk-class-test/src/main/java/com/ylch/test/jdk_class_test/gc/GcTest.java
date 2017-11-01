package com.ylch.test.jdk_class_test.gc;

/**
 * Created by yanglaichang1 on 2017/6/30.
 * -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails
 */
public class GcTest {

    public Object instance = null;

    private static final int  _1MB = 1024 * 1024;

    private byte[] bigsize = new byte[ 2 * _1MB ];

    public static void main(String[] args) {

        GcTest gcTest1 = new GcTest();
        GcTest gcTest2 = new GcTest();
        gcTest1 = null;
        gcTest2 = null;

        System.gc();

    }

}

package com.ylch.test.jdk_class_test.serializable;

import java.io.*;

/**
 * Created by yanglaichang1 on 2017/7/24.
 */
public class Test {

    @org.junit.Test
    public void test() throws IOException {
        TestVo testVo = new TestVo("3333",222);
        byte[] serialize = JDKSerializale.serialize(testVo);
        File file = new File("d:/test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(serialize);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @org.junit.Test
    public void test2() throws IOException {
        File file = new File("d:/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int read = fileInputStream.read(bytes);
        fileInputStream.close();
        TestVo unserialize = JDKSerializale.unserialize(bytes, TestVo.class);
        System.out.println(unserialize);
    }

}

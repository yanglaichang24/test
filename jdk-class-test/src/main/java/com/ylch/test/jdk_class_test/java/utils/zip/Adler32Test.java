package com.ylch.test.jdk_class_test.java.utils.zip;

import org.junit.Test;

import java.util.zip.Adler32;

/**
 * Created by yanglaichang1 on 2017/4/18.
 */
public class Adler32Test {

    @Test
    public void test(){
        Adler32 adler32 = new Adler32();
        adler32.update("woeiurmflaisopf8uqwo5tj".getBytes());
        long value = adler32.getValue();
        System.out.println(value);
    }


}

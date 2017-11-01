package com.ylch.test.jdk_class_test.java.utils.zip;

import org.apache.tools.zip.ZipEncoding;
import org.junit.Test;

import java.util.zip.CRC32;
import java.util.zip.ZipOutputStream;

/**
 * Created by yanglaichang1 on 2017/4/18.
 */
public class CRC32Test {

    @Test
    public void test(){
        CRC32 crc32 = new CRC32();
        crc32.update("woeiurmflaisopf8uqwo5tj".getBytes());
        long value = crc32.getValue();
        System.out.println(value);

    }

    @Test
    public void tes2(){



    }

}

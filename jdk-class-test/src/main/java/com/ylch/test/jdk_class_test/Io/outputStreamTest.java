package com.ylch.test.jdk_class_test.Io;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * Created by yanglaichang1 on 2017/4/20.
 */
public class outputStreamTest {


    @Test
    public void test() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("d:/test.txt");
        fileOutputStream.write(12456);
        fileOutputStream.write(456546);
        fileOutputStream.write(3456745);
        fileOutputStream.write(111234);
        fileOutputStream.write(101);
        String str = "lwekorsnflsjfl";
        fileOutputStream.write(str.getBytes());
        String str2 = "中国";
        String gbk = new String(str2.getBytes(), "GBK");
        fileOutputStream.write(gbk.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }


    @Test
    public void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("d:/test.txt");
       /* int read;
        do{
            read = fileInputStream.read();
            System.out.println(read);
        } while (read == -1);*/

      /* while (true){
            int read2 = fileInputStream.read();
            System.out.println(read2);
            if(-1 == read2){
                break;
            }
        }*/
        byte[] bt = new byte[1024];
        fileInputStream.read(bt);
        System.out.println(Arrays.toString(bt));
        System.out.println(new String(bt));

    }

    @Test
    public void test4(){






    }



}

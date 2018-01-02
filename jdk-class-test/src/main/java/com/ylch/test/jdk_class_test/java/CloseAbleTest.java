package com.ylch.test.jdk_class_test.java;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by yanglaichang1 on 2017/12/7.
 */
public class CloseAbleTest implements Closeable{

    public void test(){
        System.out.println("ylc");
    }

    public void close() throws IOException {
        System.out.println("ylc2");
    }

    public static void main(String[] args) {
        try{
            try(CloseAbleTest closeAbleTest = new CloseAbleTest()){
                closeAbleTest.test();
            } catch (Exception e){

            };
            //closeAbleTest.test();
        }catch (Exception e){

        }
    }

    //public

}

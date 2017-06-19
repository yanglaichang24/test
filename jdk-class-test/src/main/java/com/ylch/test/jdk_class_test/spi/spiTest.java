package com.ylch.test.jdk_class_test.spi;

import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by yanglaichang1 on 2017/6/19.
 */
public class spiTest {


    @Test
    public void test(){

        ServiceLoader<SpiExecute> serviceLoader = ServiceLoader.load(SpiExecute.class);
        SpiExecute exec = null;
        Iterator<SpiExecute> iterator = serviceLoader.iterator();
        if (iterator.hasNext()) {
            exec = iterator.next();
        }
        assert exec != null;
        System.out.println(exec.spitest("yyyyyyyy"));
    }



}

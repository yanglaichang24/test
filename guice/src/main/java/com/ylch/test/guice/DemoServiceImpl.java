package com.ylch.test.guice;

import com.google.inject.Inject;

/**
 * Created by yanglaichang1 on 2017/11/3.
 */
public class DemoServiceImpl implements DemoService {

    @Inject
    public DemoServiceImpl(){}

    public void test1() {
        System.out.println("=============test1================");
    }

    public String test2() {
        return "=========================== test02 =====================";
    }
}

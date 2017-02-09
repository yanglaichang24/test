package com.ylch.test.jdk_class_test.ClazzOpt.proxy;

/**
 * Created by yanglaichang1 on 2017/2/9.
 */
public class DemoVoImpl implements DemoVo {

    public void test1() {
       System.out.println("test01");
    }

    public String test2() {
        return 222+"";
    }

    public void test03(String name) {
        System.out.println(name + "");
    }
}

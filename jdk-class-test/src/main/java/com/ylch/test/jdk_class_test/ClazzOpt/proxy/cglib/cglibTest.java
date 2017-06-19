package com.ylch.test.jdk_class_test.ClazzOpt.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by yanglaichang1 on 2017/2/9.
 */
public class cglibTest {

    public static void main(String[] args){
        Programmer progammer = new Programmer();
        Hacker hacker = new Hacker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(progammer.getClass());
        enhancer.setCallback(hacker);
        Programmer proxy =(Programmer)enhancer.create();
        proxy.code();

    }
}

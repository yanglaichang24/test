package com.ylch.test.jdk_class_test.ClazzOpt.proxy.jdk;

import com.ylch.test.jdk_class_test.ClazzOpt.proxy.DemoVo;
import com.ylch.test.jdk_class_test.ClazzOpt.proxy.DemoVoImpl;

import java.lang.reflect.Proxy;

/**
 * Created by yanglaichang1 on 2017/2/9.
 */
public class JdkTest {

    public static void main(String[] args){

        DemoVoImpl demoVo = new DemoVoImpl();

        DemoVo o = (DemoVo)Proxy.newProxyInstance(
                JdkTest.getCurrentClassLoader(), new Class[]{DemoVo.class}, new MyHandler(demoVo));
        o.test1();
        String s = o.test2();
        System.out.println(s);
        o.test03("eeee");

        /*System.out.println(demoVo);
        DemoVoImpl demoVo2 = demoVo;
        demoVo = null;

        System.out.println(demoVo);
        System.out.println(demoVo2);*/

    }

    public static ClassLoader getCurrentClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if(cl == null) {
            cl = JdkTest.class.getClassLoader();
        }
        return cl == null?ClassLoader.getSystemClassLoader():cl;
    }


}

package com.ylch.test.jdk_class_test.ClazzOpt;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by yanglaichang1 on 2017/2/9.
 */
public class Test {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FileInputStream fileInputStream = new FileInputStream("d:/DemoClazz.class");
        byte[] result = new byte[1024];
        int read = fileInputStream.read(result);
        MyclassLoad myclassLoad = new MyclassLoad();
        Class<?> clazz = myclassLoad.defineMyClass(result, 0, read);
        Object demo= clazz.newInstance();
        clazz.getMethod("test",null).invoke(demo,null);
    }
}

package com.ylch.test.jdk_class_test.ClazzOpt;

/**
 * Created by yanglaichang1 on 2017/2/9.
 */
public class MyclassLoad extends ClassLoader {

    public Class<?> defineMyClass( byte[] b, int off, int len)
    {
        return super.defineClass(null,b, off, len, null);
    }

}

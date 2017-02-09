package com.ylch.test.jdk_class_test.ClazzOpt.Javassist;

import javassist.*;

import java.io.IOException;

import static javassist.CtNewMethod.make;

/**
 * Created by yanglaichang1 on 2017/2/9.
 */
public class Test {

    public static void main(String[] args) throws CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc= pool.makeClass("com.ylch.test.jdk_class_test.ClazzOpt.DemoClazz");
        //定义code方法
        CtMethod method =CtNewMethod.make("public void code(String str){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);
        //保存生成的字节码
        cc.writeFile("d://temp");
    }
}

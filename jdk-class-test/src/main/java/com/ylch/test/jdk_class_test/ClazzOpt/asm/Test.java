package com.ylch.test.jdk_class_test.ClazzOpt.asm;

import java.io.IOException;

/**
 * Created by yanglaichang1 on 2017/2/14.
 */
public class Test {

        String str = new String("good");
        char[] ch = { 'a', 'b', 'c' };
        Test test = new Test();

        public static void main(String[] args) {
            Test ex = new Test();
            System.out.println(ex.test);
            ex.change(ex.str, ex.ch);
            System.out.println(ex.str);
            System.out.println(ex.ch);
            System.out.println(ex.test);

        }

        public void change(String str, char ch[]) {
            str = "test ok";
            ch[0] = 'g';
            test = new Test();
        }
}

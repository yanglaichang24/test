package com.ylch.test.jdk_class_test;

import java.util.StringTokenizer;

/**
 *  StringTokenizer 是出于兼容性的原因而被保留的遗留类（虽然在新代码中并不鼓励使用它）。
 *  建议所有寻求此功能的人使用 String 的 split 方法或 java.util.regex 包。
 * Created by yanglaichang1 on 2017/1/10.
 */
public class StringTokenizer_test {

    public static void main(String[] args) {

        String test_str = "I am  Ylch";
        StringTokenizer st = new StringTokenizer(test_str);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }

}

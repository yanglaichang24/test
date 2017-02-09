package com.ylch.test.jdk_class_test;

import java.util.Scanner;

/**
 * Created by yanglaichang1 on 2017/1/10.
 */
public class Scanner_test {

    public static void main(String[] args) {

        String test_str = "I***amYlch";

        Scanner scanner = new Scanner(test_str);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }

    }
}

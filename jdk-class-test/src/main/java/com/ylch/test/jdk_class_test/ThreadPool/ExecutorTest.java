package com.ylch.test.jdk_class_test.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanglaichang1 on 2017/11/15.
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }));

        while (true){

        }
    }

}

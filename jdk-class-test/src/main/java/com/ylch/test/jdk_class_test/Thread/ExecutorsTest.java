package com.ylch.test.jdk_class_test.Thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanglaichang1 on 2017/5/3.
 */
public class ExecutorsTest {


    @Test
    public void test(){
        ExecutorService executorService
                = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("yyyy");
            }
        });

    }


}

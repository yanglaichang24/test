package com.ylch.test.jdk_class_test.Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by yanglaichang1 on 2017/11/10.
 */
public class FutureAndCallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(1000000);
                return "ylc";
            }
        };

        FutureTask<String> stringFutureTask = new FutureTask<String>(callable);
        new Thread(stringFutureTask).start();

        System.out.println(stringFutureTask.get());
        //System.out.println(stringFutureTask.get());
    }

}

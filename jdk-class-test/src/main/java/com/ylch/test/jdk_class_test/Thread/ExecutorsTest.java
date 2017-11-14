package com.ylch.test.jdk_class_test.Thread;

import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by yanglaichang1 on 2017/5/3.
 */
public class ExecutorsTest {

    //@Test
    public void test(){

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 无界线程组
        ExecutorService executorService
                = Executors.newCachedThreadPool();

        //固定大小线程组
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);

        // 单个后台程序
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("yyyy");
            }
        });

        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 0, 1000);*/

      /*  executorService.submit(new Runnable() {
            public void run() {
                System.out.println("xxx");
            }
        });*/


       /* Future<String> future = executorService.submit(new Callable<String>() {

            public String call() throws Exception {
                return "111";
            }
        });

        System.out.println(future.get());

        System.out.println(future.isDone());*/
        //executorService.shutdown();
    }

}

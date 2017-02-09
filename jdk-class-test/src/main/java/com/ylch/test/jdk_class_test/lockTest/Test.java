package com.ylch.test.jdk_class_test.lockTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yanglaichang1 on 2017/1/19.
 */
public class Test extends Thread{

    private static final Object lock = new Object();
    private static volatile Test test;
    private final static CountDownLatch countDownLatch = new CountDownLatch(200);

    private Test test2;

    public void exec(){
        System.out.println(Thread.currentThread().getName() + "等待");
       // synchronized (lock){
          System.out.println(Thread.currentThread().getName() + " exec 执行");
       // }
    }

    public void submit(){

    }

    public void getClient(){
        if(test == null){
            synchronized (lock){
                test = new Test();
                System.out.println(Thread.currentThread().getName()   + " 初始化");
            }
        }
    }

    @Override
    public void run() {
        getClient();
        exec();
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 1;i<=100;i++){
            Test test = new Test();
            test.setName("1 - " + i );
            test.start();
        }
        for (int i = 1;i<=100;i++){
            Test test = new Test();
            test.setName("2 - " + i);
            test.start();
        }
        countDownLatch.await();
        System.out.print(" 执行时间 : " + (System.currentTimeMillis() - start)+" ms");
    }

}

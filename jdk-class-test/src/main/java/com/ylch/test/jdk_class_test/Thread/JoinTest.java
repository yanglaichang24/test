package com.ylch.test.jdk_class_test.Thread;

/**
 * Created by yanglaichang1 on 2017/11/9.
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5*1000L);
                    System.out.println(Thread.currentThread().getName()+"  +++ done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("thread-son");
        thread.start();
        System.out.println(Thread.currentThread().getName()+" === join before");
        thread.join();
        System.out.println(Thread.currentThread().getName()+"%%%%  join after");
    }





}

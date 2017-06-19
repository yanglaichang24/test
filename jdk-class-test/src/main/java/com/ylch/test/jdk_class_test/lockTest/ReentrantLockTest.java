package com.ylch.test.jdk_class_test.lockTest;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanglaichang1 on 2017/5/9.
 */
public class ReentrantLockTest {

    @org.junit.Test
    public void test(){
        Lock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }

    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        Thread zhiboba = new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    System.out.println("ZHIBOBA");
                } finally {

                }
            }
        });

        zhiboba.setName("zhiboba");
        zhiboba.start();

        Thread.sleep(1000);

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("开始");
                    lock.lock();
                    System.out.println("3333333");
                } finally {
                    lock.unlock();
                }
            }
        });

        thread.setName("333");
        thread.start();

    }



}

package com.ylch.test.disruptors;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanglaichang1 on 2017/10/14.
 */
public class LockTest {

    ReentrantLock reentrantLock = new ReentrantLock();

    public volatile int i = 0;

    public void test(){
        i =i+1;
    }

    public void testLock(){
        try {
            reentrantLock.lock();
            i =i+1;
        } finally {
            reentrantLock.unlock();
        }
    }

    public synchronized void testlock(){
        i =i+1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LockTest lockTest = new LockTest();
        //for(;lockTest.i <100000000;){
        for(;lockTest.i <100000000;){
            //lockTest.test();
            //lockTest.testLock();
            lockTest.testlock();
        }
        System.out.println(lockTest.i+"===" +(System.currentTimeMillis() - start)+"ms");
    }

}

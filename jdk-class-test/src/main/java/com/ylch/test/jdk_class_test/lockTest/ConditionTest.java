package com.ylch.test.jdk_class_test.lockTest;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanglaichang1 on 2017/5/4.
 */
public class ConditionTest {

    public static void main(String[] args)
    {
        final BoundedBuffer q = new BoundedBuffer();

        new Thread(new Runnable() {
            public void run() {
                try {
                    q.put("1");
                    q.put("2");
                    q.put("3");
                    System.out.println(new Date() + "   --123");
                    q.put("4");
                    System.out.println(new Date() + " --- 4");

                    Thread.sleep(10000L);
                    q.put("5");
                    System.out.println(new Date() + "--- 5");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    while (true){
                        System.out.println("  take "+  new Date() + "--take--" +q.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    static  class BoundedBuffer {
        final Lock lock = new ReentrantLock();
        final Condition notFull  = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        final Object[] items = new Object[3];
        int putptr, takeptr, count;

        public void put(Object x) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length)
                    notFull.await();
                items[putptr] = x;
                if (++putptr == items.length) putptr = 0;
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0)
                    notEmpty.await();
                Object x = items[takeptr];
                if (++takeptr == items.length) takeptr = 0;
                --count;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }
        }
    }

}

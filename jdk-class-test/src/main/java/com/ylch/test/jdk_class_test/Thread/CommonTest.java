package com.ylch.test.jdk_class_test.Thread;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by yanglaichang1 on 2017/5/3.
 */
public class CommonTest {


    @Test
    public void test(){

       /* Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-6666----");
            }
        });
        thread.start();*/
        System.out.println(Integer.toBinaryString(-1 << (Integer.SIZE - 3)));

        System.out.println((-1 << (Integer.SIZE - 3)));





    }


    public static void main(String[] args) throws InterruptedException, IOException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                while (true){
                    System.out.println(Thread.currentThread().getName()+"-6666----");
                    Thread.sleep(5000L);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("ylc");

        System.out.println(thread.getState());

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(Thread.currentThread().getName() + "---" + t.getName() + "---" + t.getState()+" ---------- "+ e.getMessage());
            }
        });
        thread.start();

        System.out.println(thread.getState());

        thread.checkAccess();
        System.in.read();
        thread.interrupt();
        thread.join();

        while (true){
            System.out.println(thread.isAlive());
            System.out.println(thread.isInterrupted());
            System.out.println(thread.getState());
            Thread.sleep(1000L);
        }

    }

}

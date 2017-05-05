package com.ylch.test.jdk_class_test.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanglaichang1 on 2017/5/5.
 */
public class AtomicIntegerTest {

    public static void main(String[] args)
    {
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        new Thread(new Runnable() {
            public void run() {
                try { for(int i = 0;i<= 10;i++) {
                    System.out.println(Thread.currentThread().getName() +
                            " **** " + atomicInteger.incrementAndGet());
                    Thread.sleep(5000L);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                try { for(int i = 0;i<= 10;i++) {
                    System.out.println(Thread.currentThread().getName() +
                            " **** " + atomicInteger.incrementAndGet());
                        Thread.sleep(4000L);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                try { for(int i = 0;i<= 10;i++) {
                    System.out.println(Thread.currentThread().getName() +
                            " **** " + atomicInteger.incrementAndGet());
                    Thread.sleep(3000L);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try { for(int i = 0;i<= 10;i++) {
                    System.out.println(Thread.currentThread().getName() +
                            " **** " + atomicInteger.incrementAndGet());
                    Thread.sleep(2000L);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                try { for(int i = 0;i<= 10;i++) {
                    System.out.println(Thread.currentThread().getName() +
                            " **** " + atomicInteger.incrementAndGet());
                    Thread.sleep(1000L);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Test
    public void test(){

        int i = 1;
        int j = 3;
        int k = 5;

        i = j = k;

        System.out.println(i + " --- " + j + " --- " + k);




    }


}

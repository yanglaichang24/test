package com.ylch.test.jdk_class_test.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanglaichang1 on 2017/5/5.
 */
public class AtomicIntegerTest {

    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        new Thread(new Runnable() {
            public void run() {
                try { for(int i = 0;i<= 10;i++) {
                    System.out.println(Thread.currentThread().getName() +
                            " **** " + atomicInteger.get());
                    Thread.sleep(1000L);
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
                            " **** " + atomicInteger.get());
                    Thread.sleep(2000L);
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000L);
        atomicInteger.set(1000);

        /*new Thread(new Runnable() {
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
        */





    }

    @Test
    public void test(){

        int i = 1;
        int j = 3;
        int k = 5;

        i = j = k;

        System.out.println(i + " --- " + j + " --- " + k);
    }

    @Test
    public void test2(){
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.set(100);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());


    }


}

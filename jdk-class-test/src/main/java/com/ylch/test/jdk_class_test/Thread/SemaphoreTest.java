package com.ylch.test.jdk_class_test.Thread;

import java.util.concurrent.Semaphore;

/**
 * Created by yanglaichang1 on 2017/11/14.
 */
public class SemaphoreTest {

    public static void main(String[] args) {

    }


    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

package com.ylch.test.jdk_class_test.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanglaichang1 on 2017/5/3.
 */
public class ThreadPooExecutorTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService executorService = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


        final AtomicInteger atomicInteger = new AtomicInteger(0);

        final Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "    执行。。"  +  atomicInteger.incrementAndGet());
                    System.out.println(Thread.currentThread().isInterrupted() + "    执行。。");

                    if(atomicInteger.get() == 5){
                        System.out.println("异常");
                        throw new RuntimeException("2222");
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });

        thread.setName("ylch");

        ScheduledFuture<?> schedule = scheduledExecutorService.scheduleAtFixedRate(thread, 1, 1,TimeUnit.SECONDS);


       /* Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();*/

        Thread.sleep(1000 * 20);
        //
       /* thread.interrupt();
        thread.join();*/
       /* Object o = schedule.get();*/
        System.out.println("线程被中断");
        scheduledExecutorService.shutdown();

    }

}

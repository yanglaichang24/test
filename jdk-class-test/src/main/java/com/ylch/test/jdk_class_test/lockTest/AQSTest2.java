package com.ylch.test.jdk_class_test.lockTest;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by yanglaichang1 on 2017/11/8.
 */
public class AQSTest2 {

    int i ;
    private void test(){
        i++;
    }
    private int get(){
        return i;
    }


    private final Sync sync = new Sync();

    private void lock(){
        sync.acquire(1);
    }

    private void unlock(){
        sync.release(0);
    }

    static final class Sync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int acquires) {
            assert acquires == 1; // Otherwise unused
           if (compareAndSetState(0, 1)) {
              setExclusiveOwnerThread(Thread.currentThread());
               return true;
           }
            return false;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }




    public static void main(String[] args) throws InterruptedException {
        final AQSTest2 aqsTest2 = new AQSTest2();

        for(int i =0;i< 10000;i++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        aqsTest2.lock();
                        aqsTest2.test();
                    } finally {
                       aqsTest2.unlock();
                    }
                }
            });
            thread.start();
        }

       Thread.sleep(10000L);

        System.out.println("" + aqsTest2.get());

    }



}

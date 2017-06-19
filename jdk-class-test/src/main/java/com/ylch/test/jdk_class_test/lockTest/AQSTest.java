/*
package com.ylch.test.jdk_class_test.lockTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

*/
/**
 * Created by yanglaichang1 on 2017/5/10.
 *//*

public class AQSTest implements Lock, java.io.Serializable{

    public void lock() {

    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {

    }

    public Condition newCondition() {
        return null;
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        protected boolean isHeldExclusively() {
                return getState() == 1;
            }

            public boolean tryAcquire(int acquires) {
                assert acquires == 1; // Otherwise unused
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            }

            // Release the lock by setting state to zero
            protected boolean tryRelease(int releases) {
                assert releases == 1; // Otherwise unused
                if (getState() == 0) throw new IllegalMonitorStateException();
                setExclusiveOwnerThread(null);
                setState(0);
                return true;
            }

            // Provide a Condition
            Condition newCondition() { return new ConditionObject(); }

            // Deserialize properly
            private void readObject(ObjectInputStream s)
                    throws IOException, ClassNotFoundException {
                s.defaultReadObject();
                setState(0); // reset to unlocked state
            }
        }


    }



    public static void main(String[] args) {


    }

}
*/

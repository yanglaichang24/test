package com.ylch.test.jdk_class_test.queue;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanglaichang1 on 2017/5/4.
 *
 *
 * java.util 接口 Queue<E>
 *     类型参数：
 E - collection 中所保存元素的类型。
 所有超级接口：
 Collection<E>, Iterable<E>
 所有已知子接口：
 @See BlockingDeque<E>,
 @See BlockingQueue<E>,
 @See Deque<E>
 所有已知实现类：
 @See AbstractQueue,
 @See ArrayBlockingQueue,
 @See ArrayDeque,
 @See ConcurrentLinkedQueue,
 @See DelayQueue,
 @See LinkedBlockingDeque,
 @See LinkedBlockingQueue,
 @See LinkedList,
 @See PriorityBlockingQueue,
 @See PriorityQueue,
 @See SynchronousQueue

 ----------------------------------------
  \      抛出异常	|返回特殊值
 ----------------------------------------
 插入	add(e)	    offer(e)
 移除	remove()	poll()
 检查	element()	peek()
 *
 */
public class QueueTest {

    @Test
    public void blockingQueueAddTest() throws InterruptedException {
       BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
//*********************************************************************
        queue.add("11");
        System.out.println(queue.size());
        queue.add("22");
        queue.add("3");
        /**
         * java.lang.IllegalStateException: Queue full
         *  at java.util.AbstractQueue.add(AbstractQueue.java:98)
         */
//*********************************************************************
       /* boolean offer = queue.offer("11");
        System.out.println(offer);
        boolean offer1 = queue.offer("22");
        System.out.println(offer1);*/

        /*queue.offer("11",5, TimeUnit.SECONDS);
        System.out.println("done..");
        queue.offer("11",5, TimeUnit.SECONDS);
        System.out.println("done..");*/

//*********************************************************************
       /* queue.put("11");
        queue.put("22");*/
    }

    @Test
    public void testremove() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
//*********************************************************************
        boolean add = queue.add("22");
         queue.add("33");
         queue.add("44");
        String remove = queue.remove();
        String remove2 = queue.remove();

//*********************************************************************
        /*String poll = queue.poll();
        System.out.println(poll);

        String poll1 = queue.poll(5,TimeUnit.SECONDS);
        System.out.println(poll1);*/

//*********************************************************************
        /*String take = queue.take();
        System.out.println(take);*/
    }

    //@Test
    public void testCheck(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
//*********************************************************************
       // String element = queue.element();
//*********************************************************************
        String peek = queue.peek();
        System.out.println(peek);
    }

    public static void main(String[] args)
    {
        BlockingQueue q = new ArrayBlockingQueue(10);
        Producer p  = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }

    static class Producer implements Runnable {
        private final BlockingQueue queue;
        Producer(BlockingQueue q) {
            queue = q;
        }
        public void run() {
            try {
                int i = 0;
                while(true) {
                    if(i == 10){
                        break;
                    }
                    queue.put(i);
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
static class Consumer implements Runnable {
    private final BlockingQueue queue;
    Consumer(BlockingQueue q) {
        queue = q;
    }
    public void run() {
        try {
            while(true) {
                consume(queue.take());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void consume(Object x) {
        System.out.println("consume:"+x+" --- Thread :" +Thread.currentThread().getName());
    }

 }

    @Test
    public void test(){
        int i = 0;
        System.out.println("i++ ---" + i++);
        System.out.println("i ----"+ i);

        System.out.println("++i ---" + ++i);
        System.out.println("i ----" + i);
    }

    @Test
    public void test2(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        queue.remove();




    }


}

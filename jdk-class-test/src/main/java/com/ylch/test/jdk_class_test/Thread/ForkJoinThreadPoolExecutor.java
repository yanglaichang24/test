package com.ylch.test.jdk_class_test.Thread;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by yanglaichang1 on 2017/7/20.
 *
 * 1. 什么是Fork/Join框架
 Fork/Join框架是Java7提供了的一个用于并行执行任务的框架， 是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。
 我们再通过Fork和Join这两个单词来理解下Fork/Join框架，Fork就是把一个大任务切分为若干子任务并行的执行，Join就是合并这些子任务的执行结果，最后得到这个大任务的结果。比如计算1+2+。。＋10000，可以分割成10个子任务，每个子任务分别对1000个数进行求和，最终汇总这10个子任务的结果。Fork/Join的运行流程图如下：

 2. 工作窃取算法
 工作窃取（work-stealing）算法是指某个线程从其他队列里窃取任务来执行。工作窃取的运行流程图如下：
 那么为什么需要使用工作窃取算法呢？假如我们需要做一个比较大的任务，我们可以把这个任务分割为若干互不依赖的子任务，为了减少线程间的竞争，于是把这些子任务分别放到不同的队列里，并为每个队列创建一个单独的线程来执行队列里的任务，线程和队列一一对应，比如A线程负责处理A队列里的任务。但是有的线程会先把自己队列里的任务干完，而其他线程对应的队列里还有任务等待处理。干完活的线程与其等着，不如去帮其他线程干活，于是它就去其他线程的队列里窃取一个任务来执行。而在这时它们会访问同一个队列，所以为了减少窃取任务线程和被窃取任务线程之间的竞争，通常会使用双端队列，被窃取任务线程永远从双端队列的头部拿任务执行，而窃取任务的线程永远从双端队列的尾部拿任务执行。
 *
 */

public class ForkJoinThreadPoolExecutor {

    class Task extends RecursiveTask<Long>{

        long start;
        long end;

        public Task(long start,long end){
             this.start = start;
             this.end   = end;
        }

        @Override
        protected Long compute() {
            long sum=0;
            long s=start;
            long e=end;
            for(;s <= end; s++){
                sum+=s;
            }
            return sum;
            //可以继续进行fork/join
        }
    }

    @Test
    public void test01(){
        Task task = new ForkJoinThreadPoolExecutor().new Task(0, 500000);
        Task task2 = new ForkJoinThreadPoolExecutor().new Task(500000, 10000000);
        task.fork();
        task2.fork();
        System.out.println(task.join() + task2.join());
    }

    @Test
    public void test02(){
        long start = System.nanoTime();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Task task = new ForkJoinThreadPoolExecutor().new Task(0, 5000000);
        Task task2 = new ForkJoinThreadPoolExecutor().new Task(5000001, 10000000);
        Task task3 = new ForkJoinThreadPoolExecutor().new Task(10000001, 15000000);
        Task task4 = new ForkJoinThreadPoolExecutor().new Task(15000001, 20000000);
        Long invoke1 = forkJoinPool.invoke(task);
        Long invoke2 = forkJoinPool.invoke(task2);
        Long invoke3 = forkJoinPool.invoke(task3);
        Long invoke4 = forkJoinPool.invoke(task4);
        System.out.println( invoke1 + invoke2 +" 耗时:" + (System.nanoTime() - start));
    }

}

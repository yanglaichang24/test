package com.ylch.test.disruptors.traderinfo;

import com.lmax.disruptor.*;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by yanglaichang1 on 2018/2/1.
 */
public class RingbufferTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int BUFFER_SIZE=1024;
        int THREAD_NUMBERS=4;

        final RingBuffer<TraderInfo> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<TraderInfo>() {

            public TraderInfo newInstance() {
                return new TraderInfo();
            }
        }, BUFFER_SIZE,new YieldingWaitStrategy());

        ExecutorService executors = Executors.newFixedThreadPool(THREAD_NUMBERS);

        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        //创建消息处理器
        BatchEventProcessor<TraderInfo> transProcessor = new BatchEventProcessor<TraderInfo>(
                ringBuffer, sequenceBarrier, new TraderInfoHandler());

        //这一部的目的是让RingBuffer根据消费者的状态    如果只有一个消费者的情况可以省略
        ringBuffer.addGatingSequences(transProcessor.getSequence());

        //把消息处理器提交到线程池
        executors.submit(transProcessor);
        //如果存大多个消费者 那重复执行上面3行代码 把TradeTransactionInDBHandler换成其它消费者类


        Future<?> future=executors.submit(new Callable<Void>() {

            public Void call() throws Exception {
                long seq;
                for(int i=0;i<1000;i++){
                    seq=ringBuffer.next();//占个坑 --ringBuffer一个可用区块

                    ringBuffer.get(seq).setPrice(Math.random()*9999);//给这个区块放入 数据  如果此处不理解，想想RingBuffer的结构图

                    ringBuffer.publish(seq);//发布这个区块的数据使handler(consumer)可见
                }
                return null;
            }
        });
        future.get();//等待生产者结束
        Thread.sleep(1000);//等上1秒，等消费都处理完成
        transProcessor.halt();//通知事件(或者说消息)处理器 可以结束了（并不是马上结束!!!）
        executors.shutdown();//终止线程
    }

}

package com.ylch.test.disruptors.traderinfo;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by yanglaichang1 on 2018/2/1.
 */
public class RingbufferTest3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long beginTime=System.currentTimeMillis();

        int bufferSize=32;
        ExecutorService executor=Executors.newFixedThreadPool(4);
        //这个构造函数参数，相信你在了解上面2个demo之后就看下就明白了，不解释了~
        Disruptor<TraderInfo> disruptor=new Disruptor<TraderInfo>(new EventFactory<TraderInfo>() {
            public TraderInfo newInstance() {
                return new TraderInfo();
            }
        }, bufferSize, executor, ProducerType.SINGLE, new YieldingWaitStrategy());

        //使用disruptor创建消费者组C1,C2
        EventHandlerGroup<TraderInfo> handlerGroup=disruptor.handleEventsWith(new TraderInfoHandler());

        CleanEventHandler jmsConsumer=new CleanEventHandler();
        //声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
        handlerGroup.then(jmsConsumer);


        disruptor.start();//启动
        CountDownLatch latch=new CountDownLatch(1);
        //生产者准备
        executor.submit(new TradeTransactionPublisher(latch, disruptor));
        latch.await();//等待生产者完事.
        disruptor.shutdown();
        executor.shutdown();

        System.out.println("总耗时:"+(System.currentTimeMillis()-beginTime));
    }



    public static class TradeTransactionPublisher implements Runnable{
        Disruptor<TraderInfo> disruptor;
        private CountDownLatch latch;
        private int LOOP=100;//模拟一千万次交易的发生

        public TradeTransactionPublisher(CountDownLatch latch,Disruptor<TraderInfo> disruptor) {
            this.disruptor=disruptor;
            this.latch=latch;
        }

        public void run() {
            TradeTransactionEventTranslator tradeTransloator=new TradeTransactionEventTranslator(1+);
            for(int i=0;i<LOOP;i++){
                disruptor.publishEvent(tradeTransloator);
            }
            latch.countDown();
        }
    }


    static class TradeTransactionEventTranslator implements EventTranslator<TraderInfo>{

        String id;

        public TradeTransactionEventTranslator(String id){
            this.id = id;
        }

        private Random random=new Random();

        public void translateTo(TraderInfo event, long sequence) {
            this.generateTradeTransaction(event);
        }

        private TraderInfo generateTradeTransaction(TraderInfo trade){
            trade.setId(id);
            trade.setPrice(random.nextDouble()*9999);
            return trade;
        }
    }



}

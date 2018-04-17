package com.ylch.test.disruptors;

import com.lmax.disruptor.*;
import com.ylch.test.disruptors.traderinfo.TraderInfo;
import com.ylch.test.disruptors.traderinfo.TraderInfoHandler;

/**
 * Created by yanglaichang1 on 2018/2/1.
 */
public class RingbufferTest {

    public static void main(String[] args) throws InterruptedException, TimeoutException, AlertException {
        RingBuffer<MsgEvent> singleProducer = RingBuffer.createSingleProducer(new EventFactory<MsgEvent>() {
            public MsgEvent newInstance() {
                return new MsgEvent();
            }
        }, 32);
        for(int i = 0;i<100;i++){
            long sequence = singleProducer.next();
            try{
                final MsgEvent msgEvent = singleProducer.get(sequence);
                msgEvent.set("345324" + i);
            } finally {
                singleProducer.publish(sequence);
            }
        }



        BatchEventProcessor<MsgEvent> transProcessor = new BatchEventProcessor<MsgEvent>(
                singleProducer, singleProducer.newBarrier(), new EventHandler<MsgEvent>() {

            public void onEvent(MsgEvent event, long sequence, boolean endOfBatch) throws Exception {
                System.out.println(event+":"+sequence+":"+endOfBatch);
            }
        });

        new Thread(transProcessor).start();

        Thread.sleep(10000);

    }


    public static class MsgEvent{

        private String value;

        public void set(String value)
        {
            this.value = value;
        }

        public String get(){
            return value;
        }

        @Override
        public String toString() {
            return "MsgEvent{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }




}

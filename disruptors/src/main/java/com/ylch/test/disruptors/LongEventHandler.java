package com.ylch.test.disruptors;

import com.lmax.disruptor.EventHandler;

/**
 * Created by yanglaichang1 on 2017/10/11.
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event);
    }
}

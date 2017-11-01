package com.ylch.test.disruptors;

import com.lmax.disruptor.EventFactory;

/**
 * Created by yanglaichang1 on 2017/10/11.
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }

}

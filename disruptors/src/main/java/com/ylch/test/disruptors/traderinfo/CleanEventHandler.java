package com.ylch.test.disruptors.traderinfo;

import com.lmax.disruptor.EventHandler;

/**
 * Created by yanglaichang1 on 2018/2/2.
 */
public class CleanEventHandler implements EventHandler<TraderInfo> {


    public void onEvent(TraderInfo event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("清理数据");
        event.clean();
    }
}

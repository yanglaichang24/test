package com.ylch.test.disruptors.traderinfo;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.util.UUID;

/**
 * Created by yanglaichang1 on 2018/2/2.
 */
public class TraderInfoHandler implements EventHandler<TraderInfo>,WorkHandler<TraderInfo> {

    public void onEvent(TraderInfo event, long sequence, boolean endOfBatch) throws Exception {
       /* System.out.println("消费"  + Thread.currentThread().getName() + " " +
                ": " + event.getPrice() + " sequence :" + sequence +"endOfBatch : " + endOfBatch);*/
        this.onEvent(event);
    }

    public void onEvent(TraderInfo event) throws Exception {
        event.setId(UUID.randomUUID().toString());//简单生成下ID
        System.out.println("消费数据"  + Thread.currentThread().getName() + " : "+event.getId() +":"+ event.getPrice());
    }
}

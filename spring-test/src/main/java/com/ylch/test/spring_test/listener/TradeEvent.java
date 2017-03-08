package com.ylch.test.spring_test.listener;

import java.util.EventObject;

/**
 * Created by yanglaichang1 on 2017/3/1.
 */
public class TradeEvent extends EventObject{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TradeEvent(Object source) {
        super(source);
    }
}

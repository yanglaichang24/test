package com.ylch.test.spring_test.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by yanglaichang1 on 2017/3/1.
 */
public class HelloWorld implements ApplicationEventPublisherAware {

    private String word;
    private ApplicationEventPublisher tradeEventPublisher;

    public void setWord(String w){
        this.word = w;
    }

    public void say(){
        System.out.println("say : "+ this.word);
        TradeEvent tradeEvent = new TradeEvent(new String("tradeEvent"));
        this.tradeEventPublisher.publishEvent(tradeEvent);
    }


    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}

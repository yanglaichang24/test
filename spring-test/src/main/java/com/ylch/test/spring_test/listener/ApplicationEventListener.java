package com.ylch.test.spring_test.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * Created by yanglaichang1 on 2017/3/1.
 */
public class ApplicationEventListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent){//如果是容器关闭事件
            System.out.println(event.getClass().getSimpleName()+" 事件已发生！");
        }else  if(event instanceof ContextStartedEvent){
            System.out.println(event.getClass().getSimpleName()+" 事件已发生！");
        }else if(event instanceof ContextStoppedEvent){
            System.out.println(event.getClass().getSimpleName()+" 事件已发生！");
        }else{
            System.out.println("有其它事件发生:"+event.getClass().getName());
     }
        System.out.println(event.getTimestamp());
        event.getSource();

    }
}

package com.ylch.test.jdk_class_test.java.utils.Event;

/**
 * Created by yanglaichang1 on 2017/3/1.
 */
public class DoorListener2 implements DoorListener {

    public void doorEvent(DoorEvent event) {

        if(event.getDoorState()!=null&&event.getDoorState().equals("open"))
        {
            System.out.println("门2打开");
        }
        else
        {
            System.out.println("门2关闭");
        }
    }

    public void doorEvent(Object event) {

    }
}

package com.ylch.test.jdk_class_test.java.utils.Event;

import java.util.EventObject;

/**
 * Created by yanglaichang1 on 2017/3/1.
 */
public class DoorEvent extends EventObject {

    private String doorState = "";//表示门的状态，有“开”和“关”两种

    public DoorEvent(Object source, String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

}

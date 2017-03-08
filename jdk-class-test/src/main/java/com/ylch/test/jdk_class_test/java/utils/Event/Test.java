package com.ylch.test.jdk_class_test.java.utils.Event;

/**
 * Created by yanglaichang1 on 2017/3/1.
 */
public class Test {

    public static void main(String[] args) {
        DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener1());//给门1增加监听器
        manager.addDoorListener(new DoorListener2());//给门2增加监听器
        //开门
        manager.fireWorkspaceOpened();
        System.out.println("我已经进来了");
        //关门
        manager.fireWorkspaceClosed();



    }
}

package com.ylch.test.jdk_class_test.Thread;

/**
 * Created by yanglaichang1 on 2017/6/14.
 */
public class Task extends Thread{

    private volatile boolean open  = true;

    @Override
    public void run() {
       /* if(close();)*/

    }

    public void close(){

    }


}

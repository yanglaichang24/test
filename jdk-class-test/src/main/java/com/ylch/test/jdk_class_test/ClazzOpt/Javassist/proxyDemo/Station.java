package com.ylch.test.jdk_class_test.ClazzOpt.Javassist.proxyDemo;

/**
 * Created by yanglaichang1 on 2017/6/16.
 */
public class Station implements TicketService{

    public void sellTicket() {
        System.out.println("\n\t售票.....\n");
    }

    public void inquire() {
        System.out.println("\n\t问询。。。。\n");
    }

    public void withdraw() {
        System.out.println("\n\t退票......\n");
    }
}

package com.ylch.test.jdk_class_test.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yanglaichang1 on 2017/6/26.
 */
public class NioClientDemo {

    class NioClientHandler extends Thread {

        Selector seletor = null;

        NioClientHandler(){
            try {
                seletor= Selector.open();
                SocketChannel channel = SocketChannel.open();
                channel.configureBlocking(false);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        @Override
        public void run() {
            try {
                seletor.select(1000);
                Set<SelectionKey> selectionKeys = seletor.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

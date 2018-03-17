package com.ylch.test.jdk_class_test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yanglaichang1 on 2017/6/26.
 */
public class NioServerDemo {

    public static void main(String[] args) throws IOException {
        new NioServerDemo().new NioServerHandler().start();
    }

  class NioServerHandler extends Thread {

      Selector select;

      ServerSocketChannel channel;

      public NioServerHandler(){
          try {
              select = Selector.open();
              channel = ServerSocketChannel.open();
              channel.socket().bind(new InetSocketAddress("localhost",5334));
              channel.configureBlocking(false);
              channel.register(select, SelectionKey.OP_ACCEPT);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

      @Override
      public void run() {
        while (true){
             try {
                 execute();
             } catch (Exception e){
                e.printStackTrace();
             }
         }
          /*try {
              execute();
          } catch (IOException e) {
              e.printStackTrace();
          }*/
      }

      public void execute() throws IOException {
          select.select(5000);
          Set<SelectionKey> selectionKeys = select.selectedKeys();
          Iterator<SelectionKey> iterator =selectionKeys.iterator();
          SelectionKey selectkey = null;
          System.out.println(" point-001 selectionKeys：" + selectionKeys.size());
          while (iterator.hasNext()){
              selectkey= iterator.next();
              handler(selectkey,select);
          }
      }

    private void handler(SelectionKey key, Selector select) throws IOException {
       if(key.isValid()){
           if (key.isAcceptable()){
               ServerSocketChannel channel = (ServerSocketChannel)key.channel();
               SocketChannel accept = channel.accept();
               accept.configureBlocking(false);
               accept.register(select, SelectionKey.OP_READ);
           }

           if (key.isReadable()){
               System.out.println(" point-004 ");
               SocketChannel channel = (SocketChannel)key.channel();
               ByteBuffer allocate = ByteBuffer.allocate(1024);
               int read = channel.read(allocate);
               if (read > 0){
                  allocate.flip();
                  byte[] bytes = new byte[allocate.remaining()];
                  allocate.get(bytes);
                  System.out.println(new String(bytes));
                  doWrite(channel,"ok");
               }
           }
       }
    }

    private void  doWrite(SocketChannel channel,String resp) throws IOException {
        System.out.println(" point-005");
        byte[] bytes = resp.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(bytes);
        channel.write(allocate);
    }

  }


}

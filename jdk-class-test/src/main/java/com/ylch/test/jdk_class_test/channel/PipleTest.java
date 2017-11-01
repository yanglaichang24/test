package com.ylch.test.jdk_class_test.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Arrays;

/**
 * Created by yanglaichang1 on 2017/7/19.
 *
 * Java NIO 管道是2个线程之间的单向数据连接。
 * Pipe有一个source通道和一个sink通道。
 * 数据会被写到sink通道，
 * 从source通道读取。
 */
public class PipleTest {


    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        final Pipe.SinkChannel sink = pipe.sink();
        final Pipe.SourceChannel source = pipe.source();

        Thread thread = new Thread(new Runnable() {

            String resp = "Hello world !";

            public void run() {
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                allocate.put(resp.getBytes());
                try {
                    byte[] array = allocate.array();
                    //System.out.println("sink bute " + Arrays.toString(array));
                    sink.write(allocate);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {

            public void run() {
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                try {
                    source.read(allocate);

                    System.out.println("--------" + allocate.limit());
                    System.out.println("--------" + allocate.position());

                    byte[] array = allocate.array();

                    System.out.println(" ###source " + Arrays.toString(array));
                    byte[] bytes = new byte[allocate.remaining()];
                     allocate.get(bytes);
                    System.out.println("----------" + new String(bytes,"UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();
    }

}

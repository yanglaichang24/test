package com.ylch.test.jdk_class_test.channel;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yanglaichang1 on 2017/6/20.
 */
public class FileChannelTest {

    private static final String outputPath = "d:/test.txt";
    private static String data = "我爱中华人名共和国";

    @Test
    public void test() throws IOException {
        File inputFile = new File(outputPath);
        File outputFile = new File(outputPath);
        if(!inputFile.exists()) {
            inputFile.createNewFile();
        }
        if(!outputFile.exists()) {
            outputFile.createNewFile();
        }
        //实例化输入输出流，并且获取相对应的FileChannel实例
        FileInputStream fis = new FileInputStream(inputFile);
        FileChannel inputChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel outputChannel = fos.getChannel();

        //获取数据的字节数组
        byte[] outputBuffer = data.getBytes();
        //分配一个字节缓冲(这个类在下一篇中介绍)
        ByteBuffer obb = ByteBuffer.allocate(1024);
        //将字节数组读入字节缓冲中
        obb.put(outputBuffer);
        obb.flip();  //调用该方法表示开始读取字节缓冲中的数据，即limit=position,position=0
        //将字节写入文件中
        int n = outputChannel.write(obb);
        outputChannel.close();  //关闭通道
        System.out.println("output n is " + n);
        fos.close();  //关闭输出流

        //再分配一个字节缓冲
        ByteBuffer ibb = ByteBuffer.allocate(1024);
        //将数据从通道中读入字节缓冲中
        int in = inputChannel.read(ibb);
        //初始化一个字节数组，这个字节数组的长度不能大于这个字节缓冲的limit-position的长度，不然会抛出java.nio.BufferUnderflowException
        byte[] inputBuffer = new byte[ibb.position()];
        //准备从字节缓冲中读取数据
        ibb.flip();
        System.out.println("input n is " + in);
        //将数据读入字节数组中
        ibb.get(inputBuffer);

        System.out.println(new String(inputBuffer));
        inputChannel.close();
        fis.close();
    }


}

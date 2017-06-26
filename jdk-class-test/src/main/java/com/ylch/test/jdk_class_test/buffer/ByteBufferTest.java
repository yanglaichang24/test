package com.ylch.test.jdk_class_test.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * Created by yanglaichang1 on 2017/6/20.
 */
public class ByteBufferTest {

    @Test
    public void test() {
        byte[] inputBuffer = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer allocate = ByteBuffer.allocate(10);
        ByteBuffer byteBuffer = allocate.put(inputBuffer);

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.position(4);
        byteBuffer.limit(5);

        byte[] outBuffer = new byte[byteBuffer.remaining()];
        allocate.get(outBuffer);
        System.out.println(Arrays.toString(outBuffer));

    }

    @Test
    public void test2(){
        IntBuffer allocate = IntBuffer.allocate(1024);
    }


}

package com.ylch.test.jdk_class_test.atomic;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by yanglaichang1 on 2017/5/9.
 */
public class UnsafeTest {

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
        System.out.println(UNSAFE);


        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
        int byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);

        System.out.println(byteArrayBaseOffset);
        UNSAFE.putByte(data, byteArrayBaseOffset, (byte) 1);
        UNSAFE.putByte(data, byteArrayBaseOffset + 5, (byte) 5);
        System.out.println(Arrays.toString(data));

    }



}

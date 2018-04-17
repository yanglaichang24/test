package com.ylch.test.jdk_class_test.atomic;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by yanglaichang1 on 2017/5/9.
 */
public class UnsafeTest {

    private Integer id;

    private static Unsafe UNSAFE;

    static {
        Field theUnsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        theUnsafe.setAccessible(true);
        try {
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(UNSAFE);
    }


   /* private static final Unsafe THE_UNSAFE;

    static
    {
        try
        {
            final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>()
            {
                public Unsafe run() throws Exception
                {
                    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    return (Unsafe) theUnsafe.get(null);
                }
            };

            THE_UNSAFE = AccessController.doPrivileged(action);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }*/

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));

        int byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);

        System.out.println(byteArrayBaseOffset);

        UNSAFE.compareAndSwapObject(data,byteArrayBaseOffset,0,5);
        byte aByte = UNSAFE.getByte(data, byteArrayBaseOffset);

        System.out.println(aByte);


        //UNSAFE.putByte(data, byteArrayBaseOffset, (byte) 1);
       // UNSAFE.putByte(data, byteArrayBaseOffset + 5, (byte) 5);

       // System.out.println(Arrays.toString(data));
    }

    @Test
    public void test2(){
        String password = new String("l00k@myHor$e");
        String fake = new String(password.replaceAll(".", "?"));
        System.out.println(password); // l00k@myHor$e
        System.out.println(fake); // ????????????

       // UNSAFE.copyMemory(fake, 0L, null, toAddress(password), sizeOf(password));
        System.out.println(password); // ????????????
        System.out.println(fake);
    }


    @Test
    public void putGetTest() throws NoSuchFieldException {
        UnsafeTest unsafeTest = new UnsafeTest();
        long id = UNSAFE.objectFieldOffset(UnsafeTest.class.getDeclaredField("id"));
        UNSAFE.putObject(unsafeTest,id,new Integer(200));
        System.out.println(unsafeTest.getId());

        //UNSAFE



    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

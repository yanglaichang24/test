package com.ylch.test.jdk_class_test.bitoperation;

import org.junit.Test;

/**
 * Created by yanglaichang1 on 2017/11/15.
 */
public class BitTest {

    @Test
    public void test(){
        // 1、左移( << )
        // 0000 0000 0000 0000 0000 0000 0000 0101 然后左移2位后，低位补0：//
        // 0000 0000 0000 0000 0000 0000 0001 0100 换算成10进制为20
        System.out.println(5 << 2);// 运行结果是20
        //获取-5的补码 左移N位 求原码
        //-5 补码   11111111111111111111111111111011
        //-20 补码    11111111111111111111111111101100
        System.out.println(-5 << 2);//

        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-20));


     /*   Byte aByte = new Byte("00001000");
        System.out.println(aByte.byteValue());*/
    }


    @Test
    public void test2(){
        // 2、右移( >> ) 高位补符号位
        // 0000 0000 0000 0000 0000 0000 0000 0101 然后右移2位，高位补0：
        // 0000 0000 0000 0000 0000 0000 0000 0001

        // -10 补码   11111111111111111111111111110110
        // -3  补码 11111111111111111111111111111101
        System.out.println(10 >> 2);// 运行结果是2
        System.out.println(-10 >> 2);// 运行结果是-3

        System.out.println(30 >> 2);// 运行结果是7
        System.out.println(-30 >> 2);// 运行结果是-8

        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-3));
    }

    @Test
    public void test3(){
        // 3、无符号右移( >>> ) 高位补0
        // 例如 -5换算成二进制后为：0101 取反加1为1011
        // 1111 1111 1111 1111 1111 1111 1111 1011
        // 我们分别对5进行右移3位、 -5进行右移3位和无符号右移3位：

        //5 补码  0000 0000 0000 0000 0000 0000 0000 0101
        System.out.println(5 >>> 3);// 结果是0
        //-5 补码 11111111111111111111111111111011
        //        00011111111111111111111111111111
        System.out.println(-5 >>> 3);// 结果是536870911
        // 无符号优异位正数
        System.out.println(Integer.toBinaryString(536870911));
    }

    @Test
    public void test4(){
        // 4、位与( & )
        // 位与：第一个操作数的的第n位于第二个操作数的第n位如果都是1，
        // 那么结果的第n为也为1，否则为0
        System.out.println(5 & 3);// 结果为1
        System.out.println(4 & 1);// 结果为0
        System.out.println(100 & 35);// 结果为0

       /* System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(3));*/
    }

    @Test
    public void test5(){
        // 5、位或( | )
        // 第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
        System.out.println(5 | 3);// 结果为7
    }

    @Test
    public void test6(){
        // 6、位异或( ^ )
        // 第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
        System.out.println(5 ^ 3);//结果为6
    }

    @Test
    public void test7(){
        // 7、位非( ~ )
        // 操作数的第n位为1，那么结果的第n位为0，反之。
        System.out.println(~5);// 结果为-6
    }






}

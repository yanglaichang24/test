package com.ylch.test.jdk_class_test.Io;

import org.junit.Test;

/**
 *
 *  <p>
 *      位运算
 *  </p>
 * Created by yanglaichang1 on 2018/3/26.
 *
 */
public class BitOperateTest {


    /**
     * 左移
     */
    @Test
    public void leftTest(){
        System.out.println(5 << 2);//

        //2^2 + 2^0
        //2^4 + 2^2 = (2^2+2^0)*2^2


        System.out.println(5 << 3);//
        System.out.println(5 << 4);//
        System.out.println(7 << 2);//
        //口诀 x<<y = x*2的y次方 (为偶数)
        /**
         *   正数左移数据增大2^n倍
         *
         * */

        System.out.println(Integer.toHexString(-7));
        System.out.println("$$$"+Integer.toBinaryString(-7));
        //1111 1111 1111 1111 1111 1111 1111 1001
        //1111 1111 1111 1111 1111 1111 1110 0100

        // 补码运算||获取也是补码||根据补码获取原码
        //-28 1111 1111 1111 1111 1111 1111 1110 0100
        System.out.println("-28"+Integer.toBinaryString(-28));
        System.out.println(-7 << 2);//
    }

    /**
     *
     * 右移( >> ) 高位补符号位
     */
    @Test
    public void right(){
        System.out.println(20 >> 2);//5
        //* 0001 0100  2^4+2^2=(2^2+2^0)/2^2
        //* 0000 0101  2^2+2^0
        System.out.println(21 >> 2);//5  || 21/2^2
        System.out.println(22 >> 2);//5  || 22/2^2
        System.out.println(23 >> 2);//5  || 23/2^2

        System.out.println(20 >> 4);
        //* 0001 0100  2^4+2^2
        //  0000 0001

        System.out.println(28 >> 4); // 28/2^4
        System.out.println(27 >> 4); // 27/2^4

        System.out.println(27 >> 5);

        //公式; x>>y = x/2^y
        //System.out.println(Integer.toBinaryString(20));


        System.out.println(-20 >> 2);
    }

    /**
     *
     * // 3、无符号右移( >>> ) 高位补0
     *
     */
    @Test
    public void test3(){
        System.out.println(20 >>> 2); //
        System.out.println(21 >>> 2);
        //* 0001 0100
        System.out.println(-5 >>> 2);
    }

    /**
     *
     * // 4、位与( & )
     // 位与：
     第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
     */
    @Test
    public void test4(){

        System.out.println(5 & 3);// 结果为1
        // 0000 0101
        // 0000 0011
        // 0000 0001

        System.out.println(10 & 2);//



        System.out.println(4 & 1);// 结果为0
    }

    /**
     *  // 5、位或( | )
     //   第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
        System.out.println(5 | 3);// 结果为7
     *
     */
    @Test
    public void test5(){

    }

    /**
     *  	// 6、位异或( ^ )
     // 第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
     System.out.println(5 ^ 3);//结果为6
     *
     */

    @Test
    public void test6(){

    }


    /**
     *  	// 7、位非( ~ )
     // 操作数的第n位为1，那么结果的第n位为0，反之。
     System.out.println(~5);// 结果为-6
     *
     *
     * */
    @Test
   public void test7(){

   }





}

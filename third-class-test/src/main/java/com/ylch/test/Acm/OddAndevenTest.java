package com.ylch.test.acm;

import java.util.*;

/**
 * Created by yanglaichang1 on 2017/6/9.
 */
public class OddAndevenTest {
/**
 *
 *描述
 有一个整型偶数n(2<= n <=10000),你要做的是：先把1到n中的所有奇数从小到大输出，再把所有的偶数从小到大输出。
 输入
 第一行有一个整数i（2<=i<30)表示有 i 组测试数据；
 每组有一个整型偶数n。
 输出
 第一行输出所有的奇数
 第二行输出所有的偶数
 样例输入
 2
 10
 14
 样例输出
 1 3 5 7 9
 2 4 6 8 10

 1 3 5 7 9 11 13
 2 4 6 8 10 12 14
 *
 *
 */
public static void main(String[] args) {
    //System.currentTimeMillis();
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    split(b);
    split(c);
}

   public static void split(int odd){
       List<Integer> oddList   = new ArrayList<Integer>();
       List<Integer> devenList = new ArrayList<Integer>();
       boolean flag = true;
       for (;odd>0;odd--){
           if(flag){
               oddList.add(odd);
           }else {
               devenList.add(odd);
           }
           flag = !flag;
      }

       Collections.reverse(devenList);
       Collections.reverse(oddList);
       System.out.println(Arrays.toString(devenList.toArray()));
       System.out.println(Arrays.toString(oddList.toArray()));





   }







}

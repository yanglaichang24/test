package com.data.algorithm.sort;

/**
 * Created by yanglaichang1 on 2017/9/4.
 */
public class sortTest {

    public static void main(String[] args) {
        System.out.println(399/10);
        print(7653);
    }

    public static void print(int n){
        System.out.println("###"+n);
          if(n>=10)
              print(n/10);
        System.out.print(n % 10);

    }



}

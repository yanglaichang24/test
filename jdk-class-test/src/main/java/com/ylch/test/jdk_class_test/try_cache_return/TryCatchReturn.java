package com.ylch.test.jdk_class_test.try_cache_return;

import org.junit.Test;

/**
 * Created by yanglaichang1 on 2017/3/7.
 */
public class TryCatchReturn {


    @Test
    public void TryCatchReturn(){
        //System.out.println(TryCatchReturn.test());
        //System.out.println(TryCatchReturn.test1Stronger());
        System.out.println(TryCatchReturn.test1Stronger2());
       //System.out.println(TryCatchReturn.test1());
    }

    public static String test(){
        try {
            System.out.println(" try execute ...");
            return "try";
        } catch (Exception e){
            return "catch";
        } finally {
            System.out.println(" finally execute ...");
            //return "finally";
        }

        /**
         *    try execute ...
         *    finally execute ...
         *    try
         */
    }

    public static String test1Stronger(){
        String result = "";
        try {
            result = "try";
            return result;
        } catch (Exception e) {
            result = "catch";
            return result;
        } finally {
            result = "finally";
        }
    }

    public static String test1Stronger2(){
        String result = "";
        try {
            result = "try";
            System.out.println(result);
            return result;
        } catch (Exception e) {
            result = "catch";
            return result;
        } finally {
            System.out.println(result);
            result = "finally";
            System.out.println(result);
        }
    }




    public static String test1(){
        try {
            System.out.println("try{...}");
            return "try";
        } catch (Exception e) {
            System.out.println("catch{...}");
            return "catch";
        } finally {
            System.out.println("finally{...}");
            return "finally";
        }

        /**
         * try{...}
           finally{...}
           finally
         ，如果finally里面也有return语句，
         则try代码块中的return被屏蔽（不执行），即在try中遇到return的时候，会先执行finally里面的内容（包括finally里面的return语句）。
         *
         */
    }


}

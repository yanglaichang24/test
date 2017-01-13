package com.ylch.test.security;

import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanglaichang1 on 2017/1/9.
 */
public class Test {

    public static void main(String[] args) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //if(md instanceof MD5)
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

}

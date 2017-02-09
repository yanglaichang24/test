package com.ylch.test.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanglaichang1 on 2017/1/9.
 */
public class Test {

    public static void main(String[] args) {

        String username = "yyyyllcovkasnfoie";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(username.getBytes("utf-8"));
            BASE64Encoder en = new BASE64Encoder();
            String encode = en.encode(digest);
            //String s = new String(digest,"utf-8");
            System.out.println(encode);

            System.out.println(en.encode(username.getBytes("utf-8")));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}

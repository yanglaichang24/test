package com.ylch.test.jdk_class_test.serializable;

import java.io.*;

/**
 * Created by yanglaichang1 on 2017/7/24.
 */
public class JDKSerializale {

    public static final <T extends Serializable> byte[] serialize(T t){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos  = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(t);
            return bos.toByteArray();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(null != bos) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null != oos) oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static final <T> T unserialize(byte[] byts, Class<T> clazz){
        ObjectInputStream oit = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(byts);
        try {
            oit = new ObjectInputStream(bis);
            Object obj = oit.readObject();
            return (T)obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    if(oit != null) oit.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(null != bis) bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

}

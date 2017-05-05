package com.ylch.test.jdk_class_test.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yanglaichang1 on 2017/4/21.
 */
public class LinkedHashMapTest {

    @Test
    public void commontest(){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        for(int i =0; i<10; i++){
            map.put(i + "44444", "" + i);
            map2.put(i + "44444", "" + i);
        }

        for (String key : map.keySet()){
            System.out.println(key);
        }

        System.out.println("---------------------------------------------");

        for (String key : map2.keySet()){
            System.out.println(key);
        }

    }

    @Test
    public void testput(){
        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        for (int i =0; i<10; i++){
            map2.put(i + "44444", "" + i);
        }
    }

}

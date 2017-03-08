package com.ylch.test.jdk_class_test.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanglaichang1 on 2017/3/6.
 */
public class MapTest {

    @Test
    public void HashMapTest(){
        Map<String, Object> map = new HashMap<String, Object>();
        for(int i =0; i<1000; i++){
            map.put(i+"", "" + i);
        }
        System.out.println(map);


    }

}

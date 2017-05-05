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
        long l = System.nanoTime();
        //Map<String, Object> map = new HashMap<String, Object>((1 << 6) -1);
        Map<String, Object> map = new HashMap<String, Object>(16, 0.75f);
        for(int i =0; i<1000; i++){
              map.put(i + "44444", "" + i);
        }
        System.out.println("耗时：" + (System.nanoTime() - l));
    }

    @Test
    public void loadFactor(){

    }

    @Test
    public void get(){


    }

}

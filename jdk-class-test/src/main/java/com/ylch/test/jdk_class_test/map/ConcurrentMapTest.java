package com.ylch.test.jdk_class_test.map;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yanglaichang1 on 2017/11/10.
 */
public class ConcurrentMapTest {

    Map<String, Object> stringObjectMap = Collections.synchronizedMap(new HashMap<String, Object>());

    @Test
    public void test(){
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("ttt","ylc");
    }


}

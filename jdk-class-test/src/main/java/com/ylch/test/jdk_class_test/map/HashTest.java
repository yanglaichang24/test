package com.ylch.test.jdk_class_test.map;

import org.junit.Test;
import sun.misc.Hashing;
import sun.misc.VM;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanglaichang1 on 2017/4/20.
 */
public class HashTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void test(){
        Map<String, Object> map = new HashMap<String,Object>();

        for (int i = 0; i<100; i++){
            map.put("ee"+i,i);
        }
        //map.put("eee", "eeee");
        //map.put("eee","eeeee");
        //map.put("eee", null);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for(Map.Entry<String, Object> entry : entries){

        }
        System.out.println(map);
    }

    @Test
    public void test1(){
        int number = 16;
        System.out.println(MAXIMUM_CAPACITY);
        int a = number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;

        System.out.println(a);

        System.out.println(Integer.highestOneBit((number - 1) << 1));

        System.out.println(Integer.highestOneBit(30));

    }

    @Test
    public void test3(){
        System.out.println(VM.isBooted());
        int i = Hashing.randomHashSeed(this);
        int eee = Hashing.stringHash32("eee");

        //System.out.println(i);
        System.out.println(eee);

    }

    @Test
    public void test4(){
        int h = 0;
        Object k ="eee";

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        int i = h ^ (h >>> 7) ^ (h >>> 4);
        System.out.println(i);
    }

    @Test
    public void test5(){
        Object obj = "eee";
        int i = obj.hashCode() &
                ((1 << 4) - 1);
        System.out.println(i);

    }

}

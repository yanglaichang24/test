package com.ylch.test.jdk_class_test.collection;

import org.junit.Test;

import java.util.*;

/**
 * Created by yanglaichang1 on 2017/3/9.
 */
public class CollectionsSort {

    @Test
    public void sort(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("6");
        list.add("4");

        System.out.println(Arrays.toString(list.toArray()));
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));

    }

    @Test
    public void sor2(){
        List<TestDto> list = new ArrayList<TestDto>();
        TestDto testDto1 = new TestDto(4);
        TestDto testDt2  = new TestDto(6);
        TestDto testDt3  = new TestDto(1);
        TestDto testDt4  = new TestDto(3);
        TestDto testDt5  = new TestDto(2);

        list.add(testDto1);
        list.add(testDt2);
        list.add(testDt3);
        list.add(testDt4);
        list.add(testDt5);

        System.out.println(Arrays.toString(list.toArray()));
        Collections.sort(list);

       /* Collections.sort(list, new Comparator<TestDto>() {

            public int compare(TestDto o1, TestDto o2) {
                return 0;
            }
        });*/
        System.out.println(Arrays.toString(list.toArray()));
    }


}

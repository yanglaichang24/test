package com.ylch.test.jdk_class_test.java;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yanglaichang1 on 2017/12/12.
 */
public class TimeUnitTest {

    @Test
    public void test01() throws InterruptedException {

        TimeUnit.SECONDS.sleep(4);
    }

    @Test
    public void test02() throws InterruptedException {
        System.out.println(TimeUnit.SECONDS.convert(10000000,TimeUnit.NANOSECONDS));

        System.out.println(TimeUnit.HOURS.convert(3600, TimeUnit.SECONDS));
    }

}

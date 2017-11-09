package com.ylch.apache.commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yanglaichang1 on 2017/11/1.
 */
public class BeanUtilsTest {

    @Test
    public void test() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println(BeanUtils.describe(new Demo()));
    }


}

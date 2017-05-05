package com.ylch.test.jdk_class_test.hashcode_equal;

import org.junit.Test;

/**
 * Created by yanglaichang1 on 2017/4/20.
 */
public class HashCodeTest {

    @Test
    public void test(){
        System.out.println(this.hashCode());
        System.out.println(Integer.toHexString(this.hashCode()));
        System.out.println(this);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

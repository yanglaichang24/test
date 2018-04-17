package com.ylch.test.disruptors.traderinfo;

/**
 * Created by yanglaichang1 on 2018/2/2.
 */
public class ObjectEvent<T> {
    T val;
    void clear()
    {
        val = null;
    }

    @Override
    public String toString() {
        return "ObjectEvent{" +
                "val=" + val +
                '}';
    }
}

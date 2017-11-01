package com.ylch.test.jdk_class_test.serializable;

import java.io.Serializable;

/**
 * Created by yanglaichang1 on 2017/7/24.
 */
public class TestVo implements Serializable {

    private static final long serialVersionUID = 3356935690356235800L;

    private String name;
    private long   id;

    private String key;

    public TestVo(){}
    public TestVo(String name, long id){
        this.name = name;
        this.id   = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
       return name + ":" + id;
     }
}

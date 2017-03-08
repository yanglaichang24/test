package com.ylch.test.jdk_class_test;

import java.io.Serializable;

/**
 * Created by yanglaichang1 on 2017/3/8.
 */
public class TestDto implements Serializable {

    private long id;

    private String name;

    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

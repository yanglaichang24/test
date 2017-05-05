package com.ylch.test.jdk_class_test.collection;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanglaichang1 on 2017/3/8.
 */
public class TestDto implements Serializable,Comparable<TestDto> {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public TestDto(){}

    public TestDto(long id){
        this.id = id;
    }

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

    public int compareTo(TestDto o) {
       System.out.println(atomicInteger.incrementAndGet()+ " this.Id : " + this.id + "  o.id : " + o.id);
        if (this.id < o.getId()){
           return -1;
        } else if(o.getId() == this.id){
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "{ id : " + id
                + " name : " + name
                + " phone :" + phone
                + " } ";
    }
}

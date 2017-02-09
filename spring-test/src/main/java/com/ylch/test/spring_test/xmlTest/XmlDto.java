package com.ylch.test.spring_test.xmlTest;

import java.io.Serializable;

/**
 * Created by yanglaichang1 on 2017/1/19.
 */
public class XmlDto implements Serializable {

    private String name;

    private Long  telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}

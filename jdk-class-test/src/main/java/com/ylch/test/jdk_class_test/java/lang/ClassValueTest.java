package com.ylch.test.jdk_class_test.java.lang;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by yanglaichang1 on 2017/4/17.
 */
public class ClassValueTest {

    @Test
    public void test(){

        ClassValue<Class<? extends TestDomain>[]> classValue = new ClassValue<Class<? extends TestDomain>[]>() {
            @Override
            protected Class<? extends TestDomain>[] computeValue(Class<?> clazz) {
                final Set<Class<? extends TestDomain>> intfSet =
                        new LinkedHashSet<Class<? extends TestDomain>>();
                do {
                    for (Class<?> curInterface : clazz.getInterfaces()) {
                        if (curInterface != TestDomain.class /*&& TestDomain.class.isAssignableFrom(curInterface)*/) {
                            intfSet.add(curInterface.asSubclass(TestDomain.class));
                        }
                    }
                    clazz = clazz.getSuperclass();
                } while (clazz != null);

                return intfSet.toArray(new Class[intfSet.size()]);
            }
        };

        Class<? extends TestDomain>[] classes = classValue.get(Test1.class);
        for (Class clazz : classes){
            System.out.println(clazz.getName());
        }
        System.out.println(classes.length);
    }




}

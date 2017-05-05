package com.ylch.test.jdk_class_test.java.lang;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by yanglaichang1 on 2017/4/17.
 */
public class ModifierTest {

    private static final String field = "ee3e";

    @Test
    public void test() {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(Modifier.isPrivate(field.getModifiers()));
            System.out.println(Modifier.isFinal(field.getModifiers()));
            System.out.println(Modifier.isStatic(field.getModifiers()));
            System.out.println(Modifier.toString(field.getModifiers()));
        }
    }

    @Test
    public void test2() {
        Method[] declaredMethods = this.getClass().getDeclaredMethods();

        for (Method method : declaredMethods) {
            String name = method.getName();
            System.out.println(name);
            System.out.println(method.getModifiers());
            System.out.println(Modifier.isPublic(method.getModifiers()));
            System.out.println(Modifier.toString(method.getModifiers()));

            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations){
                Class<? extends Annotation> aClass = annotation.annotationType();
                System.out.println(aClass);
            }
        }
    }

    @Test
    public void test3() {
        Constructor<?>[] declaredConstructors = this.getClass().getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor.getName());
            System.out.println(constructor.getModifiers());
            System.out.println(Modifier.isPublic(constructor.getModifiers()));
            System.out.println(Modifier.toString(constructor.getModifiers()));
        }
    }

    @Test
    public void test4(){
        Annotation[] annotations = this.getClass().getAnnotations();
        for (Annotation annotation : annotations){
            Class<? extends Annotation> aClass = annotation.annotationType();
            System.out.println(aClass);
        }
        final Test annotation = this.getClass().getAnnotation(Test.class);
    }

}

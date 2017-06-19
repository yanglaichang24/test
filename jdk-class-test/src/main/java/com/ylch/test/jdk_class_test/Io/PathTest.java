package com.ylch.test.jdk_class_test.Io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by yanglaichang1 on 2017/6/5.
 */
public class PathTest {

    @Test
    public void test(){
        Path path = Paths.get("d:/A.java");

        //new FileInputStream()


    }

    public void fileTest(){
        File file = new File("d:/A.java");



        //file.
    }

}

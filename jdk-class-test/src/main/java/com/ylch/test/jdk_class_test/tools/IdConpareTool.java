package com.ylch.test.jdk_class_test.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanglaichang1 on 2017/10/25.
 */
public class IdConpareTool {


    public static void main(String[] args) throws FileNotFoundException {
        List<String> list1 = readFile("d:/log/312.txt");
        System.out.println("list1 size:" + list1.size());
        List<String> list2 = readFile("d:/log/316.txt");
        System.out.println("list2 size:" + list2.size());
        for(String str : list2){
            if(!list1.contains(str.trim())){
                System.out.println(str);
            }
        }

    }

    private static List<String> readFile(String fileName){
        List<String> list = new ArrayList<String>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                list.add(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }




}

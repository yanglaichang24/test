package com.ylch.test.jdk_class_test.Io;

import org.apache.tools.ant.util.StringUtils;
import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanglaichang1 on 2017/6/5.
 */
public class PathTest {

    @Test
    public void test() throws IOException {
        /*List<String> ids = getIds();*/
        List<String> strings = new ArrayList<String>();
        Path path = Paths.get("d:/test.txt");
        FileReader fileReader = new FileReader(path.toFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = "";
        int i = 0;
        while (null != s){
            s = bufferedReader.readLine();
            if("".equals(s) || null == s){
                continue;
            }
            try {
                String[] split = s.split(",");
              /*  System.out.println("---------------");*/
                String data = split[0];
                if("_index".equals(data)){
                   continue;
                }
                /*if(!"\"receivable_waybill_info\"".equals(data)){
                   *//*throw new RuntimeException("解析错误" + data);*//*
                }*/
                if("\"receivable_waybill_info\"".equals(data)){
                    String docId = split[3];
                    strings.add(docId);
                    i++;
                }

            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("$$$" + s);
                fileReader.close();
                bufferedReader.close();
                throw new RuntimeException(e);
            } catch (NullPointerException e){
                e.printStackTrace();
                System.out.print("@@@" + e);
            }
        }
        getIds(strings);
    }

   public void getIds(List<String> data) throws IOException {
       Path path = Paths.get("d:/test04.txt");
       FileReader fileReader = new FileReader(path.toFile());
       BufferedReader bufferedReader = new BufferedReader(fileReader);
       String s = "";
       int i = 0;
       while (null != s) {
           s = bufferedReader.readLine();
           if("".equals(s) || null == s){
               continue;
           }
           //System.out.println( (++i) + " --" + s );
           if(!data.contains("\""+s+"\"")){
               System.out.println(s);
           }
       }
   }


    @Test
    public void fileTest() throws IOException {
        File file = new File("d:/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        int read = 0;
        while (read != -1){
          System.out.println("1");
          read = bufferedInputStream.read(bytes);
        }
        System.out.println(new String(bytes,"UTF-8"));
    }


    @Test
    public void test3() throws IOException {
        Path path = Paths.get("d:/test.txt");
        FileReader fileReader = new FileReader(path.toFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int read = bufferedReader.read();
    }

    @Test
    public void test1443() throws IOException {
        Path path = Paths.get("d:/test1443.txt");
        FileReader fileReader = new FileReader(path.toFile());
        List<String> test1443 = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = "";
        while (null != s) {
            s = bufferedReader.readLine();
            if("".equals(s) || null == s){
                continue;
            }
            test1443.add(s);
        }
        bufferedReader.close();
        fileReader.close();
        System.out.println( " -------- " + test1443.size());


        Path path2 = Paths.get("d:/test1477.txt");
        FileReader fileReader2 = new FileReader(path2.toFile());
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        String s2 = "";
        int i = 1;
        while (null != s2) {
            s = bufferedReader2.readLine();
            if("".equals(s) || null == s){
                continue;
            }

            if(!test1443.contains(s)){
                System.out.println( i +"------ " + s);
                i++;
            }
        }
        fileReader2.close();
        bufferedReader2.close();
        System.out.println( "&&&&" + i);
    }

}

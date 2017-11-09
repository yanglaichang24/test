package com.ylch.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanglaichang1 on 2017/11/1.
 */
public class CsvServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = new HashMap<String, String>();

        for(int i= 0;i< 10;i++){
            map.put("t"+i,"title"+i);
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0; i < 3000; i++){
            Map<String, Object> data = new HashMap<String, Object>();
            for(int j= 0; j< 10; j++){
                if (j != 4){
                    data.put("t"+j,"我是");
                }
            }
            list.add(data);
        }

        String fn = "test.csv";

        CsvUtils.CSVTitle test = new CsvUtils.CSVTitle("test");
        test.putAll(map);
        long start = System.currentTimeMillis();
        CsvUtils.download(fn,test,list,resp);
        System.out.println((System.currentTimeMillis() - start));
    }
}

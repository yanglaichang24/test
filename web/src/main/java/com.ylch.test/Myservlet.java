package com.ylch.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * Created by yanglaichang1 on 2017/10/28.
 */
public class Myservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> map = new HashMap<String, String>();

        for(int i= 0;i< 20;i++){
            map.put("t"+i,"title"+i);
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<100;i++){
            Map<String, Object> data = new HashMap<String, Object>();
            for(int j= 0;j< 20;j++){
                data.put("t"+j,"我是中国人呢对阿里山东二"+j+"arewrvcqert"+i);
            }
            list.add(data);
        }

        BufferedWriter bfw = null;

        //设置文件后缀
        String fn = "test.csv";

        //设置响应
        setResponseHeader(response, fn);

        try {
            bfw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "GBK"));
            int length = map.values().size();

            //写入表头
            writeTitleOfCSV(map, bfw, length);

            //每页写入
            List<BulkInfo> bulkInfos = splitTask(2000, list.size());
            for(BulkInfo info : bulkInfos){
                writeCSVByPageII(bfw, map, list.subList(info.getFromIndex(),info.getToIndex()));
            }

            bfw.flush();
        } catch (Exception e) {
        } finally {
            closeBufferdWriter(bfw);
        }

    }


    private List<BulkInfo> splitTask(int size, int total){
        List<BulkInfo> bulkInfos = new ArrayList<BulkInfo>();
        int page = (total + size -1) / size;
        int fromIndex = 0;
        for (int i= 0; i < page; i++){
            int toIndex = fromIndex + size;
            if (toIndex > total) toIndex= total;
            bulkInfos.add(new BulkInfo(fromIndex, toIndex));
            fromIndex = toIndex;
        }
        return bulkInfos;
    }

    class BulkInfo {
        private int fromIndex;
        private int toIndex;

        public BulkInfo(int fromIndex,int toIndex){
            this.toIndex   = toIndex;
            this.fromIndex = fromIndex;
        }

        public int getFromIndex() {
            return fromIndex;
        }

        public void setFromIndex(int fromIndex) {
            this.fromIndex = fromIndex;
        }

        public int getToIndex() {
            return toIndex;
        }

        public void setToIndex(int toIndex) {
            this.toIndex = toIndex;
        }

        @Override
        public String toString() {
            return "\n" + "fromIndex:" + fromIndex +"\n"
                    + "toIndex:" + toIndex;
        }
    }


   /* public void writeTitleOfCSV(Map<String, String> map, BufferedWriter bfw, int length) throws IOException {
        int numtitle = 0;
        for (String value : map.values()) {
            numtitle++;
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            bfw.write(sb.toString());
            if (numtitle <= length) {
                bfw.write(",");
            }
        }
        bfw.newLine();
    }*/


    public void writeTitleOfCSV(Map<String, String> map, BufferedWriter bfw, int length) throws IOException {
        for (String value : map.values()) {
            StringBuffer sb = new StringBuffer();
            sb.append(value).append(",");
            bfw.write(sb.toString());
        }
        bfw.newLine();
    }


    public void closeBufferdWriter(BufferedWriter bfw) {
        try {
            if (bfw != null) {
                bfw.flush();
                bfw.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            response.setContentType("text/csv;charset=UTF-8");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void writeCSVByPageII(BufferedWriter bfw, Map<String, String> map, List list) {
        try {
            for (Object obj : list) {
                int numObj = 0;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    numObj++;
                    StringBuffer sb = null;
                    if (obj instanceof Map) {
                        Map _map = (Map) obj;
                        sb = new StringBuffer();
                        sb.append("\"");
                        Object value = _map.get(entry.getKey());
                        if (value != null) {
                           sb.append(String.valueOf(value));
                        }
                        sb.append("\"");
                    }
                    bfw.write(sb.toString());

                    if (numObj <= map.values().size()) {
                        bfw.write(",");
                    }
                }
                bfw.newLine();
            }
        } catch (Exception ex) {
        }
    }
}

package com.ylch.test;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *   <p>  csv 导出优化
 *       1.使用{@link org.apache.commons.lang.time.FastDateFormat}
 *         代替 {@link java.text.SimpleDateFormat
 *       2.{@link CSVTitle} 代替 以前的map，根据key 缓存TITLE 信息
 *       3.BeanUtils.descri() 对Bean 转化为map,直接获取key进行转化
 *   </p>
 *   Created by yanglaichang1 on 2017/10/28.
 */
public abstract class CsvUtils {

 /*   private static Logger LOG = LoggerFactory.getLogger(CsvUtils.class);*/
    public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");
    public static final Map<String, String> TITLE_CACHE = new ConcurrentHashMap<String, String>();
    public static final Map<String, String> TITLE_CACHE_ = new HashMap<String, String>();
    public static final Object lock = new Object();
    public static final String Separator = ",";

    public static final void download(String fileName, CSVTitle title, List list, HttpServletResponse response){

        BufferedWriter bfw = null;
        //设置文件后缀
        String fn = fileName + ISO_DATE_FORMAT.format(new Date()) + ".csv";
        setResponseHeader(response, fn);
        try {
            bfw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "GBK"));
            writeTitleOfCSV(title, bfw);
            List<BulkInfo> bulkInfos = splitTask(50000, list.size());
            for (BulkInfo info : bulkInfos){
                writeCSVByPageII(bfw, title, list.subList(info.getFromIndex(),info.getToIndex()));
            }
            bfw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            list = null;
            try {
                if (bfw != null) {
                    bfw.flush();
                    bfw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final static void writeTitleOfCSV(CSVTitle title, BufferedWriter bfw) throws IOException {
        String titleStr = TITLE_CACHE_.get(title.getKey());
        if(StringUtils.isBlank(titleStr)){
            StringBuffer sb = new StringBuffer();
            for (String value : title.values()) {
                sb.append(value).append(Separator);
            }
            bfw.write(sb.toString());
            synchronized (lock){
                TITLE_CACHE.put(title.getKey(), sb.toString());
            }
        } else{
            bfw.write(titleStr);
        }
        bfw.newLine();
    }

    public static final void writeCSVByPageII(BufferedWriter bfw, CSVTitle title, List list) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        for (Object data : list) {
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> entry : title.entrySet()) {
                Map detail;
                if (data instanceof Map){
                    detail = (Map) data;
                 } else {
                    detail = BeanUtils.describe(data);
                 }
                Object value = detail.get(entry.getKey());
                if (null != value) {
                    sb.append(value);
                }
                sb.append(Separator);
            }
            bfw.write(sb.toString());
            bfw.newLine();
        }
    }

    public static final void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            response.setContentType("text/csv;charset=UTF-8");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final List<BulkInfo> splitTask(int size, int total){
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

    static class BulkInfo {
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

   public static class CSVTitle extends HashMap<String,String>{

       private String key;

       public CSVTitle(String key){
           this.key = key;
       }

       public String getKey() {
           return key;
       }
   }

}

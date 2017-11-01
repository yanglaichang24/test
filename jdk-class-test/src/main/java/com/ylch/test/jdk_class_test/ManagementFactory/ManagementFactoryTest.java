package com.ylch.test.jdk_class_test.ManagementFactory;

import org.junit.Test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * Created by yanglaichang1 on 2017/4/27.
 */
public class ManagementFactoryTest {


    @Test
    public void test() throws InterruptedException {
        int i = 0;
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        while (true) {
            MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(heapMemoryUsage.getCommitted()/1024).append("--")
                    .append(heapMemoryUsage.getInit()/1024).append("---")
                    .append(heapMemoryUsage.getMax()/1024).append("----")
                    .append(heapMemoryUsage.getUsed()/1024);
            System.out.println(stringBuilder);
            Thread.sleep(5000);

            if(i == 5){
                new Object();
            }

            if(i== 10)break;

            i++;
        }

        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        int objectPendingFinalizationCount = memoryMXBean.getObjectPendingFinalizationCount();

    }

    @Test
    public void test2(){
        List<GarbageCollectorMXBean> garbageCollectorMXBeans
                = ManagementFactory.getGarbageCollectorMXBeans();

        for  (GarbageCollectorMXBean bean : garbageCollectorMXBeans){
               new StringBuilder();
            long collectionCount = bean.getCollectionCount();
        }

    }

}

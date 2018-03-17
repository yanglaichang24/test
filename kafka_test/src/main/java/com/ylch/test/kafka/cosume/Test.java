package com.ylch.test.kafka.cosume;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanglaichang1 on 2017/10/9.
 */
public class Test {

    public static void main(String[] args) {
            Properties props = new Properties();
            props.put("zookeeper.connect", "test01:2181");
            props.put("group.id", "test");
            props.put("zookeeper.session.timeout.ms", "60000");
            props.put("zookeeper.sync.time.ms", "200");
            props.put("auto.commit.interval.ms", "1000");
            props.put("auto.offset.reset", "smallest");
            props.put("auto.commit.enable", "false");
//          props.put("rebalance.max.retries", "5");
//          props.put("rebalance.backoff.ms", "15000");
            ConsumerConfig consumerConfig = new ConsumerConfig(props);
            ConsumerConnector javaConsumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
            Map hashMap = new HashMap();
            hashMap.put("test_topic",1);
            Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = javaConsumerConnector.createMessageStreams(hashMap);
            List<KafkaStream<byte[], byte[]>> streams = messageStreams.get("test_topic");

         ExecutorService executor =   Executors.newFixedThreadPool(1);
        for (final KafkaStream stream : streams) {
            executor.submit(new Thread() {
                @Override
                public void run() {
                    ConsumerIterator<byte[], byte[]> it = stream.iterator();
                    while (it.hasNext())
                        try {
                            MessageAndMetadata<byte[], byte[]> thisMetadata=it.next();
                            String jsonStr = new String(thisMetadata.message(),"utf-8") ;
                            System.out.println(Thread.currentThread().getName()+"==partion:"+thisMetadata.partition()+",offset:"+thisMetadata.offset());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            });
        }
            javaConsumerConnector.commitOffsets();
    }
}

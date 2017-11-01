package com.ylch.test.kafka.product;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by yanglaichang1 on 2017/10/9.
 */
public class Test {

    private static final String TOPIC = "test_topic"; //kafka创建的topic
    private static final String CONTENT = "This is a single message"; //要发送的内容
    private static final String BROKER_LIST = "test01:19092,test02:19092"; //broker的地址和端口
    private static final String SERIALIZER_CLASS = "kafka.serializer.StringEncoder"; // 序列化类


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("serializer.class", SERIALIZER_CLASS);
        props.put("metadata.broker.list", BROKER_LIST);
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);

      /*  KeyedMessage<String, String> message = new KeyedMessage<String, String>(TOPIC, CONTENT);
        producer.send(message);*/

        //Send multiple messages.
       List<KeyedMessage<String,String>> messages = new ArrayList<KeyedMessage<String, String>>();
        for (int i = 0; i < 100000; i++) {
            messages.add(new KeyedMessage<String, String>
                    (TOPIC, "Multiple message at a time. " + i));
        }
        producer.send(messages);

    }

}

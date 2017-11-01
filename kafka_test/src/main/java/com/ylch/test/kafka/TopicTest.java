package com.ylch.test.kafka;


import kafka.admin.TopicCommand;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created by yanglaichang1 on 2017/10/9.
 */

public class TopicTest {

    public static void main(String[] args) {
            String[] arrys = new String[6];
            arrys[0] = "--replication-factor";
            arrys[1] = "1";
            arrys[2] = "--partitions";
            arrys[3] = "1";
            arrys[4] = "--topic";
            arrys[5] = "EFGH";

            ZkClient client =  new ZkClient("192.168.8.222:2181", 30000, 30000);
            client.setZkSerializer(new ZKStringSerialize());   //一定要加上ZkSerializer

            TopicCommand.TopicCommandOptions opts = new TopicCommand.TopicCommandOptions(arrys);
            TopicCommand.createTopic(client, opts);


        }
}


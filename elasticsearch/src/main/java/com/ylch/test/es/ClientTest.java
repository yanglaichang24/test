package com.ylch.test.es;

import org.elasticsearch.action.admin.cluster.stats.ClusterStatsRequest;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanglaichang1 on 2017/11/3.
 */
public class ClientTest {

    public TransportClient getClient() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder().put("cluster.name", "yanglaichang").build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        InetSocketTransportAddress localhost = new InetSocketTransportAddress(InetAddress.getByName("localhost"), Integer.valueOf(9300));
        InetSocketTransportAddress test01 = new InetSocketTransportAddress(InetAddress.getByName("test01"), Integer.valueOf(9300));
        client.addTransportAddresses(localhost, test01);
        return client;
    }

    @Test
    public void testclient() throws UnknownHostException {
        TransportClient client = getClient();
        //ClusterStatsRequest clusterStatsRequest = new ClusterStatsRequest();
        //ClusterStatsResponse clusterStatsNodeResponses = client.admin().cluster().clusterStats(clusterStatsRequest).actionGet(5, TimeUnit.MINUTES);
        //System.out.println(clusterStatsNodeResponses);
    }


    @Test
    public void test() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder().put("cluster.name", "yanglaichang").build();

        //Settings settings = Settings.settingsBuilder().put("cluster.name", "goldshield").build();

        TransportClient client = TransportClient.builder().settings(settings).build();

        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), Integer.valueOf(9300)));

        ClusterStatsRequest clusterStatsRequest = new ClusterStatsRequest();
        ClusterStatsResponse clusterStatsNodeResponses = client.admin().cluster().clusterStats(clusterStatsRequest).actionGet(5, TimeUnit.MINUTES);
        //System.out.println(clusterStatsNodeResponses);
        client.connectedNodes();

        List<DiscoveryNode> discoveryNodes = client.listedNodes();

        for (DiscoveryNode node : discoveryNodes){
            //System.out.println(node.getAddress());
        }
    }

    @Test
    public void index() throws UnknownHostException {
        TransportClient client = getClient();
        Settings.Builder builder = Settings.settingsBuilder();
        boolean test = client.admin().indices().create(
                Requests.createIndexRequest("test2")

              ).actionGet(5, TimeUnit.MINUTES).isAcknowledged();
        System.out.println("test : "+test);

    }

    @Test
    public void mapping() throws UnknownHostException {
        TransportClient client = getClient();
        boolean test = client.admin().indices().putMapping(Requests.putMappingRequest("test").type("test").source("")).actionGet(5, TimeUnit.MINUTES).isAcknowledged();
        System.out.println("test : "+test);
    }

    @Test
    public void deleteIndex() throws UnknownHostException {
        TransportClient client = getClient();
        boolean test = client.admin().indices().delete(Requests.deleteIndexRequest("test")).actionGet(5, TimeUnit.MINUTES).isAcknowledged();
        System.out.println("test : "+test);
    }

    public TransportClient getClient2() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder().put("cluster.name", "goldshield").build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        InetSocketTransportAddress localhost = new InetSocketTransportAddress(InetAddress.getByName("192.168.159.61"), Integer.valueOf(9300));
        InetSocketTransportAddress test01 = new InetSocketTransportAddress(InetAddress.getByName("192.168.159.62"), Integer.valueOf(9300));
        client.addTransportAddresses(localhost, test01);
        return client;
    }


    @Test
    public void bulk() throws UnknownHostException {
        BulkProcessor build = BulkProcessor.builder(getClient2(), new BulkProcessor.Listener() {

            public void beforeBulk(long executionId, BulkRequest request) {
                //logger.info(");
            }

            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                System.out.println(response);
            }

            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {

            }
        })/*.setBulkActions(10)
                .setBulkSize(new ByteSizeValue(512, ByteSizeUnit.KB))
                .setFlushInterval(TimeValue.timeValueMillis(30000))
                .setConcurrentRequests(10)*/.build();

         for(int i =0;i< 100;i++){
             UpdateRequest request = getClient2().prepareUpdate("zd_blame_exp",
                     "zd_blame_exp", "VB41511200172-1520317897000")
                     .setDoc("dept_code","4447" + i)
                     .setDetectNoop(true)
                     .setDocAsUpsert(true)
                     .setRetryOnConflict(1)
                     .request();
             build.add(request);
         }
        build.flush();
    }

    @Test
    public  void  testof(){
        //Object test = null;
        Object test = "";
        if(test instanceof String){
            String tem = (String)test;
            System.out.println("$$" + tem);
        } else {
            System.out.println("22");
        }
    }








}

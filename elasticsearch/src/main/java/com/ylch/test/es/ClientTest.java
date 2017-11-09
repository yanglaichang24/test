package com.ylch.test.es;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsRequest;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
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
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), Integer.valueOf(9300)));
        return client;
    }

    @Test
    public void testclient() throws UnknownHostException {
        TransportClient client = getClient();
        ClusterStatsRequest clusterStatsRequest = new ClusterStatsRequest();
        ClusterStatsResponse clusterStatsNodeResponses = client.admin().cluster().clusterStats(clusterStatsRequest).actionGet(5, TimeUnit.MINUTES);
        System.out.println(clusterStatsNodeResponses);

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
        boolean test = client.admin().indices().create(Requests.createIndexRequest("test")).actionGet(5, TimeUnit.MINUTES).isAcknowledged();
        System.out.println("test : "+test);

    }



}

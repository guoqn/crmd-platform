package com.ffcs.crmd.platform.dubbo.client.curator2;

import org.I0Itec.zkclient.ZkClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.retry.RetryNTimes;

public class CuratorTest {
    public static void main(String[] args) {
        Builder builder = CuratorFrameworkFactory.builder()
            .connectString(args[0]).sessionTimeoutMs(120000)
            .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000)).connectionTimeoutMs(5000);
        CuratorFramework client = builder.build();
        client.start();
        try {
            System.out.println(client.checkExists().forPath("/dubbo"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        ZkClient client2 = new ZkClient(args[0]);
        System.out.println(client2.exists("/dubbo"));
        
    }
}

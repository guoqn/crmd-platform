package com.ffcs.crmd.platform.mq.impl;

import java.io.IOException;
import java.util.Properties;

import com.ffcs.crmd.platform.mq.ConsumerConfig;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.consumer.api.IPullConsumer;
import com.ffcs.crmd.platform.mq.consumer.impl.DefaultConsumer;
import com.ffcs.crmd.platform.mq.util.PropertiesUtil;

public class PullDefined {
    private IPullConsumer consumer;
    
    public void start() throws MqException {
        Properties properties = null;
        try {
            properties = PropertiesUtil.getInstance().load("crm-mq.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setAuthID(properties.getProperty("authID"));
        consumerConfig.setAuthPWD(properties.getProperty("authPWD"));
        consumerConfig.setNameSrv(properties.getProperty("namesrvAddr"));
        consumerConfig.setGroupName(properties.getProperty("consumer.group"));
        consumerConfig.setTopicName(properties.getProperty("topic"));
        consumer = new DefaultConsumer(consumerConfig);
        consumer.start();
    }
    
    public IPullConsumer getConsumer(){
        return consumer;
    }
    
    public void close() throws MqException {
        consumer.close();
    }
    
}

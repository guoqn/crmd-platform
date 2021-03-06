package com.ffcs.crmd.platform.mq.impl;

import java.io.IOException;
import java.util.Properties;

import com.ffcs.crmd.platform.mq.ConsumerConfig;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.consumer.api.IMessageListener;
import com.ffcs.crmd.platform.mq.consumer.impl.ListenerConsumerContainer;
import com.ffcs.crmd.platform.mq.listener.impl.ListenerOrderlyImpl;
import com.ffcs.crmd.platform.mq.util.PropertiesUtil;

public class PushContainerDefined {
    private ListenerConsumerContainer consumer;
    
    public void start() throws MqException{
        Properties properties = null;
        try {
            properties = PropertiesUtil.getInstance().load("crm-mq.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        IMessageListener messageListener =new ListenerOrderlyImpl();
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setAuthID(properties.getProperty("authID"));
        consumerConfig.setAuthPWD(properties.getProperty("authPWD"));
        consumerConfig.setNameSrv(properties.getProperty("namesrvAddr"));
        consumerConfig.setGroupName(properties.getProperty("consumer.group"));
        consumerConfig.setTopicName(properties.getProperty("topic"));
        consumerConfig.setMessageListener(messageListener);
        consumerConfig.setConsumeThreadMin(20);
        consumerConfig.setConsumerConn(2);
        consumer = new ListenerConsumerContainer(consumerConfig);
        consumer.start();
    }
    
    
    public void close() throws MqException{
        consumer.close();
    }
}

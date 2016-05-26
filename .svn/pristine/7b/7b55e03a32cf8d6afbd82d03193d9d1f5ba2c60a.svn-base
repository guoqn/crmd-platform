package com.ffcs.crmd.platform.mq.impl;

import java.io.IOException;
import java.util.Properties;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.ProducerConfig;
import com.ffcs.crmd.platform.mq.producer.api.IProducer;
import com.ffcs.crmd.platform.mq.producer.impl.OrderlyProducer;
import com.ffcs.crmd.platform.mq.util.PropertiesUtil;

public class ProducerOrderlyDefined {
    private IProducer producer;
    
    public void start() throws MqException {
        Properties properties = null;
        try {
            properties = PropertiesUtil.getInstance().load("crm-mq.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ProducerConfig producerConfig = new ProducerConfig();
        producerConfig.setAuthID(properties.getProperty("authID"));
        producerConfig.setAuthPWD(properties.getProperty("authPWD"));
        producerConfig.setNameSrv(properties.getProperty("namesrvAddr"));
        producerConfig.setGroupName(properties.getProperty("producer.group"));
        producerConfig.setTopicName(properties.getProperty("topic"));
        producer = new OrderlyProducer(producerConfig);
        producer.start();
    }
    
    public IProducer getProducer() {
        return producer;
    }
    
    public void close() throws MqException {
        producer.close();
    }
}

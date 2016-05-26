package com.ffcs.crmd.platform.mq;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 功能说明:消息中间的消息定义
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 下午3:04:11
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class MqMessage {
    
    /**
     * 消息Id
     */
    private String              msgId          = null;
    
    /**
     * 标签
     */
    private String              tags           = null;
    
    /**
     * key
     */
    private String              keys           = null;
    
    /**
     * 消息主体
     */
    private byte[]              body           = null;
    
    /**
     * 主题名称
     */
    private String              topicName      = null;
    
    /**
     * 队列名称
     */
    private String              queueName      = null;
    
    /**
     * 消息偏移量
     */
    private long                queueOffset    = 0;
    
    /**
     * 队列号
     */
    private int                 queueId        = 0;
    
    /**
     * 当前消息被某个订阅组重新消费了几次（订阅组之间独立计数）
     */
    private int                 reconsumeTimes = 0;
    
    /**
     * 消息最大偏移量(只有push,pull方式获取的消息才有值)
     */
    @SuppressWarnings("unused")
    private long                maxOffset      ;
    
    /**
     * broker名称
     */
    private String              brokerName;
    
    /**
     * 消息属性，都是系统属性，禁止应用设置
     */
    private Map<String, String> properties;
    
    public String getMsgId() {
        return msgId;
    }
    
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    
    public byte[] getBody() {
        return body;
    }
    
    public void setBody(byte[] body) {
        this.body = body;
    }
    
    public String getTags() {
        return tags;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
    }
    
    public String getKeys() {
        return keys;
    }
    
    public void setKeys(String keys) {
        this.keys = keys;
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    
    public String getQueueName() {
        return queueName;
    }
    
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
    
    public int getQueueId() {
        return queueId;
    }
    
    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }
    
    public int getReconsumeTimes() {
        return reconsumeTimes;
    }
    
    public void setReconsumeTimes(int reconsumeTimes) {
        this.reconsumeTimes = reconsumeTimes;
    }
    
    public long getQueueOffset() {
        return queueOffset;
    }
    
    public void setQueueOffset(long queueOffset) {
        this.queueOffset = queueOffset;
    }
    
    
    public String getBrokerName() {
        return brokerName;
    }
    
    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }
    
    public Map<String, String> getProperties() {
        return properties;
    }
    
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
    
    public long getMaxOffset() {
        if (null == this.properties) {
            this.properties = new HashMap<String, String>();
        }
        return Long.valueOf(properties.get("MAX_OFFSET"));
    }

    public void setMaxOffset(long maxOffset) {
        this.maxOffset = maxOffset;
    }

    @Override
    public String toString() {
        return msgId;
    }
}

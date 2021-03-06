package com.ffcs.crmd.platform.mq;

import com.ffcs.crmd.platform.mq.consumer.api.IMessageListener;

/**
 * 
 * 功能说明:消费者配置
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2016年1月19日 下午2:55:34
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class ConsumerConfig {
    
    /**
     * 名服务地址(必选)
     */
    private String           nameSrv              = null;
    
    /**
     * 消费组名(必选)
     */
    private String           groupName            = null;
    
    /**
     * 消费者者实例名(可选)
     */
    private String           instanceName         = null;
    
    /**
     * 主题(必选)
     */
    private String           topicName            = null;
    
    /**
     * 认证用户名(必选)
     */
    private String           authID               = null;
    
    /**
     * 认证密码(必选)
     */
    private String           authPWD              = null;
    
    /**
     * 批量消费数量[监听模式](可选)
     */
    private int              batchSize            = 1;
    
    /**
     * 单消费实例消费最小线程数[监听模式](可选)
     */
    private int              consumeThreadMin     = 100;
    
    /**
     * 内存中每个队列最多允许未消费的数量[监听模式](可选)
     */
    private int              memoryMaxMsgForQueue = 1000;
    
    /**
     * 容器初始化消费者实例个数[监听模式](可选)
     */
    private int              consumerConn         = 1;
    
    /**
     * 是否有序消费[监听模式](可选)
     */
    private boolean          orderly              = false;
    
    /**
     * 监听器[监听模式](必选)
     */
    private IMessageListener messageListener      = null;
    
    /**
     * 过滤标签表达式(可选)
     */
    private String           subExpression        = "*";
    
    public ConsumerConfig() {
        
    }
    
    public ConsumerConfig(String nameSrv, String groupName, String topicName, String authID,
        String authPWD, IMessageListener messageListener) {
        this.nameSrv = nameSrv;
        this.groupName = groupName;
        this.topicName = topicName;
        this.authID = authID;
        this.authPWD = authPWD;
        this.messageListener = messageListener;
    }
    
    public String getNameSrv() {
        return nameSrv;
    }
    
    public void setNameSrv(String nameSrv) {
        this.nameSrv = nameSrv;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getInstanceName() {
        return instanceName;
    }
    
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    
    public int getBatchSize() {
        return batchSize;
    }
    
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
    
    public String getAuthID() {
        return authID;
    }
    
    public void setAuthID(String authID) {
        this.authID = authID;
    }
    
    public String getAuthPWD() {
        return authPWD;
    }
    
    public void setAuthPWD(String authPWD) {
        this.authPWD = authPWD;
    }
    
    public int getConsumeThreadMin() {
        return consumeThreadMin;
    }
    
    public void setConsumeThreadMin(int consumeThreadMin) {
        this.consumeThreadMin = consumeThreadMin;
    }
    
    public boolean isOrderly() {
        return orderly;
    }
    
    public void setOrderly(boolean orderly) {
        this.orderly = orderly;
    }
    
    public IMessageListener getMessageListener() {
        return messageListener;
    }
    
    public void setMessageListener(IMessageListener messageListener) {
        this.messageListener = messageListener;
    }
    
    public int getConsumerConn() {
        return consumerConn;
    }
    
    public void setConsumerConn(int consumerConn) {
        this.consumerConn = consumerConn;
    }
    
    public String getSubExpression() {
        return subExpression;
    }
    
    public void setSubExpression(String subExpression) {
        this.subExpression = subExpression;
    }

    public int getMemoryMaxMsgForQueue() {
        return memoryMaxMsgForQueue;
    }

    public void setMemoryMaxMsgForQueue(int memoryMaxMsgForQueue) {
        this.memoryMaxMsgForQueue = memoryMaxMsgForQueue;
    }
    
    
}

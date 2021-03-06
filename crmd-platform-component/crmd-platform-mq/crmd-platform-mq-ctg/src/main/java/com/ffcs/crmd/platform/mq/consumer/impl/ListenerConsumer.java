package com.ffcs.crmd.platform.mq.consumer.impl;

import java.util.List;

import org.slf4j.Logger;

import com.alibaba.rocketmq.client.log.ClientLogger;
import com.ctg.mq.api.IMQAckHandler;
import com.ctg.mq.api.bean.MQResult;
import com.ctg.mq.api.exception.MQException;
import com.ctg.mq.api.impl.MQPushConsumerImpl;
import com.ctg.mq.api.listener.ConsumeListener;
import com.ffcs.crmd.platform.mq.ConsumeStatus;
import com.ffcs.crmd.platform.mq.ConsumerConfig;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.consumer.api.IMessageListener;
import com.ffcs.crmd.platform.mq.consumer.api.IPushConsumer;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:监听消费者
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2016年1月19日 下午2:53:13
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class ListenerConsumer extends AbstractConsumer implements IPushConsumer{
    
    /**
     * 日志
     */
    private final Logger             log                   = ClientLogger.getLog();
    
    /**
     * 消费者实例
     */
    private final MQPushConsumerImpl consumer;
    
    /**
     * 监听器
     */
    private IMessageListener         messageListener       = null;
    
    /**
     * 消费者连接结果
     */
    private int                      result                = -1;
    
    /**
     * 单消费实例消费最小线程数
     */
    private int                      consumeThreadMin      = 100;
    
    /**
     * 内存中每个队列最多允许未消费的数量
     */
    private int                      memoryMaxMsgForQueue  = 1000;
    
    /**
     * 批量消费数量
     */
    private int                      batchSize             = 1;
    
    /**
     * 是否有序消费
     */
    private boolean                  orderly               = false;
    
    public ListenerConsumer(){
        consumer = new MQPushConsumerImpl();
    }
    
    public ListenerConsumer(ConsumerConfig consumerConfig) throws MqException {
        consumer = new MQPushConsumerImpl();
        this.setNameSrv(consumerConfig.getNameSrv());
        this.setGroupName(consumerConfig.getGroupName());
        this.setTopicName(consumerConfig.getTopicName());
        this.setInstanceName(consumerConfig.getInstanceName());
        this.setBatchSize(consumerConfig.getBatchSize());
        this.setOrderly(consumerConfig.isOrderly());
        this.setConsumeThreadMin(consumerConfig.getConsumeThreadMin());
        this.setMemoryMaxMsgForQueue(consumerConfig.getMemoryMaxMsgForQueue());
        this.setAuthID(consumerConfig.getAuthID());
        this.setAuthPWD(consumerConfig.getAuthPWD());
        this.setMessageListener(consumerConfig.getMessageListener());
        this.setSubExpression(consumerConfig.getSubExpression());
    }
    
    /**
     * 
     * 功能说明:监听消费者初始化
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2015年8月29日
     *
     */
    @Override
    public void start() throws MqException {
        this.checkConfig();
        consumer.setAuthID(this.getAuthID());
        consumer.setAuthPWD(this.getAuthPWD());
        consumer.setBatchSize(this.getBatchSize());
        consumer.setNameSrvAddr(this.getNameSrv());
        consumer.setConsumerGroup(this.getGroupName());
        consumer.setInstanceName(this.getInstanceName());
        consumer.setConsumeThreadMin(this.getConsumeThreadMin());
        consumer.setConsumeThreadMax(this.getConsumeThreadMin());
        consumer.setConsumeOrderly(this.isOrderly());
        consumer.setPullThresholdForQueue(this.getMemoryMaxMsgForQueue());
        
        try {
            result = consumer.connect();
            if (result == 0) {
                if (this.isOrderly()) {
                    consumer.listenQueue(this.getTopicName(), this.getSubExpression(), new MqListenerOrderlyImpl(this.messageListener));
                } else {
                    consumer.listenTopic(this.getTopicName(), this.getSubExpression(), new MqListenerCurrentlyImpl(this.messageListener));
                }
                log.info("CrmLogger: Listen consumer[{}] start ok [{}]", consumer.getInstanceName());
            }
        } catch (MQException e) {
            log.warn("CrmLogger: Listen consumer[{}] start fail - exception[{}]", consumer.getInstanceName(), e.getMessage());
            throw new MqException(e);
        }
    }
    
    /**
     * 
     * 功能说明:监听消费者关闭
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2015年8月29日
     *
     */
    @Override
    public void close() throws MqException {
        try {
            consumer.close();
            log.info("CrmLogger: Listen consumer[{}] close ok", consumer.getInstanceName());
        } catch (MQException e) {
            log.warn("CrmLogger: Listen consumer[{}] close fail - exception[{}]", consumer.getInstanceName(), e);
            throw new MqException(e);
        }
    }
    
    
    /**
     * 
     * 功能说明:队列监听器内部类
     *
     * @author ZHONGFUHUA
     * 
     * @Date 2015年8月29日 下午3:53:28
     *
     * 版本号  |   作者   |  修改时间   |   修改内容
     *
     */
    class MqListenerCurrentlyImpl implements ConsumeListener {
        
        private final IMessageListener   messageListener;
        
        public MqListenerCurrentlyImpl(IMessageListener messageListener) {
            this.messageListener = messageListener;
        }
        
        @Override
        public void onMessage(List<MQResult> msgList, IMQAckHandler handler) {
            List<MqMessage> messageList = MessageUtil.rocketmq(msgList);
            ConsumeStatus retStatus = messageListener.onMessage(messageList);
            switch (retStatus) {
                case SUCCESS:
                    for(MQResult mqResult : msgList){
                        handler.ackMessageSuccessAsync(mqResult);
                    }
                    break;
                case FAIL:
                    for(MQResult mqResult : msgList){
                        handler.ackMessageRetryAsync(mqResult);
                    }
                    break;
            }
        }
    }
    
    /**
     * 
     * 功能说明:主题监听内部类
     *
     * @author ZHONGFUHUA
     * 
     * @Date 2015年8月29日 下午3:54:34
     *
     *
     * 版本号  |   作者   |  修改时间   |   修改内容
     *
     */
    class MqListenerOrderlyImpl implements ConsumeListener {
        
        private final IMessageListener   messageListener ;
        
        public MqListenerOrderlyImpl(IMessageListener messageListener) {
            this.messageListener = messageListener;
        }
        
        @Override
        public void onMessage(List<MQResult> msgList, IMQAckHandler handler) {
            List<MqMessage> messageList = MessageUtil.rocketmq(msgList);
            ConsumeStatus retStatus = messageListener.onMessage(messageList);
            switch (retStatus) {
                case SUCCESS:
                    for(MQResult mqResult : msgList){
                        handler.ackMessageSuccessAsync(mqResult);
                    }
                    break;
                case FAIL:
                    for(MQResult mqResult : msgList){
                        handler.ackMessageRetryAsync(mqResult);
                    }
                    break;
            }
        }
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
    
    public void setMessageListener(IMessageListener messageListener) throws MqException {
        if (messageListener == null) {
            throw new MqException("监听器实例不能为空");
        }
        this.messageListener = messageListener;
    }
    
    public int getBatchSize() {
        return batchSize;
    }
    
    public void setBatchSize(int batchSize) throws MqException {
        if (batchSize < 1) {
            throw new MqException("批量消费条数不能小于1");
        }
        this.batchSize = batchSize;
    }
    
    public int getConsumeThreadMin() {
        return consumeThreadMin;
    }
    
    public void setConsumeThreadMin(int consumeThreadMin) throws MqException {
        if (consumeThreadMin < 20) {
            throw new MqException("消费实例消费线程数不能小于20");
        }
        this.consumeThreadMin = consumeThreadMin;
    }
    
    public int getMemoryMaxMsgForQueue() {
        return memoryMaxMsgForQueue;
    }

    public void setMemoryMaxMsgForQueue(int memoryMaxMsgForQueue) throws MqException {
        if (memoryMaxMsgForQueue < 1) {
            throw new MqException("内存中每个队列最多允许未消费的数量不能小余1");
        }
        this.memoryMaxMsgForQueue = memoryMaxMsgForQueue;
    }
    
}

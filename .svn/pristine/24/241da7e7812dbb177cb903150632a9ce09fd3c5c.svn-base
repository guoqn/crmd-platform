package com.ffcs.crmd.platform.mq.consumer.impl;

import java.util.List;

import org.slf4j.Logger;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.log.ClientLogger;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.ffcs.crmd.platform.mq.ConsumeStatus;
import com.ffcs.crmd.platform.mq.ConsumerConfig;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.consumer.api.IMessageListener;
import com.ffcs.crmd.platform.mq.consumer.api.IPushConsumer;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:RocketMq基本消费者监听
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 上午11:54:08
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class ListenerConsumer extends AbstractConsumer implements IPushConsumer {
    
    /**
     * 日志
     */
    private final Logger          log                  = ClientLogger.getLog();
    
    /**
     * 消费者实例
     */
    private DefaultMQPushConsumer consumer             = null;
    
    /**
     * 监听器
     */
    private IMessageListener      messageListener      = null;
    
    /**
     * 单消费实例消费最小线程数
     */
    private int                   consumeThreadMin     = 100;
    
    /**
     * 内存中每个队列最多允许未消费的数量
     */
    private int                   memoryMaxMsgForQueue = 1000;
    
    /**
     * 批量消费数量
     */
    private int                   batchSize            = 1;
    
    /**
     * 是否有序消费
     */
    private boolean               orderly              = false;
    
    public ListenerConsumer() {
        consumer = new DefaultMQPushConsumer();
    }
    
    public ListenerConsumer(ConsumerConfig consumerConfig) throws MqException {
        consumer = new DefaultMQPushConsumer();
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
     * 功能说明:启动消费者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public void start() throws MqException {
        this.checkConfig();
        try {
            consumer.setNamesrvAddr(this.getNameSrv());
            consumer.subscribe(this.getTopicName(), this.getSubExpression());
            consumer.setConsumerGroup(this.getGroupName());
            consumer.setInstanceName(this.getInstanceName());
            consumer.setConsumeThreadMin(this.getConsumeThreadMin());
            consumer.setConsumeThreadMax(this.getConsumeThreadMin());
            consumer.setConsumeMessageBatchMaxSize(this.getBatchSize());
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.setPullThresholdForQueue(this.getMemoryMaxMsgForQueue());
            
            // 监听器类型
            if (this.isOrderly()) {
                consumer.registerMessageListener(new OrderMessageListener(this.messageListener));
            } else {
                consumer.registerMessageListener(new DefualtMessageListener(this.messageListener));
            }
            consumer.start();
            log.info("CrmLogger: Listen consumer[{}] start ok [{}]", consumer.getInstanceName());
        } catch (MQClientException e) {
            log.warn("CrmLogger: Listen consumer[{}] start fail - exception[{}]",
                consumer.getInstanceName(), e.getMessage());
            throw new MqException(e);
        }
    }
    
    /**
     * 
     * 功能说明:关闭生产者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public void close() {
        consumer.shutdown();
        log.info("CrmLogger: Listen consumer[{}] close ok", consumer.getInstanceName());
    }
    
    /**
     * 
     * 功能说明:有序的监听器
     *
     * @author ZHONGFUHUA
     * 
     * @Date 2015年10月30日 上午11:54:31
     *
     *
     * 版本号  |   作者   |  修改时间   |   修改内容
     *
     */
    protected class OrderMessageListener implements MessageListenerOrderly {
        private IMessageListener messageListener;
        
        public OrderMessageListener(IMessageListener messageListener) {
            this.messageListener = messageListener;
        }
        
        @Override
        public ConsumeOrderlyStatus consumeMessage(List<MessageExt> paramList,
            ConsumeOrderlyContext OrderlyContext) {
            List<MqMessage> messageList = MessageUtil.rocketmq(paramList);
            try {
                ConsumeStatus status = messageListener.onMessage(messageList);
                switch (status) {
                    case SUCCESS:
                        return ConsumeOrderlyStatus.SUCCESS;
                    case FAIL:
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                    default:
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                log.warn("CrmLogger: Message listen consumer exception [{}], quque[{}], msgId{}",
                    ex.getMessage(), OrderlyContext.getMessageQueue(), messageList);
                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
        }
        
    }
    
    /**
     * 
     * 功能说明:默认监听器,并发监听
     *
     * @author ZHONGFUHUA
     * 
     * @Date 2015年10月30日 上午11:54:42
     *
     *
     * 版本号  |   作者   |  修改时间   |   修改内容
     *
     */
    protected class DefualtMessageListener implements MessageListenerConcurrently {
        private IMessageListener messageListener;
        
        public DefualtMessageListener(IMessageListener messageListener) {
            this.messageListener = messageListener;
        }
        
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> paramList,
            ConsumeConcurrentlyContext concurrentlyContext) {
            List<MqMessage> messageList = MessageUtil.rocketmq(paramList);
            try {
                ConsumeStatus status = messageListener.onMessage(messageList);
                switch (status) {
                    case SUCCESS:
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    case FAIL:
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    default:
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                log.warn("CrmLogger: Message listen consumer exception [{}], quque[{}], msgId{}",
                    ex.getMessage(), concurrentlyContext.getMessageQueue(), messageList);
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
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

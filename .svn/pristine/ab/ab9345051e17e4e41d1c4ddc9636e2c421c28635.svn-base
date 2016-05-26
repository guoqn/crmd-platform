package com.ffcs.crmd.platform.mq.producer.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.log.ClientLogger;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.ProdResult;
import com.ffcs.crmd.platform.mq.ProducerConfig;
import com.ffcs.crmd.platform.mq.producer.selector.impl.SimpleQueueSelector;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:无序生产者
 *
 * @author CHENZHI
 * 
 * @Date 2015年10月30日 下午2:57:23
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class DefaultProducer extends AbstractProducer {
    
    /**
     * 日志
     */
    private final Logger              log            = ClientLogger.getLog();
    
    /**
     * 选择器
     */
    private final SimpleQueueSelector simpleSelector = new SimpleQueueSelector();
    
    /**
     * 生产者实例
     */
    private DefaultMQProducer         producer       = null;
    
    public DefaultProducer() {
        this.producer = new DefaultMQProducer();
    }
    
    public DefaultProducer(ProducerConfig producerConfig) throws MqException {
        this.producer = new DefaultMQProducer();
        this.setNameSrv(producerConfig.getNameSrv());
        this.setGroupName(producerConfig.getGroupName());
        this.setTopicName(producerConfig.getTopicName());
        this.setInstanceName(producerConfig.getInstanceName());
        this.setMaxMessageSize(producerConfig.getMaxMessageSize());
        this.setMaxRetryTimes(producerConfig.getMaxRetryTimes());
        this.setCompressMsgOver(producerConfig.getCompressMsgOver());
        this.setSendTimeOut(producerConfig.getSendTimeOut());
        this.setAuthID(producerConfig.getAuthID());
        this.setAuthPWD(producerConfig.getAuthPWD());
    }
    
    /**
     * 
     * 功能说明:生产者启动
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public void start() throws MqException {
        this.checkConfig();
        try {
            producer.setProducerGroup(this.getGroupName());
            producer.setNamesrvAddr(this.getNameSrv());
            producer.setInstanceName(this.getInstanceName());
            producer.setMaxMessageSize(this.getMaxMessageSize());
            producer.setSendMsgTimeout(this.getSendTimeOut());
            producer.start();
            log.info("CrmLogger: DisOrderly producer[{}] start success", producer.getInstanceName());
        } catch (MQClientException e) {
            log.warn("CrmLogger: DisOrderly producer[{}] start fail {}", producer.getInstanceName(), e);
            throw new MqException(e.getMessage(), e.getCause());
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
        producer.shutdown();
        log.info("CrmLogger: DisOrderly producer[{}] close success", producer.getInstanceName());
    }
    
    /**
     * 
     * 功能说明:发送消息,无序模式
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public ProdResult send(byte[] msg, String tag, String key) throws MqException {
        if (StringUtils.isBlank(this.getTopicName())) {
            throw new MqException("topic不能为空!");
        }
        
        if (msg == null || msg.length == 0) {
            throw new MqException("消息内容不能为空!");
        }
        
        Message message = new Message();
        message.setTopic(this.getTopicName());
        message.setBody(msg);
        message.setTags(tag);
        message.setKeys(key);
        
        try {
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object param) {
                    int index = simpleSelector.onSelect(MessageUtil.rocketmq(msg), mqs.size(), param);
                    return mqs.get(index);
                }
            }, null);
            return MessageUtil.rocketmq(sendResult);
        } catch (Exception e) {
            log.warn("CrmLogger: DisOrderly producer[{}] send message exception {}", producer.getInstanceName(), e);
            return MessageUtil.rocketmq(e);
        }
    }

    
}

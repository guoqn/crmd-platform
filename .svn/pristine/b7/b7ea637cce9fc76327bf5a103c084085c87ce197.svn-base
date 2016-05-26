package com.ffcs.crmd.platform.mq.producer.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import com.alibaba.rocketmq.client.log.ClientLogger;
import com.ctg.mq.api.bean.MQMessage;
import com.ctg.mq.api.bean.MQSendResult;
import com.ctg.mq.api.exception.MQException;
import com.ctg.mq.api.exception.MQProducerException;
import com.ctg.mq.api.impl.MQProducerImpl;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.ProdResult;
import com.ffcs.crmd.platform.mq.ProducerConfig;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:无序生产者
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 下午2:58:12
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class DefaultProducer extends AbstractProducer {
    
    /**
     * 日志
     */
    private final Logger   log      = ClientLogger.getLog();
    
    /**
     * 生产者实例
     */
    private MQProducerImpl producer = null;
    
    /**
     * 生产者连接结果
     */
    private int            result   = -1;
    
    public DefaultProducer() {
        this.producer = new MQProducerImpl();
    }
    
    public DefaultProducer(ProducerConfig producerConfig) throws MqException {
        this.producer = new MQProducerImpl();
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
     * @throws MqException 
     * 
     * @Date 2015年10月30日
     *
     */
    @Override
    public void start() throws MqException {
        this.checkConfig();
        try {
            producer.setAuthID(this.getAuthID());
            producer.setAuthPWD(this.getAuthPWD());
            producer.setNameSrvAddr(this.getNameSrv());
            producer.setProducerGroup(this.getGroupName());
            producer.setInstanceName(this.getInstanceName());
            producer.setSendMsgTimeout(this.getSendTimeOut());
            producer.setMaxMessageSize(this.getMaxMessageSize());
            producer.setMaxRetryTimes(this.getMaxRetryTimes());
            producer.setCompressMsgBodyOverHowmuch(this.getCompressMsgOver());
            producer.setSetNotWriteableWhenStoreNotOk(this.isNotWriteWhenStoreNotOk());
            result = producer.connect();
            if (result == 0) {
                log.info("CrmLogger: DisOrderly producer[{}] start success", producer.getInstanceName());
            } else {
                throw new MqException("DisOrderly producer start fail");
            }
        } catch (MQException e) {
            log.warn("CrmLogger: DisOrderly producer[{}] start fail {}", producer.getInstanceName(), e);
            throw new MqException(e);
        }
    }
    
    /**
     * 
     * 功能说明:关闭生产者
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2016年1月19日
     *
     */
    @Override
    public void close(){
        try {
            this.producer.close();
            log.info("CrmLogger: DisOrderly producer[{}] close success", producer.getInstanceName());
        } catch (MQException e) {
            log.warn("CrmLogger: DisOrderly producer[{}] close fail {}", producer.getInstanceName(), e);
        }
    }
    
    /**
     * 
     * 功能说明:发送消息
     * 
     * @param msg
     *      消息内容
     * @param tag
     *      标签
     * @param key
     *      标识
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2015年8月28日
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
        
        MQMessage message = new MQMessage();
        message.setSourceName(this.getTopicName());
        message.setBody(msg);
        message.setTag(tag);
        message.setKey(key);
        try {
            MQSendResult result = producer.send(message);
            return MessageUtil.rocketmq(result, message);
        } catch (MQProducerException e) {
            log.warn("CrmLogger: DisOrderly producer[{}] send message exception {}",producer.getInstanceName(), e);
            return MessageUtil.rocketmq(e, message);
        }
    }
    
}

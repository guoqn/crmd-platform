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
 * 功能说明:有序生产者
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 下午2:58:01
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class OrderlyProducer extends AbstractProducer {
    
    /**
     * 日志
     */
    private static final Logger log      = ClientLogger.getLog();
    
    /**
     * 生产者实例
     */
    MQProducerImpl              producer = null;
    
    /**
     * 生产者连接结果
     */
    private int                 result   = -1;
    
    public OrderlyProducer(){
        
    }
    
    public OrderlyProducer(ProducerConfig producerConfig) throws MqException {
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
        if (producer == null) {
            this.checkConfig();
            producer = new MQProducerImpl();
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
            
            try {
                result = producer.connect();
                if (result == 0) {
                    log.info("CrmLogger: Orderly producer start success [{}]", producer.getInstanceName());
                }
            } catch (MQException e) {
                log.warn("CrmLogger: Orderly producer start fail  {} [{}]", producer.getInstanceName(),
                    e.getMessage());
                throw new MqException(e.getMessage(), e.getCause());
            }
        }else{
            log.warn("CrmLogger: Orderly producer already started,maybe bean init error");
        }
    }
    
    /**
     * 关闭生产者
     * 
     * @author ZHONGFUHUA
     * @throws MqException 
     * @since 2015-08-19
     */
    @Override
    public void close() throws MqException {
        if (this.producer != null) {
            try {
                this.producer.close();
                log.info("CrmLogger: Orderly producer close success  [{}]", producer.getInstanceName());
                producer = null;
            } catch (MQException e) {
                log.warn("CrmLogger: Orderly producer close fail  {} [{}]", producer.getInstanceName(),
                    e.getMessage());
                throw new MqException(e.getMessage(), e.getCause());
            }
        }else{
            log.warn("CrmLogger: Orderly producer close fail, because producer object is null");
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
        
        if (StringUtils.isBlank(key)) {
            throw new MqException("key不能为空!");
        }
        
        if (msg == null || msg.length == 0) {
            throw new MqException("消息内容不能为空!");
        }
        
        MQMessage message = new MQMessage();
        message.setSourceName(this.getTopicName());
        message.setBody(msg);
        message.setTag(tag);
        message.setKey(key);
        message.setGroupId(key);
        if (result == 0) {
            try {
                MQSendResult result = producer.sendByGroupId(message);
                return MessageUtil.rocketmq(result, message);
            } catch (MQProducerException e) {
                log.warn("CrmLogger: Orderly producer send message exception {} [{}]", producer.getInstanceName(),e.getMessage());
                return MessageUtil.rocketmq(e, message);
            }
        }
        return null;
    }
    
}

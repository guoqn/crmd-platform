package com.ffcs.crmd.platform.mq.consumer.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.alibaba.rocketmq.client.log.ClientLogger;
import com.ctg.mq.api.bean.MQMessageExt;
import com.ctg.mq.api.bean.MQResult;
import com.ctg.mq.api.exception.MQException;
import com.ctg.mq.api.exception.MQExceptionCode;
import com.ctg.mq.api.impl.MQPullConsumerImpl;
import com.ffcs.crmd.platform.mq.ConsumerConfig;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.consumer.api.IPullConsumer;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:拉消费者
 *
 * @author CHENZHI
 * 
 * @Date 2015年10月30日 下午2:15:26
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class DefaultConsumer extends AbstractConsumer implements IPullConsumer{
    
    /**
     * 日志
     */
    private final Logger             log     = ClientLogger.getLog();
    
    /**
     * 消费者实例
     */
    private MQPullConsumerImpl       consumer;
    
    /**
     * 消费者连接结果
     */
    private int                      result  = -1;
    
    /**
     * 默认拉取条数
     */
    private int                      pullNum = 1;
    
    public DefaultConsumer(){
        this.consumer = new MQPullConsumerImpl();
    }
    
    public DefaultConsumer(ConsumerConfig consumerConfig) throws MqException {
        this.consumer = new MQPullConsumerImpl();
        this.setNameSrv(consumerConfig.getNameSrv());
        this.setGroupName(consumerConfig.getGroupName());
        this.setTopicName(consumerConfig.getTopicName());
        this.setInstanceName(consumerConfig.getInstanceName());
        this.setAuthID(consumerConfig.getAuthID());
        this.setAuthPWD(consumerConfig.getAuthPWD());
    }
    
    @Override
    public List<MqMessage> pull() throws MqException {
        return this.pull(this.pullNum);
    }
    
    /**
     * 
     * 功能说明:拉消息
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public List<MqMessage> pull(int pullNum) throws MqException {
        if (result != 0) {
            return null;
        }
        
        List<MqMessage> msgList = new ArrayList<MqMessage>();
        try {
            List<MQResult> resultList = consumer.consumeMessagesByTopic(getTopicName(), "*", pullNum, 5000);
            for (MQResult result : resultList) {
                msgList.add(MessageUtil.rocketmq(result));
            }
        } catch (MQException e) {
            throw new MqException(e);
        }
        return msgList;
    }
    
    /**
     * 
     * 功能说明:签收消息
     * 
     * @param message
     *          要签收的消息
     * @param ack
     *          签收是否成功
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public void ackMessage(MqMessage message, boolean ack) throws MqException {
        MQResult result = new MQResult();
        MQMessageExt messageExt = new MQMessageExt();
        messageExt.setQueueId(message.getQueueId());
        messageExt.setQueueOffset(message.getQueueOffset());
        messageExt.setSourceName(message.getTopicName());
        messageExt.setBrokerName(message.getBrokerName());
        result.setMessage(messageExt);
        try {
            if (ack) {
                consumer.ackMessageSuccess(result);
            } else {
                consumer.ackMessageRetry(result);
            }
        } catch (MQException e) {
            switch(e.getErrorCode()){
                case MQExceptionCode.MESSAGE_ALREADY_ACKED:
                    log.warn("CrmLogger: message has been ack msgId=[{}]", result.getMessage().getMessageID());
                    break;
                case MQExceptionCode.MESSAGE_IS_NOT_CONSUMING:
                    log.error("CrmLogger: message is't consumed msgId=[{}]", result.getMessage().getMessageID());
                    throw new MqException(e);
                case MQExceptionCode.SKIP_ACK_NOT_ALLOWED_FOR_ORDER_MESSAGE:
                    log.error("CrmLogger: message can't skip ack msgId=[{}]", result.getMessage().getMessageID());
                    throw new MqException(e);
                default:
                    log.error("CrmLogger: message ack fail msg=[{}] exception:", result.getMessage().getMessageID(), e);
                    throw new MqException(e);
            }
        }
    }
    
    /**
     * 
     * 功能说明:开启消费者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public void start() throws MqException {
        this.checkConfig();
        consumer.setAuthID(this.getAuthID());
        consumer.setAuthPWD(this.getAuthPWD());
        consumer.setNameSrvAddr(this.getNameSrv());
        consumer.setConsumerGroup(this.getGroupName());
        consumer.setInstanceName(this.getInstanceName());
        try {
            result = consumer.connect();
            if (result == 0) {
                log.info("CrmLogger: Pull consumer[{}] start success.",consumer.getInstanceName());
            }
        } catch (MQException e) {
            log.warn("CrmLogger: Pull consumer[{}] start fail{}", consumer.getInstanceName(), e);
            throw new MqException(e);
        }
    }
    
    /**
     * 
     * 功能说明:关闭消费者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public void close() throws MqException {
        try {
            consumer.close();
            log.info("CrmLogger: Pull consumer[{}] close success.", consumer.getInstanceName());
        } catch (MQException e) {
            log.warn("CrmLogger: Pull consumer[{}] close fail exception:{}", consumer.getInstanceName(), e);
            throw new MqException(e);
        }
    }
    
    public int getPullNum() {
        return pullNum;
    }
    
    public void setPullNum(int pullNum) {
        this.pullNum = pullNum;
    }
    
}

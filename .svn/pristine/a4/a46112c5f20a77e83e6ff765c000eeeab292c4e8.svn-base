package com.ffcs.crmd.platform.mq.consumer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.log.ClientLogger;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.ffcs.crmd.platform.mq.ConsumerConfig;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.consumer.api.IPullConsumer;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 消费者定义
 * 
 * @author chenzhi
 *
 */
public class DefaultConsumer extends AbstractConsumer implements IPullConsumer{
    
    /**
     * 日志
     */
    private final Logger          log      = ClientLogger.getLog();
    
    /**
     * 单次拉取条数
     */
    private int                   pullNum  = 1;
    
    /**
     * 消费者实例
     */
    private DefaultMQPullConsumer consumer = null;
    
    public DefaultConsumer() {
        this.consumer = new DefaultMQPullConsumer();
    }
    
    public DefaultConsumer(ConsumerConfig consumerConfig) throws MqException {
        this.consumer = new DefaultMQPullConsumer();
        this.setNameSrv(consumerConfig.getNameSrv());
        this.setGroupName(consumerConfig.getGroupName());
        this.setTopicName(consumerConfig.getTopicName());
        this.setInstanceName(consumerConfig.getInstanceName());
        this.setAuthID(consumerConfig.getAuthID());
        this.setAuthPWD(consumerConfig.getAuthPWD());
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
    @Override
    public void start() throws MqException {
        this.checkConfig();
        consumer.setConsumerGroup(this.getGroupName());
        consumer.setNamesrvAddr(this.getNameSrv());
        consumer.setInstanceName(this.getInstanceName());
        consumer.setMessageModel(MessageModel.CLUSTERING);
        try {
            // 平衡模式需添加方法
            consumer.getRegisterTopics().add(this.getTopicName());
            consumer.start();
            log.info("CrmLogger: Pull consumer start success [{}]", consumer.getClientIP()
                + "@" + consumer.getInstanceName());
        } catch (MQClientException e) {
            log.warn("CrmLogger: Pull consumer start fail [{}]", consumer.getClientIP() + "@"
                + consumer.getInstanceName());
            throw new MqException(e.getMessage(), e.getCause());
        }
    }
    
    @Override
    public List<MqMessage> pull() throws MqException {
        return pull(this.pullNum);
    }
    
    /**
     * 
     * 功能说明:pull方式暂时不实现
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public void ackMessage(MqMessage message, boolean ack) throws MqException {
        // TODO Auto-generated method stub
    }
    
    /**
     * 
     * 功能说明:拉消息,立即应答模式
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    @Override
    public List<MqMessage> pull(int pullNum) throws MqException {
        if (pullNum <= 0) {
            throw new MqException("num<=0,非法参数!");
        }
        List<MqMessage> msglist = new ArrayList<MqMessage>();
        try {
            Set<MessageQueue> mqs = consumer.fetchMessageQueuesInBalance(this.getTopicName());
            
            int retry = 0;
            while (mqs.size() == 0) {
                if (retry >= 3) {
                    return msglist;
                }
                retry++;
                Thread.sleep(100);
                mqs = consumer.fetchMessageQueuesInBalance(this.getTopicName());
            }
            
            int remain = 0;
            for (MessageQueue mq : mqs) {
                // RocketMq一次最大为32条消息,当大于32条消息时，单个需要多次拉消息
                SINGLE_MQ: while ((remain = (pullNum - msglist.size())) > 0) {
                    // 先从本地缓存拉offset,不存在时到namesrv拉offset
                    long offset = consumer.fetchConsumeOffset(mq, false);
                    if (offset < 0) {
                        break SINGLE_MQ;
                    }
                    PullResult pullResult = consumer.pull(mq, "*", offset, remain);
                    // 单个分区异常时,处理下一个分区数据
                    if (pullResult == null) {
                        break SINGLE_MQ;
                    }
                    
                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            List<MessageExt> list = pullResult.getMsgFoundList();
                            
                            if (list == null || list.size() == 0) {// 空队列,进入下一个分区
                                break SINGLE_MQ;
                            }
                            
                            for (int i = 0; i < list.size(); i++) {
                                MessageExt msg = list.get(i);
                                msglist.add(MessageUtil.rocketmq(msg));
                            }
                            // 存储Offset，客户端每隔5s会定时刷新到Broker
                            consumer.updateConsumeOffset(mq, pullResult.getNextBeginOffset());
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                            break SINGLE_MQ;
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                }
            }
            // 实时向broker更新offset
            consumer.getDefaultMQPullConsumerImpl().getOffsetStore().persistAll(mqs);
        } catch (MQClientException e) {
            throw new MqException(e.getMessage(), e.getCause());
        } catch (RemotingException e) {
            throw new MqException(e.getMessage(), e.getCause());
        } catch (MQBrokerException e) {
            throw new MqException(e.getMessage(), e.getCause());
        } catch (InterruptedException e) {
            throw new MqException(e.getMessage(), e.getCause());
        }
        return msglist;
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
    public void close() {
        if (this.consumer != null) {
            this.consumer.shutdown();
            this.consumer = null;
            log.info("CrmLogger: Pull consumer close success  [{}]", consumer.getClientIP() + "@"
                + consumer.getInstanceName());
        } else {
            log.warn("CrmLogger: Pull consumer close fail ,because it's null consumer object ");
        }
    }
    
    public int getPullNum() {
        return pullNum;
    }
    
    public void setPullNum(int pullNum) {
        this.pullNum = pullNum;
    }
    
}

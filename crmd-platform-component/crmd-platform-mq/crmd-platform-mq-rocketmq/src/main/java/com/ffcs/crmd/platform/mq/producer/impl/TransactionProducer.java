package com.ffcs.crmd.platform.mq.producer.impl;


import org.apache.commons.lang.StringUtils;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.ffcs.crmd.platform.mq.ConsumeStatus;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.ProdResult;
import com.ffcs.crmd.platform.mq.producer.api.ITransactionCheckListener;
import com.ffcs.crmd.platform.mq.producer.api.ITransactionExecuter;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 事务生产者(阿里屏蔽该功能代码)
 * 操作方式：
 * 1.发送消息
 * 2.执行事务回调ITransactionExecuter
 * @author chenzhi
 * @2015年8月25日 下午3:46:53
 */
@Deprecated
public class TransactionProducer extends AbstractProducer{   
    private TransactionMQProducer producer = null;

    private ITransactionExecuter transactionExecuter;

    //private ITransactionCheckListener transactionCheckListener;


    public TransactionProducer() {

    }


    public TransactionProducer(String nameSrv, String groupName, String topicName) {
    	this.setNameSrv(nameSrv);
        this.setGroupName(groupName);
        this.setTopicName(topicName);
    }


    /**
     * 发送消息
     * 
     * @param msg
     *            消息内容
     * @param tag
     *            标签
     * @param key
     *            标识
     * @author ZHONGFUHUA
     * @throws MqException 
     * @since 2015-08-19
     */
    @Override
    public ProdResult send(byte[] msg, String tag, String key) throws MqException {
        String tTag = null;
        String tKey = null;
        SendResult sendResult = null;

        if (msg == null || msg.length == 0) {
            throw new MqException("消息内容不能为空!");
        }
        if (StringUtils.isBlank(tag)) {
            tTag = null;
        }
        else {
            tTag = tag;
        }

        if (StringUtils.isBlank(key)) {
            tKey = null;
        }
        else {
            tKey = key;
        }

        // 创建消息体
        Message rocketmqMsg = new Message("chenz", // topic
            tTag, // tag
            tKey, // key
            msg); // body
        
        try {
            sendResult = producer.sendMessageInTransaction(rocketmqMsg, new MessageTransactionExecuter(this.transactionExecuter), null);
            return MessageUtil.rocketmq(sendResult);
        }
        catch (MQClientException e) {
            throw new MqException(e.getMessage(), e.getCause());
        }
    }

    /**
     * 启动生产者
     * 
     * @author ZHONGFUHUA
     * @throws MqException 
     * @since 2015-08-19
     */
    @Override
    public void start() throws MqException {
        this.checkConfig();
        try {
            if (producer == null) {
                producer = new TransactionMQProducer(this.getGroupName());
                producer.setNamesrvAddr(this.getNameSrv());
                producer.setInstanceName(this.getInstanceName());
                producer.setTransactionCheckListener(new MessageTransactionCheckListener(null));
                producer.start();
                
            }
        }
        catch (MQClientException e) {
            throw new MqException(e.getMessage(),e.getCause());
        }

    }


    /**
     * 关闭生产者
     * 
     * @author ZHONGFUHUA
     * @since 2015-08-19
     */
    @Override
    public void close() {
        if (producer != null) {
            producer.shutdown();
            producer = null;
        }
    }
    
    
    class MessageTransactionExecuter implements LocalTransactionExecuter{
        
        ITransactionExecuter mqMessageTransacExecuter;
        
        public MessageTransactionExecuter(ITransactionExecuter mqMessageTransacExecuter){
            this.mqMessageTransacExecuter = mqMessageTransacExecuter;
        }

        @Override
        public LocalTransactionState executeLocalTransactionBranch(final Message msg, final Object arg) {
        	if(mqMessageTransacExecuter==null){
        		return LocalTransactionState.ROLLBACK_MESSAGE;
        	}
            ConsumeStatus status = mqMessageTransacExecuter.executeTransaction(MessageUtil.rocketmq(msg), arg);
            switch (status) {
            case SUCCESS:
                return LocalTransactionState.COMMIT_MESSAGE;
            case FAIL:
                return LocalTransactionState.ROLLBACK_MESSAGE;
            default:
                return LocalTransactionState.UNKNOW;
            }
        }
    }
    
    
    class MessageTransactionCheckListener implements TransactionCheckListener {
        
        private ITransactionCheckListener transactionCheckListener;
        
        public MessageTransactionCheckListener(ITransactionCheckListener transactionCheckListener) {
            this.transactionCheckListener = transactionCheckListener;
        }
        
        public LocalTransactionState checkLocalTransactionState(MessageExt msg) {
        	if(transactionCheckListener==null){
        		return LocalTransactionState.UNKNOW;
        	}
            ConsumeStatus status = transactionCheckListener.checkLocalTransactionState(MessageUtil
                .rocketmq(msg));
            switch (status) {
                case SUCCESS:
                    return LocalTransactionState.COMMIT_MESSAGE;
                case FAIL:
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                default:
                    return LocalTransactionState.UNKNOW;
            }
        }
    }


	public ITransactionExecuter getTransactionExecuter() {
		return transactionExecuter;
	}


	public void setTransactionExecuter(ITransactionExecuter transactionExecuter) {
		this.transactionExecuter = transactionExecuter;
	} 
}

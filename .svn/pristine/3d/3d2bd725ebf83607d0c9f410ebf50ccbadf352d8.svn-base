package com.ffcs.crmd.platform.mq.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ctg.mq.api.bean.MQMessage;
import com.ctg.mq.api.bean.MQMessageExt;
import com.ctg.mq.api.bean.MQResult;
import com.ctg.mq.api.bean.MQSendResult;
import com.ctg.mq.api.exception.MQExceptionCode;
import com.ctg.mq.api.exception.MQProducerException;
import com.ctg.mq.api.exception.MQProducerExceptionType;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.SendStatus;
import com.ffcs.crmd.platform.mq.ProdResult;

/**
 * 
 * 功能说明:消息处理工具类,应用到消息中间件的转化
 *
 * @author CHENZHI
 * 
 * @Date 2015年10月30日 下午3:14:43
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public final class MessageUtil {
    
    protected MessageUtil() {
        
    }
    
    /**
     * 
     * 功能说明:rocketmq的发送结果转化
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     * @return ProdResult (mqMessage:topicName,body,key,tag,msgId)
     */
    public static ProdResult rocketmq(MQSendResult sendResult, MQMessage rmsg) {
        ProdResult prodResult = new ProdResult();
        if (sendResult == null) {
            return prodResult;
        }
        MqMessage mqMessage = new MqMessage();
        prodResult.setSendStatus(SendStatus.SEND_OK);
        mqMessage.setMsgId(sendResult.getMessageID());
        mqMessage.setTopicName(rmsg.getSourceName());
        mqMessage.setBody(rmsg.getBody());
        mqMessage.setKeys(rmsg.getKey());
        mqMessage.setTags(rmsg.getTag());
        prodResult.setMqMessage(mqMessage);
        return prodResult;
    }
    
    /**
     * 
     * 功能说明:rocketmq的发送结果转化
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public static ProdResult rocketmq(MQProducerException exception, MQMessage rmsg) {
        ProdResult prodResult = new ProdResult();
        MqMessage mqMessage = new MqMessage();
        if (MQProducerExceptionType.UNCERTAIN == exception.getExceptionType()) {
            if (MQExceptionCode.PRODUCER_UNCERTAIN_FLUSH_DISK_TIMEOUT == exception.getErrorCode()) {
                mqMessage.setMsgId(exception.getMessageID());
            } else if (MQExceptionCode.PRODUCER_UNCERTAIN_FLUSH_SLAVE_TIMEOUT == exception
                .getErrorCode()) {
                mqMessage.setMsgId(exception.getMessageID());
            } else if (MQExceptionCode.PRODUCER_UNCERTAIN_SLAVE_NOT_AVAILABLE == exception
                .getErrorCode()) {
                mqMessage.setMsgId(exception.getMessageID());
            }
            prodResult.setSendStatus(SendStatus.UNCERTAIN);
        } else {
            prodResult.setSendStatus(SendStatus.SEND_FAIL);
        }
        prodResult.setErrorMessage(exception.getExpDesc());
        prodResult.setMqMessage(mqMessage);
        return prodResult;
    }
    
    /**
     * 
     * 功能说明:ctgMq结果转成Mq实体
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public static MqMessage rocketmqExt(MQMessageExt msg) {
        if (msg == null) {
            return null;
        }
        MqMessage mqMessage = new MqMessage();
        mqMessage.setMsgId(msg.getMessageID());
        mqMessage.setTopicName(msg.getSourceName());
        mqMessage.setKeys(msg.getKey());
        mqMessage.setTags(msg.getTag());
        mqMessage.setBody(msg.getBody());
        mqMessage.setQueueId(msg.getQueueId());
        mqMessage.setQueueOffset(msg.getQueueOffset());
        mqMessage.setBrokerName(msg.getBrokerName());
        mqMessage.setReconsumeTimes(msg.getReconsumeTimes());
        mqMessage.setProperties(msg.getProperties());
        return mqMessage;
    }
    
    /**
     * 
     * 功能说明:ctgMq结果转成Mq实体
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public static List<MqMessage> rocketmqExt(List<MQMessageExt> msgList) {
        if (msgList == null || msgList.isEmpty()) {
            return null;
        }
        List<MqMessage> mqMessageList = new ArrayList<MqMessage>();
        
        for (MQMessageExt msg : msgList) {
            mqMessageList.add(rocketmqExt(msg));
        }
        return mqMessageList;
    }
    
    /**
     * 
     * 功能说明:ctgMq结果转成Mq实体
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public static MqMessage rocketmq(MQResult result) {
        MQMessageExt msg = result.getMessage();
        if (msg == null) {
            return null;
        }
        return rocketmqExt(msg);
    }
    
    /**
     * 
     * 功能说明:ctgMq结果集转成Mq实体
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public static List<MqMessage> rocketmq(List<MQResult> msgList) {
        List<MqMessage> mqList = new ArrayList<MqMessage>();
        for (MQResult msg : msgList) {
            MqMessage mqMessage = rocketmq(msg);
            mqList.add(mqMessage);
        }
        return mqList;
    }
    
    /**
     * 创建实例名称 组名+主题+UUID
     * 
     * @author ZHONGFUHUA
     * @since 2015-08-19
     */
    public static String createInstanceName(String groupName, String topicName) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replaceAll("-", "");
        String instanceName = groupName + "&" + topicName + "&" + str;
        return instanceName;
    }
    
}

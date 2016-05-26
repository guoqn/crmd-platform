package com.ffcs.crmd.platform.mq.query.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import com.alibaba.rocketmq.client.log.ClientLogger;
import com.ctg.mq.api.bean.QueryCondition;
import com.ctg.mq.api.bean.QueryResult;
import com.ctg.mq.api.exception.MQException;
import com.ctg.mq.api.impl.MQProducerImpl;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.query.api.IQuery;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:消息查询实现
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月20日 下午4:17:19
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class QueryImpl implements IQuery {
    
    /**
     * 日志
     */
    private static final Logger log           = ClientLogger.getLog();
    
    /**
     * 默认查询用途的生产者组名
     */
    private final String        producerGroup = "query_producer_group_default";
    
    /**
     * 默认查询用途的主题名
     */
    private final String        producerTopic = "defalut_query_topic";
    
    /**
     * 名服务地址
     */
    private String              nameSrv       = null;
    
    /**
     * 认证用户名
     */
    private String              authID        = null;
    
    /**
     * 认证密码
     */
    private String              authPWD       = null;
    
    /**
     * 使用生产者作为查询的实例
     */
    private MQProducerImpl      producer      = null;
    
    public QueryImpl(){
        producer = new MQProducerImpl();
        
    }
    
    public QueryImpl(String nameSrv,String authID,String authPWD){
        this.setNameSrv(nameSrv);
        this.setAuthID(authID);
        this.setAuthPWD(authPWD);
        producer = new MQProducerImpl();
    }
    
    @Override
    public void init() throws MqException {
        if (StringUtils.isBlank(this.getNameSrv())) {
            throw new MqException("名服务地址不能为空!");
        }
        if (StringUtils.isBlank(authID)) {
            throw new MqException("用户验证ID不能为空");
        }
        if (StringUtils.isBlank(authPWD)) {
            throw new MqException("用户验证密码不能为空");
        }
        producer.setAuthID(this.getAuthID());
        producer.setAuthPWD(this.getAuthPWD());
        producer.setNameSrvAddr(this.getNameSrv());
        producer.setInstanceName(MessageUtil.createInstanceName(producerGroup, producerTopic));
        producer.setProducerGroup(producerGroup);
        try {
            int result = producer.connect();
            if (result == 0) {
                log.info("CrmLogger: admin[{}] start success", producer.getInstanceName());
            }
        } catch (MQException e) {
            log.warn("CrmLogger: admin[{}] start fail {}", producer.getInstanceName(), e);
            throw new MqException(e.getMessage(), e.getCause());
        }
    }
    
    @Override
    public void close() throws MqException {
        try {
            this.producer.close();
            log.info("CrmLogger: admin[{}] close success", producer.getInstanceName());
            producer = null;
        } catch (MQException e) {
            log.warn("CrmLogger: admin[{}] close fail {}", producer.getInstanceName(), e);
            throw new MqException(e);
        }
    }
    
    /**
     * 
     * 功能说明:根据消息ID查询消息
     * 
     * @param msgId
     *          消息标识
     *          
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2015年8月26日
     *
     */
    @Override
    public MqMessage queryMessageById(String msgId) {
        QueryCondition condition = new QueryCondition();
        condition.setMessageId(msgId);
        QueryResult result = null;
        try {
            result = producer.queryMessage(condition);
        } catch (MQException e) {
            e.printStackTrace();
            return null;
        }
        if (result != null) {
            return MessageUtil.rocketmqExt(result.getMessageList().get(0));
        } else {
            return null;
        }
    }
    
    /**
     * 
     * 功能说明:根据key和topic查询消息
     * 
     * @param key
     *          消息key
     * @param topic
     *          消息topic
     * @param maxNum
     *          查询最大数
     * @param beginTime
     *          开始时间,long类型毫秒数
     * @param endTime
     *          结束时间,long类型毫秒数
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     * 
     * @Date 2015年8月26日
     *
     */
    @Override
    public List<MqMessage> queryMessageByKey(String key, String topic, int maxNum, long beginTime,
        long endTime) throws MqException {
        if (StringUtils.isBlank(key)) {
            throw new MqException("key不能为空");
        }
        if (StringUtils.isBlank(topic)) {
            throw new MqException("topic不能为空");
        }
        List<MqMessage> msgResult = new ArrayList<MqMessage>();
        if (maxNum <= 0) {
            return msgResult;
        }
        endTime = endTime >= 0 ? endTime : System.currentTimeMillis();
        
        QueryCondition condition = new QueryCondition();
        condition.setKey(key);
        condition.setTopic(topic);
        condition.setMaxNum(maxNum);
        condition.setBeginTime(beginTime);
        condition.setEndTime(endTime);
        QueryResult result = null;
        try {
            result = producer.queryMessage(condition);
        } catch (MQException e) {
            e.printStackTrace();
            return msgResult;
        }
        if (result != null) {
            msgResult = MessageUtil.rocketmqExt(result.getMessageList());
        } 
        return msgResult;
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
    
    public String getNameSrv() {
        return nameSrv;
    }
    
    public void setNameSrv(String nameSrv) {
        this.nameSrv = nameSrv;
    }
    
}

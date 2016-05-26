package com.ffcs.crmd.platform.mq.query.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import com.alibaba.rocketmq.client.QueryResult;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.log.ClientLogger;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.alibaba.rocketmq.tools.admin.DefaultMQAdminExt;
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
    private static final Logger      log               = ClientLogger.getLog();
    
    /**
     * 运维对象
     */
    private static DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt();
    
    /**
     * 默认查询用途的生产者组名
     */
    private final String             producerGroup     = "query_producer_group_default";
    
    /**
     * 默认查询用途的主题名
     */
    private final String             producerTopic     = "defalut_query_topic";
    
    /**
     * 名服务地址
     */
    private String                   nameSrv;
    
    /**
     * 认证用户名
     */
    private String                   authID            = null;
    
    /**
     * 认证密码
     */
    private String                   authPWD           = null;
    
    /**
     * 
     */
    private String                   instanceName      = MessageUtil.createInstanceName(
                                                           producerGroup, producerTopic);
    
    public QueryImpl(){
        
    }
    
    public QueryImpl(String nameSrv,String authID,String authPWD){
        this.setNameSrv(nameSrv);
        this.setAuthID(authID);
        this.setAuthPWD(authPWD);
    }
    
    public void init() throws MqException {
        if (StringUtils.isBlank(this.getNameSrv())) {
            throw new MqException("名服务地址不能为空!");
        }
        defaultMQAdminExt.setNamesrvAddr(this.getNameSrv());
        defaultMQAdminExt.setInstanceName(instanceName);
        try {
            defaultMQAdminExt.start();
            log.info("CrmLogger: admin[{}] start success", instanceName);
        } catch (MQClientException e) {
            throw new MqException(e);
        }
    }
    
    public void close() {
        defaultMQAdminExt.shutdown();
        log.info("CrmLogger: admin[{}] close success", instanceName);
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
    public MqMessage queryMessageById(String msgId) throws MqException {
        MessageExt msgExt = null;
        try {
            msgExt = defaultMQAdminExt.viewMessage(msgId);
        } catch (RemotingException e) {
            throw new MqException(e.getMessage(), e.getCause());
        } catch (MQBrokerException e) {
            throw new MqException(e.getMessage(), e.getCause());
        } catch (InterruptedException e) {
            throw new MqException(e.getMessage(), e.getCause());
        } catch (MQClientException e) {
            throw new MqException(e.getMessage(), e.getCause());
        }
        return MessageUtil.rocketmq(msgExt);
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
        try {
            QueryResult queryMessage = defaultMQAdminExt.queryMessage(topic, key, maxNum, beginTime, endTime);
            for (MessageExt msgExt : queryMessage.getMessageList()) {
                msgResult.add(MessageUtil.rocketmq(msgExt));
            }
        } catch (MQClientException e) {
            throw new MqException(e.getMessage(), e.getCause());
        } catch (InterruptedException e) {
            throw new MqException(e.getMessage(), e.getCause());
        }
        return msgResult;
    }
    
    
    public String getNameSrv() {
        return nameSrv;
    }

    public void setNameSrv(String nameSrv) {
        this.nameSrv = nameSrv;
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
    
}

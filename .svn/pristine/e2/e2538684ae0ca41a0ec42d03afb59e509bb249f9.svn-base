package com.ffcs.crmd.platform.mq.producer.impl;

import org.apache.commons.lang3.StringUtils;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.producer.api.IProducer;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:生产者抽象类
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 下午2:58:30
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public abstract class AbstractProducer implements IProducer {
    
    /**
     * 名服务列表
     */
    private String  nameSrv                = null;
    
    /**
     * 消费组名
     */
    private String  groupName              = null;
    
    /**
     * 生产者实例
     */
    private String  instanceName           = null;
    
    /**
     * 主题名称
     */
    private String  topicName              = null;
    
    /**
     * 消息体最大值
     */
    private int     maxMessageSize         = 1024 * 128;
    
    /**
     * 发送超时时间,底层默认值为30s
     */
    private int     sendTimeOut            = 30000;
    
    /**
     * 认证用户名
     */
    private String  authID                 = null;
    
    /**
     * 认证密码
     */
    private String  authPWD                = null;
    
    /**
     * 消息体超过指定大小压缩
     */
    private int     compressMsgOver        = 1024 * 4;
    
    /**
     * 发送失败重试次数
     */
    private int     maxRetryTimes          = 0;
    
    /**
     * 发送出现不确定状态时是否停止Topic写入功能
     */
    private boolean notWriteWhenStoreNotOk = false;
    
    /**
     * 参数校验,实例名设置
     * @throws MqException 
     */
    protected void checkConfig() throws MqException {
        if (StringUtils.isBlank(this.getNameSrv())) {
            throw new MqException("名服务地址不能为空!");
        }
        if (StringUtils.isBlank(this.getGroupName())) {
            throw new MqException("消费者组名不能为空!");
        }
        if (StringUtils.isBlank(this.getTopicName())) {
            throw new MqException("主题名不能为空!");
        }
        if (StringUtils.isBlank(this.getInstanceName())) {
            this.setInstanceName(MessageUtil.createInstanceName(this.getGroupName(),
                this.getTopicName()));
        }
        if (StringUtils.isBlank(authID)) {
            throw new MqException("用户验证ID不能为空");
        }
        if (StringUtils.isBlank(authPWD)) {
            throw new MqException("用户验证密码不能为空");
        }
    }
    
    public String getNameSrv() {
        return nameSrv.trim();
    }
    
    public void setNameSrv(String nameSrv) {
        this.nameSrv = nameSrv;
    }
    
    public String getGroupName() {
        return groupName.trim();
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getInstanceName() {
        return instanceName;
    }
    
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }
    
    public int getSendTimeOut() {
        return sendTimeOut;
    }
    
    public void setSendTimeOut(int sendTimeOut) throws MqException {
        if (sendTimeOut < 0) {
            throw new MqException("发送超时时间要>0");
        }
        this.sendTimeOut = sendTimeOut;
    }
    
    public String getTopicName() {
        return topicName.trim();
    }
    
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    
    public int getMaxMessageSize() {
        return maxMessageSize;
    }
    
    public void setMaxMessageSize(int maxMessageSize) throws MqException {
        if (maxMessageSize < 0) {
            throw new MqException("消息体最大值要大于>0");
        }
        this.maxMessageSize = maxMessageSize;
    }
    
    public String getAuthID() {
        return authID.trim();
    }
    
    public void setAuthID(String authID) {
        this.authID = authID;
    }
    
    public String getAuthPWD() {
        return authPWD.trim();
    }
    
    public void setAuthPWD(String authPWD) {
        this.authPWD = authPWD;
    }
    
    public int getCompressMsgOver() {
        return compressMsgOver;
    }

    public void setCompressMsgOver(int compressMsgOver) throws MqException {
        if (compressMsgOver < 0) {
            throw new MqException("消息体压缩值要大于>0");
        }
        this.compressMsgOver = compressMsgOver;
    }

    public int getMaxRetryTimes() {
        return maxRetryTimes;
    }

    public void setMaxRetryTimes(int maxRetryTimes) throws MqException {
        if (maxRetryTimes < 0) {
            throw new MqException("重试次数要大于>0");
        }
        this.maxRetryTimes = maxRetryTimes;
    }

    public boolean isNotWriteWhenStoreNotOk() {
        return notWriteWhenStoreNotOk;
    }
    
    public void setNotWriteWhenStoreNotOk(boolean notWriteWhenStoreNotOk) {
        this.notWriteWhenStoreNotOk = notWriteWhenStoreNotOk;
    }
    
}

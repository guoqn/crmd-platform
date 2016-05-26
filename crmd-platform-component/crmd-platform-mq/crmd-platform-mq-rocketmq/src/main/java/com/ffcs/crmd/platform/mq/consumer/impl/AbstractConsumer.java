package com.ffcs.crmd.platform.mq.consumer.impl;

import org.apache.commons.lang3.StringUtils;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:监听抽象类
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 上午11:56:56
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public abstract class AbstractConsumer {
    
    /**
     * 名服务地址
     */
    private String nameSrv       = null;
    
    /**
     * 消费组名
     */
    private String groupName     = null;
    
    /**
     * 主题
     */
    private String topicName     = null;
    
    /**
     * 实例名
     */
    private String instanceName  = null;
    
    /**
     * 认证用户名
     */
    private String authID        = null;
    
    /**
     * 认证密码
     */
    private String authPWD       = null;
    
    /**
     * 过滤标签表达式
     */
    private String subExpression = "*";
    
    public AbstractConsumer() {
        
    }
    
    /**
     * 
     * 功能说明:检查启动配置
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
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
    }
    
    public String getNameSrv() {
        return nameSrv;
    }
    
    public void setNameSrv(String nameSrv) {
        this.nameSrv = nameSrv;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    
    public String getInstanceName() {
        return instanceName;
    }
    
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }
    
    public String getAuthID() {
        return authID.trim();
    }
    
    public void setAuthID(String authID) throws MqException {
        this.authID = authID;
    }
    
    public String getAuthPWD() {
        return authPWD.trim();
    }
    
    public void setAuthPWD(String authPWD) throws MqException {
        this.authPWD = authPWD;
    }
    
    public String getSubExpression() {
        return subExpression;
    }
    
    public void setSubExpression(String subExpression) {
        this.subExpression = subExpression;
    }
}

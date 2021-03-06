package com.ffcs.crmd.platform.mq.consumer.impl;

import org.apache.commons.lang3.StringUtils;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.util.MessageUtil;

/**
 * 
 * 功能说明:监听消费者、拉消费者抽象类
 *
 * @author CHENZHI
 * 
 * @Date 2015年10月30日 下午2:16:00
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public abstract class AbstractConsumer {
    
    /**
     * 名服务地址
     */
    private String nameSrv          = null;
    
    /**
     * 消费组名
     */
    private String groupName        = null;
    
    /**
     * 消费者者实例名,不重复
     */
    private String instanceName     = null;
    
    /**
     * 主题
     */
    private String topicName        = null;
    
    /**
     * 认证用户名
     */
    private String authID           = null;
    
    /**
     * 认证密码
     */
    private String authPWD          = null;
    
    /**
     * 过滤标签表达式
     */
    private String subExpression    = "*";
    

    
    /**
     * 
     * 功能说明:检查配置
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
        if (StringUtils.isBlank(authID)) {
            throw new MqException("用户验证ID不能为空");
        }
        if (StringUtils.isBlank(authPWD)) {
            throw new MqException("用户验证密码不能为空");
        }
        if (StringUtils.isBlank(this.getInstanceName())) {
            this.setInstanceName(MessageUtil.createInstanceName(this.getGroupName(),
                this.getTopicName()));
        }
    }
    
    public String getTopicName() {
        return topicName.trim();
    }
    
    public void setTopicName(String topicName) throws MqException {
        this.topicName = topicName;
    }
    
    public String getNameSrv() {
        return nameSrv.trim();
    }
    
    public void setNameSrv(String nameSrv) throws MqException {
        this.nameSrv = nameSrv;
    }
    
    public String getGroupName() {
        return groupName.trim();
    }
    
    public void setGroupName(String groupName) throws MqException {
        this.groupName = groupName;
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

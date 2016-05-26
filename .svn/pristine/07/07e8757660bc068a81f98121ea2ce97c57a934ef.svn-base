/**
 * 
 */
package com.ffcs.crmd.platform.mq.consumer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import com.alibaba.rocketmq.client.log.ClientLogger;
import com.ffcs.crmd.platform.mq.ConsumerConfig;
import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.consumer.api.IMessageListener;
import com.ffcs.crmd.platform.mq.consumer.api.IPushConsumer;

/**
 * 
 * 功能说明:消息监听器容器
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2016年4月9日 下午1:46:49
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
@Deprecated
public class ListenerConsumerContainer {
    
    /**
     * 日志
     */
    private final Logger         log                   = ClientLogger.getLog();
    
    /**
     * 名服务地址
     */
    private String               nameSrv               = null;
    
    /**
     * 消费者组名
     */
    private String               groupName             = null;
    
    /**
     * 主题名
     */
    private String               topicName             = null;
    
    /**
     * 一次最大消费数量
     */
    private int                  batchSize             = 1;
    
    /**
     * 消费者连接数
     */
    private int                  consumerConnectionNum = 1;
    
    /**
     * 单消费实例消费最小线程数
     */
    private int                  consumeThreadMin      = 100;
    
    /**
     * 过滤标签表达式
     */
    private String               subExpression         = "*";
    
    /**
     * 是否有序消费
     */
    private boolean              orderly               = false;
    
    /**
     * 认证用户名
     */
    private String               authID                = null;
    
    /**
     * 认证密码
     */
    private String               authPWD               = null;
    
    /**
     * 监听器
     */
    private IMessageListener     messageListener       = null;
    
    /**
     * 消费者实例配置
     */
    private ConsumerConfig       consumerConfig        = null;
    
    /**
     * 监听消费者实例集合
     */
    private List<IPushConsumer> consumerListeners      = new ArrayList<IPushConsumer>();

    
    public ListenerConsumerContainer() {
        
    }
    
    public ListenerConsumerContainer(ConsumerConfig consumerConfig) throws MqException {
        this.consumerConfig = consumerConfig;
        this.setConsumerConnectionNum(consumerConfig.getConsumerConn());
    }
    
    private void loadConsumerConfig(){
        if(this.consumerConfig!=null){
            return ;
        }else{
            consumerConfig = new ConsumerConfig();
            consumerConfig.setNameSrv(this.getNameSrv());
            consumerConfig.setGroupName(this.getGroupName());
            consumerConfig.setTopicName(this.getTopicName());
            consumerConfig.setBatchSize(this.getBatchSize());
            consumerConfig.setOrderly(this.isOrderly());
            consumerConfig.setConsumeThreadMin(this.getConsumeThreadMin());
            consumerConfig.setAuthID(this.getAuthID());
            consumerConfig.setAuthPWD(this.getAuthPWD());
            consumerConfig.setMessageListener(this.getMessageListener());
            consumerConfig.setSubExpression(this.getSubExpression());
        }
    }
    
    
    /**
     * 
     * 功能说明:启动并初始化线程池
     * 
     * @author ZHONGFUHUA
     * @throws MqException 
     *
     * @Date 2015年10月29日
     *
     */
    public void start() throws MqException {
        if (this.getConsumerConnectionNum() > 0) {
            ExecutorService pool = Executors.newFixedThreadPool(this.getConsumerConnectionNum());
            this.loadConsumerConfig();
            for (int i = 0; i < this.getConsumerConnectionNum(); i++) {
                final IPushConsumer simpleListener = new ListenerConsumer(consumerConfig);
                consumerListeners.add(simpleListener);
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            simpleListener.start();
                        } catch (MqException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } else {
            log.warn("CrmLogger: Container connection  < 1, no consumers start");
        }
    }
    
    /**
     * 
     * 功能说明:关闭监听消费实例，并清空监听消费实例列表
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2015年10月29日
     *
     */
    public void close() throws MqException {
        if (null != consumerListeners || 0 <= consumerListeners.size()) {
            for (IPushConsumer simpleListener : consumerListeners) {
                simpleListener.close();
            }
        }
        consumerListeners.clear();
    }
    
    public String getNameSrv() {
        return nameSrv;
    }
    
    public void setNameSrv(String nameSrv) throws MqException {
        if (StringUtils.isBlank(nameSrv)) {
            throw new MqException("名服务地址不能为空");
        }
        this.nameSrv = nameSrv;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) throws MqException {
        if (StringUtils.isBlank(groupName)) {
            throw new MqException("消费组名不能为空");
        }
        this.groupName = groupName;
    }
    
    public String getTopicName() {
        return topicName;
    }
    
    public void setTopicName(String topicName) throws MqException {
        if (StringUtils.isBlank(topicName)) {
            throw new MqException("主题不能为空");
        }
        this.topicName = topicName;
    }
    
    public int getBatchSize() {
        return batchSize;
    }
    
    public void setBatchSize(int batchSize) throws MqException {
        if (batchSize < 1) {
            throw new MqException("批量消费条数不能小于1");
        }
        this.batchSize = batchSize;
    }
    
    public boolean isOrderly() {
        return orderly;
    }
    
    public void setOrderly(boolean orderly) {
        this.orderly = orderly;
    }
    
    public IMessageListener getMessageListener() {
        return messageListener;
    }
    
    public void setMessageListener(IMessageListener messageListener) throws MqException {
        if (messageListener == null) {
            throw new MqException("监听器不能为空值");
        }
        this.messageListener = messageListener;
    }
    
    public String getAuthID() {
        return authID;
    }
    
    public void setAuthID(String authID) throws MqException {
        if (StringUtils.isBlank(authID)) {
            throw new MqException("用户验证ID不能为空");
        }
        this.authID = authID;
    }
    
    public String getAuthPWD() {
        return authPWD;
    }
    
    public void setAuthPWD(String authPWD) throws MqException {
        if (StringUtils.isBlank(authPWD)) {
            throw new MqException("用户验证密码不能为空");
        }
        this.authPWD = authPWD;
    }
    
    public int getConsumerConnectionNum() {
        return consumerConnectionNum;
    }
    
    public void setConsumerConnectionNum(int consumerConnectionNum) throws MqException {
        if (consumerConnectionNum < 0) {
            throw new MqException("消费者连接数不能小于0");
        }
        this.consumerConnectionNum = consumerConnectionNum;
    }
    
    public int getConsumeThreadMin() {
        return consumeThreadMin;
    }
    
    public void setConsumeThreadMin(int consumeThreadMin) throws MqException {
        if (consumeThreadMin < 20) {
            throw new MqException("消费实例消费线程数不能小于20");
        }
        this.consumeThreadMin = consumeThreadMin;
    }

    public String getSubExpression() {
        return subExpression;
    }

    public void setSubExpression(String subExpression) {
        this.subExpression = subExpression;
    }
    
}

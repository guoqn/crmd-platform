package com.ffcs.crmd.platform.mq.consumer.api;

import java.util.List;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;

/**
 * 
 * 功能说明:消费者接口
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 下午3:01:52
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public interface IPullConsumer {
    
    /**
     * 
     * 功能说明:启动或者初始化消费者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public void start() throws MqException;
    
    /**
     * 
     * 功能说明:关闭消息消费者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public void close() throws MqException;
    
    /**
     * 
     * 功能说明:拉模式获取消息
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public List<MqMessage> pull() throws MqException;
    
    /**
     * 
     * 功能说明:拉模式获取消息
     * 
     * @param num
     *         拉取消息的数量
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public List<MqMessage> pull(int num) throws MqException;
    
    /**
     * 
     * 功能说明:签收消息
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
    public void ackMessage(MqMessage message, boolean ack) throws MqException;
}

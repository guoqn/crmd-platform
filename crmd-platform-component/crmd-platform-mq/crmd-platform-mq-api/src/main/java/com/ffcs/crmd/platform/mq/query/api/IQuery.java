package com.ffcs.crmd.platform.mq.query.api;

import java.util.List;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;

/**
 * 
 * 功能说明:消息查询接口定义
 *
 * @author CHENZHI
 * 
 * @Date 2015年10月30日 下午3:12:05
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public interface IQuery {
    
    /**
     * 
     * 功能说明:初始化启动
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2016年1月19日
     *
     */
    public void init() throws MqException;
    
    /**
     * 
     * 功能说明:关闭
     * 
     * @author ZHONGFUHUA
     * 
     * @throws MqException 
     *
     * @Date 2016年1月19日
     *
     */
    public void close() throws MqException;
    
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
    public MqMessage queryMessageById(String msgId) throws MqException;
    
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
    public List<MqMessage> queryMessageByKey(String key, String topic, int maxNum, long beginTime,
        long endTime) throws MqException;
    
}

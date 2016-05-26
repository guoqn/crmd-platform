package com.ffcs.crmd.platform.mq.producer.api;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.ProdResult;

/**
 * 
 * 功能说明:生产者接口
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2015年10月30日 下午2:59:39
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public interface IProducer {
    
    /**
     * 
     * 功能说明:启动或者初始化生产者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public void start() throws MqException;
    
    /**
     * 
     * 功能说明:发送消息
     * 
     * @param msg
     *          消息体内容
     * @param tag
     *          标签
     * @param key
     *          key值
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public ProdResult send(byte[] msg, String tag, String key) throws MqException;
    
    /**
     * 
     * 功能说明:关闭生产者
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2015年10月30日
     *
     */
    public void close() throws MqException;
}

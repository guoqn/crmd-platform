package com.ffcs.crmd.platform.mq.producer.api;

import com.ffcs.crmd.platform.mq.MqMessage;

/**
 * rocketmq消息队列选择器，用来控制消息顺序性
 * @author chenzhi
 * @2015年8月25日 下午10:00:51
 */
public interface IQueueSelector {
    /**
     * 队列选择器
     * @param msg
     * @param queueSize
     * @param param
     * @return
     */
    public int onSelect(MqMessage msg, int queueSize, Object param);
}

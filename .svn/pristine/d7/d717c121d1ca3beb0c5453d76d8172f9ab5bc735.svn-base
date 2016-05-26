/**
 * 
 */
package com.ffcs.crmd.platform.mq.producer.selector.impl;

import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.producer.api.IQueueSelector;

/**
 * 
 * 功能说明:简单的队列选型器实现
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2016年4月9日 上午11:30:04
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class SimpleQueueSelector implements IQueueSelector {

	@Override
	public int onSelect(MqMessage msg, int queueSize, Object param){
		int hashCode = 0;
		
		if(msg.getKeys()==null){
			 hashCode=Math.abs(msg.hashCode());
		}else{
			 hashCode = Math.abs(msg.getKeys().hashCode());	
		}				
        int index = hashCode % queueSize;        
        return index;//将特定的消息插入知道的队列中
	}
}

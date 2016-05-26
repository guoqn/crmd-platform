package com.ffcs.crmd.platform.mq.listener.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.ffcs.crmd.platform.mq.ConsumeStatus;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.consumer.api.IMessageListener;

public class ListenerCurrentlyImpl implements IMessageListener {
    
    static AtomicLong index     = new AtomicLong(0);
    static long       beginTime = System.currentTimeMillis();
    
    @Override
    public ConsumeStatus onMessage(List<MqMessage> messages) {
        if (null != messages && messages.size() > 0) {
            for (MqMessage msg : messages) {
                System.out.println(Thread.currentThread().getName() + " count="
                    + index.addAndGet(1) + "  msgId=" + msg.getMsgId() + "   key=" + msg.getKeys()
                    + "begintime=" + beginTime+"   currentTime="+System.currentTimeMillis());
            }
            System.out.println("=======================================");
        } else {
            System.err.print("no msg");
        }
        return ConsumeStatus.SUCCESS;
    }
    
}

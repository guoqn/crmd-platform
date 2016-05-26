package com.ffcs.crmd.platform.mq.listener.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.ffcs.crmd.platform.mq.ConsumeStatus;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.consumer.api.IMessageListener;

public class ListenerOrderlyImpl implements IMessageListener {
    
    AtomicLong index = new AtomicLong(0);
    
    @Override
    public ConsumeStatus onMessage(List<MqMessage> messages) {
        if (null != messages && messages.size() > 0) {
            for (MqMessage msg : messages) {
                System.out.println(Thread.currentThread().getName() + " count="
                    + index.addAndGet(1) + "  msgId=" + msg.getMsgId() + "   key=" + msg.getKeys());
            }
            System.out.println("=======================================");
        } else {
            System.err.print("no msg");
        }
        return ConsumeStatus.SUCCESS;
    }
}

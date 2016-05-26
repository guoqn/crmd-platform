package com.ffcs.crmd.platform.mq.producer.api;

import com.ffcs.crmd.platform.mq.ConsumeStatus;
import com.ffcs.crmd.platform.mq.MqMessage;


public interface ITransactionCheckListener {

    public  ConsumeStatus checkLocalTransactionState(MqMessage msg);

}

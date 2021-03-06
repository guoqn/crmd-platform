package com.ffcs.crmd.platform.mq;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.consumer.api.IPullConsumer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/mq/spring/applicationContext-mq-pull.xml" })
public class TestPull {
    
    @Resource(name = "ctgMqDefaultConsumer")
    private IPullConsumer defaultConsumer;
    
    @Test
    public void testPull() throws MqException{
        while (true) {
            List<MqMessage> msgs = defaultConsumer.pull();
            int i = 0;
            for (MqMessage msg : msgs) {
                // 消息要签收
                defaultConsumer.ackMessage(msg, true);
                System.out.println(" count=" + (i++) + " " + Thread.currentThread().getName()
                    + "  msg=" + msg);
            }
            System.out.println("=================================================");
        }
    }
}

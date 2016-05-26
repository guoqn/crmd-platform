package com.ffcs.crmd.platform.mq;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ffcs.crmd.platform.mq.ProdResult;
import com.ffcs.crmd.platform.mq.producer.api.IProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/mq/spring/applicationContext-mq-producer-orderly.xml" })
public class TestProducerOrderly {
    
    @Resource(name = "ctgMqOrderlyProducer")
    private IProducer orderlyProducer;
    
    @Test
    public void testOrderlyProducer() {
        for (int i = 0; i < 32; i++) {
            try {
                ProdResult result = orderlyProducer.send(("Body" + i).getBytes(), "Tag", "Key" + i);
                System.out.println(result.toString()+" error:"+result.getErrorMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}

package com.ffcs.crmd.platform.mq;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ffcs.crmd.platform.mq.ProdResult;
import com.ffcs.crmd.platform.mq.impl.ProducerOrderlyDefined;
import com.ffcs.crmd.platform.mq.producer.api.IProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/mq/spring/applicationContext-mq-producer-orderly-userdefined.xml" })
public class TestProducerOrderlyDefined {
    
    @Resource(name = "ctgMqOrderlyProducer")
    private ProducerOrderlyDefined orderlyProducer;
    
    @Test
    public void testOrderlyProducer() {
        // 获取生产者实例
        IProducer producer = orderlyProducer.getProducer();
        for (int i = 0; i < 32; i++) {
            try {
                ProdResult result = producer.send(("Body" + i).getBytes(), "Tag", "Key" + i);
                System.out.println(result.toString()+" error:"+result.getErrorMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

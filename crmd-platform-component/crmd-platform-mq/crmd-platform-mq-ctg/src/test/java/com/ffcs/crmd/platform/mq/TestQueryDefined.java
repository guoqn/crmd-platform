package com.ffcs.crmd.platform.mq;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.MqMessage;
import com.ffcs.crmd.platform.mq.impl.QueryDefined;
import com.ffcs.crmd.platform.mq.query.api.IQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/mq/spring/applicationContext-mq-query-userdefined.xml" })
public class TestQueryDefined {
    
    @Resource(name = "ctgMqQueryImpl")
    private QueryDefined queryUserDefined;
    
    @Test
    public void queryMessageById() throws MqException {
        IQuery query = queryUserDefined.getQuery();
        MqMessage msg = query.queryMessageById("868442CD00002A9F000000078DD352B6");
        System.out.println(msg);
    }
    
    @Test
    public void queryMessageByKey() throws MqException {
        IQuery query = queryUserDefined.getQuery();
        List<MqMessage> msgList = query.queryMessageByKey("Key1", "CTG_MQ_TEST", 32, 0,
            System.currentTimeMillis());
        for (MqMessage msg : msgList) {
            System.out.println(msg);
        }
    }
    
}

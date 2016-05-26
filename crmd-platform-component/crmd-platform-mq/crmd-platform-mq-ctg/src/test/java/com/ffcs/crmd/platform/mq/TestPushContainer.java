package com.ffcs.crmd.platform.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/mq/spring/applicationContext-mq-push-container.xml" })
public class TestPushContainer {
    
    @Test
    public void testPushContainer() {
        while (true) {
            try {
                // spring初始化直接启动
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

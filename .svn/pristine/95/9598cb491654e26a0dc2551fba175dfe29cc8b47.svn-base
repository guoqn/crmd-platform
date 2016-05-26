package com.ffcs.crmd.platform.pub.interfaces;

import com.ffcs.crmd.platform.pub.interfaces.handle.InterfHandleManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by linzhiqiang on 16/5/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath*:conf/spring/intf-applicationContext.xml"})
public class InterTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testGlobalConfig() {
        System.out.println(InterfHandleManager.getInstance().getHandler("CRM","PF","completeOrder").handle("test",null));
        System.out.println("\n\n\n\n");
        System.out.println(InterfHandleManager.getInstance().getHandler("CRM","PF",null).handle("test22",null));
    }
}

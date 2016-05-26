package com.ffcs.crmd.platform.core.ddd;

import com.ctg.itrdc.platform.data.entity.ClassInfoUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by linzhiqiang on 16/2/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:conf/spring/applicationContext*.xml",
    "classpath*:conf/spring/**/applicationContext*.xml" })
public class TestDom extends AbstractJUnit4SpringContextTests {

    @Test
    public void testSelect() {
        try {
            ClassInfoUtils.initEntityInfo(Cust.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cust cust = Cust.repository().getById(1L);
        System.out.println(cust.getCustName());
    }
}

package com.ffcs.crmd.platform.meta.client;

import com.alibaba.fastjson.JSON;
import com.ffcs.crmd.platform.meta.entity.SysConfig;
import com.ffcs.crmd.platform.meta.util.SamplingUtil;
import com.ffcs.crmd.platform.meta.util.SwitchUtil;
import com.ffcs.crmd.platform.meta.util.SysConfigUtil;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by FFSC-GUOQN on 2015/12/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/spring/applicationContext*.xml",
        "classpath*:conf/spring/**/applicationContext*.xml"})
public class SysConfigUtilTest {
    @Test
    public void Test() {
//        System.out.println(SysClass.repository().getById(1L,false) + "");
        String str = SysConfigUtil.getNodeValue("/intfIsSimuReturn/hb/svtonetcServices");
        System.out.println(str);
        String str2 = SysConfigUtil.getNodeValue("/intfUrl/hb/svtonetcServices");
//        List<SysConfig> list = SysConfigUtil.getChildListByPath("/root/child1");
        RetVo retVo = SysConfigUtil.cleanCacheByNode("/intfIsSimuReturn/hb/svtonetcServices");
        System.out.println(JSON.toJSON(retVo));
    }

    @Test
    public void TestSwitch() {
        boolean result = SwitchUtil.getSwitch("/child2/child1-2");
        System.out.println("" + result + "");
    }

    @Test
    public void TestSampling() {
        int[] arr = SamplingUtil.getArrayNodeValue("/root/child3/child1-3");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}

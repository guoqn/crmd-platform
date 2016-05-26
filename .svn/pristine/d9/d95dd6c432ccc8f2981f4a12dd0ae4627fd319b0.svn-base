package com.ffcs.crmd.platform.cache.core;

import com.ffcs.crmd.platform.cache.api.CacheConfigLoader;
import com.ffcs.crmd.platform.cache.api.utils.CacheUtils;
import com.ffcs.crmd.platform.cache.core.config.PropCacheConfigLoader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class TestCacheConfigLoader {

    @Test
    public void testProp() {
//        CacheConfigLoader prop = new PropCacheConfigLoader("testCache.properties");
//        System.out.println(prop.getAllCacheConfig());
        String serviceName="custFacade";
        String methodName="queryCust";
        List<String> serviceStr = new ArrayList<String>();
        String orginKey = serviceName + "." + methodName;
        serviceStr.add(orginKey);
        for (int i = serviceName.length(); i >= 0; i--) {
            String newServiceName = serviceName;
            if (i != serviceName.length()) {
                newServiceName = serviceName.substring(0, i) + "*";
            }
            for (int j = methodName.length() - 1; j >= 0; j--) {
                serviceStr.add(newServiceName + "." + methodName.substring(0, j) + "*");
            }
        }
        System.out.println(serviceStr);
//        String s1 = "11";
//        String[] s2 = {"22","33"};
//        System.out.println(CacheUtils.generateKey(s1,s2));
    }

}

package com.ffcs.crmd.platform.pub.interfaces.config;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;

/**
 * Created by linzhiqiang on 16/4/29.
 */
public class InterfConfigureFactory {

    public static IInterfConfigure getServerConfigure() {
        if (ApplicationContextUtil.containsBean("serverConfigure")) {
            return ApplicationContextUtil.getBean("serverConfigure");
        }
        return null;
    }

    public static IInterfConfigure getClientConfigure() {
        if (ApplicationContextUtil.containsBean("clientConfigure")) {
            return ApplicationContextUtil.getBean("clientConfigure");
        }
        return null;
    }
}

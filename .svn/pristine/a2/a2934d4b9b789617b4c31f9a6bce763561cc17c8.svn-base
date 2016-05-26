package com.ffcs.crmd.platform.pub.proxy.provider;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;

public class ServiceProviderFactory {
    public static final String DEF_SERVICE_PROVIDER_BEAN_ID = "defaultServiceProvider";
    
    public static final String SERVICE_PROVIDER_BEAN_ID     = "serviceProvider";
    
    public static IServiceProvider getService() {
        if (ApplicationContextUtil.containsBean(SERVICE_PROVIDER_BEAN_ID)) {
            return ApplicationContextUtil.getBean(SERVICE_PROVIDER_BEAN_ID);
        } else {
            return ApplicationContextUtil.getBean(DEF_SERVICE_PROVIDER_BEAN_ID);
        }
    }
}

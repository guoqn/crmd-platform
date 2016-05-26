package com.ffcs.crmd.platform.pub.proxy.provider.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component("defaultServiceProvider")
public class DefaultServiceProvider extends AbstractServiceProvider {
    
    @Override
    public String getServiceName(String serviceName, String mod, Map<String, Object> params) {
        return serviceName;
    }
    
    @Override
    public String getServiceName(String serviceName, String mod) {
        return serviceName;
    }
    
}

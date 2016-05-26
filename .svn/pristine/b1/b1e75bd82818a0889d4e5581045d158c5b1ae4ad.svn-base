package com.ffcs.crmd.platform.pub.proxy.callframework.proxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;
import java.util.Properties;

public class CrmServiceBatchCallProxyFactoryBean implements FactoryBean<Object> {
    
    protected Class<?> serviceInterface;
    private Properties serviceConfig = new Properties();
    
    @Override
    public Object getObject() throws Exception {
        CrmServiceBatchCallProxyHandler handler = new CrmServiceBatchCallProxyHandler(serviceConfig);
        
        return Proxy.newProxyInstance(serviceInterface.getClassLoader(),
            new Class[] {serviceInterface }, handler);
    }
    
    @Override
    public Class<?> getObjectType() {
        return getServiceInterface();
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
    
    public void setServiceInterface(Class<?> serviceInterface) {
        if ((serviceInterface != null) && (!serviceInterface.isInterface())) {
            throw new IllegalArgumentException("'serviceInterface' must be an interface");
        }
        this.serviceInterface = serviceInterface;
    }
    
    public Class<?> getServiceInterface() {
        return this.serviceInterface;
    }
    
    public Properties getServiceConfig() {
        return serviceConfig;
    }
    
    public void setServiceConfig(Properties serviceConfig) {
        this.serviceConfig = serviceConfig;
    }
}

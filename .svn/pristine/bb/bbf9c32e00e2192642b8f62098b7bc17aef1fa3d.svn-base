package com.ffcs.crmd.platform.pub.cache.context.service;

/**
 * Created by linzhiqiang on 16/3/29.
 */
public class CacheKey {

    private String serviceName;

    private String methodName;

    private Object[] params;

    private String uuid;

    public CacheKey(String serviceName, String methodName, Object[] params) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.params = params;
    }

    public CacheKey(String serviceName, String methodName, Object[] params, String uuid) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.params = params;
        this.uuid = uuid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

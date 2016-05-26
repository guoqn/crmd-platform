package com.ffcs.crmd.platform.pub.proxy.callframework;

import com.ctg.itrdc.platform.pub.bean.ReqData;

import java.io.Serializable;

/**
 * Created by linzhiqiang on 16/3/8.
 */
public class ReqBatchData implements Serializable {
    private String uuid;

    private String serviceName;

    private String methodName;

    private String serialType;

    private Object[] args;

    public ReqBatchData(String uuid, String serviceName, String methodName, String serialType,
        Object[] args) {
        this.uuid = uuid;
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.serialType = serialType;
        this.args = args;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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

    public String getSerialType() {
        return serialType;
    }

    public void setSerialType(String serialType) {
        this.serialType = serialType;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}

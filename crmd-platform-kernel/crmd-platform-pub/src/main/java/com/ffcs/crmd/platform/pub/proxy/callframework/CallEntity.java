package com.ffcs.crmd.platform.pub.proxy.callframework;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.thoughtworks.xstream.converters.basic.StringBufferConverter;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by linzhiqiang on 16/3/8.
 */
public class CallEntity {

    private String uuid = UUID.randomUUID().toString();
    private String mod;
    private String serviceName;

    private String serialType;

    private String   methodName;
    private Class<?> returnType;
    private Object[] args;

    private ReqResult reqResult;
    private String key = "";
    private String baseKey = "";

    public CallEntity(String mod, String serviceName, String serialType, String methodName,
        Class<?> returnType, Object... args) {
        this.mod = mod;
        this.serviceName = serviceName;
        this.serialType = serialType;
        this.methodName = methodName;
        this.returnType = returnType;

        this.args = args;
    }

    public String getUuid() {
        return uuid;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSerialType() {
        return serialType;
    }

    public void setSerialType(String serialType) {
        this.serialType = serialType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getKey() {
        if (StringUtils.isNullOrEmpty(key)) {
            StringBuilder builder = new StringBuilder();
            builder.append(getBaseKey());
            for (int i = 0; i < args.length; i++) {
                builder.append(CallContextConstants.CALL_KEY_SPLIT);
                builder.append(StringUtils.strnull(args[i]));
            }
            key = builder.toString();
        }
        return key;
    }

    public String getBaseKey() {
        if (StringUtils.isNullOrEmpty(baseKey)) {
            StringBuilder builder = new StringBuilder();
            builder.append(mod);
            builder.append(CallContextConstants.CALL_KEY_SPLIT);
            builder.append(serviceName);
            builder.append(CallContextConstants.CALL_KEY_SPLIT);
            builder.append(methodName);
            builder.append(CallContextConstants.CALL_KEY_SPLIT);
            builder.append(serialType);
            baseKey = builder.toString();
        }
        return baseKey;
    }

    public ReqResult getReqResult() {
        return reqResult;
    }

    public void setReqResult(ReqResult reqResult) {
        this.reqResult = reqResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CallEntity that = (CallEntity) o;

        if (mod != null ? !mod.equals(that.mod) : that.mod != null)
            return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null)
            return false;
        if (serialType != null ? !serialType.equals(that.serialType) : that.serialType != null)
            return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null)
            return false;
        if (returnType != null ? !returnType.equals(that.returnType) : that.returnType != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(args, that.args);

    }

    @Override
    public int hashCode() {
        int result = mod != null ? mod.hashCode() : 0;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (serialType != null ? serialType.hashCode() : 0);
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        result = 31 * result + (returnType != null ? returnType.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(args);
        return result;
    }
}

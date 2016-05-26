package com.ffcs.crmd.platform.pub.bean.lazyloader;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public abstract class AbstractLoaderConfig {

    protected ILogger logger = LoggerFactory.getLogger(this.getClass());

    private Method setter;

    public Method getSetter() {
        return setter;
    }

    public void setSetter(Method setter) {
        this.setter = setter;
    }

    public void fillProps(Object srcObj, Object destObj) {
        try {
            getSetter().invoke(destObj, getPropFromSrc(srcObj, destObj));
        } catch (Exception e) {
            logger.error("could not set props,methodName:{}", getSetter().getName());
            ExceptionUtils.throwEx(e);
        }
    }

    public abstract Object getPropFromSrc(Object srcObj, Object destObj);
}

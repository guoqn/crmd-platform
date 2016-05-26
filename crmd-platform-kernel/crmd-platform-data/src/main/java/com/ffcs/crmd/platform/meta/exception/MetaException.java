package com.ffcs.crmd.platform.meta.exception;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;

import java.util.Map;

/**
 * Created by linzq on 2016/1/14.
 */
public class MetaException extends RtManagerException {
    public MetaException() {
    }

    public MetaException(Throwable throwable) {
        super(throwable);
    }

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Class clazz, String method, String code) {
        super(message, clazz, method, code);
    }

    public MetaException(String message, Class clazz, String method, String code, Map dataMap) {
        super(message, clazz, method, code, dataMap);
    }

    public MetaException(String message, Class clazz, String method, String code,
        Object... params) {
        super(message, clazz, method, code, params);
    }

    public MetaException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public MetaException(String message, Throwable throwable, String code) {
        super(message, throwable, code);
    }
}

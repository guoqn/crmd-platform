package com.ffcs.crmd.platform.idempotency.core.exception;

import java.util.Map;

import com.ctg.itrdc.platform.common.exception.RtManagerException;

public class IdempotencyException extends RtManagerException {
    
    private static final long serialVersionUID = -4946143626562697208L;
    
    public IdempotencyException() {
    }
    
    public IdempotencyException(Throwable throwable) {
        super(throwable);
    }
    
    public IdempotencyException(String message) {
        super(message);
    }
    
    public IdempotencyException(String message, Class<?> clazz, String method, String code) {
        super(message, clazz, method, code);
    }
    
    public IdempotencyException(String message, Class<?> clazz, String method, String code,
        Map<?, ?> dataMap) {
        super(message, clazz, method, code, dataMap);
    }
    
    public IdempotencyException(String message, Class<?> clazz, String method, String code,
        Object... params) {
        super(message, clazz, method, code, params);
    }
    
    public IdempotencyException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    public IdempotencyException(String message, Throwable throwable, String code) {
        super(message, throwable, code);
    }
}

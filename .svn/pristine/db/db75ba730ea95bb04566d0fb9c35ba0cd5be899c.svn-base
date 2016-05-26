package com.ffcs.crmd.platform.meta.daaction.interceptor.impl;

import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.IDaActionContextFactory;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorContext;
import com.ffcs.crmd.platform.meta.daaction.interceptor.IDaInterceptorContextFactory;
import org.springframework.stereotype.Component;

/**
 * Created by linzhiqiang on 16/2/15.
 */
@Component("defaultDaInterceptorContextFactory")
public class DefaultDaInterceptorContextFactory implements IDaInterceptorContextFactory {

    @Override
    public DaInterceptorContext createContect(Object entity, DaActionContext actionContext) {
        return DaInterceptorContext.EMPTY_CONTEXT;
    }
}

package com.ffcs.crmd.platform.meta.daaction.interceptor;

import com.ffcs.crmd.platform.meta.daaction.DaActionContext;

/**
 * Created by linzhiqiang on 16/2/15.
 */
public interface IDaInterceptorContextFactory {
    DaInterceptorContext createContect(Object entity,DaActionContext actionContext);

}

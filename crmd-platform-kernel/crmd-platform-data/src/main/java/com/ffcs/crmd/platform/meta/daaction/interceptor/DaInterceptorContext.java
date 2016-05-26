package com.ffcs.crmd.platform.meta.daaction.interceptor;

import com.ffcs.crmd.platform.meta.daaction.DaActionContext;

/**
 * Created by linzq on 2016/1/16.
 */
public class DaInterceptorContext {
    public static final DaInterceptorContext EMPTY_CONTEXT = new DaInterceptorContext();
    public static final String          DEFAULT_FACTORY = "defaultDaInterceptorContextFactory";
    public static final String          DEFINE_FACTORY  = "daInterceptorContextFactory";
    protected DaActionContext actionContext;

    public DaActionContext getActionContext() {
        return actionContext;
    }

    public void setActionContext(DaActionContext actionContext) {
        this.actionContext = actionContext;
    }
}

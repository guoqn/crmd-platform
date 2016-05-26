package com.ffcs.crmd.platform.meta.daaction.impl;

import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.IDaActionContextFactory;
import org.springframework.stereotype.Component;

/**
 * Created by linzhiqiang on 16/2/15.
 */
@Component("defaultDaActionContextFactory")
public class DefaultDaActionContextFactory implements IDaActionContextFactory {
    @Override
    public DaActionContext createContext(Object entity) {
        return DaActionContext.EMPTY_CONTEXT;
    }
}

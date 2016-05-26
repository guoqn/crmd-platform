package com.ffcs.crmd.platform.meta.daaction;

/**
 * Created by linzhiqiang on 16/2/15.
 */
public interface IDaActionContextFactory {

    DaActionContext createContext(Object entity);
}

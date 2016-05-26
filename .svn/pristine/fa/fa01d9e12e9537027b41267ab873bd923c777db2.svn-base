package com.ffcs.crmd.platform.meta.daaction.interceptor.impl;

import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.pool.DaInterceptorChainPool;
import com.ffcs.crmd.platform.meta.daaction.interceptor.pool.DaInterceptorChainPoolObjectFactory;

/**
 * Created by linzq on 2016/1/17.
 */
public class DaInterceptorChainFactory {
    private static DaInterceptorChainPool pool = new DaInterceptorChainPool(
        new DaInterceptorChainPoolObjectFactory());

    public static DaInterceptorChain createChain() {
        return pool.getResource();
    }

    public static void returnChain(DaInterceptorChain chain) {
        pool.returnResource(chain);
    }
}

package com.ffcs.crmd.platform.pub.interfaces.log.lmax;

import com.ffcs.crmd.lmax.pool.ObjectPool;

public class AsyncLogCommandPool extends ObjectPool<AsyncLogCommand> {
    public AsyncLogCommandPool(AsyncLogCommandPoolConfig poolConfig,
        AsyncLogCommandPoolObjectFactory factory) {
        super(poolConfig, factory);
    }
}

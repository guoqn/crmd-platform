package com.ffcs.crmd.platform.pub.interfaces.log.lmax;

import com.ffcs.crmd.lmax.pool.AbstractObjectPoolConfig;

public class AsyncLogCommandPoolConfig extends AbstractObjectPoolConfig {
    public AsyncLogCommandPoolConfig() {
    }

    public AsyncLogCommandPoolConfig(Boolean isLifo, Integer maxTotal, Integer maxIdle) {
        super(isLifo, maxTotal, maxIdle);
    }
}

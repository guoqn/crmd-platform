package com.ffcs.crmd.platform.pub.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Created by linzhiqiang on 16/3/12.
 */
public abstract class AbstractObjectPoolConfig extends GenericObjectPoolConfig {

    public static final int ABS_DEFAULT_MAX_TOTAL = -1;

    public static final int ABS_DEFAULT_MAX_IDLE = 500;

    public AbstractObjectPoolConfig() {
        this(false,ABS_DEFAULT_MAX_TOTAL,ABS_DEFAULT_MAX_IDLE);
    }

    public AbstractObjectPoolConfig(boolean isLifo,Integer maxTotal,Integer maxIdle) {
        setLifo(isLifo);
        //默认不限制最大
        if (maxTotal == null) {
            setMaxTotal(ABS_DEFAULT_MAX_TOTAL);
        } else {
            setMaxTotal(maxTotal);
        }

        //最大空闲对象
        if (maxIdle == null) {
            setMaxIdle(ABS_DEFAULT_MAX_IDLE);
        } else {
            setMaxIdle(maxIdle);
        }
    }


}

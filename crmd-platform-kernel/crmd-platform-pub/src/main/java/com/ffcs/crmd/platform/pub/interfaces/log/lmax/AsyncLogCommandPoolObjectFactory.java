package com.ffcs.crmd.platform.pub.interfaces.log.lmax;

import com.ffcs.crmd.lmax.pool.AbstractPoolObjectFactory;

/**
 * Created by linzhiqiang on 16/3/25.
 */
public class AsyncLogCommandPoolObjectFactory extends AbstractPoolObjectFactory<AsyncLogCommand> {
    @Override
    public AsyncLogCommand createObject() {
        return new AsyncLogCommand();
    }
}

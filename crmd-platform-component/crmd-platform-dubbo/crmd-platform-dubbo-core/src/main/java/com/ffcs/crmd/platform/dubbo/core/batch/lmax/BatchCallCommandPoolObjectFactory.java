package com.ffcs.crmd.platform.dubbo.core.batch.lmax;

import com.ffcs.crmd.lmax.pool.AbstractPoolObjectFactory;

/**
 * Created by linzhiqiang on 16/3/25.
 */
public class BatchCallCommandPoolObjectFactory extends AbstractPoolObjectFactory<BatchCallCommand> {
    @Override
    public BatchCallCommand createObject() {
        return new BatchCallCommand();
    }
}

package com.ffcs.crmd.platform.pub.proxy.callframework.lmax;

import com.ffcs.crmd.lmax.pool.AbstractPoolObjectFactory;

/**
 * Created by linzhiqiang on 16/3/25.
 */
public class ModCallCommandPoolObjectFactory extends AbstractPoolObjectFactory<ModCallCommand> {
    @Override
    public ModCallCommand createObject() {
        return new ModCallCommand();
    }
}

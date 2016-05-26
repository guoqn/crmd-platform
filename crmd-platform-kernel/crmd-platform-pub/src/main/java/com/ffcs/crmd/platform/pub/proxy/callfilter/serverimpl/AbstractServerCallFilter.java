package com.ffcs.crmd.platform.pub.proxy.callfilter.serverimpl;

import com.ffcs.crmd.platform.pub.proxy.callfilter.AbstractCallFilter;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public abstract class AbstractServerCallFilter extends AbstractCallFilter {
    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}

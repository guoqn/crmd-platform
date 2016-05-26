package com.ffcs.crmd.platform.pub.proxy.callfilter.serverimpl;

import com.ffcs.crmd.platform.pub.proxy.callfilter.CallFilterManager;
import com.ffcs.crmd.platform.pub.proxy.callfilter.impl.AbstractProxyCallFilter;

/**
 * Created by linzhiqiang on 16/4/27.
 */
public abstract class AbstractCompServerCallFilter extends AbstractProxyCallFilter {

    public AbstractCompServerCallFilter() {
        CallFilterManager.getInstance().registerServerCallFilter(this);
    }

    @Override
    public abstract int getOrder();
}

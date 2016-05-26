package com.ffcs.crmd.platform.pub.proxy.callfilter.impl;

import com.ffcs.crmd.platform.pub.proxy.callfilter.AbstractCallFilter;
import com.ffcs.crmd.platform.pub.proxy.callfilter.ICallFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/2/16.
 */
public abstract class AbstractProxyCallFilter extends AbstractCallFilter {

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}

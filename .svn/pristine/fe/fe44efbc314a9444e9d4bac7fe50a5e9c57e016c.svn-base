package com.ffcs.crmd.platform.pub.proxy.callfilter.impl;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.proxy.callfilter.CallFilterManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/4/27.
 */
public abstract class AbstractCompProxyCallFilter extends AbstractProxyCallFilter {

    public AbstractCompProxyCallFilter() {
        CallFilterManager.getInstance().registerProxyCallFilter(this);
    }

    @Override
    public abstract int getOrder();
}

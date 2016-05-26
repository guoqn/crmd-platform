package com.ffcs.crmd.platform.pub.interfaces.filter.impl.client;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractAfterFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractClientAfterFilter extends AbstractAfterFilter {
    public AbstractClientAfterFilter() {
        super();
        ClientInterfFilterManager
            .getInstance().registerAfterFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

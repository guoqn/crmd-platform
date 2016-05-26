package com.ffcs.crmd.platform.pub.interfaces.filter.impl.client;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractBeforeFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractClientBeforeFilter extends AbstractBeforeFilter {
    public AbstractClientBeforeFilter() {
        super();
        ClientInterfFilterManager
            .getInstance().registerBeforeFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

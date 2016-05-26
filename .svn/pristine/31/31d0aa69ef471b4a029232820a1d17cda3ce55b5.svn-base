package com.ffcs.crmd.platform.pub.interfaces.filter.impl.client;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractPostFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractClientPostFilter extends AbstractPostFilter {
    public AbstractClientPostFilter() {
        super();
        ClientInterfFilterManager
            .getInstance().registerPostFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

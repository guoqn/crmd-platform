package com.ffcs.crmd.platform.pub.interfaces.filter.impl.client;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractPreFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractClientPreFilter extends AbstractPreFilter {

    public AbstractClientPreFilter() {
        super();
        ClientInterfFilterManager
            .getInstance().registerPreFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

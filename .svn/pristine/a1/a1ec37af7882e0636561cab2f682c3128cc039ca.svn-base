package com.ffcs.crmd.platform.pub.interfaces.filter.impl.server;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractPreFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractServerPreFilter extends AbstractPreFilter {

    public AbstractServerPreFilter() {
        super();
        ServerInterfFilterManager.getInstance().registerPreFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

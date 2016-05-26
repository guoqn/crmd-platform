package com.ffcs.crmd.platform.pub.interfaces.filter.impl.server;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractBeforeFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractServerBeforeFilter extends AbstractBeforeFilter {
    public AbstractServerBeforeFilter() {
        super();
        ServerInterfFilterManager.getInstance().registerBeforeFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

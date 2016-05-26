package com.ffcs.crmd.platform.pub.interfaces.filter.impl.server;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractAfterFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractBeforeFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractServerAfterFilter extends AbstractAfterFilter {
    public AbstractServerAfterFilter() {
        super();
        ServerInterfFilterManager.getInstance().registerAfterFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

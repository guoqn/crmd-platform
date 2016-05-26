package com.ffcs.crmd.platform.pub.interfaces.filter.impl.server;

import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractBeforeFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.impl.AbstractPostFilter;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractServerPostFilter extends AbstractPostFilter {
    public AbstractServerPostFilter() {
        super();
        ServerInterfFilterManager.getInstance().registerPostFilter(getRequester(),getResponder(),getExtraKey(),this);
    }
}

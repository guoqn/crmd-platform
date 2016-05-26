package com.ffcs.crmd.platform.pub.interfaces.filter.impl;

import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.filter.FilterRetObject;
import com.ffcs.crmd.platform.pub.interfaces.filter.IInterfFilter;
import com.ffcs.crmd.platform.pub.interfaces.handle.AbstractInterfHandler;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public abstract class AbstractInterfFilter implements IInterfFilter {

    @Override
    public FilterRetObject filter(IMsgContext contect, AbstractInterfHandler handler) {
        return doFilter(contect, handler);
    }

    protected abstract FilterRetObject doFilter(IMsgContext contect, AbstractInterfHandler handler);
}

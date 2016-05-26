package com.ffcs.crmd.platform.pub.interfaces.handle.impl;

import com.ffcs.crmd.platform.pub.interfaces.config.IInterfConfigure;
import com.ffcs.crmd.platform.pub.interfaces.config.InterfConfigureFactory;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.entity.RetObject;
import com.ffcs.crmd.platform.pub.interfaces.filter.IAfterFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.IBeforeFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.IPostFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.IPreFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.impl.server.ServerInterfFilterManager;
import com.ffcs.crmd.platform.pub.interfaces.handle.AbstractInterfHandler;

import java.util.List;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public abstract class AbstractServerInterfHandler extends AbstractInterfHandler {

    @Override
    protected IInterfConfigure getConfigure() {
        return InterfConfigureFactory.getServerConfigure();
    }

    @Override
    public RetObject preHandle(IMsgContext context) {
        RetObject object = super.preHandle(context);
        List<IPreFilter> filters = ServerInterfFilterManager.getInstance()
            .getPreFilters(getRequester(), getResponder(), getExtraKey());
        if (filters != null && filters.size() > 0) {
            for (IPreFilter filter : filters) {
                filter.filter(context, this);
            }
        }
        return object;
    }

    @Override
    public RetObject beforeHandle(IMsgContext context) {
        RetObject object = super.beforeHandle(context);
        List<IBeforeFilter> filters = ServerInterfFilterManager.getInstance()
            .getBeforeFilters(getRequester(), getResponder(), getExtraKey());
        if (filters != null && filters.size() > 0) {
            for (IBeforeFilter filter : filters) {
                filter.filter(context, this);
            }
        }
        return object;
    }

    @Override
    public RetObject afterHandle(IMsgContext context) {
        RetObject object = super.afterHandle(context);
        List<IAfterFilter> filters = ServerInterfFilterManager.getInstance()
            .getAfterFilters(getRequester(), getResponder(), getExtraKey());
        if (filters != null && filters.size() > 0) {
            for (IAfterFilter filter : filters) {
                filter.filter(context, this);
            }
        }
        return object;
    }

    @Override
    public RetObject postHandle(IMsgContext context) {
        RetObject object = super.postHandle(context);
        List<IPostFilter> filters = ServerInterfFilterManager.getInstance()
            .getPostFilters(getRequester(), getResponder(), getExtraKey());
        if (filters != null && filters.size() > 0) {
            for (IPostFilter filter : filters) {
                filter.filter(context, this);
            }
        }
        return object;
    }
}

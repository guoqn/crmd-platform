package com.ffcs.crmd.platform.meta.daaction.interceptor.impl;

import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptor;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorContext;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorManager;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

/**
 * Created by linzq on 2016/1/17.
 */
public abstract class AbstractDaInterceptor implements DaInterceptor {

    public AbstractDaInterceptor() {
        DaInterceptorManager.getInstance().registerInterceptor(this);
    }

    @Override
    public boolean onSave(DaInterceptorChain chain, DaInterceptorContext context,  Object entity) {
        boolean save = doSave(context,entity);
        if (save) {
            return chain.onSave(context,entity);
        }
        return save;
    }

    @Override
    public boolean onUpdate(DaInterceptorChain chain, DaInterceptorContext context, Object entity) {
        boolean update = doUpdate(context,entity);
        if (update) {
            return chain.onUpdate(context,entity);
        }
        return update;
    }

    @Override
    public boolean onDelete(DaInterceptorChain chain, DaInterceptorContext context, Object entity) {
        boolean del = doDelete(context,entity);
        if (del) {
            return chain.onDelete(context,entity);
        }
        return del;
    }

    public boolean doSave(DaInterceptorContext context, Object entity) {
        return true;
    }

    public boolean doUpdate(DaInterceptorContext context, Object entity) {
        return true;
    }

    public boolean doDelete(DaInterceptorContext context, Object entity) {
        return true;
    }
}

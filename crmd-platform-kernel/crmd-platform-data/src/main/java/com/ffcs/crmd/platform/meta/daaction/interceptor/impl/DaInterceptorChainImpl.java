package com.ffcs.crmd.platform.meta.daaction.interceptor.impl;

import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptor;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorContext;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzq on 2016/1/17.
 */
public class DaInterceptorChainImpl implements DaInterceptorChain {

    private List<DaInterceptor> interceptors = new ArrayList<DaInterceptor>();

    private int pos = 0;

    public DaInterceptorChainImpl(List<DaInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    @Override
    public boolean onSave(DaInterceptorContext context, Object entity) {
        if (pos < getInterceptorSize()) {
            return nextInterceptor().onSave(this,context,entity);
        }
        return true;
    }

    @Override
    public boolean onUpdate(DaInterceptorContext context, Object entity) {
        if (pos < getInterceptorSize()) {
            return nextInterceptor().onUpdate(this,context,entity);
        }
        return true;
    }

    @Override
    public boolean onDelete(DaInterceptorContext context, Object entity) {
        if (pos < getInterceptorSize()) {
            return nextInterceptor().onDelete(this,context,entity);
        }
        return true;
    }

    @Override
    public void reset() {
        pos = 0;
    }

    public int getInterceptorSize() {
        if (interceptors == null) {
            return 0;
        }
        return interceptors.size();
    }

    private DaInterceptor nextInterceptor() {
        return interceptors.get(pos++);
    }
}

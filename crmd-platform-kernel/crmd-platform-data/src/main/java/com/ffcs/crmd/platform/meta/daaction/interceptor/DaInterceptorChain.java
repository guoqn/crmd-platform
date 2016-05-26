package com.ffcs.crmd.platform.meta.daaction.interceptor;

import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

/**
 * Created by linzq on 2016/1/17.
 */
public interface DaInterceptorChain {

    boolean onSave(DaInterceptorContext context, Object entity);

    boolean onUpdate(DaInterceptorContext context, Object entity);

    boolean onDelete(DaInterceptorContext context, Object entity);

    void reset();
}

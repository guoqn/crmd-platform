package com.ffcs.crmd.platform.meta.daaction.interceptor;

import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

/**
 * Created by linzq on 2016/1/16.
 */
public interface DaInterceptor {
    /**
     * 保存前的判断
     * @param context
     * @param entity
     * @return
     */
    boolean onSave(DaInterceptorChain chain, DaInterceptorContext context, Object entity);

    /**
     * 更新前的判断
     * @param context
     * @param entity
     * @return
     */
    boolean onUpdate(DaInterceptorChain chain, DaInterceptorContext context, Object entity);

    /**
     * 删除前的判断
     * @param context
     * @param entity
     * @return
     */
    boolean onDelete(DaInterceptorChain chain, DaInterceptorContext context, Object entity);
}

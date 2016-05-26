package com.ffcs.crmd.platform.meta.client.interceptor;

import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorContext;
import com.ffcs.crmd.platform.meta.daaction.interceptor.impl.AbstractDaInterceptor;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.provider.TableMetaData;

/**
 * Created by linzq on 2016/1/17.
 */
public class TestSaveInterceptor extends AbstractDaInterceptor {

    public TestSaveInterceptor() {
        super();
    }

    @Override
    public boolean doSave(DaInterceptorContext context, Object entity) {
        System.out.println(this.getClass().getName());
        return true;
    }

    @Override
    public boolean doUpdate(DaInterceptorContext context, Object entity) {
        System.out.println(this.getClass().getName());

        return false;
    }
}

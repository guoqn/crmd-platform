package com.ffcs.crmd.platform.meta.daaction;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.meta.daaction.impl.DeleteDaAction;
import com.ffcs.crmd.platform.meta.daaction.impl.SaveDaAction;
import com.ffcs.crmd.platform.meta.daaction.impl.UpdateDaAction;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * Created by linzq on 2016/1/18.
 */
public class DaActionSupport {

    private static final IDaActionContextFactory EMPTY_FACTORY = new IDaActionContextFactory() {
        @Override
        public DaActionContext createContext(Object entity) {
            return DaActionContext.EMPTY_CONTEXT;
        }
    };

    protected static IDaActionContextFactory getContextFactory() {
        if (ApplicationContextUtil.containsBean(DaActionContext.DEFINE_FACTORY)) {
            return ApplicationContextUtil.getBean(DaActionContext.DEFINE_FACTORY);
        } else if (ApplicationContextUtil.containsBean(DaActionContext.DEFAULT_FACTORY)) {
            return ApplicationContextUtil.getBean(DaActionContext.DEFAULT_FACTORY);
        } else {
            return EMPTY_FACTORY;
        }
    }

    protected static DaActionContext getContext(Object entity) {
        return getContextFactory().createContext(entity);
    }

    public static RetVo doSaveAction(Object entity) {
        RetVo vo = new SaveDaAction(getContext(entity), entity).action();
        return vo;
    }

    public static RetVo doUpdateAction(Object entity) {
        RetVo vo = new UpdateDaAction(getContext(entity), entity).action();
        return vo;
    }

    public static RetVo doDeleteAction(Object entity) {
        RetVo vo = new DeleteDaAction(getContext(entity), entity).action();
        return vo;
    }

}

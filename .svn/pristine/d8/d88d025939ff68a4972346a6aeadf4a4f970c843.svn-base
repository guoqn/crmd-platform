package com.ffcs.crmd.platform.meta.daaction.impl;

import com.ctg.itrdc.platform.data.dao.IBaseDao;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.meta.daaction.IDaActionContextFactory;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorContext;
import com.ffcs.crmd.platform.meta.daaction.interceptor.IDaInterceptorContextFactory;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.IDaAction;
import com.ffcs.crmd.platform.meta.daaction.filter.IDaActionFilter;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by linzq on 2016/1/16.
 */
public abstract class BaseDaAction implements IDaAction {
    protected JdbcTemplate jdbcTemplate = ApplicationContextUtil.getBean("jdbcTemplate");

    protected IBaseDao groupDao = ApplicationContextUtil.getBean("baseDao");

    protected DaActionContext context;

    protected Object entity;

    protected static final IDaInterceptorContextFactory EMPTY_FACTORY = new IDaInterceptorContextFactory() {
        @Override
        public DaInterceptorContext createContect(Object entity,
            DaActionContext actionContext) {
            return DaInterceptorContext.EMPTY_CONTEXT;
        }
    };

    public BaseDaAction(DaActionContext context, Object entity) {
        this.context = context;
        this.entity = entity;
    }

    public abstract IDaActionFilter getActionFilter();

    public abstract boolean interceptor();

    @Override
    public RetVo action() {
        if (!interceptor()) {
            return new RetVo(false, "interceptor Action");
        }
        RetVo vo = new RetVo(true);
        IDaActionFilter filter = getActionFilter();
        if (filter != null) {
            filter.doBeforeAction(context, entity,getActionType());
        }
        vo = doAction(context, entity);
        if (filter != null) {
            filter.doAfterAction(context, entity,getActionType());
        }
        return vo;
    }

    protected abstract ActionType getActionType();

    public abstract RetVo doAction(DaActionContext context, Object entity);

    protected IDaInterceptorContextFactory getInterceptorContextFactory() {
        if (ApplicationContextUtil.containsBean(DaInterceptorContext.DEFINE_FACTORY)) {
            return ApplicationContextUtil.getBean(DaInterceptorContext.DEFINE_FACTORY);
        } else if (ApplicationContextUtil.containsBean(DaInterceptorContext.DEFAULT_FACTORY)) {
            return ApplicationContextUtil.getBean(DaInterceptorContext.DEFAULT_FACTORY);
        } else {
            return EMPTY_FACTORY;
        }
    }

    protected DaInterceptorContext getInterceptorContext(Object entity,DaActionContext actionContext) {
        return getInterceptorContextFactory().createContect(entity,actionContext);
    }
}

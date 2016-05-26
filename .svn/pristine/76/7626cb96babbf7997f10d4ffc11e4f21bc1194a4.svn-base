package com.ffcs.crmd.platform.meta.daaction.impl;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.DaActionSupport;
import com.ffcs.crmd.platform.meta.daaction.filter.DaActionFilterFactory;
import com.ffcs.crmd.platform.meta.daaction.filter.IDaActionFilter;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.impl.DaInterceptorChainFactory;
import com.ffcs.crmd.platform.meta.entity.impl.BaseAttrEntityImpl;
import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.util.DaoSupport;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzq on 2016/1/16.
 */
public class SaveDaAction extends BaseDaAction {

    public SaveDaAction(DaActionContext context, Object entity) {
        super(context, entity);
    }

    @Override
    public IDaActionFilter getActionFilter() {
        return DaActionFilterFactory.getSaveActionFilter(entity);
    }

    @Override
    public boolean interceptor() {
        DaInterceptorChain chain = DaInterceptorChainFactory.createChain();
        try {
            return chain.onSave(getInterceptorContext(entity, context), entity);
        } finally {
            DaInterceptorChainFactory.returnChain(chain);
        }
    }

    @Override
    protected ActionType getActionType() {
        return ActionType.SAVE;
    }

    @Override
    public RetVo doAction(DaActionContext context, Object entity) {
        RetVo vo = new RetVo(true);
        List<RetVo> vos = new ArrayList<RetVo>();

        String sql = "";
        List<Object> params = new ArrayList<Object>();

        int i = 0;
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            if (entity instanceof CrmBaseMetaEntityImpl) {
                List<BaseAttrEntityImpl> insts = ((CrmBaseMetaEntityImpl) entity).readAttrInsts();
                if (insts != null && !insts.isEmpty()) {
                    for (BaseAttrEntityImpl entityInst : insts) {
                        entityInst.setMasterId(((CrmBaseMetaEntityImpl) entity).getId());
                        RetVo instVo = DaActionSupport.doSaveAction(entityInst);
                        vos.add(instVo);
                    }
                }
            }
            IMetaEntity metaEntity = (IMetaEntity) entity;
            if (metaEntity.getId() != null) {
                sql = metaEntity.readTableMeta().getInsertWithPkOp().getSql();
                List<String> paramNbrs = metaEntity.readTableMeta().getInsertWithPkOp().getAttrs();
                params = metaEntity.readTableMeta().getInsertWithPkOp()
                    .buildParamsList(metaEntity, paramNbrs);
            } else {
                sql = metaEntity.readTableMeta().getInsertAutoPkOp().getSql();
                params = metaEntity.readTableMeta().getInsertAutoPkOp().buildParamsList(metaEntity,
                    metaEntity.readTableMeta().getInsertAutoPkOp().getAttrs());
            }
            i = DaoSupport.excuteUpate(sql, params);
        } else if (entity instanceof BaseEntity) {
            i = groupDao.insert((BaseEntity) entity);
        } else {
            ExceptionUtils.throwEx(new RtManagerException("not support operation"));
        }
        vo.setObject(i);
        return vo;
    }

}

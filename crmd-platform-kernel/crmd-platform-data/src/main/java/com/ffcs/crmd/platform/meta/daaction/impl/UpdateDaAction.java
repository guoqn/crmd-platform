package com.ffcs.crmd.platform.meta.daaction.impl;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.DaActionSupport;
import com.ffcs.crmd.platform.meta.daaction.filter.DaActionFilterFactory;
import com.ffcs.crmd.platform.meta.daaction.filter.IDaActionFilter;
import com.ffcs.crmd.platform.meta.entity.impl.AttrOpType;
import com.ffcs.crmd.platform.meta.entity.impl.BaseAttrEntityImpl;
import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.impl.DaInterceptorChainFactory;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.IOpMetaInfo;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.util.DaoSupport;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzq on 2016/1/16.
 */
public class UpdateDaAction extends BaseDaAction {

    public UpdateDaAction(DaActionContext context, Object entity) {
        super(context, entity);
    }

    @Override
    public IDaActionFilter getActionFilter() {
        return DaActionFilterFactory.getUpdateActionFilter(entity);
    }

    @Override
    public boolean interceptor() {
        DaInterceptorChain chain = DaInterceptorChainFactory.createChain();
        try {
            return chain.onUpdate(getInterceptorContext(entity, context), entity);
        } finally {
            DaInterceptorChainFactory.returnChain(chain);
        }
    }

    @Override
    protected ActionType getActionType() {
        return ActionType.UPDATE;
    }

    @Override
    public RetVo doAction(DaActionContext context, Object entity) {
        int i = 0;
        List<RetVo> vos = new ArrayList<RetVo>();

        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            if (entity instanceof CrmBaseMetaEntityImpl) {
                List<BaseAttrEntityImpl> insts = ((CrmBaseMetaEntityImpl) entity).readAttrInsts();
                if (insts != null && !insts.isEmpty()) {
                    for (BaseAttrEntityImpl entityInst : insts) {
                        RetVo vo = new RetVo();
                        entityInst.setMasterId(((CrmBaseMetaEntityImpl) entity).getId());
                        if (AttrOpType.ADD.op().equals(entityInst.getAttrOpType())) {
                            vo = DaActionSupport.doSaveAction(entityInst);
                        } else if (AttrOpType.UPDATE.op().equals(entityInst.getAttrOpType())) {
                            vo = DaActionSupport.doUpdateAction(entityInst);
                        } else if (AttrOpType.DEL.op().equals(entityInst.getAttrOpType())) {
                            vo = DaActionSupport.doDeleteAction(entityInst);
                        }
                        vos.add(vo);
                    }
                }
            }
            IMetaEntity metaEntity = (IMetaEntity) entity;
            ITableMetaData metaData = metaEntity.readTableMeta();
            IOpMetaInfo op = null;
            if (metaData.hasInnerShard(metaEntity)) {
                op = metaData.getUpdateOpByPkAndAllSk();
            } else {
                op = metaData.getUpdateOpByPkAndTableSk();
            }
            String sql = op.getSql();
            List<Object> params = op.buildParamsList(metaEntity, op.getAttrs());
            i = DaoSupport.excuteUpate(sql, params);
        } else if (entity instanceof BaseEntity) {
            i = groupDao.updateByPrimaryKey((BaseEntity) entity);
        } else {
            ExceptionUtils.throwEx(new RtManagerException("not support operation"));
        }
        RetVo vo = new RetVo(true);

        vo.setObject(i);
        return vo;
    }

}

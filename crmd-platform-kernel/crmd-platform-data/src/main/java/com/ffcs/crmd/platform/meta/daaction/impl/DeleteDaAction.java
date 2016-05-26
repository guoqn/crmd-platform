package com.ffcs.crmd.platform.meta.daaction.impl;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.DaActionSupport;
import com.ffcs.crmd.platform.meta.daaction.filter.DaActionFilterFactory;
import com.ffcs.crmd.platform.meta.daaction.filter.IDaActionFilter;
import com.ffcs.crmd.platform.meta.entity.impl.BaseAttrEntityImpl;
import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.impl.DaInterceptorChainFactory;
import com.ffcs.crmd.platform.meta.provider.IOpMetaInfo;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.util.DaoSupport;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzq on 2016/1/16.
 */
public class DeleteDaAction extends BaseDaAction {

    public DeleteDaAction(DaActionContext context, Object entity) {
        super(context, entity);
    }

    @Override
    public IDaActionFilter getActionFilter() {
        return DaActionFilterFactory.getDeleteActionFilter(entity);
    }

    @Override
    public boolean interceptor() {
        DaInterceptorChain chain = DaInterceptorChainFactory.createChain();
        try {
            return chain.onDelete(getInterceptorContext(entity, context), entity);
        } finally {
            DaInterceptorChainFactory.returnChain(chain);
        }
    }

    @Override
    protected ActionType getActionType() {
        return ActionType.DELETE;
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
                        entityInst.setMasterId(((CrmBaseMetaEntityImpl) entity).getId());
                        RetVo vo = DaActionSupport.doDeleteAction(entityInst);
                        vos.add(vo);
                    }
                }
            }

            IMetaEntity metaEntity = (IMetaEntity) entity;
            ITableMetaData metaData = metaEntity.readTableMeta();
            IOpMetaInfo op = null;
            if (metaData.hasInnerShard(metaEntity)) {
                op = metaData.getDeleteOpByPkAndAllSk();
            } else {
                op = metaData.getDeleteOpByPkAndTableSk();
            }
            String sql = op.getSql();
            List<Object> params = op.buildParamsList(metaEntity, op.getAttrs());
            i = DaoSupport.excuteUpate(sql, params);
        } else if (entity instanceof BaseEntity) {
            i = groupDao.deleteByPrimaryKey((BaseEntity) entity);
        } else {
            ExceptionUtils.throwEx(new RtManagerException("not support operation"));
        }
        RetVo vo = new RetVo(true);

        vo.setObject(i);
        return vo;
    }

}

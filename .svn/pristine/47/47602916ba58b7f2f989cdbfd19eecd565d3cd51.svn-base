package com.ffcs.crmd.platform.idempotency.core.service.impl;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.idempotency.api.service.IIdempotencyDataService;
import com.ffcs.crmd.platform.idempotency.core.constants.IdempotencyConstant;
import com.ffcs.crmd.platform.idempotency.core.vo.SysWorkItemObjVo;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

@Service("idempotencyDataService")
public class IdempotencyDataServiceImpl implements IIdempotencyDataService {
    
    @Override
    public boolean isSysWorkRunning() {
        if (IdempotencyConstant.SysWorkStatus.RUNNING.equals(CrmSessionContext.getContext()
            .getSysWorkStatus())) {
            return true;
        }
        return false;
    }
    
    private int commOperation(BaseEntity<?> entity, String operType) {
        SysWorkItemObjVo objVo = new SysWorkItemObjVo();
        objVo.setEntt((AbstractCrmDomBaseEntityImpl<?>) entity);
        objVo.setOperType(operType);
        CrmSessionContext.getContext().addSysWorkItemObj(objVo);
        //默认返回0，使用分布式事务幂等性组件时，需注意不要使用返回的执行记录数
        return 0;
    }
    
    @Override
    public int insert(BaseEntity<?> entity) {
        return this.commOperation(entity, IdempotencyConstant.OperType.INSERT);
    }
    
    @Override
    public int updateByPrimaryKey(BaseEntity<?> entity) {
        return this.commOperation(entity, IdempotencyConstant.OperType.UPDATE_BY_PRIMARY_KEY);
    }
    
    @Override
    public int deleteByPrimaryKey(BaseEntity<?> entity) {
        return this.commOperation(entity, IdempotencyConstant.OperType.DELETE_BY_PRIMARY_KEY);
    }
    
    @Override
    public int updateSelectiveByPrimaryKey(BaseEntity<?> entity) {
        return this.commOperation(entity,
            IdempotencyConstant.OperType.UPDATE_SELECTIVE_BY_PRIMARY_KEY);
    }
    
}

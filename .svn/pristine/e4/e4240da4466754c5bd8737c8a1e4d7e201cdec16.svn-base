package com.ffcs.crmd.platform.idempotency.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;
import com.ffcs.crmd.platform.idempotency.core.constants.IdempotencyConstant;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkItem;
import com.ffcs.crmd.platform.idempotency.core.exception.IdempotencyException;
import com.ffcs.crmd.platform.idempotency.core.repository.ISysWorkItemRepository;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

@Repository("sysWorkItemRepository")
public class SysWorkItemRepositoryImpl extends AbstractCrmDomBaseRepository<SysWorkItem, Long>
    implements ISysWorkItemRepository {
    
    public SysWorkItemRepositoryImpl() {
        super(SysWorkItem.class);
    }
    
    @Override
    public List<SysWorkItem> querySysWorkItemBySheetId(Long sheetId) {
        List<Object> params = new ArrayList<Object>();
        params.add(sheetId);
        return this.jdbcFindListByName("sysWorkItemRepository.queryWorkItemBySheetId",
            SysWorkItem.class, params);
    }
    
    private int innerGetWorkItemActionCnt(String tableName, Long workItemId, Object shardingId) {
        if (StringUtils.isNullOrEmpty(tableName)) {
            ExceptionUtils.throwEx(new IdempotencyException("表名不能为空"));
        }
        if (workItemId == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项标识不能为空"));
        }
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<Object>();
        params.add(workItemId);
        sql.append("select count(*) from ").append(tableName).append(" where item_id = ?");
        if (shardingId != null) {
            sql.append(" and sharding_id = ?");
            params.add(shardingId);
            
        }
        return this.jdbcQueryForInt(sql.toString(), params.toArray());
    }
    
    @Override
    public int getWorkItemActionCnt(String tableName, Long workItemId, Object shardingId) {
        return this.innerGetWorkItemActionCnt(tableName, workItemId, shardingId);
    }
    
    @Override
    public int getWorkItemActionCnt(String tableName, Long workItemId) {
        return this.innerGetWorkItemActionCnt(tableName, workItemId, null);
    }
    
    private void innerSaveWorkItemAction(String tableName, SysWorkItem sysWorkItem,
        Object shardingId) {
        if (StringUtils.isNullOrEmpty(tableName)) {
            ExceptionUtils.throwEx(new IdempotencyException("表名不能为空"));
        }
        if (sysWorkItem == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项不能为空"));
        }
        StringBuffer sql = new StringBuffer();
        sql.append("insert into ");
        sql.append(tableName);
        sql.append("(action_id,item_id,sheet_id,area_id,region_cd,status_cd,");
        sql.append("status_date,create_staff,create_date,update_staff,");
        sql.append("update_date,dversion,dtimestamp");
        if (shardingId != null) {
            sql.append(",sharding_id");
        }
        sql.append(") values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
        if (shardingId != null) {
            sql.append(",?");
        }
        sql.append(")");
        List<Object> params = new ArrayList<Object>();
        params.add(CrmEntityUtils.getSeq(IdempotencyConstant.SEQ_SYS_WORK_ITEM_ACTION_ID));
        params.add(sysWorkItem.getId());
        params.add(sysWorkItem.getSheetId());
        params.add(CrmSessionContext.getContext().getRegionId());
        params.add(CrmSessionContext.getContext().getRegionId());
        params.add(IdempotencyConstant.SysWorkActionStatus.COMPLETE);
        params.add(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
        params.add(CrmSessionContext.getContext().getStaffId());
        params.add(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
        params.add(CrmSessionContext.getContext().getStaffId());
        params.add(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
        params.add(0L);
        params.add(DateUtils.getNowDate().getTime());
        if (shardingId != null) {
            params.add(shardingId);
        }
        this.getJdbcTemplate().update(sql.toString(), params.toArray());
    }
    
    @Override
    public void saveWorkItemAction(String tableName, SysWorkItem sysWorkItem, Object shardingId) {
        this.innerSaveWorkItemAction(tableName, sysWorkItem, shardingId);
    }
    
    @Override
    public void saveWorkItemAction(String tableName, SysWorkItem sysWorkItem) {
        this.innerSaveWorkItemAction(tableName, sysWorkItem, null);
    }
    
}

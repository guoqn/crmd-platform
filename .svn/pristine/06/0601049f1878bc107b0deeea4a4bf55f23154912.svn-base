package com.ffcs.crmd.platform.idempotency.core.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkItem;

public interface ISysWorkItemRepository extends ICrmDomBaseRepository<SysWorkItem, Long> {
    
    /**
     * 
     * 查询事务事件项.
     * 
     * @param sheetId
     * @return
     */
    public List<SysWorkItem> querySysWorkItemBySheetId(Long sheetId);
    
    /**
     * 
     * 查询是事务事件项响应数量(分片表).
     * @param tableName
     * @param workItemId
     * @param shardingId
     * @return
     */
    public int getWorkItemActionCnt(String tableName, Long workItemId, Object shardingId);
    
    /**
     * 
     * 查询是事务事件项响应数量(单库表).
     * @param tableName
     * @param workItemId
     * @return
     */
    public int getWorkItemActionCnt(String tableName, Long workItemId);
    
    /**
     * 
     * 写入事务事件响应表（分片表）.
     * 
     * @param tableName
     * @param sysWorkItem
     * @param shardingId
     */
    public void saveWorkItemAction(String tableName, SysWorkItem sysWorkItem, Object shardingId);
    
    /**
     * 
     * 写入事务事件响应表（单库表）.
     * 
     * @param tableName
     * @param sysWorkItem
     */
    public void saveWorkItemAction(String tableName, SysWorkItem sysWorkItem);
    
}

package com.ffcs.crmd.platform.idempotency.core.service.impl;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.base.utils.CastorUtils;
import com.ffcs.crmd.platform.idempotency.core.constants.IdempotencyConstant;
import com.ffcs.crmd.platform.idempotency.core.entity.ShardingRule;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkItem;
import com.ffcs.crmd.platform.idempotency.core.exception.IdempotencyException;
import com.ffcs.crmd.platform.idempotency.core.service.ISysWorkItemService;
import com.ffcs.crmd.platform.idempotency.core.vo.SysWorkItemObjVo;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

@Service("sysWorkItemService")
public class SysWorkItemServiceImpl implements ISysWorkItemService {
    
    private static final ILogger LOGGER = LoggerFactory.getLogger(CastorUtils.class);
    
    /**
     * 
     * 执行事务事件项.
     * 
     * @param sysWorkItem
     */
    @Override
    public void processSysWorkItem(SysWorkItem sysWorkItem) {
        if (sysWorkItem == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项不能为空"));
        }
        LOGGER.debug("执行事务事件项Id:" + sysWorkItem.getId());
        //判断是否已有事件项响应记录
        if (this.hasProcessSysWorkItem(sysWorkItem)) {
            LOGGER.debug("已执行过事务事件项Id：" + sysWorkItem.getId() + "不再重复执行");
            //直接返回
            return;
        }
        if (sysWorkItem.getObjList() == null || sysWorkItem.getObjList().size() == 0) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项操作对象列表不能为空"));
        }
        //遍历执行事务事件项操作对象
        for (SysWorkItemObjVo objVo : sysWorkItem.getObjList()) {
            this.processEntity(objVo, sysWorkItem);
        }
        //写入事务事件项响应对象
        this.saveSysWorkItemAction(sysWorkItem);
    }
    
    /**
     * 
     * 判断事务事件项是否已经执行过.
     * 
     * @param sysWorkItem
     * @return
     */
    private boolean hasProcessSysWorkItem(SysWorkItem sysWorkItem) {
        ShardingRule rule = sysWorkItem.getRule();
        if (rule == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项的分片规则能为空"));
        }
        if (rule.getActionTableName() == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项响应记录不能为空"));
        }
        int cnt = 0;
        //只有分片表需要分片键
        if (IdempotencyConstant.ShardingType.SHARDING.equals(rule.getShardingType())) {
            Long shardingId = sysWorkItem.getObjShardingId();
            if (shardingId == null) {
                ExceptionUtils.throwEx(new IdempotencyException("事件项Id:" + sysWorkItem.getId()
                    + "的分片键值不能为空"));
            }
            cnt = SysWorkItem.repository().getWorkItemActionCnt(rule.getActionTableName(),
                sysWorkItem.getId(), shardingId);
        } else {
            cnt = SysWorkItem.repository().getWorkItemActionCnt(rule.getActionTableName(),
                sysWorkItem.getId());
        }
        return cnt > 0;
    }
    
    /**
     * 
     * 存储事务事件项响应记录.
     * 
     * @param sysWorkItem
     */
    public void saveSysWorkItemAction(SysWorkItem sysWorkItem) {
        ShardingRule rule = sysWorkItem.getRule();
        if (rule == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项的分片规则能为空"));
        }
        if (rule.getActionTableName() == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项响应记录不能为空"));
        }
        //只有分片表需要分片键
        if (IdempotencyConstant.ShardingType.SHARDING.equals(rule.getShardingType())) {
            Long shardingId = sysWorkItem.getObjShardingId();
            if (shardingId == null) {
                ExceptionUtils.throwEx(new IdempotencyException("事件项Id:" + sysWorkItem.getId()
                    + "的分片键值不能为空"));
            }
            SysWorkItem.repository().saveWorkItemAction(rule.getActionTableName(), sysWorkItem,
                shardingId);
        } else {
            SysWorkItem.repository().saveWorkItemAction(rule.getActionTableName(), sysWorkItem);
        }
    }
    
    /**
     * 
     * 执行事务事件项对象操作.
     * 
     * @param objVo
     */
    public void processEntity(SysWorkItemObjVo objVo, SysWorkItem sysWorkItem) {
        if (objVo == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务操作对象Vo不能为空"));
        }
        if (StringUtils.isNullOrEmpty(objVo.getOperType())) {
            ExceptionUtils.throwEx(new IdempotencyException("事务操作对象动作不能为空"));
        }
        if (objVo.getEntt() == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务操作对象不能为空"));
        }
        if (IdempotencyConstant.OperType.INSERT.equals(objVo.getOperType())) {
            SysWorkItem.repository().insert(objVo.getEntt());
        } else if (IdempotencyConstant.OperType.UPDATE_BY_PRIMARY_KEY.equals(objVo.getOperType())) {
            SysWorkItem.repository().updateByPrimaryKey(objVo.getEntt());
        } else if (IdempotencyConstant.OperType.DELETE_BY_PRIMARY_KEY.equals(objVo.getOperType())) {
            SysWorkItem.repository().deleteByPrimaryKey(objVo.getEntt());
        } else if (IdempotencyConstant.OperType.UPDATE_SELECTIVE_BY_PRIMARY_KEY.equals(objVo
            .getOperType())) {
            SysWorkItem.repository().updateSelectiveByPrimaryKey(objVo.getEntt());
        } else {
            ExceptionUtils.throwEx(new IdempotencyException("未知操作类型"));
        }
    }
    
}

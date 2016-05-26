package com.ffcs.crmd.platform.idempotency.core.service.impl;

import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.base.utils.CastorUtils;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;
import com.ffcs.crmd.platform.idempotency.core.annotation.Distributed;
import com.ffcs.crmd.platform.idempotency.core.constants.IdempotencyConstant;
import com.ffcs.crmd.platform.idempotency.core.entity.ShardingRule;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkItem;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkItemAttach;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkSheet;
import com.ffcs.crmd.platform.idempotency.core.exception.IdempotencyException;
import com.ffcs.crmd.platform.idempotency.core.service.IIdempotencyService;
import com.ffcs.crmd.platform.idempotency.core.service.ISysWorkItemService;
import com.ffcs.crmd.platform.idempotency.core.utils.ShardingRuleUtil;
import com.ffcs.crmd.platform.idempotency.core.vo.SysWorkItemObjVo;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

@Service("idempotencyService")
public class IdempotencyServiceImpl implements IIdempotencyService {
    
    private static final ILogger LOGGER = LoggerFactory.getLogger(CastorUtils.class);
    
    @Resource
    private ISysWorkItemService  sysWorkItemService;
    
    /**
     * 
     * 生成事务事件集编码.
     * 
     * @param invocation
     * @return
     */
    private String genSheetCd(MethodInvocation invocation) {
        
        //获取method
        Method method = invocation.getMethod();
        //获取@Distributed
        Distributed annotation = method.getAnnotation(Distributed.class);
        //如果方法没有配置@Distributed，则返回null，手工设置事务事件集编码
        if (annotation == null) {
            return null;
        }
        int index = annotation.index();
        String name = annotation.name();
        //如果没有配置参数索引值，则返回null，手工设置事务事件集编码
        if (index == 0) {
            return null;
        }
        if (index < 0) {
            ExceptionUtils.throwEx(new IdempotencyException("@Distributed.index不能小于0"));
        }
        if (index > invocation.getArguments().length) {
            ExceptionUtils.throwEx(new IdempotencyException("Distributed.index不能大于参数数量"));
        }
        String sheetCd = null;
        //如果没有配置name属性，则默认事件集编码为类名+方法名+参数，否则为name+参数
        if (StringUtils.isNullOrEmpty(name)) {
            sheetCd = method.toString() + IdempotencyConstant.SEPARATOR
                + invocation.getArguments()[index - 1];
        } else {
            sheetCd = name + IdempotencyConstant.SEPARATOR + invocation.getArguments()[index - 1];
        }
        return sheetCd;
    }
    
    @Override
    public SysWorkSheet loadOrCreateSysWorkSheet(MethodInvocation invocation) {
        // 优先获取本地线程缓存中的事务事件集编码
        String sheetCd = CrmSessionContext.getContext().getSysWorkSheetCd();
        // 如果为空则根据@Distributed注解生成
        if (StringUtils.isNullOrEmpty(sheetCd)) {
            sheetCd = this.genSheetCd(invocation);
        }
        //无事务事件集编码抛出异常
        if (StringUtils.isNullOrEmpty(sheetCd)) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件集编码没有设置，且没有为分布式事务方法配置编码生成注解"));
        }
        //根据事务事件集编码加载分事务事件集
        SysWorkSheet sysWorkSheet = SysWorkSheet.repository().getSysWorkSheetBySheetCd(sheetCd);
        //数据库中查询到后，直接返回
        if (sysWorkSheet == null) {
            //数据库中未查询到，创建一个
            sysWorkSheet = this.genSysWorkSheet(sheetCd);
        }
        //构建事务事件集
        this.buildWorkSheet(sysWorkSheet);
        return sysWorkSheet;
    }
    
    /**
     * 
     * 构建事务事件集，把缓存中的操作对象加入到事务事件项中.
     * 
     * @param sysWorkSheet
     */
    private void buildWorkSheet(SysWorkSheet sysWorkSheet) {
        List<Object> objList = CrmSessionContext.getContext().getSysWorkItemObjList();
        if (objList == null || objList.isEmpty()) {
            ExceptionUtils.throwEx(new IdempotencyException("该方法没有涉及到数据写入，无需使用分布式事务幂等性组件"));
        }
        for (Object obj : objList) {
            //加入到事务事件集中
            this.buildWorkItem((SysWorkItemObjVo) obj, sysWorkSheet);
        }
    }
    
    /**
     * 
     * 初始化事务事件集.
     * 
     * @param sheetCd
     * @return
     */
    private SysWorkSheet genSysWorkSheet(String sheetCd) {
        SysWorkSheet sysWorkSheet = new SysWorkSheet(true);
        sysWorkSheet.setSheetCd(sheetCd);
        sysWorkSheet.setShardingId(sysWorkSheet.getId());
        sysWorkSheet.setStatusCd(IdempotencyConstant.SysWorkSheetStatus.CREATE);
        return sysWorkSheet;
    }
    
    @Override
    public void commitSysWorkSheet(SysWorkSheet sysWorkSheet) {
        if (sysWorkSheet == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件集不能为空"));
        }
        if (sysWorkSheet.getSysWorkItemList() == null
            || sysWorkSheet.getSysWorkItemList().isEmpty()) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项列表不能为空"));
        }
        //存储事务事件集
        if (sysWorkSheet.isNewEnttity()) {
            sysWorkSheet.save();
        } else {
            sysWorkSheet.update();
        }
    }
    
    /**
     * 
     * 根据分片规则在事务事件集中查找事务事件项.
     * 
     * @param workSheet
     * @param rule
     * @param shardingId
     * @return
     */
    private SysWorkItem findItemInSheet(SysWorkSheet workSheet, ShardingRule rule, Long shardingId) {
        SysWorkItem result = null;
        if (workSheet == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件集不能为空"));
        }
        if (rule == null || rule.getId() == null) {
            ExceptionUtils.throwEx(new IdempotencyException("分片规则不能为空"));
        }
        //事件集中无事件项，直接返回空
        if (workSheet.getSysWorkItemList() == null || workSheet.getSysWorkItemList().size() == 0) {
            return result;
        }
        if (IdempotencyConstant.ShardingType.SHARDING.equals(rule.getShardingType())) {
            if (shardingId == null) {
                ExceptionUtils.throwEx(new IdempotencyException("分片表的分片键Id不能为空"));
            }
            for (SysWorkItem workItem : workSheet.getSysWorkItemList()) {
                //分片规则和分片键值相等才相等
                if (workItem != null && rule.getId().equals(workItem.getObjShardingRuleId())
                    && shardingId.equals(workItem.getObjShardingId())) {
                    result = workItem;
                    break;
                }
            }
        } else if (IdempotencyConstant.ShardingType.SINGLE.equals(rule.getShardingType())
            || IdempotencyConstant.ShardingType.GLOBAL.equals(rule.getShardingType())) {
            for (SysWorkItem workItem : workSheet.getSysWorkItemList()) {
                //分片规则相等就相等
                if (workItem != null && rule.getId().equals(workItem.getObjShardingRuleId())) {
                    result = workItem;
                    break;
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * 构建事务事件项
     * 
     * @param objVo
     * @param workSheet
     * @return
     */
    private SysWorkItem buildWorkItem(SysWorkItemObjVo objVo, SysWorkSheet workSheet) {
        if (workSheet == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件集不能为空"));
        }
        if (objVo == null) {
            ExceptionUtils.throwEx(new IdempotencyException("操作对象Vo不能为空"));
        }
        if (StringUtils.isNullOrEmpty(objVo.getOperType())) {
            ExceptionUtils.throwEx(new IdempotencyException("对象操作类型不能为空"));
        }
        if (objVo.getEntt() == null) {
            ExceptionUtils.throwEx(new IdempotencyException("涉及的操作对象不能为空"));
        }
        ShardingRule rule = ShardingRuleUtil.getShardingRule(objVo.getEntt().getTableName());
        if (rule == null) {
            ExceptionUtils.throwEx(new IdempotencyException("对象:" + objVo.getEntt() + "的分片规则不能为空"));
        }
        Long shardingId = null;
        //只有分片表需要分片键
        if (IdempotencyConstant.ShardingType.SHARDING.equals(rule.getShardingType())) {
            shardingId = (Long) CrmEntityUtils.getShardingId(objVo.getEntt());
            if (shardingId == null) {
                ExceptionUtils.throwEx(new IdempotencyException("对象:" + objVo.getEntt()
                    + "的分片键值不能为空"));
            }
        }
        SysWorkItem workItem = this.findItemInSheet(workSheet, rule, shardingId);
        if (!workSheet.isNewEnttity() && workItem == null) {
            ExceptionUtils.throwEx(new IdempotencyException("补偿执行分布式事务方法，不能新增其他分片规则的数据写入"));
        }
        //如果没有同类事务事件集，则新增一个
        if (workItem == null) {
            workItem = new SysWorkItem(true);
            //事务事件项分片规则同事务事件集
            workItem.setShardingId(workSheet.getShardingId());
            workItem.setObjShardingId(shardingId);
            workItem.setObjShardingRuleId(rule.getId());
            //设置事务事件集Id
            workItem.setSheetId(workSheet.getId());
            workItem.setStatusCd(IdempotencyConstant.SysWorkItemStatus.CREATE);
            //增加事件项附件
            SysWorkItemAttach attach = new SysWorkItemAttach(true);
            //设置事件项Id和分片键
            attach.setItemId(workItem.getId());
            attach.setShardingId(workItem.getShardingId());
            workItem.setAttach(attach);
        }
        if (workItem.getRule() == null) {
            workItem.setRule(rule);
        }
        //只有首次执行写入分布式事务涉及对象或SQL
        if (workItem.isNewEnttity()) {
            String content = workItem.getAttach().getContent();
            if (content == null) {
                content = "";
            }
            content = content + objVo.getVoName();
            workItem.getAttach().setContent(content);
        }
        //操作对象加入到对象事件集中
        workItem.getObjList().add(objVo);
        //加入到事务事件集中
        if (!workSheet.getSysWorkItemList().contains(workItem)) {
            workSheet.getSysWorkItemList().add(workItem);
        }
        return workItem;
    }
    
    @Override
    public void processSysWorkSheet(SysWorkSheet sysWorkSheet) {
        if (sysWorkSheet == null) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件集不能为空"));
        }
        LOGGER.debug("执行事务事件集Id:" + sysWorkSheet.getId());
        if (sysWorkSheet.getSysWorkItemList() == null
            || sysWorkSheet.getSysWorkItemList().size() == 0) {
            ExceptionUtils.throwEx(new IdempotencyException("事务事件项不能为空"));
        }
        for (SysWorkItem workItem : sysWorkSheet.getSysWorkItemList()) {
            //每个事务事件项独立事务执行
            sysWorkItemService.processSysWorkItem(workItem);
        }
    }
    
    @Override
    public void completeSysWorkSheet(SysWorkSheet sysWorkSheet) {
        //更新为完成状态
        sysWorkSheet.updateStatusCd(IdempotencyConstant.SysWorkSheetStatus.COMPLETE);
    }
}

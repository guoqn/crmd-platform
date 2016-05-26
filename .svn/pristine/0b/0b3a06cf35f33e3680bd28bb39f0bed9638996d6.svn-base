package com.ffcs.crmd.platform.idempotency.core.filter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.idempotency.core.constants.IdempotencyConstant;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkItem;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.filter.impl.AbstractDaActionFilter;
import com.ffcs.crmd.platform.meta.daaction.impl.ActionType;
import com.ffcs.crmd.platform.meta.util.DaoSupport;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * 
 * 公共字段处理过滤器.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author chenye
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2016年2月17日
 * @功能说明：
 *
 */

@Component("sysWorkItemActionFilter")
public class SysWorkItemActionFilter extends AbstractDaActionFilter {
    
    /**
     * CUD前处理，设置默认字段.
     * @param context
     * @param entity
     */
    @Override
    public void beforeAction(DaActionContext context, Object entity, ActionType actionType) {
        if (entity instanceof SysWorkItem) {
            SysWorkItem entt = (SysWorkItem) entity;
            //本地网标识为空，从sessionContext中获取默认
            if (entt.getAreaId() == null && CrmSessionContext.getContext().getRegionId() != null) {
                entt.setAreaId(CrmSessionContext.getContext().getRegionId());
            }
            //县局标识为空，从SessionContext中获取默认
            if (entt.getRegionCd() == null && CrmSessionContext.getContext().getRegionId() != null) {
                entt.setRegionCd(CrmSessionContext.getContext().getRegionId());
            }
            //默认工号信息，从SessionContext中获取
            if (CrmSessionContext.getContext().getStaffId() != null) {
                if (entt.getCreateStaff() == null) {
                    entt.setCreateStaff(CrmSessionContext.getContext().getStaffId());
                }
                if (entt.getUpdateStaff() == null) {
                    entt.setUpdateStaff(CrmSessionContext.getContext().getStaffId());
                }
            }
            //默认创建时间
            if (entt.getCreateDate() == null) {
                entt.setCreateDate(Timestamp.valueOf(DateUtils.getCurDate()));
            }
            //默认更新时间
            if (entt.getUpdateDate() == null) {
                entt.setUpdateDate(Timestamp.valueOf(DateUtils.getCurDate()));
            }
            //默认状态时间
            if (entt.getStatusDate() == null) {
                entt.setStatusDate(Timestamp.valueOf(DateUtils.getCurDate()));
            }
            //默认状态
            if (StringUtils.isNullOrEmpty(entt.getStatusCd())) {
                entt.setStatusCd(IdempotencyConstant.SysWorkSheetStatus.CREATE);
            }
            //默认修改时间，任何数据库操作都需要修改改字段
            entt.setDtimestamp(DateUtils.getNowDate().getTime());
            //默认版本号
            Long version = entt.getDversion();
            if (version == null) {
                version = 0L;
            } else {
                version = version + 1;
            }
            entt.setDversion(version);
            if (ActionType.UPDATE.equals(actionType)) {
                entt.setUpdateStaff(CrmSessionContext.getContext().getStaffId());
                entt.setUpdateDate(Timestamp.valueOf(DateUtils.getCurDate()));
            }
        }
    }
    
    /**
     * CUD后处理，先留空.
     * @param context
     * @param entity
     */
    @Override
    public void afterAction(DaActionContext context, Object entity, ActionType actionType) {
        
    }
    
    /**
     * 
     * 只有update、delete时需要更新日记
     * 
     */
    @Override
    protected boolean getDefaultLog(DaActionContext context, Object entity, ActionType actionType) {
        if (entity instanceof SysWorkItem) {
            SysWorkItem entt = (SysWorkItem) entity;
            if (ActionType.UPDATE.equals(actionType)) {
                return entt.isLogHisOnUpdate();
            } else if (ActionType.DELETE.equals(actionType)) {
                return entt.isLogHisOnDelete();
            } else {
                return false;
            }
        }
        return false;
    }
    
    @Override
    protected RetVo logHistory(DaActionContext context, Object entity, ActionType actionType) {
        Object orignEntity = getOrignEntity(context, entity);
        RetVo vo = new RetVo(true);
        if (orignEntity == null) {
            logger.warn("orign entity is not exists");
            vo.setResult(false);
            return vo;
        }
        //档案类实体保存历史时需要设置recUpdateDate和Dtimestamp
        if (orignEntity instanceof SysWorkItem) {
            ((SysWorkItem) orignEntity).setRecUpdateDate(Timestamp.valueOf(DateUtils.getCurDate()));
            ((SysWorkItem) orignEntity).setDtimestamp(DateUtils.getNowDate().getTime());
        }
        String sql = getInsertSql(context, entity, orignEntity);
        List<Object> params = new ArrayList<Object>();
        List<String> columns = getColumnList(context, entity, orignEntity);
        List<String> attrCode = getAttrCodeList(context, entity, orignEntity);
        int i = 0;
        for (String column : columns) {
            String code = attrCode.get(i);
            i++;
            Object object = getValue(context, code, column, entity, orignEntity);
            params.add(object);
        }
        
        int ret = DaoSupport.excuteUpate(sql, params);
        vo.setObject(ret);
        return vo;
    }
}

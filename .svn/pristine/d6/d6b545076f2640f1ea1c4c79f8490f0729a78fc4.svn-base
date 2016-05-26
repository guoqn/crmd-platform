package com.ffcs.crmd.platform.meta.daaction.filter.impl;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.data.entity.ClassInfoUtils;
import com.ctg.itrdc.platform.data.entity.ColumnInfo;
import com.ctg.itrdc.platform.data.entity.EntityInfo;
import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import com.ffcs.crmd.platform.data.ddl.SeqServiceFactory;
import com.ffcs.crmd.platform.meta.daaction.filter.IDaActionFilter;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.impl.ActionType;
import com.ffcs.crmd.platform.meta.entity.impl.BaseAttrEntityImpl;
import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;
import com.ffcs.crmd.platform.meta.exception.MetaException;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.intf.ISysColumn;
import com.ffcs.crmd.platform.meta.provider.IOpMetaInfo;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.util.DaoSupport;
import com.ffcs.crmd.platform.meta.util.SqlConstants;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by linzq on 2016/1/18.
 */
public abstract class AbstractDaActionFilter implements IDaActionFilter {

    protected ICrmBaseDao crmBaseDao = ApplicationContextUtil.getBean("crmBaseDao");

    protected ILogger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public RetVo doBeforeAction(DaActionContext context, Object entity, ActionType actionType) {
        RetVo vo = new RetVo(true);
        //默认处理,如历史表等
        if (ActionType.SAVE.equals(actionType)) {
            //保存不做历史表的处理.
        } else {
            if (isLogHis(context,entity,actionType)) {
                logHistory(context,entity,actionType);
            }
        }

        beforeAction(context, entity,actionType);
        return vo;
    }

    public abstract void beforeAction(DaActionContext context, Object entity,
        ActionType actionType);

    @Override
    public RetVo doAfterAction(DaActionContext context, Object entity, ActionType actionType) {
        RetVo vo = new RetVo(true);
        //默认处理,如历史表等

        afterAction(context, entity,actionType);
        return vo;
    }

    public abstract void afterAction(DaActionContext context, Object entity, ActionType actionType);

    /**
     * 根据操作类型判断是否需要写历史表操作
     * @param context
     * @param entity
     * @param actionType
     * @return
     */
    protected boolean isLogHis(DaActionContext context,Object entity,ActionType actionType) {
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            ITableMetaData meta = ((IMetaEntity) entity).readTableMeta();
            if (meta == null) {
                ExceptionUtils.throwEx(new MetaException(entity.getClass() + " metaData Not exists"));
            }
            if (ActionType.UPDATE.equals(actionType)) {
                return meta.isLogToHisOnUpdate();
            } else if (ActionType.DELETE.equals(actionType)) {
                return meta.isLogToHisOnDelete();
            } else {
                return getDefaultLog(context,entity,actionType);
            }
        } else {
            return getDefaultLog(context,entity,actionType);
        }
    }

    /**
     * 获取默认的历史表记录要求
     *
     * @param context
     * @param entity
     * @param actionType
     * @return
     */
    protected boolean getDefaultLog(DaActionContext context, Object entity, ActionType actionType) {
        return false;
    }

    /**
     * 实际的写历史表操作
     * @param context
     * @param entity
     * @param actionType
     * @return
     */
    protected RetVo logHistory(DaActionContext context,Object entity,ActionType actionType) {
        Object orignEntity = getOrignEntity(context,entity);
        RetVo vo = new RetVo(true);
        if (orignEntity == null) {
            logger.warn("orign entity is not exists");
            vo.setResult(false);
            return vo;
        }
        String sql = getInsertSql(context,entity,orignEntity);
        List<Object> params = new ArrayList<Object>();
        List<String> columns = getColumnList(context,entity,orignEntity);
        List<String> attrCode = getAttrCodeList(context,entity,orignEntity);
        int i = 0;

        String seqName = getHisSeqName(context,entity,orignEntity);
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            sql.replace(getSeqColumnValue(seqName),"?");
        }
        Long hisId = SeqServiceFactory.getSeqService().getSeq(seqName);
        params.add(hisId);
        for (String column : columns) {
            String code = attrCode.get(i);
            i++;
            Object object = getValue(context,code,column,entity,orignEntity);
            params.add(object);
        }

        int ret = DaoSupport.excuteUpate(sql,params);
        vo.setObject(hisId);
        vo.setRetCode(StringUtils.strnull(ret));
        return vo;
    }

    /**
     * 获取原始对象
     * @param context
     * @param entity
     * @return
     */
    protected Object getOrignEntity(DaActionContext context,Object entity) {

        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            ITableMetaData meta = ((IMetaEntity) entity).readTableMeta();
            if (meta == null) {
                ExceptionUtils.throwEx(new MetaException(entity.getClass() + " metaData Not exists"));
            }

            IOpMetaInfo op = meta.getSelectByPrimaryKeyAndAllSK();
            List<Object> params = op.buildParamsList((IMetaEntity) entity,op.getAttrs());
            List<Map<String,Object>> attrs = DaoSupport.jdbcFindMapList(op.getSql(),params);
            if (attrs != null && attrs.size() > 0) {
                Map<String,Object> map = attrs.get(0);
                IMetaEntity nEntity = null;
                try {
                    nEntity = (IMetaEntity) entity.getClass().newInstance();
                } catch (Exception e) {
                    logger.error("init Error",e);
                    ExceptionUtils.throwEx(e);
                }
                if (entity instanceof CrmBaseMetaEntityImpl) {

                } else if (entity instanceof BaseAttrEntityImpl) {
                    BaseAttrEntityImpl attrEntity = (BaseAttrEntityImpl) nEntity;
                    attrEntity.setBaseBusiObjId(((BaseAttrEntityImpl) entity).getBaseBusiObjId());
                    attrEntity.setBaseEntityName(((BaseAttrEntityImpl) entity).getBaseEntityName());
                    attrEntity.setMasterAttrId(((BaseAttrEntityImpl) entity).getMasterAttrId());
                    attrEntity.setSlaAttrId(((BaseAttrEntityImpl) entity).getSlaAttrId());
                    attrEntity.setSlaAttrValue(((BaseAttrEntityImpl) entity).getSlaAttrValue());
                    attrEntity.setPkAttrId(((BaseAttrEntityImpl) entity).getPkAttrId());
                    attrEntity.setTableName(((BaseAttrEntityImpl) entity).getTableName());
                    attrEntity.
                        setEntityName(StringUtils.firstCharUpCase(
                            StringUtils.parseColumnName2PropertyName(attrEntity.getTableName())));
                    attrEntity.setAttrIds(((BaseAttrEntityImpl) entity).getAttrIds());
                    attrEntity.setData(new Object[attrEntity.getAttrIds().size()]);
                }
                nEntity.fillEntityFromMap(map);
                return nEntity;
            }
        } else {
            Object entitys = crmBaseDao.selectByPrimaryKey((BaseEntity) entity);
            if (entitys != null) {
                return entitys;
            } else {
                ExceptionUtils.throwEx("orign entity is not exists");
            }
        }
        return null;
    }

    /**
     * 获取历史表插入的sql
     * @param context
     * @param entity
     * @param orignEntity
     * @return
     */
    protected String getInsertSql(DaActionContext context,Object entity, Object orignEntity) {
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            String sql = ((IMetaEntity) entity).readTableMeta().getInsertHisTableOp().getSql();
            return sql;
        } else {
            EntityInfo entityInfo = ClassInfoUtils.getEntityMap().get(entity.getClass());
            if (entityInfo == null) {

                ExceptionUtils
                    .throwEx(new RtManagerException(entity.getClass() + " entityInfo is null"));
            }
            List<ColumnInfo> columnInfos = entityInfo.getColumnList();
            StringBuffer insertSql = new StringBuffer();
            insertSql.append(SqlConstants.INSERT_INTO);
            insertSql.append(entityInfo.getTableName() + "_HIS");
            insertSql.append(" (");
            insertSql.append("HIS_ID");
            for (ColumnInfo columnInfo : columnInfos) {
                insertSql.append("," + columnInfo.getColumnName());
            }
            insertSql.append(" ) ");
            insertSql.append(SqlConstants.VALUES);
            insertSql.append(" ( ");
//            insertSql.append(getSeqColumnValue(getHisSeqName(context,entity, orignEntity)));
            insertSql.append("?");
            for (ColumnInfo columnInfo : columnInfos) {
                insertSql.append(",?");
            }
            insertSql.append(" ) ");
            return insertSql.toString();
        }
    }

    /**
     * 获取历史表名
     * @param context
     * @param entity
     * @param orignEntity
     * @return
     */
    protected String getHisTableName(DaActionContext context,Object entity, Object orignEntity) {
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            return ((IMetaEntity) entity).readTableMeta().getTable().getHisTableName();
        } else {
            EntityInfo entityInfo = ClassInfoUtils.getEntityMap().get(entity.getClass());
            if (entityInfo == null) {
                ExceptionUtils
                    .throwEx(new RtManagerException(entity.getClass() + " entityInfo is null"));
            }
            return entityInfo.getTableName() + "_HIS";
        }
    }

    /**
     * 获取历史表的序列名称
     * @param context
     * @param entity
     * @param orignEntity
     * @return
     */
    protected String getHisSeqName(DaActionContext context,Object entity, Object orignEntity) {
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            return ((IMetaEntity) entity).readTableMeta().getTable().getHisSeqName();
        } else {
            EntityInfo entityInfo = ClassInfoUtils.getEntityMap().get(entity.getClass());
            if (entityInfo == null) {
                ExceptionUtils
                    .throwEx(new RtManagerException(entity.getClass() + " entityInfo is null"));
            }
            return "SEQ_" + entityInfo.getTableName() + "_HIS_ID";
        }
    }

    protected String getSeqColumnValue(String seqName) {

        return seqName + ".nextval";
    }

    /**
     * 获取历史表的操作列清单
     * @param context
     * @param entity
     * @param orignEntity
     * @return
     */
    protected List<String> getColumnList(DaActionContext context,Object entity, Object orignEntity) {
        List<String> columnList = new ArrayList<String>();
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            List<ISysColumn> columns = ((IMetaEntity) entity).readTableMeta().getColumns();
            for (ISysColumn column : columns) {
                columnList.add(column.getColName());
            }
        } else {
            EntityInfo entityInfo = ClassInfoUtils.getEntityMap().get(entity.getClass());
            if (entityInfo == null) {
                ExceptionUtils
                    .throwEx(new RtManagerException(entity.getClass() + " entityInfo is null"));
            }
            List<ColumnInfo> columnInfos = entityInfo.getColumnList();
            for (ColumnInfo columnInfo : columnInfos) {
                columnList.add(columnInfo.getColumnName());
            }
        }
        return columnList;
    }

    /**
     * 获取历史表操作的属性清单
     * @param context
     * @param entity
     * @param orignEntity
     * @return
     */
    protected List<String> getAttrCodeList(DaActionContext context,Object entity, Object orignEntity) {
        List<String> columnList = new ArrayList<String>();
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            List<ISysColumn> columns = ((IMetaEntity) entity).readTableMeta().getColumns();
            Map<String, String> colNameToNbr = ((IMetaEntity) entity).readTableMeta()
                .getColumnNameToAttrNbrMap();
            for (ISysColumn column : columns) {
                columnList.add(colNameToNbr.get(column.getColName()));
            }
        } else {
            EntityInfo entityInfo = ClassInfoUtils.getEntityMap().get(entity.getClass());
            if (entityInfo == null) {
                ExceptionUtils
                    .throwEx(new RtManagerException(entity.getClass() + " entityInfo is null"));
            }
            List<ColumnInfo> columnInfos = entityInfo.getColumnList();
            for (ColumnInfo columnInfo : columnInfos) {
                columnList.add(columnInfo.getFiledName());
            }
        }
        return columnList;
    }

    /**
     * 获取属性对应的值.
     * @param context
     * @param attrNbr
     * @param columnName
     * @param entity
     * @param orignEntity
     * @return
     */
    protected Object getValue(DaActionContext context,String attrNbr, String columnName, Object entity,
        Object orignEntity) {
        if (orignEntity instanceof IMetaEntity && ((IMetaEntity) orignEntity).isUseMeta()) {
            return ((IMetaEntity) orignEntity).readAttr(attrNbr);
        } else {
            return ClassInfoUtils.getValues(orignEntity, attrNbr);
        }
    }

}

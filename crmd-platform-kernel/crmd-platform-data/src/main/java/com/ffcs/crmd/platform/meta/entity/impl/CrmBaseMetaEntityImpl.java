package com.ffcs.crmd.platform.meta.entity.impl;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.exception.MetaException;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.service.MetaServiceFactory;
import com.ffcs.crmd.platform.meta.util.DaoSupport;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CrmBaseMetaEntityImpl<ID extends Serializable>
    extends AbstractBaseMetaEntityImpl<ID> {

    protected boolean                  fetch     = false;
    protected List<BaseAttrEntityImpl> attrInsts = new ArrayList<BaseAttrEntityImpl>();


    public synchronized void fetch() {
        if (!fetch) {
            IBusiObj busiObj = readBusiObj();
            if (busiObj == null) {
                ExceptionUtils.throwEx(new MetaException("could not get busiObj"));
            }
            //获取初始化规格数据
            List<ISysTable> tables = MetaServiceFactory.getMetaService()
                .getSysTables(readBusiObj());
            if (tables == null) {
                ExceptionUtils.throwEx(new MetaException("could not get Tables"));
            }
            ITableMetaData tableMetaData = readTableMeta();
            if (tableMetaData == null) {
                ExceptionUtils.throwEx(new MetaException("could not get TableMetaDate"));
            }
            List<IBusiObjAttr> attrs = tableMetaData.getTableBaseAttr();
            attrIds = new ArrayList<Long>();
            for (IBusiObjAttr attr : attrs) {
                attrIds.add(attr.getId());
            }
            this.setPkAttrId(tableMetaData.getPkAttr().getId());
            data = new Object[attrIds.size()];

            //从数据库初始化数据
            if (this.getId() != null) {
                ISysTable danyTable = MetaServiceFactory.getMetaService()
                    .getDanyTable(tables, tableMetaData.getTable());
                if (danyTable != null) {
                    loadAttr(danyTable);
                }
            } else {
                attrInsts = new ArrayList<BaseAttrEntityImpl>();
            }
            fetch = true;
        }

    }

    private void loadAttr(ISysTable table) {
        attrInsts = new ArrayList<BaseAttrEntityImpl>();
        ITableMetaData tableMetaData = MetaServiceFactory.getMetaService()
            .getTableMetaDataByEntityNameAndTableName(this, table.getTabName());
        if (tableMetaData == null) {
            ExceptionUtils.throwEx(new MetaException("could not get TableMetaDate"));
        }

        //数据库查询
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        List<Object> params = new ArrayList<Object>();
        params.add(this.getId());
        mapList = DaoSupport.jdbcFindMapList(tableMetaData.getSelectByMasterKey().getSql(), params);
        for (Map<String, Object> map : mapList) {
            BaseAttrEntityImpl attrEntity = initAttrEntityImpl();
            attrEntity.fillEntityFromMap(map);
            attrInsts.add(attrEntity);
        }
    }

    private BaseAttrEntityImpl initAttrEntityImpl() {
        ISysTable danyTable = MetaServiceFactory.getMetaService()
            .getDanyTableByBusiObj(readBusiObj(), readTableMeta().getTable());
        if (danyTable == null) {
            ExceptionUtils.throwEx(new MetaException("could not get Dany Table"));
        }
        ITableMetaData tableMetaData = MetaServiceFactory.getMetaService()
            .getTableMetaDataByEntityNameAndTableName(this, danyTable.getTabName());
        if (tableMetaData == null) {
            ExceptionUtils.throwEx(new MetaException("could not get TableMetaDate"));
        }
        BaseAttrEntityImpl attrEntity = createAttrEntity(this.readBusiObj().getId(),
            this.getEntityName(), tableMetaData.getMasterAttr().getId(),
            tableMetaData.getSlaAttrIdAttr().getId(), tableMetaData.getSlaAttrValueAttr().getId());
        attrEntity.setPkAttrId(tableMetaData.getPkAttr().getId());
        attrEntity.setTableName(danyTable.getTabName().toUpperCase());
        attrEntity.
            setEntityName(StringUtils.firstCharUpCase(
                StringUtils.parseColumnName2PropertyName(attrEntity.getTableName())));
        List<Long> attrIds = new ArrayList<Long>();
        for (IBusiObjAttr attr : tableMetaData.getTableBaseAttr()) {
            attrIds.add(attr.getId());
        }
        attrEntity.setAttrIds(attrIds);
        attrEntity.setData(new Object[attrIds.size()]);
        return attrEntity;
    }

    protected BaseAttrEntityImpl createAttrEntity(Long busiObjId, String entityName,
        Long masterAttrId, Long slaAttrId, Long slaAttrValueId) {
        return new BaseAttrEntityImpl(busiObjId, entityName, masterAttrId, slaAttrId,
            slaAttrValueId);
    }

    private BaseAttrEntityImpl readAttrInstByAttr(IBusiObjAttr attr) {
        if (attrInsts == null || attrInsts.isEmpty()) {
            return null;
        }
        for (BaseAttrEntityImpl entityInst : attrInsts) {
            if (NumberUtils.nullToLongZero(entityInst.getAttrId()).equals(attr.getAttrId())) {
                return entityInst;
            }
        }
        return null;
    }

    @Override
    public RetVo writeAttr(String attrNbr, Object value, boolean check) {
        if (!fetch) {
            fetch();
        }
        return super.writeAttr(attrNbr, value, check);
    }

    @Override
    public Object readAttr(String attrNbr) {
        if (!fetch) {
            fetch();
        }
        return super.readAttr(attrNbr);
    }

    @Override
    protected Object readAttrByBusiObjAttr(IBusiObjAttr attr) {
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException("attr is not exists"));
        }
        if (!attr.checkIsDanyAttr()) {
            return super.readAttrByBusiObjAttr(attr);
        } else {
            BaseAttrEntityImpl attrInst = readAttrInstByAttr(attr);
            if (attrInst != null) {
                return attrInst.getAttrValue();
            }
            return null;
        }
    }

    @Override
    public String getEntityName() {
        return super.getEntityName();
    }

    @Override
    protected RetVo writeAttrByBusiObjAttr(IBusiObjAttr attr, Object value) {
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException("attr is not exists"));
        }
        if (!attr.checkIsDanyAttr()) {
            return super.writeAttrByBusiObjAttr(attr, value);
        } else {
            BaseAttrEntityImpl attrInst = readAttrInstByAttr(attr);
            if (attrInst == null) {
                attrInst = initAttrEntityImpl();
                attrInst.setAttrOpType(AttrOpType.ADD.op());
                attrInsts.add(attrInst);
            }
            attrInst.setAttrId(attr.getAttrId());
            String oldAttrValue = attrInst.getAttrValue();
            attrInst.setAttrValue(StringUtils.strnull(value));
            if (StringUtils.isNullOrEmpty(attrInst.getAttrValue())) {
                if (!AttrOpType.ADD.op().equals(attrInst.getAttrOpType())) {
                    //原有对象置空，标记为删除
                    attrInst.setAttrOpType(AttrOpType.DEL.op());
                } else {
                    //如果新增对象，又做了置空，则移除掉
                    attrInsts.remove(attrInst);
                }
            } else {
                //新旧值发生变化
                if (!StringUtils.strnull(oldAttrValue).equals(attrInst.getAttrValue())) {
                    attrInst.setAttrOpType(AttrOpType.UPDATE.op());
                }
            }
        }
        return new RetVo(true);
    }

    public List<BaseAttrEntityImpl> readAttrInsts() {
        if (!fetch) {
            fetch();
        }
        return attrInsts;
    }

    public void writeAttrInsts(List<BaseAttrEntityImpl> attrInsts) {
        this.attrInsts = attrInsts;
    }
}

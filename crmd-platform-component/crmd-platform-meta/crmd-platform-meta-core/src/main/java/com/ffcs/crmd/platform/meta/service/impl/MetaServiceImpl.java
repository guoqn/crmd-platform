package com.ffcs.crmd.platform.meta.service.impl;

import com.ffcs.crmd.platform.meta.entity.AttrSpec2;
import com.ffcs.crmd.platform.meta.intf.IAttrSpec2;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.meta.provider.BusiObjAttrProvider;
import com.ffcs.crmd.platform.meta.provider.BusiObjAttrValueProvider;
import com.ffcs.crmd.platform.meta.provider.BusiObjProvider;
import com.ffcs.crmd.platform.meta.provider.BusiTypeProvider;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.provider.MetaProvider;
import com.ffcs.crmd.platform.meta.provider.TableMetaProvier;
import com.ffcs.crmd.platform.meta.service.IMetaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by linzq on 2016/1/26.
 */
@Service("metaService")
public class MetaServiceImpl implements IMetaService {
    @Override
    public ITableMetaData getTableMetaDataByBusiObjIdAndTableName(Long busiObjId,
        String tableName) {
        return MetaProvider.getTableMetaDataByBusiObjIdAndTableName(busiObjId, tableName);
    }

    @Override
    public IBusiObj getBusiObj(IMetaEntity entity) {
        return BusiObjProvider.getBusiObj(entity);
    }

    @Override
    public IBusiType getBusiTypeByEntityName(String entityName) {
        return BusiTypeProvider.getBusiTypeByEntityName(entityName);
    }

    @Override
    public List<IBusiObjAttr> getAllBusiObjAttrs(IMetaEntity entity) {
        return BusiObjAttrProvider.getAllBusiObjAttrs(entity);
    }

    @Override
    public String getAttrValueNameByValue(IBusiObj busiObj, String attrNbr, Object val) {
        return BusiObjAttrValueProvider.getAttrValueNameByValue(busiObj, attrNbr, val);
    }

    @Override
    public List<ISysTable> getSysTables(IBusiObj busiObj) {
        return TableMetaProvier.getSysTables(busiObj);
    }

    @Override
    public ISysTable getDanyTable(List<ISysTable> sysTables, ISysTable masterTable) {
        return TableMetaProvier.getDanyTable(sysTables, masterTable);
    }

    @Override
    public ITableMetaData getTableMetaDataByEntityNameAndTableName(IMetaEntity entity,
        String tableName) {
        return MetaProvider.getTableMetaDataByEntityNameAndTableName(entity, tableName);
    }

    @Override
    public ISysTable getDanyTableByBusiObj(IBusiObj busiObj, ISysTable masterTable) {
        return TableMetaProvier.getDanyTableByBusiObj(busiObj, masterTable);
    }

    @Override
    public String getAttrValueNameByValue(String busiObjNbr, String attrNbr, Object val) {
        return BusiObjAttrValueProvider.getAttrValueNameByValue(busiObjNbr,attrNbr,val);
    }

    @Override
    public IAttrSpec2 getAttrSpec(Long attrId) {
        return AttrSpec2.repository().getById(attrId);
    }
}

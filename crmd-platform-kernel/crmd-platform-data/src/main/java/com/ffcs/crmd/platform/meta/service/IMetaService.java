package com.ffcs.crmd.platform.meta.service;

import com.ffcs.crmd.platform.meta.intf.IAttrSpec2;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

import java.util.List;

/**
 * Created by linzq on 2016/1/26.
 */
public interface IMetaService {
    ITableMetaData getTableMetaDataByBusiObjIdAndTableName(Long busiObjId,
        String tableName);

    IBusiObj getBusiObj(IMetaEntity entity);

    IBusiType getBusiTypeByEntityName(String entityName);

    List<IBusiObjAttr> getAllBusiObjAttrs(IMetaEntity entity);

    String getAttrValueNameByValue(IBusiObj busiObj, String attrNbr, Object val);

    List<ISysTable> getSysTables(IBusiObj busiObj);

    ISysTable getDanyTable(List<ISysTable> sysTables, ISysTable masterTable);

    ITableMetaData getTableMetaDataByEntityNameAndTableName(IMetaEntity entity,
        String tableName);

    ISysTable getDanyTableByBusiObj(IBusiObj busiObj, ISysTable masterTable);

    String getAttrValueNameByValue(String busiObjNbr, String attrNbr, Object val);

    IAttrSpec2 getAttrSpec(Long attrId);
}

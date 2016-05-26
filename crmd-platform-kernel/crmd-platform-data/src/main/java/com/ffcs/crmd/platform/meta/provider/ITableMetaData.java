package com.ffcs.crmd.platform.meta.provider;

import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.intf.ISysColumn;
import com.ffcs.crmd.platform.meta.intf.ISysTable;

import java.util.List;
import java.util.Map;

/**
 * Created by linzq on 2016/1/25.
 */
public interface ITableMetaData {
    ISysTable getTable();

    void setTable(ISysTable table);

    ISysColumn getPkColumn();

    void setPkColumn(ISysColumn pkColumn);

    IBusiObjAttr getPkAttr();

    void setPkAttr(IBusiObjAttr pkAttr);

    List<IBusiObjAttr> getTableAttr();

    void setTableAttr(List<IBusiObjAttr> tableAttr);

    List<ISysColumn> getColumns();

    void setColumns(List<ISysColumn> columns);

    Map<String, String> getAttrNbrToColumnNameMap();

    void setAttrNbrToColumnNameMap(Map<String, String> attrNbrToColumnNameMap);

    Map<String, String> getColumnNameToAttrNbrMap();

    void setColumnNameToAttrNbrMap(Map<String, String> columnNameToAttrNbrMap);

    List<IBusiObjAttr> getInnerShardAttrs();

    void setInnerShardAttrs(List<IBusiObjAttr> innerShardAttrs);

    List<ISysColumn> getInnerShardColumns();

    void setInnerShardColumns(List<ISysColumn> innerShardColumns);

    List<IBusiObjAttr> getTableShardAttrs();

    void setTableShardAttrs(List<IBusiObjAttr> tableShardAttrs);

    List<ISysColumn> getTableShardColumns();

    void setTableShardColumns(List<ISysColumn> tableShardColumns);

    boolean isDanyTable();

    void setDanyTable(boolean danyTable);

    boolean isLogToHisOnUpdate();

    void setLogToHisOnUpdate(boolean logToHisOnUpdate);

    boolean isLogToHisOnDelete();

    void setLogToHisOnDelete(boolean logToHisOnDelete);

    ISysColumn getMasterColumn();

    void setMasterColumn(ISysColumn masterColumn);

    IBusiObjAttr getMasterAttr();

    void setMasterAttr(IBusiObjAttr masterAttr);

    ISysColumn getSlaAttrIdColumn();

    void setSlaAttrIdColumn(ISysColumn slaAttrIdColumn);

    IBusiObjAttr getSlaAttrIdAttr();

    void setSlaAttrIdAttr(IBusiObjAttr slaAttrIdAttr);

    ISysColumn getSlaAttrValueColumn();

    void setSlaAttrValueColumn(ISysColumn slaAttrValueColumn);

    IBusiObjAttr getSlaAttrValueAttr();

    void setSlaAttrValueAttr(IBusiObjAttr slaAttrValueAttr);

    IOpMetaInfo getSelectByPrimaryKey();

    IOpMetaInfo getSelectByPrimaryKeyAndTableSK();

    IOpMetaInfo getSelectByPrimaryKeyAndAllSK();

    IOpMetaInfo getInsertWithPkOp();

    IOpMetaInfo getInsertAutoPkOp();

    IOpMetaInfo getUpdateOpByPkAndTableSk();

    IOpMetaInfo getUpdateOpByPkAndAllSk();

    IOpMetaInfo getDeleteOpByPkAndTableSk();

    IOpMetaInfo getDeleteOpByPkAndAllSk();

    IOpMetaInfo getInsertHisTableOp();

    void setInsertHisTableOp(IOpMetaInfo insertHisTableOp);

    IOpMetaInfo getSelectByMasterKey();

    IOpMetaInfo getSelectByMasterKeyAndTableSK();

    IOpMetaInfo getSelectByMasterKeyAndAllSK();

    List<IBusiObjAttr> getTableDanyAttr();

    void setTableDanyAttr(List<IBusiObjAttr> tableDanyAttr);

    List<IBusiObjAttr> getTableBaseAttr();

    void setTableBaseAttr(List<IBusiObjAttr> tableBaseAttr);

    IExampleQuery getExampleQuery(IMetaEntity entity);

    void build();

    boolean hasInnerShard(IMetaEntity entity);
}

package com.ffcs.crmd.platform.meta.provider;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.exception.MetaException;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.intf.ISysColumn;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.meta.util.SqlConstants;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linzq on 2016/1/15.
 */
public class TableMetaData implements ITableMetaData {

    private ISysTable           table                        = null;
    private ISysColumn          pkColumn                     = null;
    private IBusiObjAttr        pkAttr                       = null;
    private List<IBusiObjAttr>  tableAttr                    = new ArrayList<IBusiObjAttr>();
    private List<IBusiObjAttr>  tableBaseAttr                = new ArrayList<IBusiObjAttr>();
    private List<IBusiObjAttr>  tableDanyAttr                = new ArrayList<IBusiObjAttr>();
    private List<ISysColumn>    columns                      = new ArrayList<ISysColumn>();
    private Map<String, String> attrNbrToColumnNameMap       = new HashMap<String, String>();
    private Map<String, String> columnNameToAttrNbrMap       = new HashMap<String, String>();
    private List<IBusiObjAttr>  innerShardAttrs              = new ArrayList<IBusiObjAttr>();
    private List<ISysColumn>    innerShardColumns            = new ArrayList<ISysColumn>();
    private List<IBusiObjAttr>  tableShardAttrs              = new ArrayList<IBusiObjAttr>();
    private List<ISysColumn>    tableShardColumns            = new ArrayList<ISysColumn>();
    private boolean             danyTable                    = false;
    private boolean             logToHisOnUpdate             = false;
    private boolean             logToHisOnDelete             = false;
    private ISysColumn          masterColumn                 = null;
    private IBusiObjAttr        masterAttr                   = null;
    private ISysColumn          slaAttrIdColumn              = null;
    private IBusiObjAttr        slaAttrIdAttr                = null;
    private ISysColumn          slaAttrValueColumn           = null;
    private IBusiObjAttr        slaAttrValueAttr             = null;
    private IOpMetaInfo         selectByPrimaryKey           = null;
    private IOpMetaInfo         selectByPrimaryKeyAndTableSK = null;
    private IOpMetaInfo         selectByPrimaryKeyAndAllSK   = null;
    //自行传入主键
    private IOpMetaInfo         insertWithPkOp               = null;
    //自动生成主键
    private IOpMetaInfo         insertAutoPkOp               = null;
    private IOpMetaInfo         updateOpByPkAndTableSk       = null;
    private IOpMetaInfo         updateOpByPkAndAllSk         = null;
    private IOpMetaInfo         deleteOpByPkAndTableSk       = null;
    private IOpMetaInfo         deleteOpByPkAndAllSk         = null;
    //插入历史表
    private IOpMetaInfo         insertHisTableOp             = null;
    private IOpMetaInfo         selectByMasterKey            = null;
    private IOpMetaInfo         selectByMasterKeyAndTableSK  = null;
    private IOpMetaInfo         selectByMasterKeyAndAllSK    = null;

    public TableMetaData() {

    }

    @Override
    public ISysTable getTable() {
        return table;
    }

    @Override
    public void setTable(ISysTable table) {
        this.table = table;
    }

    @Override
    public ISysColumn getPkColumn() {
        return pkColumn;
    }

    @Override
    public void setPkColumn(ISysColumn pkColumn) {
        this.pkColumn = pkColumn;
    }

    @Override
    public IBusiObjAttr getPkAttr() {
        return pkAttr;
    }

    @Override
    public void setPkAttr(IBusiObjAttr pkAttr) {
        this.pkAttr = pkAttr;
    }

    @Override
    public List<IBusiObjAttr> getTableAttr() {
        return tableAttr;
    }

    @Override
    public void setTableAttr(List<IBusiObjAttr> tableAttr) {
        this.tableAttr = tableAttr;
    }

    @Override
    public List<ISysColumn> getColumns() {
        return columns;
    }

    @Override
    public void setColumns(List<ISysColumn> columns) {
        this.columns = columns;
    }

    @Override
    public Map<String, String> getAttrNbrToColumnNameMap() {
        return attrNbrToColumnNameMap;
    }

    @Override
    public void setAttrNbrToColumnNameMap(Map<String, String> attrNbrToColumnNameMap) {
        this.attrNbrToColumnNameMap = attrNbrToColumnNameMap;
    }

    @Override
    public Map<String, String> getColumnNameToAttrNbrMap() {
        return columnNameToAttrNbrMap;
    }

    @Override
    public void setColumnNameToAttrNbrMap(Map<String, String> columnNameToAttrNbrMap) {
        this.columnNameToAttrNbrMap = columnNameToAttrNbrMap;
    }

    @Override
    public List<IBusiObjAttr> getInnerShardAttrs() {
        return innerShardAttrs;
    }

    @Override
    public void setInnerShardAttrs(List<IBusiObjAttr> innerShardAttrs) {
        this.innerShardAttrs = innerShardAttrs;
    }

    @Override
    public List<ISysColumn> getInnerShardColumns() {
        return innerShardColumns;
    }

    @Override
    public void setInnerShardColumns(List<ISysColumn> innerShardColumns) {
        this.innerShardColumns = innerShardColumns;
    }

    @Override
    public List<IBusiObjAttr> getTableShardAttrs() {
        return tableShardAttrs;
    }

    @Override
    public void setTableShardAttrs(List<IBusiObjAttr> tableShardAttrs) {
        this.tableShardAttrs = tableShardAttrs;
    }

    @Override
    public List<ISysColumn> getTableShardColumns() {
        return tableShardColumns;
    }

    @Override
    public void setTableShardColumns(List<ISysColumn> tableShardColumns) {
        this.tableShardColumns = tableShardColumns;
    }

    @Override
    public boolean isDanyTable() {
        return danyTable;
    }

    @Override
    public void setDanyTable(boolean danyTable) {
        this.danyTable = danyTable;
    }

    @Override
    public boolean isLogToHisOnUpdate() {
        return logToHisOnUpdate;
    }

    @Override
    public void setLogToHisOnUpdate(boolean logToHisOnUpdate) {
        this.logToHisOnUpdate = logToHisOnUpdate;
    }

    @Override
    public boolean isLogToHisOnDelete() {
        return logToHisOnDelete;
    }

    @Override
    public void setLogToHisOnDelete(boolean logToHisOnDelete) {
        this.logToHisOnDelete = logToHisOnDelete;
    }

    @Override
    public ISysColumn getMasterColumn() {

        return masterColumn;
    }

    @Override
    public void setMasterColumn(ISysColumn masterColumn) {
        this.masterColumn = masterColumn;
    }

    @Override
    public IBusiObjAttr getMasterAttr() {
        return masterAttr;
    }

    @Override
    public void setMasterAttr(IBusiObjAttr masterAttr) {
        this.masterAttr = masterAttr;
    }

    @Override
    public ISysColumn getSlaAttrIdColumn() {
        return slaAttrIdColumn;
    }

    @Override
    public void setSlaAttrIdColumn(ISysColumn slaAttrIdColumn) {
        this.slaAttrIdColumn = slaAttrIdColumn;
    }

    @Override
    public IBusiObjAttr getSlaAttrIdAttr() {
        return slaAttrIdAttr;
    }

    @Override
    public void setSlaAttrIdAttr(IBusiObjAttr slaAttrIdAttr) {
        this.slaAttrIdAttr = slaAttrIdAttr;
    }

    @Override
    public ISysColumn getSlaAttrValueColumn() {
        return slaAttrValueColumn;
    }

    @Override
    public void setSlaAttrValueColumn(ISysColumn slaAttrValueColumn) {
        this.slaAttrValueColumn = slaAttrValueColumn;
    }

    @Override
    public IBusiObjAttr getSlaAttrValueAttr() {
        return slaAttrValueAttr;
    }

    @Override
    public void setSlaAttrValueAttr(IBusiObjAttr slaAttrValueAttr) {
        this.slaAttrValueAttr = slaAttrValueAttr;
    }

    public void build() {
        String tableName = table.getTabName();

        String insertFields = buildSelectAndInsertField();
        String insertAllSql =
            SqlConstants.INSERT_INTO + tableName + "(" + insertFields + ")" + SqlConstants.VALUES
                + "(" + buildInsertAllValues() + ")";
        String insertAutoPkSql =
            SqlConstants.INSERT_INTO + tableName + "(" + insertFields + ")" + SqlConstants.VALUES
                + "(" + buildInsertAutoPkValues() + ")";
        //生成插入操作
        insertWithPkOp = new OpMetaInfo();
        insertWithPkOp.setSql(insertAllSql);
        insertWithPkOp.setAttrs(buildInsertAllParamNbrs());
        insertWithPkOp.setPkAttr(pkAttr);

        insertAutoPkOp = new OpMetaInfo();
        insertAutoPkOp.setSql(insertAutoPkSql);
        insertAutoPkOp.setAttrs(buildInsertAutoPkParamNbrs());
        insertAutoPkOp.setPkAttr(pkAttr);

        //生成查询操作
        String selectFields = buildSelectAndInsertField();
        selectByPrimaryKey = new OpMetaInfo();
        String selectByPkSql =
            SqlConstants.SELECT + selectFields + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(false, false, false);
        selectByPrimaryKey.setSql(selectByPkSql);
        selectByPrimaryKey.setAttrs(buildWhereParamNbr(false, false, false));

        selectByPrimaryKeyAndTableSK = new OpMetaInfo();
        String selectByPkAndTableSkSql =
            SqlConstants.SELECT + selectFields + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(false, true, false);
        selectByPrimaryKeyAndTableSK.setSql(selectByPkAndTableSkSql);
        selectByPrimaryKeyAndTableSK.setAttrs(buildWhereParamNbr(false, true, false));

        selectByPrimaryKeyAndAllSK = new OpMetaInfo();
        String selectByPkAndAllSkSql =
            SqlConstants.SELECT + selectFields + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(false, true, true);
        selectByPrimaryKeyAndAllSK.setSql(selectByPkAndAllSkSql);
        selectByPrimaryKeyAndAllSK.setAttrs(buildWhereParamNbr(false, true, true));

        selectByMasterKey = new OpMetaInfo();
        String selectByMkSql =
            SqlConstants.SELECT + selectFields + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(true, false, false);
        selectByMasterKey.setSql(selectByMkSql);
        selectByMasterKey.setAttrs(buildWhereParamNbr(true, false, false));

        selectByMasterKeyAndTableSK = new OpMetaInfo();
        String selectByMkAndTableSkSql =
            SqlConstants.SELECT + selectFields + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(true, true, false);
        selectByMasterKeyAndTableSK.setSql(selectByMkAndTableSkSql);
        selectByMasterKeyAndTableSK.setAttrs(buildWhereParamNbr(true, true, false));

        selectByMasterKeyAndAllSK = new OpMetaInfo();
        String selectByMkAndAllSkSql =
            SqlConstants.SELECT + selectFields + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(true, true, true);
        selectByMasterKeyAndAllSK.setSql(selectByMkAndAllSkSql);
        selectByMasterKeyAndAllSK.setAttrs(buildWhereParamNbr(true, true, true));

        String updateFields = buildUpdateField();
        List<String> updateAttrs = buildUpdateParamNbrs();

        String updateSqlByPkAndTableSk =
            SqlConstants.UPDATE + tableName + SqlConstants.SET + updateFields + SqlConstants.WHERE
                + buildWhereSql(false, true, false);
        updateOpByPkAndTableSk = new OpMetaInfo();
        updateOpByPkAndTableSk.setSql(updateSqlByPkAndTableSk);
        List<String> attrs = new ArrayList<String>(updateAttrs);
        attrs.addAll(buildWhereParamNbr(false, true, false));
        updateOpByPkAndTableSk.setAttrs(attrs);

        String updateSqlByPkAndAllSk =
            SqlConstants.UPDATE + tableName + SqlConstants.SET + updateFields + SqlConstants.WHERE
                + buildWhereSql(false, true, true);
        updateOpByPkAndAllSk = new OpMetaInfo();
        updateOpByPkAndAllSk.setSql(updateSqlByPkAndAllSk);
        List<String> attrs2 = new ArrayList<String>(updateAttrs);
        attrs2.addAll(buildWhereParamNbr(false, true, true));
        updateOpByPkAndAllSk.setAttrs(attrs2);

        String deleteSqlByPkAndTableSk =
            SqlConstants.DELETE + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(false, true, false);
        String deleteSqlByPkAndAllSk =
            SqlConstants.DELETE + SqlConstants.FROM + tableName + SqlConstants.WHERE
                + buildWhereSql(false, true, true);

        deleteOpByPkAndTableSk = new OpMetaInfo();
        deleteOpByPkAndTableSk.setSql(deleteSqlByPkAndTableSk);
        deleteOpByPkAndTableSk.setAttrs(buildWhereParamNbr(false, true, false));

        deleteOpByPkAndAllSk = new OpMetaInfo();
        deleteOpByPkAndAllSk.setSql(deleteSqlByPkAndAllSk);
        deleteOpByPkAndAllSk.setAttrs(buildWhereParamNbr(false, true, true));

        //生成历史表操作
        insertHisTableOp = new OpMetaInfo();
        String hisTableName = table.getHisTableName();
        String insertHisSql =
            SqlConstants.INSERT_INTO + hisTableName + "(" + "HIS_ID," + insertFields + ")"
                + SqlConstants.VALUES + "(" + getSeqColumnValue(table.getHisSeqName()) + ","
                + buildInsertAllValues() + ")";
        insertHisTableOp.setSql(insertHisSql);
        insertHisTableOp.setAttrs(buildInsertAllParamNbrs());

    }

    @Override
    public boolean hasInnerShard(IMetaEntity entity) {
        List<IBusiObjAttr> tableShardAttrs = this.getTableShardAttrs();
        if (tableShardAttrs != null && tableShardAttrs.size() > 0) {
            for (IBusiObjAttr attr : tableShardAttrs) {
                Object obj = entity.readAttrByBusiObjAttrId(attr.getId());
                if (obj == null) {
                    ExceptionUtils.throwEx(new MetaException("sharding_key could not null:" + attr.getId()));
                }
            }
        }

        boolean hasInner = false;
        List<IBusiObjAttr> innerShardAttrs = this.getInnerShardAttrs();
        if (innerShardAttrs != null && innerShardAttrs.size() > 0) {
            for (IBusiObjAttr attr : innerShardAttrs) {
                Object obj = entity.readAttrByBusiObjAttrId(attr.getId());
                if (obj == null) {
                    hasInner = false;
                    break;
                }
            }
            hasInner = true;
        }
        return hasInner;
    }

    private String buildSelectAndInsertField() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (ISysColumn column : columns) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(column.getColName());
            i++;
        }
        return builder.toString();
    }

    private String buildInsertAllValues() {
        return buildInsertValues(false);
    }

    private String buildInsertAutoPkValues() {
        return buildInsertValues(true);
    }

    private String buildInsertValues(boolean isAutoPk) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (ISysColumn column : columns) {
            if (i != 0) {
                builder.append(",");
            }
            if (isAutoPk && column.getId().equals(pkColumn.getId())) {
                builder.append(getSeqColumnValue(pkAttr.readSeqName()));
            } else {
                builder.append("?");
            }
            i++;
        }
        return builder.toString();
    }

    /**
     * 不自动生成主键的insert参数列表
     * @return
     */
    public List<String> buildInsertAllParamNbrs() {
        return buildInsertParamsNbrs(false);
    }

    /**
     * 自动生成主键的insert参数列表
     * @return
     */
    public List<String> buildInsertAutoPkParamNbrs() {
        return buildInsertParamsNbrs(true);
    }

    private List<String> buildInsertParamsNbrs(boolean isIgnorePk) {
        List<String> attrNbrs = new ArrayList<String>();

        for (ISysColumn column : columns) {
            if (isIgnorePk && column.getId().equals(pkColumn.getId())) {
                continue;
            }
            attrNbrs.add(columnNameToAttrNbrMap.get(column.getColName()));
        }
        return attrNbrs;
    }

    private String buildUpdateField() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (ISysColumn column : columns) {
            //主键不更新
            if (column.getColName().equals(pkColumn.getColName())) {
                continue;
            }
            //分片键不能更新
            List<ISysColumn> allShardColumns = new ArrayList<ISysColumn>();
            allShardColumns.addAll(getInnerShardColumns());
            allShardColumns.addAll(getTableShardColumns());
            boolean isShardind = false;
            if (allShardColumns != null && allShardColumns.size() > 0) {
                for (ISysColumn shardColumn : allShardColumns) {
                    if (shardColumn.getColName().equals(column.getColName())) {
                        isShardind = true;
                        break;
                    }
                }
            }
            if (isShardind) {
                continue;
            }
            if (i != 0) {
                builder.append(",");
            }
            builder.append(column.getColName());
            builder.append("=?");
            i++;
        }
        return builder.toString();
    }

    public List<String> buildUpdateParamNbrs() {
        List<String> attrNbrs = new ArrayList<String>();

        for (ISysColumn column : columns) {
            //主键不更新
            if (column.getColName().equals(pkColumn.getColName())) {
                continue;
            }

            //分片键不能更新
            List<ISysColumn> allShardColumns = new ArrayList<ISysColumn>();
            allShardColumns.addAll(getInnerShardColumns());
            allShardColumns.addAll(getTableShardColumns());
            boolean isShardind = false;

            if (allShardColumns != null && allShardColumns.size() > 0) {
                for (ISysColumn shardColumn : allShardColumns) {
                    if (shardColumn.getColName().equals(column.getColName())) {
                        isShardind = true;
                    }
                }
            }
            if (isShardind) {
                continue;
            }

            attrNbrs.add(columnNameToAttrNbrMap.get(column.getColName()));
        }
        return attrNbrs;
    }

    /**
     * 构建sql条件，是否包含分库分表条件
     * @param isIncludeShard
     * @param isIncludeInnerShard
     * @return
     */
    private String buildWhereSql(boolean isUseMasterKey, boolean isIncludeShard,
        boolean isIncludeInnerShard) {
        StringBuilder builder = new StringBuilder();
        if (isUseMasterKey && isDanyTable()) {
            builder.append(masterColumn.getColName());
        } else {
            builder.append(pkColumn.getColName());
        }
        builder.append("=?");

        Map<String, String> map = new HashMap<String, String>();
        if (isIncludeShard) {
            //分库分表处理
            if (tableShardColumns != null && tableShardColumns.size() > 0) {
                for (ISysColumn tableShardColumn : tableShardColumns) {
                    builder.append(SqlConstants.AND);
                    builder.append(tableShardColumn.getColName());
                    builder.append("= ?");
                    map.put(tableShardColumn.getColName(), tableShardColumn.getColName());
                }
            }
        }

        //库内分表处理
        if (isIncludeInnerShard) {
            //分库分表处理
            if (innerShardColumns != null && innerShardColumns.size() > 0) {
                for (ISysColumn innerShardColumn : innerShardColumns) {
                    if (map.containsKey(innerShardColumn.getColName())) {
                        continue;
                    }
                    builder.append(SqlConstants.AND);
                    builder.append(innerShardColumn.getColName());
                    builder.append("= ?");
                    map.put(innerShardColumn.getColName(), innerShardColumn.getColName());
                }
            }
        }

        return builder.toString();
    }

    /**
     * 构建和sql语句对应的属性列表
     * @return
     */
    public List<String> buildWhereParamNbr(boolean isUseMasterKey, boolean isIncludeShard,
        boolean isIncludeInnerShard) {
        List<String> attrNbrs = new ArrayList<String>();
        if (isUseMasterKey && isDanyTable()) {
            attrNbrs.add(masterAttr.readAttrNbr());
        } else {
            attrNbrs.add(pkAttr.readAttrNbr());
        }

        Map<Long, Long> map = new HashMap<Long, Long>();
        if (isIncludeShard) {
            //分库分表处理
            if (tableShardAttrs != null && tableShardAttrs.size() > 0) {
                for (IBusiObjAttr busiObjAttr : tableShardAttrs) {
                    attrNbrs.add(busiObjAttr.readAttrNbr());
                    map.put(busiObjAttr.getId(), busiObjAttr.getId());
                }
            }
        }

        //库内分表处理
        if (isIncludeInnerShard) {
            if (innerShardAttrs != null && innerShardAttrs.size() > 0) {
                for (IBusiObjAttr busiObjAttr : innerShardAttrs) {
                    if (map.containsKey(busiObjAttr.getId())) {
                        continue;
                    }
                    attrNbrs.add(busiObjAttr.readAttrNbr());
                    map.put(busiObjAttr.getId(), busiObjAttr.getId());
                }
            }
        }
        return attrNbrs;
    }

    private String getSeqColumnValue(String seqName) {
        //        if (StringUtils.isNullOrEmpty(seqName)) {
        //            ExceptionUtils.throwEx(new MetaException(
        //                "tableName:" + this.getTable().getTabName() + ";seqName could Not null"));
        //        }
        return seqName + ".nextval";
    }

    @Override
    public IOpMetaInfo getSelectByPrimaryKey() {
        return selectByPrimaryKey;
    }

    @Override
    public IOpMetaInfo getSelectByPrimaryKeyAndTableSK() {
        return selectByPrimaryKeyAndTableSK;
    }

    @Override
    public IOpMetaInfo getSelectByPrimaryKeyAndAllSK() {
        return selectByPrimaryKeyAndAllSK;
    }

    @Override
    public IOpMetaInfo getInsertWithPkOp() {
        return insertWithPkOp;
    }

    @Override
    public IOpMetaInfo getInsertAutoPkOp() {
        return insertAutoPkOp;
    }

    @Override
    public IOpMetaInfo getUpdateOpByPkAndTableSk() {
        return updateOpByPkAndTableSk;
    }

    @Override
    public IOpMetaInfo getUpdateOpByPkAndAllSk() {
        return updateOpByPkAndAllSk;
    }

    @Override
    public IOpMetaInfo getDeleteOpByPkAndTableSk() {
        return deleteOpByPkAndTableSk;
    }

    @Override
    public IOpMetaInfo getDeleteOpByPkAndAllSk() {
        return deleteOpByPkAndAllSk;
    }

    @Override
    public IOpMetaInfo getInsertHisTableOp() {
        return insertHisTableOp;
    }

    @Override
    public void setInsertHisTableOp(IOpMetaInfo insertHisTableOp) {
        this.insertHisTableOp = insertHisTableOp;
    }

    @Override
    public IOpMetaInfo getSelectByMasterKey() {
        return selectByMasterKey;
    }

    @Override
    public IOpMetaInfo getSelectByMasterKeyAndTableSK() {
        return selectByMasterKeyAndTableSK;
    }

    @Override
    public IOpMetaInfo getSelectByMasterKeyAndAllSK() {
        return selectByMasterKeyAndAllSK;
    }

    @Override
    public List<IBusiObjAttr> getTableDanyAttr() {
        return tableDanyAttr;
    }

    @Override
    public void setTableDanyAttr(List<IBusiObjAttr> tableDanyAttr) {
        this.tableDanyAttr = tableDanyAttr;
    }

    @Override
    public List<IBusiObjAttr> getTableBaseAttr() {
        return tableBaseAttr;
    }

    @Override
    public void setTableBaseAttr(List<IBusiObjAttr> tableBaseAttr) {
        this.tableBaseAttr = tableBaseAttr;
    }

    public IExampleQuery getExampleQuery(IMetaEntity entity) {
        List<IBusiObjAttr> baseAttrs = getTableBaseAttr();
        if (baseAttrs == null || baseAttrs.size() <=0) {
            ExceptionUtils.throwEx(new MetaException("not define BaseAttr"));
        }
        StringBuilder sql = new StringBuilder();
        sql.append(SqlConstants.SELECT);
        sql.append(buildSelectAndInsertField());
        sql.append(SqlConstants.FROM);
        sql.append(this.getTable().getTabName());
        int i = 0;
        List<Object> params = new ArrayList<Object>();
        for (IBusiObjAttr attr : baseAttrs) {
            String attrNbr = attr.readAttrNbr();
            Object value = entity.readAttr(attrNbr);
            if (!StringUtils.isNullOrEmpty(value)) {
                if (i == 0) {
                    sql.append(SqlConstants.WHERE);
                } else {
                    sql.append(SqlConstants.AND);
                }
                sql.append(getAttrNbrToColumnNameMap().get(attrNbr));
                sql.append("=?");
                params.add(value);
                i++;
            }
        }
        IExampleQuery query = new ExampleQuery();
        query.setSql(sql.toString());
        query.setParams(params);
        return query;
    }


}

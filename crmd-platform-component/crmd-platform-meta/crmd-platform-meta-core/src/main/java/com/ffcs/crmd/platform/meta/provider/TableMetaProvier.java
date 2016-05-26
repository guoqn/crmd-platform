package com.ffcs.crmd.platform.meta.provider;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.entity.SysColumn;
import com.ffcs.crmd.platform.meta.entity.SysTable;
import com.ffcs.crmd.platform.meta.exception.MetaException;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.ISysColumn;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/2/25.
 */
public class TableMetaProvier {
    //日志记录器
    private static final ILogger                                              LOG                                   = LoggerFactory
        .getLogger(TableMetaProvier.class);
    //BusiObj对应的Table列表
    private static       ConcurrentMap<Long, List<ISysTable>>                 objIdToSysTablesMap                   = new ConcurrentHashMap<Long, List<ISysTable>>();
    //BusiObjId和TableId对应的列清单,实际操作的列，如总的15列，但是个人客户至操作13列
    private static       ConcurrentMap<String, List<ISysColumn>>              objIdAndTableIdToColumnsMap           = new ConcurrentHashMap<String, List<ISysColumn>>();
    //BusiObjId和TableId对应的列和属性对应关系
    private static       ConcurrentMap<String, Map<String, String>>           objIdAndTableIdToColumnToAttrNbrMap   = new ConcurrentHashMap<String, Map<String, String>>();
    //BusiObjId和TableId对应的属性和列对应关系
    private static       ConcurrentMap<String, Map<String, String>>           objIdAndTableIdToAttrNbrToColumnMap   = new ConcurrentHashMap<String, Map<String, String>>();
    //tableId对应的所有列
    private static       ConcurrentMap<Long, List<ISysColumn>>                tableIdToColumnsMap                   = new ConcurrentHashMap<Long, List<ISysColumn>>();
    //BusiObjId和TableId对应的有效属性清单
    private static       ConcurrentMap<String, List<IBusiObjAttr>>            objIdAndTableIdToAttrsMap             = new ConcurrentHashMap<String, List<IBusiObjAttr>>();
    //BusiObjId和TableId对应的有效横表属性清单
    private static       ConcurrentMap<String, List<IBusiObjAttr>>            objIdAndTableIdToBaseAttrsMap         = new ConcurrentHashMap<String, List<IBusiObjAttr>>();
    //BusiObjId和TableId对应的有效纵表属性清单
    private static       ConcurrentMap<String, List<IBusiObjAttr>>            objIdAndTableIdToDanyAttrsMap         = new ConcurrentHashMap<String, List<IBusiObjAttr>>();
    //BusiObjId和TableId对应的有效的主键属性、列
    private static       ConcurrentMap<String, IBusiObjAttr>                  objIdAndTableIdToPkAttrMap            = new ConcurrentHashMap<String, IBusiObjAttr>();
    private static       ConcurrentMap<String, ISysColumn>                    objIdAndTableIdToPkColumnMap          = new ConcurrentHashMap<String, ISysColumn>();
    //Table为扩展属性表时，BusiObjId和TableId对应的有效的主表属性、列
    private static       ConcurrentMap<String, ISysColumn>                    objIdAndTableIdToMasterColumnMap      = new ConcurrentHashMap<String, ISysColumn>();
    private static       ConcurrentMap<String, IBusiObjAttr>                  objIdAndTableIdToMasterAttrMap        = new ConcurrentHashMap<String, IBusiObjAttr>();
    //Table为扩展属性表时，BusiObjId和TableId对应的有效的attrId属性和列
    private static       ConcurrentMap<String, ISysColumn>                    objIdAndTableIdToAttrIdColumnMap      = new ConcurrentHashMap<String, ISysColumn>();
    private static       ConcurrentMap<String, IBusiObjAttr>                  objIdAndTableIdToAttrIdAttrMap        = new ConcurrentHashMap<String, IBusiObjAttr>();
    //Table为扩展属性表时，BusiObjId和TableId对应的有效的attrVale属性和列
    private static       ConcurrentMap<String, ISysColumn>                    objIdAndTableIdToAttrValueColumnMap   = new ConcurrentHashMap<String, ISysColumn>();
    private static       ConcurrentMap<String, IBusiObjAttr>                  objIdAndTableIdToAttrValueAttrMap     = new ConcurrentHashMap<String, IBusiObjAttr>();
    //BusiObjId和TableId对应的库内分表属性和列清单
    private static       ConcurrentMap<String, List<IBusiObjAttr>>            objIdAndTableIdToInnerShardAttrsMap   = new ConcurrentHashMap<String, List<IBusiObjAttr>>();
    private static       ConcurrentMap<String, List<ISysColumn>>              objIdAndTableIdToInnerShardColumnsMap = new ConcurrentHashMap<String, List<ISysColumn>>();
    //BusiObjId和TableId对应的分片表属性和列清单
    private static       ConcurrentMap<String, List<IBusiObjAttr>>            objIdAndTableIdToTableShardAttrsMap   = new ConcurrentHashMap<String, List<IBusiObjAttr>>();
    private static       ConcurrentMap<String, List<ISysColumn>>              objIdAndTableIdToTableShardColumnsMap = new ConcurrentHashMap<String, List<ISysColumn>>();
    //BusiObj对应的属性，根据表做分组
    private static       ConcurrentMap<Long, Map<String, List<IBusiObjAttr>>> objIdToGroupTableAttrsMap             = new ConcurrentHashMap<Long, Map<String, List<IBusiObjAttr>>>();
    private static       ConcurrentMap<Long, Map<String, List<Long>>>         objIdToGroupTableAttrIdsMap           = new ConcurrentHashMap<Long, Map<String, List<Long>>>();
    private static       ConcurrentMap<Long, Map<String, List<String>>>       objIdToGroupTableAttrNbrsMap          = new ConcurrentHashMap<Long, Map<String, List<String>>>();

    //公共字段的列表
    private static final List<String> PUBLIC_COLUMNS = new ArrayList<String>();
    private static final List<String> PUBLIC_ATTRS   = new ArrayList<String>();

    static {
        String[] COLUMNS = new String[] { "STATUS_CD", "CREATE_DATE", "STATUS_DATE", "UPDATE_DATE",
            "SHARDING_ID", "CREATE_STAFF", "UPDATE_STATFF", "TENANT_ID", "REGION_CD", "AREA_ID",
            "REC_UPDATE_DATE", "REL_SHARING_ID", "DVERSION", "DTIMESTAMP" };
        for (String column : COLUMNS) {
            PUBLIC_ATTRS.add(StringUtils.parseColumnName2PropertyName(column));
            PUBLIC_COLUMNS.add(column);
        }
    }

    /**
     * 是否为公共字段
     * @param column
     * @return
     */
    private static boolean isPublicColumn(String column) {
        return PUBLIC_COLUMNS.contains(column);
    }

    /**
     * 是否为公共属性
     * @param attr
     * @return
     */
    private static boolean isPublicAttr(String attr) {
        return PUBLIC_ATTRS.contains(attr);
    }

    /**
     * 获取业务对象关联的表
     * @param busiObj
     * @return
     */
    public static List<ISysTable> getSysTables(IBusiObj busiObj) {
        Long busiObjId = busiObj.getId();
        if (objIdToSysTablesMap.containsKey(busiObjId)) {
            return objIdToSysTablesMap.get(busiObjId);
        }

        List<SysTable> sysTables = SysTable.repository().getValidSysTableByObjId(busiObjId);
        List<ISysTable> tables = new ArrayList<ISysTable>(sysTables);
        objIdToSysTablesMap.putIfAbsent(busiObjId, tables);
        return objIdToSysTablesMap.get(busiObjId);
    }

    public static ISysTable getDanyTable(List<ISysTable> sysTables, ISysTable masterTable) {
        for (ISysTable table : sysTables) {
            if (table.getMstrTabId() != null && table.getMstrTabId().equals(masterTable.getId())) {
                return table;
            }
        }
        return null;
    }

    public static ISysTable getDanyTableByBusiObj(IBusiObj busiObj, ISysTable masterTable) {
        List<ISysTable> sysTables = getSysTables(busiObj);
        return getDanyTable(sysTables, masterTable);
    }

    public static ISysTable getDanyTableByName(List<ISysTable> sysTables, String masterTableName) {
        ISysTable masterTable = null;
        for (ISysTable table : sysTables) {
            if (table.getTabName().equals(masterTableName)) {
                masterTable = table;
                break;
            }
        }
        if (masterTable == null) {
            return null;
        }
        return getDanyTable(sysTables, masterTable);

    }

    /**
     * 获取表对应的columns信息
     * @param sysTable
     * @return
     */
    public static List<ISysColumn> getAllColumns(ISysTable sysTable) {
        Long tableId = sysTable.getId();
        if (!tableIdToColumnsMap.containsKey(tableId)) {
            List<SysColumn> columns = SysColumn.repository()
                .qrySysColumnsListByTabIdAndStatusCd(tableId);
            List<ISysColumn> sysColumns = new ArrayList<ISysColumn>(columns);
            tableIdToColumnsMap.putIfAbsent(tableId, sysColumns);
        }
        return tableIdToColumnsMap.get(tableId);
    }

    /**
     * 根据业务对象和表，获取能操作的属性
     * @param busiObj
     * @param table
     * @return
     */
    public static List<IBusiObjAttr> getTableAttrsByBusiObj(IBusiObj busiObj, ISysTable table) {
        Long busiObjId = busiObj.getId();
        Long tableId = table.getId();
        String key = MetaProvider.getKey(busiObjId, tableId);
        if (!objIdAndTableIdToAttrsMap.containsKey(key)) {
            List<ISysTable> sysTables = getSysTables(busiObj);
            boolean exists = false;
            for (ISysTable sysTable : sysTables) {
                if (sysTable.getId().equals(tableId)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                throw new MetaException(tableId + " is Not in busiObj:" + busiObjId);
            }
            List<IBusiObjAttr> tableAttrs = new ArrayList<IBusiObjAttr>();

            List<IBusiObjAttr> attrSpecs = BusiObjAttrProvider.getAllBusiObjAttrsByBusiObj(busiObj);
            if (attrSpecs == null || attrSpecs.size() <= 0) {
                //            throw new MetaException(tableId + " is Not Define:" + busiObjId);
                LOG.warn(busiObjId + " is Not Define Attrs,Could not get tableInfo");
                objIdAndTableIdToAttrsMap.putIfAbsent(key, new ArrayList<IBusiObjAttr>());
                return objIdAndTableIdToAttrsMap.get(key);
            }

            for (IBusiObjAttr attr : attrSpecs) {
                //如果表ID相等，则直接加入列表
                ////静态表，可以做如下处理
                //tableId和当前表相等的，加入列表
                //输入固定属性的，加入列表
                if (tableId.equals(attr.getTabId())) {
                    tableAttrs.add(attr);
                } else if (!table.isDanyTable() && isPublicAttr(
                    attr.readAttrNbr())) { //属于公共字段属性，一定要处理
                    tableAttrs.add(attr);
                }
            }
            //动态属性表，需要做特殊处理
            if (table.isDanyTable()) {
                //动态属性表，需要根据表名，翻译成busiType名称，去获取对应的busiObj，以及属性清单
                String entityName = StringUtils
                    .firstCharUpCase(StringUtils.parseColumnName2PropertyName(table.getTabName()));
                List<IBusiObj> busiObjs = BusiObjProvider.getAllBusiObjByEntityName(entityName);
                if (busiObjs == null || busiObjs.size() <= 0) {
                    ExceptionUtils.throwEx(entityName + " do not define busiObj");
                }
                if (busiObjs.size() > 1) {
                    LOG.warn(entityName + " has too many BusiObj");
                }
                IBusiObj danyObj = busiObjs.get(0);
                List<IBusiObjAttr> danyTableAttrSpecs = BusiObjAttrProvider
                    .getAllBusiObjAttrsByBusiObj(danyObj);
                if (danyTableAttrSpecs == null || danyTableAttrSpecs.size() <= 0) {
                    //            throw new MetaException(tableId + " is Not Define:" + busiObjId);
                    LOG.warn(danyObj.getId() + " is Not Define Attrs,Could not get tableInfo");
                    objIdAndTableIdToAttrsMap.putIfAbsent(key, new ArrayList<IBusiObjAttr>());
                    return objIdAndTableIdToAttrsMap.get(key);
                }

                for (IBusiObjAttr attr : danyTableAttrSpecs) {
                    //如果表ID相等，则直接加入列表
                    //tableId和当前表相等的，加入列表
                    //输入固定属性的，加入列表
                    if (tableId.equals(attr.getTabId())) {
                        tableAttrs.add(attr);
                    } else if (isPublicAttr(attr.readAttrNbr())) { //属于公共字段属性，一定要处理
                        tableAttrs.add(attr);
                    }
                }

            }

            List<IBusiObjAttr> baseTableAttrs = new ArrayList<IBusiObjAttr>();
            List<IBusiObjAttr> danyTableAttrs = new ArrayList<IBusiObjAttr>();
            for (IBusiObjAttr attr : tableAttrs) {
                if (!attr.checkIsDanyAttr()) {
                    baseTableAttrs.add(attr);
                } else {
                    danyTableAttrs.add(attr);
                }
            }
            objIdAndTableIdToAttrsMap.putIfAbsent(key, tableAttrs);
            objIdAndTableIdToBaseAttrsMap.putIfAbsent(key, baseTableAttrs);
            objIdAndTableIdToDanyAttrsMap.putIfAbsent(key, danyTableAttrs);
        }

        return objIdAndTableIdToAttrsMap.get(key);

    }

    /**
     * 根据业务对象和表，获取能操作的字段
     * @param busiObj
     * @param tables
     * @return
     */
    public static List<ISysColumn> getTableColumnsByBusiObj(IBusiObj busiObj, ISysTable tables) {
        Long busiObjId = busiObj.getId();
        Long tableId = tables.getId();
        String key = MetaProvider.getKey(busiObjId, tableId);
        if (!objIdAndTableIdToColumnsMap.containsKey(key)) {

            List<ISysTable> sysTables = getSysTables(busiObj);
            boolean exists = false;
            for (ISysTable sysTable : sysTables) {
                if (sysTable.getId().equals(tableId)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                throw new MetaException(tableId + " is Not in busiObj:" + busiObjId);
            }

            List<IBusiObjAttr> attrSpecs = getTableAttrsByBusiObj(busiObj, tables);
            if (attrSpecs == null || attrSpecs.size() <= 0) {
                //            throw new MetaException(tableId + " is Not Define:" + busiObjId);
                LOG.warn(busiObjId + " is Not Define Attrs,Could not get tableInfo");
                objIdAndTableIdToColumnsMap.putIfAbsent(key, new ArrayList<ISysColumn>());
                return objIdAndTableIdToColumnsMap.get(key);
            }

            List<ISysColumn> columns = getAllColumns(tables);
            List<ISysColumn> tableColumns = new ArrayList<ISysColumn>();
            Map<String, String> attrNbrToColumn = new HashMap<String, String>();
            Map<String, String> columnToAttrNbr = new HashMap<String, String>();
            ISysColumn pkColumn = null;
            IBusiObjAttr pkAttr = null;
            ISysColumn masterColumn = null;
            IBusiObjAttr masterAttr = null;

            ISysColumn attrIdColumn = null;
            IBusiObjAttr attrIdAttr = null;

            ISysColumn attrValueColumn = null;
            IBusiObjAttr attrValueAttr = null;
            //库内分片信息
            List<IBusiObjAttr> innerShardAttr = new ArrayList<IBusiObjAttr>();
            List<ISysColumn> innerShardColumn = new ArrayList<ISysColumn>();

            //分库分片信息
            List<IBusiObjAttr> tableShardAttr = new ArrayList<IBusiObjAttr>();
            List<ISysColumn> tableShardColumn = new ArrayList<ISysColumn>();

            if (columns != null && columns.size() > 0) {
                for (IBusiObjAttr attr : attrSpecs) {
                    for (ISysColumn column : columns) {
                        //如果col的id和attr的colId,tableId和attr的tableid相等
                        //或者attr和column都是公共属性
                        if ((column.getId().equals(attr.getColId()) && tableId
                            .equals(attr.getTabId())) || (attr.readAttrNbr()
                            .equals(StringUtils.parseColumnName2PropertyName(column.getColName()))
                            && isPublicColumn(column.getColName()))) {
                            tableColumns.add(column);
                            attrNbrToColumn.put(attr.readAttrNbr(), column.getColName());
                            columnToAttrNbr.put(column.getColName(), attr.readAttrNbr());
                            if (tables.getTabKeyColName().equals(column.getColName())) {
                                pkColumn = column;
                                pkAttr = attr;
                            }
                            if (tables.isDanyTable()) {
                                if (StringUtils.strnull(tables.getSlaTabInstColName())
                                    .equals(column.getColName())) {
                                    masterColumn = column;
                                    masterAttr = attr;
                                }
                                if (StringUtils.strnull(tables.getSlaTabAttrColName())
                                    .equals(column.getColName())) {
                                    attrIdColumn = column;
                                    attrIdAttr = attr;
                                }

                                if (StringUtils.strnull(tables.getSlaTabAttrValColName())
                                    .equals(column.getColName())) {
                                    attrValueAttr = attr;
                                    attrValueColumn = column;
                                }
                            }
                            //如果是分片键
                            if (NumberUtils.nullToLongZero(column.getShardingLevel()) >= 1) {
                                if (NumberUtils.nullToLongZero(column.getShardingLevel()) >= 2) {

                                    if (NumberUtils.nullToLongZero(column.getShardingLevel())
                                        >= 3) {
                                        //既是分片建还是库内分表
                                        tableShardAttr.add(attr);
                                        tableShardColumn.add(column);
                                        innerShardAttr.add(attr);
                                        innerShardColumn.add(column);
                                    } else {
                                        //分片建
                                        tableShardAttr.add(attr);
                                        tableShardColumn.add(column);
                                    }
                                } else {
                                    //库内分表
                                    innerShardAttr.add(attr);
                                    innerShardColumn.add(column);
                                }
                            }
                        }
                    }
                }
            }
            objIdAndTableIdToInnerShardAttrsMap.putIfAbsent(key, innerShardAttr);
            objIdAndTableIdToInnerShardColumnsMap.putIfAbsent(key, innerShardColumn);
            objIdAndTableIdToTableShardAttrsMap.putIfAbsent(key, tableShardAttr);
            objIdAndTableIdToTableShardColumnsMap.putIfAbsent(key, tableShardColumn);
            if (masterColumn != null) {
                objIdAndTableIdToMasterColumnMap.putIfAbsent(key, masterColumn);
            }
            if (masterAttr != null) {
                objIdAndTableIdToMasterAttrMap.putIfAbsent(key, masterAttr);
            }
            if (pkAttr != null) {
                objIdAndTableIdToPkAttrMap.putIfAbsent(key, pkAttr);
            } else {
                LOG.warn(key + ":pk attr not config");
            }
            if (pkColumn != null) {
                objIdAndTableIdToPkColumnMap.putIfAbsent(key, pkColumn);
            } else {
                LOG.warn(key + ":pk Column not config");
            }
            objIdAndTableIdToColumnsMap.putIfAbsent(key, tableColumns);
            objIdAndTableIdToAttrNbrToColumnMap.putIfAbsent(key, attrNbrToColumn);
            objIdAndTableIdToColumnToAttrNbrMap.putIfAbsent(key, columnToAttrNbr);
            if (attrIdAttr != null) {
                objIdAndTableIdToAttrIdAttrMap.putIfAbsent(key, attrIdAttr);
            }
            if (attrIdColumn != null) {
                objIdAndTableIdToAttrIdColumnMap.putIfAbsent(key, attrIdColumn);
            }
            if (attrValueAttr != null) {
                objIdAndTableIdToAttrValueAttrMap.putIfAbsent(key, attrValueAttr);
            }
            if (attrValueColumn != null) {
                objIdAndTableIdToAttrValueColumnMap.putIfAbsent(key, attrValueColumn);
            }
        }
        return objIdAndTableIdToColumnsMap.get(key);
    }

    private static <K, V> V getObjectFromMapWithInit(IBusiObj busiObj, ISysTable tables,
        Map<K, V> map) {
        Long busiObjId = busiObj.getId();
        Long tableId = tables.getId();
        String key = MetaProvider.getKey(busiObjId, tableId);
        if (!map.containsKey(key)) {
            getTableColumnsByBusiObj(busiObj, tables);
        }
        return map.get(key);
    }

    public static Map<String, String> getColumnNameToAttrNbrMap(IBusiObj busiObj,
        ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToColumnToAttrNbrMap);
    }

    public static Map<String, String> getAttrNbrToColumnNameMap(IBusiObj busiObj,
        ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToAttrNbrToColumnMap);
    }

    public static IBusiObjAttr getPkAttr(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToPkAttrMap);
    }

    public static ISysColumn getPkColumn(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToPkColumnMap);
    }

    public static IBusiObjAttr getMasterAttr(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToMasterAttrMap);
    }

    public static ISysColumn getMasterColumn(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToMasterColumnMap);
    }

    public static List<ISysColumn> getInnerShardColumns(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToInnerShardColumnsMap);
    }

    public static List<IBusiObjAttr> getInnerShardAttrs(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToInnerShardAttrsMap);
    }

    public static List<ISysColumn> getTableShardColumns(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToTableShardColumnsMap);
    }

    public static List<IBusiObjAttr> getTableShardAttrs(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToTableShardAttrsMap);
    }

    public static IBusiObjAttr getSlaAttrIdAttr(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToAttrIdAttrMap);
    }

    public static ISysColumn getSlaAttrIdColumn(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToAttrIdColumnMap);
    }

    public static IBusiObjAttr getSlaAttrValueAttr(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToAttrValueAttrMap);
    }

    public static ISysColumn getSlaAttrValueColumn(IBusiObj busiObj, ISysTable tables) {
        return getObjectFromMapWithInit(busiObj, tables, objIdAndTableIdToAttrValueColumnMap);
    }

    public static List<IBusiObjAttr> getTableBaseAttrsByBusiObj(IBusiObj busiObj, ISysTable table) {
        Long busiObjId = busiObj.getId();
        Long tableId = table.getId();
        String key = MetaProvider.getKey(busiObjId, tableId);
        if (!objIdAndTableIdToBaseAttrsMap.containsKey(key)) {
            getTableAttrsByBusiObj(busiObj, table);
        }
        return objIdAndTableIdToBaseAttrsMap.get(key);
    }

    public static List<IBusiObjAttr> getTableDanyAttrsByBusiObj(IBusiObj busiObj, ISysTable table) {
        Long busiObjId = busiObj.getId();
        Long tableId = table.getId();
        String key = MetaProvider.getKey(busiObjId, tableId);
        if (!objIdAndTableIdToDanyAttrsMap.containsKey(key)) {
            getTableAttrsByBusiObj(busiObj, table);
        }
        return objIdAndTableIdToDanyAttrsMap.get(key);
    }

    /**
     * 根据表分组表属性
     * @param busiObj
     * @return
     */
    public static Map<String, List<IBusiObjAttr>> getTableAttrsByBusiObjGroupByTableName(
        IBusiObj busiObj) {
        Long busiObjId = busiObj.getId();
        if (!objIdToGroupTableAttrsMap.containsKey(busiObjId)) {
            Map<String, ITableMetaData> tableMetaDataMap = MetaProvider
                .getEntityMetaDataByBusiObj(busiObj);
            Map<String, List<IBusiObjAttr>> tableAttrsMap = new HashMap<String, List<IBusiObjAttr>>();

            Map<String, List<Long>> tableAttrIdsMap = new HashMap<String, List<Long>>();
            Map<String, List<String>> tableAttrNbrsMap = new HashMap<String, List<String>>();

            if (tableMetaDataMap != null && tableMetaDataMap.size() > 0) {
                for (Map.Entry<String, ITableMetaData> entry : tableMetaDataMap.entrySet()) {
                    tableAttrsMap.put(entry.getKey(), entry.getValue().getTableAttr());
                    List<Long> attrIds = new ArrayList<Long>();
                    List<String> attrNbrs = new ArrayList<String>();
                    for (IBusiObjAttr attr : entry.getValue().getTableAttr()) {
                        attrIds.add(attr.getId());
                        attrNbrs.add(attr.readAttrNbr());
                    }
                    tableAttrIdsMap.put(entry.getKey(), attrIds);
                    tableAttrNbrsMap.put(entry.getKey(), attrNbrs);
                }
            }
            objIdToGroupTableAttrsMap.putIfAbsent(busiObjId, tableAttrsMap);
            objIdToGroupTableAttrIdsMap.putIfAbsent(busiObjId, tableAttrIdsMap);
            objIdToGroupTableAttrNbrsMap.putIfAbsent(busiObjId, tableAttrNbrsMap);

        }
        return objIdToGroupTableAttrsMap.get(busiObjId);
    }

    public static List<IBusiObjAttr> getTableAttrsByBusiObjAndTableName(IBusiObj busiObj,
        String tableName) {
        Map<String, List<IBusiObjAttr>> tableAttrsMap = getTableAttrsByBusiObjGroupByTableName(
            busiObj);
        if (tableAttrsMap.containsKey(tableName)) {
            return tableAttrsMap.get(tableName);
        }
        return new ArrayList<IBusiObjAttr>();
    }

    public static List<Long> getTableAttrIdsByBusiObjAndTableName(IBusiObj busiObj,
        String tableName) {
        if (!objIdToGroupTableAttrIdsMap.containsKey(busiObj.getId())) {
            getTableAttrsByBusiObjGroupByTableName(busiObj);
        }
        return objIdToGroupTableAttrIdsMap.get(busiObj.getId()).get(tableName);
    }

    public static List<String> getTableAttrNbrsByBusiObjAndTableName(IBusiObj busiObj,
        String tableName) {
        if (!objIdToGroupTableAttrNbrsMap.containsKey(busiObj.getId())) {
            getTableAttrsByBusiObjGroupByTableName(busiObj);
        }
        return objIdToGroupTableAttrNbrsMap.get(busiObj.getId()).get(tableName);
    }
}

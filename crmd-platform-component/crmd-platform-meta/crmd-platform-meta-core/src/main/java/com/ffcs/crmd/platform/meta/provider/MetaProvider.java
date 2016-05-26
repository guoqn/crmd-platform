package com.ffcs.crmd.platform.meta.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.intf.ISysColumn;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttrValue;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.meta.exception.MetaException;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttr;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttrValue;
import com.ffcs.crmd.platform.meta.entity.BusiType;
import com.ffcs.crmd.platform.meta.entity.SysColumn;
import com.ffcs.crmd.platform.meta.entity.SysTable;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

public class MetaProvider {

    //日志记录器
    private static final ILogger                                          LOG                  = LoggerFactory
        .getLogger(MetaProvider.class);
    //key值分隔符
    private static final String                                           CACHE_SPLIT          = "_#_";
    //BusiObj对应的Entity元数据Map
    private static       ConcurrentMap<Long, Map<String, ITableMetaData>> objIdToEntityInfoMap = new ConcurrentHashMap<Long, Map<String, ITableMetaData>>();

    /**
     * 生成Key值
     * @param params
     * @return
     */
    public static String getKey(Object... params) {
        if (params.length == 0) {
            return "";
        } else if (params.length == 1) {
            return StringUtils.strnull(params[0]);
        } else {
            int i = 0;
            StringBuilder builder = new StringBuilder();
            for (Object str : params) {
                if (i != 0) {
                    builder.append(CACHE_SPLIT);
                }
                builder.append(StringUtils.strnull(str));
                i++;
            }
            return builder.toString();
        }
    }

    public static Map<String, ITableMetaData> getEntityMetaData(IMetaEntity entity) {
        IBusiObj busiObj = BusiObjProvider.getBusiObj(entity);
        Map<String, ITableMetaData> map = getEntityMetaDataByBusiObj(busiObj);
        return map;
    }

    public static Map<String, ITableMetaData> getEntityMetaDataByBusiObj(IBusiObj busiObj) {
        Map<String, ITableMetaData> map = new HashMap<String, ITableMetaData>();
        if (busiObj == null) {
            return map;
        }
        Long busiObjId = busiObj.getId();
        if (!objIdToEntityInfoMap.containsKey(busiObjId)) {
            List<ISysTable> tables = TableMetaProvier.getSysTables(busiObj);
            if (tables == null || tables.size() <= 0) {
                objIdToEntityInfoMap.putIfAbsent(busiObjId, map);
                return map;
            }

            for (ISysTable table : tables) {
                ITableMetaData info = new TableMetaData();

                info.setTable(table);
                info.setColumns(TableMetaProvier.getTableColumnsByBusiObj(busiObj, table));
                info.setTableAttr(TableMetaProvier.getTableAttrsByBusiObj(busiObj, table));
                info.setTableBaseAttr(TableMetaProvier.getTableBaseAttrsByBusiObj(busiObj, table));
                info.setTableDanyAttr(TableMetaProvier.getTableDanyAttrsByBusiObj(busiObj, table));
                info.setPkAttr(TableMetaProvier.getPkAttr(busiObj, table));

                info.setPkColumn(TableMetaProvier.getPkColumn(busiObj, table));
                info.setMasterAttr(TableMetaProvier.getMasterAttr(busiObj, table));
                info.setMasterColumn(TableMetaProvier.getMasterColumn(busiObj, table));
                info.setSlaAttrIdAttr(TableMetaProvier.getSlaAttrIdAttr(busiObj, table));
                info.setSlaAttrIdColumn(TableMetaProvier.getSlaAttrIdColumn(busiObj, table));
                info.setSlaAttrValueAttr(TableMetaProvier.getSlaAttrValueAttr(busiObj, table));
                info.setSlaAttrValueColumn(TableMetaProvier.getSlaAttrValueColumn(busiObj, table));
                info.setColumnNameToAttrNbrMap(
                    TableMetaProvier.getColumnNameToAttrNbrMap(busiObj, table));
                info.setAttrNbrToColumnNameMap(
                    TableMetaProvier.getAttrNbrToColumnNameMap(busiObj, table));
                info.setInnerShardAttrs(TableMetaProvier.getInnerShardAttrs(busiObj, table));
                info.setInnerShardColumns(TableMetaProvier.getInnerShardColumns(busiObj, table));
                info.setTableShardAttrs(TableMetaProvier.getTableShardAttrs(busiObj, table));
                info.setTableShardColumns(TableMetaProvier.getTableShardColumns(busiObj, table));
                //是否纵表标识
                info.setDanyTable(table.isDanyTable());
                //是否记录变更历史
                info.setLogToHisOnUpdate(MetaConstants.BUSI_TYPE_UPDATE_LOG_LEVEL.LOGGING
                    .equals(busiObj.readChangeLogLevel()));
                //是否记录删除历史
                info.setLogToHisOnDelete(MetaConstants.BUSI_TYPE_DELETE_LOG_LEVEL.LOGGING
                    .equals(busiObj.readDeleteLogLevel()));
                if (info.isDanyTable()) {
                    info.setMasterColumn(TableMetaProvier.getMasterColumn(busiObj, table));
                }

                info.build();
                map.put(table.getTabName(), info);
            }
            objIdToEntityInfoMap.putIfAbsent(busiObjId, map);
        }
        return objIdToEntityInfoMap.get(busiObjId);
    }

    public static ITableMetaData getTableMetaDataByEntityNameAndTableName(IMetaEntity entity,
        String tableName) {
        IBusiObj busiObj = BusiObjProvider.getBusiObj(entity);
        if (busiObj == null) {
            ExceptionUtils.throwEx(new MetaException("could Not get the BusiObj"));
        }
        Map<String, ITableMetaData> map = getEntityMetaDataByBusiObj(busiObj);
        return map.get(tableName);
    }

    public static ITableMetaData getTableMetaDataByBusiObjIdAndTableName(Long busiObjId,
        String tableName) {
        IBusiObj busiObj = BusiObj.repository().getById(busiObjId);
        Map<String, ITableMetaData> map = getEntityMetaDataByBusiObj(busiObj);
        return map.get(tableName);
    }

}

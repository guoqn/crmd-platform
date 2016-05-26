package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.App;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.meta.intf.IAttrSpec2;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by linzq on 2016/1/26.
 */
public class MetaServiceFactory {
    private static IMetaService EMPTY_SERVICE = new IMetaService() {
        @Override
        public ITableMetaData getTableMetaDataByBusiObjIdAndTableName(Long busiObjId,
            String tableName) {
            return null;
        }

        @Override
        public IBusiObj getBusiObj(IMetaEntity entity) {
            return null;
        }

        @Override
        public IBusiType getBusiTypeByEntityName(String entityName) {
            return null;
        }

        @Override
        public List<IBusiObjAttr> getAllBusiObjAttrs(IMetaEntity entity) {
            return new ArrayList<IBusiObjAttr>();
        }

        @Override
        public String getAttrValueNameByValue(IBusiObj busiObj, String attrNbr, Object val) {
            return StringUtils.strnull(val);
        }

        @Override
        public List<ISysTable> getSysTables(IBusiObj busiObj) {
            return new ArrayList<ISysTable>();
        }

        @Override
        public ISysTable getDanyTable(List<ISysTable> sysTables, ISysTable masterTable) {
            return null;
        }

        @Override
        public ITableMetaData getTableMetaDataByEntityNameAndTableName(IMetaEntity entity,
            String tableName) {
            return null;
        }

        @Override
        public ISysTable getDanyTableByBusiObj(IBusiObj busiObj, ISysTable masterTable) {
            return null;
        }

        @Override
        public String getAttrValueNameByValue(String busiObjNbr, String attrNbr, Object val) {
            return StringUtils.strnull(val);
        }

        @Override
        public IAttrSpec2 getAttrSpec(Long attrId) {
            return null;
        }
    };
    private static IMetaService metaService = null;

    private static AtomicBoolean initService = new AtomicBoolean(false);


    public static IMetaService getMetaService() {
        if (metaService == null && !initService.get()) {
            try {
                metaService = ApplicationContextUtil.getBean("metaService");
            } catch (Exception e) {
                //ignore Exception
                metaService = EMPTY_SERVICE;
            }
            initService.compareAndSet(false,true);
        }
        if (metaService != null) {
            return metaService;
        }
        return EMPTY_SERVICE;
    }
}

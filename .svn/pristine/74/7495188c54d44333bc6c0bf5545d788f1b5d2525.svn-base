package com.ffcs.crmd.platform.meta.provider;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.entity.BusiType;
import com.ffcs.crmd.platform.meta.intf.IBusiType;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/2/25.
 */
public class BusiTypeProvider {

    //日志记录器
    private static final ILogger                          LOG                     = LoggerFactory.getLogger(BusiTypeProvider.class);
    //EntityName和BusiType，BusiTypeId的对应关系
    //begin
    private static       ConcurrentMap<String, IBusiType> entityNameBusiTypeMap   = new ConcurrentHashMap<String, IBusiType>();
    private static       ConcurrentMap<String, Long>      entityNameBusiTypeIdMap = new ConcurrentHashMap<String, Long>();
    //end

    /**
     *
     * 方法功能:
     * 根据JavaEntity名称获取业务大类。 .
     * @param entityName
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public static IBusiType getBusiTypeByEntityName(String entityName) {
        if (StringUtils.isNullOrEmpty(entityName)) {
            return null;
        }

        IBusiType entity = entityNameBusiTypeMap.get(entityName);

        if (entityNameBusiTypeMap.containsKey(entityName)) {
            LOG.debug("BusiType:" + entityName + " not exists");
            return entity;
        }

        if (BusiType.repository() == null) {
            LOG.error("BusiTypeRepository could not getInstants");
            return null;
        }

        List<BusiType> res = BusiType.repository().qryTypeByNbr(entityName);

        if (res == null || res.size() <= 0) {
            //            entityNameBusiTypeMap.putIfAbsent(entityName, null);
            //            entityNameBusiTypeIdMap.putIfAbsent(entityName, null);
            LOG.info("实体元数据未配置:" + entityName);
            return null;
        } else if (res.size() > 1) {
            LOG.warn("entityName:" + entityName + " has too many Config");
        }

        entity = res.get(0);

        entityNameBusiTypeMap.putIfAbsent(entityName, entity);
        entityNameBusiTypeIdMap.putIfAbsent(entityName, entity.getId());

        return entityNameBusiTypeMap.get(entityName);
    }

    /**
     * 根据类名获取BusiType
     * @param className
     * @return
     */
    public static IBusiType getBusiTypeByClassName(String className) {
        String entityName = StringUtils.substringAfterLast(className, ".");
        IBusiType busiType = getBusiTypeByEntityName(entityName);
        return busiType;
    }
}

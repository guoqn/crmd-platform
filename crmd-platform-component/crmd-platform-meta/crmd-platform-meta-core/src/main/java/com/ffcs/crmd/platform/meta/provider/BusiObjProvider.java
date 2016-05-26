package com.ffcs.crmd.platform.meta.provider;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/2/25.
 */
public class BusiObjProvider {
    //日志记录器
    private static final ILogger                               LOG                 = LoggerFactory
        .getLogger(BusiObjProvider.class);
    //busiTypeId对应的BusiObj列表
    private static       ConcurrentMap<Long, List<IBusiObj>>   typeIdToObjsMap     = new ConcurrentHashMap<Long, List<IBusiObj>>();
    //EntityName对应的BusiObj列表
    private static       ConcurrentMap<String, List<IBusiObj>> entityNameToObjMap  = new ConcurrentHashMap<String, List<IBusiObj>>();
    //busiObjNbr对应的BusiObj列表
    private static       ConcurrentMap<String, List<IBusiObj>> busiObjNbrToObjsMap = new ConcurrentHashMap<String, List<IBusiObj>>();

    /**
     *
     * 方法功能:
     *  根据类名获取对应的所有的BusiObj清单.
     * @param
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public static List<IBusiObj> getAllBusiObjByClassName(String className) {
        String entityName = StringUtils.substringAfterLast(className, ".");
        return getAllBusiObjByEntityName(entityName);
    }

    /**
     *
     * 方法功能:
     *  根据JavaEntity名称获取所有的BusiObj清单
     * @param entityName
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public static List<IBusiObj> getAllBusiObjByEntityName(String entityName) {
        if (entityNameToObjMap.containsKey(entityName)) {
            return entityNameToObjMap.get(entityName);
        }
        IBusiType type = BusiTypeProvider.getBusiTypeByEntityName(entityName);
        if (type == null) {
            LOG.debug(entityName + " BusiType not exists");
            entityNameToObjMap.putIfAbsent(entityName, new ArrayList<IBusiObj>());
            return entityNameToObjMap.get(entityName);
        }
        return getAllBusiObjByBusiTypeId(type.getId());
    }

    /**
     * 根据BusiTypeId获取所有的BusiObj列表
     * @param typeId
     * @return
     */
    public static List<IBusiObj> getAllBusiObjByBusiTypeId(Long typeId) {
        List<IBusiObj> objList = typeIdToObjsMap.get(typeId);
        if ((objList == null && typeIdToObjsMap.containsKey(typeId)) || (objList != null
            && objList.size() <= 0)) {
            LOG.debug("BusiObj not exists,BusiTypeId:" + typeId);
            if (objList == null) {
                objList = new ArrayList<IBusiObj>();
                typeIdToObjsMap.putIfAbsent(typeId, objList);
            }
        } else {
            List<BusiObj> res = BusiObj.repository().queryBusiObjByTypeId(typeId);
            List<IBusiObj> busiObjs = new ArrayList<IBusiObj>(res);
            typeIdToObjsMap.putIfAbsent(typeId, busiObjs);
        }
        return typeIdToObjsMap.get(typeId);
    }

    /**
     *
     * 方法功能:
     *  根据对象，获取实例对应的BusiObj
     * @param entity
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public static IBusiObj getBusiObj(IMetaEntity entity) {
        String entityName = entity.getEntityName();
        List<IBusiObj> allObjs = getAllBusiObjByEntityName(entityName);
        //目前默认只返回第一个。
        if (allObjs != null && allObjs.size() > 0) {
//            return allObjs.get(0);
            if (allObjs.size() == 1) {
                return allObjs.get(0);
            } else {
                String className = entity.getClass().getName();
                String code = StringUtils.substringAfterLast(className,".");
                for (IBusiObj obj : allObjs) {
                    if (code.equals(obj.getBusiObjNbr())) {
                        return obj;
                    }
                }
            }
        }
        return null;
    }

    public static IBusiObj getBusiObjByBusiObjNbr(String busiObjNbr) {
        List<IBusiObj> objList = busiObjNbrToObjsMap.get(busiObjNbr);
        if ((objList == null && busiObjNbrToObjsMap.containsKey(busiObjNbr)) || (objList != null
            && objList.size() <= 0)) {
            LOG.debug("BusiObj not exists,BusiObjNbr:" + busiObjNbr);
            if (objList == null) {
                objList = new ArrayList<IBusiObj>();
                busiObjNbrToObjsMap.putIfAbsent(busiObjNbr, objList);
            }
        } else {
            List<BusiObj> res = BusiObj.repository().queryBusiObjByBusiObjNbrAndStatusCd(busiObjNbr);
            List<IBusiObj> busiObjs = new ArrayList<IBusiObj>(res);
            busiObjNbrToObjsMap.putIfAbsent(busiObjNbr, busiObjs);
        }
        objList = busiObjNbrToObjsMap.get(busiObjNbr);
        if (objList.size() > 0) {
            return objList.get(0);
        } else {
            return null;
        }
    }

}

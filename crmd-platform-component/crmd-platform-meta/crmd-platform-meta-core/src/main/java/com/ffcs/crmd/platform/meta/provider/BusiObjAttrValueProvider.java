package com.ffcs.crmd.platform.meta.provider;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttrValue;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttrValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/2/25.
 */
public class BusiObjAttrValueProvider {
    //日志记录器
    private static final ILogger                                        LOG                        = LoggerFactory
        .getLogger(BusiObjAttrValueProvider.class);
    //BusiObj下的BusiObjAttr的Id对应的BusiObjAttrValue
    private static       ConcurrentMap<String, List<IBusiObjAttrValue>> objIdAndAttrIdToValuesMap  = new ConcurrentHashMap<String, List<IBusiObjAttrValue>>();
    //BusiObj下的BusiObjAttr的Nbr对应的BusiObjAttrValue
    private static       ConcurrentMap<String, List<IBusiObjAttrValue>> objIdAndAttrNbrToValuesMap = new ConcurrentHashMap<String, List<IBusiObjAttrValue>>();

    /**
     * 获取属性关联的属性值列表
     * @param busiObj
     * @param propertyName
     * @return
     */
    public static List<IBusiObjAttrValue> getBusiObjAttrValues(IBusiObj busiObj, String propertyName) {
        Long objId = busiObj.getId();
        String key = MetaProvider.getKey(objId, propertyName);
        if (objIdAndAttrNbrToValuesMap.containsKey(key)) {
            return objIdAndAttrNbrToValuesMap.get(key);
        }
        List<IBusiObjAttr> attrSpecs = BusiObjAttrProvider.getAllBusiObjAttrsByBusiObj(busiObj);
        if (attrSpecs == null || attrSpecs.size() <= 0) {
            LOG.warn("no AttrSpec define for busiObj:" + busiObj.getId());
            List<IBusiObjAttrValue> list = new ArrayList<IBusiObjAttrValue>();
            objIdAndAttrNbrToValuesMap.putIfAbsent(key, list);
            return objIdAndAttrNbrToValuesMap.get(key);
        }
        IBusiObjAttr attr = null;
        for (IBusiObjAttr busiObjAttr : attrSpecs) {
            if (propertyName.equals(busiObjAttr.readAttrNbr())) {
                attr = busiObjAttr;
                break;
            }
        }
        if (attr == null) {
            LOG.warn(propertyName + "not AttrSpec");
            List<IBusiObjAttrValue> list = new ArrayList<IBusiObjAttrValue>();
            objIdAndAttrNbrToValuesMap.putIfAbsent(key, list);
            return objIdAndAttrNbrToValuesMap.get(key);
        }

        List<IBusiObjAttrValue> values = getBusiObjAttrValues(busiObj,attr.getId());
        objIdAndAttrNbrToValuesMap.putIfAbsent(key, values);
        return objIdAndAttrNbrToValuesMap.get(key);

    }

    public static String getAttrValueNameByValue(IBusiObj busiObj, String attrNbr, Object val) {
        String valueName = "";
        IBusiObjAttrValue value = getBusiObjAttrValueByValue(busiObj, attrNbr, val);
        if (value == null) {
            return StringUtils.strnull(val);
        } else {
            return value.readAttrValueName();
        }
    }

    public static IBusiObjAttrValue getBusiObjAttrValueByValue(IBusiObj busiObj, String attrNbr,
        Object val) {
        String valueName = "";
        if (StringUtils.isNullOrEmpty(val)) {
            return null;
        }
        List<IBusiObjAttrValue> values = getBusiObjAttrValues(busiObj, attrNbr);
        if (values == null || values.size() <= 0) {
            return null;
        }
        for (IBusiObjAttrValue value : values) {
            if (StringUtils.strnull(val).equals(value.readAttrValue())) {
                return value;
            }
        }
        return null;
    }

    /**
     * 根据属性ID获取关联的属性值列表
     * @param busiObj
     * @param attrId
     * @return
     */
    public static List<IBusiObjAttrValue> getBusiObjAttrValues(IBusiObj busiObj, Long attrId) {
        Long objId = busiObj.getId();
        String key = MetaProvider.getKey(objId, attrId);
        if (objIdAndAttrIdToValuesMap.containsKey(key)) {
            return objIdAndAttrIdToValuesMap.get(key);
        }
        List<IBusiObjAttr> attrSpecs = BusiObjAttrProvider.getAllBusiObjAttrsByBusiObj(busiObj);
        if (attrSpecs == null || attrSpecs.size() <= 0) {
            LOG.warn("no AttrSpec define for busiObj:" + busiObj.getId());
            List<IBusiObjAttrValue> list = new ArrayList<IBusiObjAttrValue>();
            objIdAndAttrIdToValuesMap.putIfAbsent(key, list);
            return objIdAndAttrIdToValuesMap.get(key);
        }
        IBusiObjAttr attr = null;
        for (IBusiObjAttr busiObjAttr : attrSpecs) {
            if (attrId.equals(busiObjAttr.getId())) {
                attr = busiObjAttr;
                break;
            }
        }
        if (attr == null) {
            LOG.warn(attrId + " not AttrSpec");
            List<IBusiObjAttrValue> list = new ArrayList<IBusiObjAttrValue>();
            objIdAndAttrIdToValuesMap.putIfAbsent(key, list);
            return objIdAndAttrIdToValuesMap.get(key);
        }
        List<BusiObjAttrValue> attrValues = BusiObjAttrValue.repository()
            .qryBusiObjAttrValuesByBusiObjAttrId(attr.getId());
        List<IBusiObjAttrValue> values = new ArrayList<IBusiObjAttrValue>(attrValues);
        objIdAndAttrIdToValuesMap.putIfAbsent(key, values);
        return objIdAndAttrIdToValuesMap.get(key);
    }

    public static List<IBusiObjAttrValue> getBusiObjAttrValues(String busiObjNbr,String attrNbr) {
        IBusiObj busiObj = BusiObjProvider.getBusiObjByBusiObjNbr(busiObjNbr);
        if (busiObj == null) {
            LOG.warn("busiObj not exists.Nbr:" + busiObjNbr);
            return new ArrayList<IBusiObjAttrValue>();
        }
        return getBusiObjAttrValues(busiObj,attrNbr);
    }

    public static String getAttrValueNameByValue(String busiObjNbr, String attrNbr, Object val) {
        String valueName = "";
        IBusiObj busiObj = BusiObjProvider.getBusiObjByBusiObjNbr(busiObjNbr);
        if (busiObj == null) {
            LOG.warn("busiObj not exists.Nbr:" + busiObjNbr);
            return StringUtils.strnull(val);
        }
        IBusiObjAttrValue value = getBusiObjAttrValueByValue(busiObj, attrNbr, val);
        if (value == null) {
            return StringUtils.strnull(val);
        } else {
            return value.readAttrValueName();
        }
    }
}

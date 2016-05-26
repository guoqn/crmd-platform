package com.ffcs.crmd.platform.meta.provider;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/2/25.
 */
public class BusiObjAttrProvider {

    //日志记录器
    private static final ILogger LOG = LoggerFactory.getLogger(BusiObjAttrProvider.class);

    //BisuObjAttr中BusiObj关联的所有属性，包括父级对象属性集合。
    //begin
    private static ConcurrentMap<Long, List<IBusiObjAttr>> objIdToAllBusiObjAttrsMap       = new ConcurrentHashMap<Long, List<IBusiObjAttr>>();
    private static ConcurrentMap<Long, List<Long>>         objIdToAllBusiObjAttrIdsMap     = new ConcurrentHashMap<Long, List<Long>>();
    private static ConcurrentMap<Long, List<String>>       objIdToAllAttrNbrsMap           = new ConcurrentHashMap<Long, List<String>>();
    //end
    //BisuObjAttr中BusiObj关联的所有横表属性，包括父级对象属性集合。
    //begin
    private static ConcurrentMap<Long, List<IBusiObjAttr>> objIdToAllBaseBusiObjAttrsMap   = new ConcurrentHashMap<Long, List<IBusiObjAttr>>();
    private static ConcurrentMap<Long, List<Long>>         objIdToAllBaseBusiObjAttrIdsMap = new ConcurrentHashMap<Long, List<Long>>();
    private static ConcurrentMap<Long, List<String>>       objIdToAllBaseAttrNbrsMap       = new ConcurrentHashMap<Long, List<String>>();
    //end
    //BisuObjAttr中BusiObj关联的所有纵表属性，包括父级对象属性集合。
    //begin
    private static ConcurrentMap<Long, List<IBusiObjAttr>> objIdToAllDanyBusiObjAttrsMap   = new ConcurrentHashMap<Long, List<IBusiObjAttr>>();
    private static ConcurrentMap<Long, List<Long>>         objIdToAllDanyBusiObjAttrIdsMap = new ConcurrentHashMap<Long, List<Long>>();
    private static ConcurrentMap<Long, List<String>>       objIdToAllDanyAttrNbrsMap       = new ConcurrentHashMap<Long, List<String>>();
    //end
    //BusiObj直接关联的busiObjAttr
    private static ConcurrentMap<Long, List<IBusiObjAttr>> objIdToSelfBusiObjAttrsMap      = new ConcurrentHashMap<Long, List<IBusiObjAttr>>();

    /**
     * 根据实例获取所有的属性列表
     * @param entity
     * @return
     */
    public static List<IBusiObjAttr> getAllBusiObjAttrs(IMetaEntity entity) {
        IBusiObj busiObj = BusiObjProvider.getBusiObj(entity);
        if (busiObj == null) {
            LOG.warn("do not config busiObj");
            return new ArrayList<IBusiObjAttr>();
        }
        return getAllBusiObjAttrsByBusiObj(busiObj);
    }

    /**
     * 获取业务对象关联的属性列表，包括父类
     *
     * @param busiObj
     * @return
     */
    public static List<IBusiObjAttr> getAllBusiObjAttrsByBusiObj(IBusiObj busiObj) {
        Long busiObjId = busiObj.getId();
        //用于去重，如果当前busiObj有，则不从父类继承
        Map<String, String> repeatMap = new HashMap<String, String>();
        if (!objIdToAllBusiObjAttrsMap.containsKey(busiObjId)) {
            List<IBusiObjAttr> busiObjAttrs = getSelfBusiObjAttrsByBusiObjId(busiObjId);

            for (IBusiObjAttr attr : busiObjAttrs) {
                String attrNbr = attr.readAttrNbr();
                if (!repeatMap.containsKey(attrNbr)) {
                    repeatMap.put(attrNbr, attrNbr);
                } else {
                    LOG.warn("have repeat attr,attrNbr:" + attrNbr + ",attrId:" + attr.getId());
                }
            }

            while (busiObj != null && busiObj.getParBusiObjId() != null) {
                Long parBusiObjId = busiObj.getParBusiObjId();
                if (parBusiObjId == null) {
                    break;
                }
                List<IBusiObjAttr> tempAttrs = getSelfBusiObjAttrsByBusiObjId(parBusiObjId);
                for (IBusiObjAttr attr : tempAttrs) {
                    String attrNbr = attr.readAttrNbr();
                    //如果属性已经存在，则不从父类继承。
                    if (!repeatMap.containsKey(attrNbr)) {
                        repeatMap.put(attrNbr, attrNbr);
                        busiObjAttrs.add(attr);
                    } else {
                        LOG.warn("have repeat attr,attrNbr:" + attrNbr + ",attrId:" + attr.getId());
                    }
                }
                //                busiObjAttrs.addAll(tempAttrs);
                busiObj = BusiObj.repository().getById(parBusiObjId);
            }

            objIdToAllBusiObjAttrsMap.putIfAbsent(busiObjId, busiObjAttrs);

            List<Long> attrSpecIds = new ArrayList<Long>();
            List<String> attrSpecNbrs = new ArrayList<String>();

            List<IBusiObjAttr> allBaseAttrSpecs = new ArrayList<IBusiObjAttr>();
            List<IBusiObjAttr> allDanyAttrSpecs = new ArrayList<IBusiObjAttr>();
            List<Long> allBaseAttrSpecIds = new ArrayList<Long>();
            List<String> allBaseAttrSpecNbrs = new ArrayList<String>();
            List<Long> allDanyAttrSpecIds = new ArrayList<Long>();
            List<String> allDanyAttrSpecNbrs = new ArrayList<String>();

            for (IBusiObjAttr attr : busiObjAttrs) {
                attrSpecIds.add(attr.getId());
                attrSpecNbrs.add(attr.readAttrNbr());

                if (!attr.checkIsDanyAttr()) {
                    allBaseAttrSpecs.add(attr);
                    allBaseAttrSpecIds.add(attr.getId());
                    allBaseAttrSpecNbrs.add(attr.readAttrNbr());
                } else {
                    allDanyAttrSpecs.add(attr);
                    allDanyAttrSpecIds.add(attr.getId());
                    allDanyAttrSpecNbrs.add(attr.readAttrNbr());
                }
            }
            objIdToAllBusiObjAttrIdsMap.putIfAbsent(busiObjId, attrSpecIds);
            objIdToAllAttrNbrsMap.putIfAbsent(busiObjId, attrSpecNbrs);

            objIdToAllBaseBusiObjAttrsMap.putIfAbsent(busiObjId, allBaseAttrSpecs);
            objIdToAllBaseBusiObjAttrIdsMap.putIfAbsent(busiObjId, allBaseAttrSpecIds);
            objIdToAllBaseAttrNbrsMap.putIfAbsent(busiObjId, allBaseAttrSpecNbrs);

            objIdToAllDanyBusiObjAttrsMap.putIfAbsent(busiObjId, allDanyAttrSpecs);
            objIdToAllDanyBusiObjAttrIdsMap.putIfAbsent(busiObjId, allDanyAttrSpecIds);
            objIdToAllDanyAttrNbrsMap.putIfAbsent(busiObjId, allDanyAttrSpecNbrs);
        }
        return objIdToAllBusiObjAttrsMap.get(busiObjId);
    }

    /**
     * 根据Id获取属性列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<IBusiObjAttr> getAllBusiObjAttrsByBusiObjId(Long busiObjId) {
        BusiObj busiObj = BusiObj.repository().getById(busiObjId);
        return getAllBusiObjAttrsByBusiObj(busiObj);
    }

    /**
     * 根据Id获取静态属性列表,包括父类。
     * @param busiObjId
     * @return
     */
    public static List<IBusiObjAttr> getAllBaseBusiObjAttrsByBusiObjId(Long busiObjId) {
        if (!objIdToAllBaseBusiObjAttrsMap.containsKey(busiObjId)) {
            getAllBusiObjAttrsByBusiObjId(busiObjId);
        }
        return objIdToAllBaseBusiObjAttrsMap.get(busiObjId);
    }

    /**
     * 根据BusiObj获取所有静态属性列表，包括父类。
     * @param busiObj
     * @return
     */
    public static List<IBusiObjAttr> getAllBaseBusiObjAttrsByBusiObj(BusiObj busiObj) {
        if (!objIdToAllBaseBusiObjAttrsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllBaseBusiObjAttrsMap.get(busiObj.getId());
    }

    /**
     * 根据Id获取动态属性列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<IBusiObjAttr> getAllDanyBusiObjAttrsByBusiObjId(Long busiObjId) {
        if (!objIdToAllDanyBusiObjAttrsMap.containsKey(busiObjId)) {
            getAllBusiObjAttrsByBusiObjId(busiObjId);
        }
        return objIdToAllDanyBusiObjAttrsMap.get(busiObjId);
    }

    /**
     * 根据BusiObj获取所有动态属性列表，包括父类。
     * @param busiObj
     * @return
     */
    public static List<IBusiObjAttr> getAllDanyBusiObjAttrsByBusiObj(BusiObj busiObj) {
        if (!objIdToAllDanyBusiObjAttrsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllDanyBusiObjAttrsMap.get(busiObj.getId());
    }

    /**
     * 根据BusiObj获取属性Id列表,包括父类
     * @param busiObj
     * @return
     */
    public static List<Long> getAllBusiObjAttrIdsByBusiObj(IBusiObj busiObj) {
        if (!objIdToAllBusiObjAttrIdsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllBusiObjAttrIdsMap.get(busiObj.getId());
    }

    /**
     * 根据Id获取属性Id列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<Long> getAllBusiObjAttrIdsByBusiObjId(Long busiObjId) {
        if (!objIdToAllBusiObjAttrIdsMap.containsKey(busiObjId)) {
            getAllBusiObjAttrsByBusiObjId(busiObjId);
        }
        return objIdToAllBusiObjAttrIdsMap.get(busiObjId);
    }

    /**
     * 根据BusiObj获取静态属性Id列表,包括父类
     * @param busiObj
     * @return
     */
    public static List<Long> getAllBaseBusiObjAttrIdsByBusiObj(IBusiObj busiObj) {
        if (!objIdToAllBaseBusiObjAttrIdsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllBaseBusiObjAttrIdsMap.get(busiObj.getId());
    }

    /**
     * 根据BusiObjId获取静态属性Id列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<Long> getAllBaseBusiObjAttrIdsByBusiObjId(Long busiObjId) {
        if (!objIdToAllBaseBusiObjAttrIdsMap.containsKey(busiObjId)) {
            getAllBusiObjAttrsByBusiObjId(busiObjId);
        }
        return objIdToAllBaseBusiObjAttrIdsMap.get(busiObjId);
    }

    /**
     * 根据BusiObj获取动态属性Id列表,包括父类
     * @param busiObj
     * @return
     */
    public static List<Long> getAllDanyBusiObjAttrIdsByBusiObj(IBusiObj busiObj) {
        if (!objIdToAllDanyBusiObjAttrIdsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllDanyBusiObjAttrIdsMap.get(busiObj.getId());
    }

    /**
     * 根据BusiObjId获取动态属性Id列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<Long> getAllDanyBusiObjAttrIdsByBusiObjId(Long busiObjId) {
        if (!objIdToAllDanyBusiObjAttrIdsMap.containsKey(busiObjId)) {
            getAllBusiObjAttrsByBusiObjId(busiObjId);
        }
        return objIdToAllDanyBusiObjAttrIdsMap.get(busiObjId);
    }

    /**
     * 根据BusiObj获取属性Nbr列表,包括父类
     * @param busiObj
     * @return
     */
    public static List<String> getAllAttrNbrsByBusiObj(IBusiObj busiObj) {
        if (!objIdToAllAttrNbrsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllAttrNbrsMap.get(busiObj.getId());
    }

    /**
     * 根据BusiObjId获取属性Nbr列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<String> getAllAttrNbrsByBusiObjId(Long busiObjId) {
        getAllBusiObjAttrsByBusiObjId(busiObjId);
        return objIdToAllAttrNbrsMap.get(busiObjId);
    }

    /**
     * 根据BusiObj获取横表属性Nbr列表,包括父类
     * @param busiObj
     * @return
     */
    public static List<String> getAllBaseAttrNbrsByBusiObj(IBusiObj busiObj) {
        if (!objIdToAllAttrNbrsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllAttrNbrsMap.get(busiObj.getId());
    }

    /**
     * 根据BusiObjId获取横表属性Nbr列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<String> getAllBaseAttrNbrsByBusiObjId(Long busiObjId) {
        getAllBusiObjAttrsByBusiObjId(busiObjId);
        return objIdToAllAttrNbrsMap.get(busiObjId);
    }

    /**
     * 根据BUsiObj获取动态属性Nbr列表,包括父类
     * @param busiObj
     * @return
     */
    public static List<String> getAllDanyAttrNbrsByBusiObj(IBusiObj busiObj) {
        if (!objIdToAllAttrNbrsMap.containsKey(busiObj.getId())) {
            getAllBusiObjAttrsByBusiObj(busiObj);
        }
        return objIdToAllAttrNbrsMap.get(busiObj.getId());
    }

    /**
     * 根据Id获取属性列表,包括父类
     * @param busiObjId
     * @return
     */
    public static List<String> getAllDanyAttrNbrsByBusiObjId(Long busiObjId) {
        getAllBusiObjAttrsByBusiObjId(busiObjId);
        return objIdToAllAttrNbrsMap.get(busiObjId);
    }

    /**
     * 根据Id获取属性列表
     * @param busiObjId
     * @return
     */
    public static List<IBusiObjAttr> getSelfBusiObjAttrsByBusiObjId(Long busiObjId) {
        if (!objIdToSelfBusiObjAttrsMap.containsKey(busiObjId)) {
            List<BusiObjAttr> attrs = BusiObjAttr.repository().queryBusiObjAttrByObjId(busiObjId);
            List<IBusiObjAttr> busiObjAttrs = new ArrayList<IBusiObjAttr>(attrs);
            objIdToSelfBusiObjAttrsMap.putIfAbsent(busiObjId, busiObjAttrs);
        }
        return objIdToSelfBusiObjAttrsMap.get(busiObjId);
    }

    /**
     * 根据业务对象编码和属性编码获取业务对象属性
     * @param busiObjNbr
     * @param busiObjAttrNbr
     * @return
     */
    public static IBusiObjAttr getBusiObjAttrByObjNbrAndAttrNbr(String busiObjNbr,
        String busiObjAttrNbr) {
        IBusiObj busiObj = BusiObjProvider.getBusiObjByBusiObjNbr(busiObjNbr);
        if (busiObj == null) {
            LOG.warn("busiObj not exists.Nbr:" + busiObjNbr);
            return null;
        }
        List<IBusiObjAttr> attrs = getAllBusiObjAttrsByBusiObj(busiObj);
        if (attrs == null || attrs.size() <= 0) {
            LOG.warn("busiObj not exists attrs.Nbr:" + busiObjNbr);
            return null;
        }
        for (IBusiObjAttr attr : attrs) {
            if (StringUtils.strnull(busiObjAttrNbr).equals(attr.readAttrNbr())) {
                return attr;
            }
        }
        LOG.warn(
            "busiObjAttr not exists attrs.ObjNbr:" + busiObjNbr + ",AttrNbr:" + busiObjAttrNbr);

        return null;
    }

}

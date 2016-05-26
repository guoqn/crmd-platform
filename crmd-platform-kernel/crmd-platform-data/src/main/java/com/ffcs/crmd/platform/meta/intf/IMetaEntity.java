package com.ffcs.crmd.platform.meta.intf;

import com.ffcs.crmd.platform.data.entity.ICrmBaseEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IMetaEntity<ID extends Serializable> extends ICrmBaseEntity<ID> {
    /**
     *
     * 方法功能:
     *  获取业务对象.
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    IBusiObj readBusiObj();

    /**
     *
     * 方法功能:
     *  获取业务大类.
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    IBusiType readBusiType();

    /**
     * 获取表元数据信息
     * @return
     */
    ITableMetaData readTableMeta();

    /**
     * 获取所有的配置属性
     * @return
     */
    List<IBusiObjAttr> readAllBusiObjAttrs();

    /**
     * 获取所有的配置属性
     * @return
     */
    IBusiObjAttr readBusiObjAttrByCode(String code);

    /**
     * 获取所有的配置属性
     * @return
     */
    IBusiObjAttr readBusiObjAttrByBusiObjAttrId(Long attrId);

    /**
     * 获取所有的配置属性
     * @return
     */
    IBusiObjAttr readBusiObjAttrByAttrSpecId(Long attrId);

    /**
     *
     * 方法功能:
     *  读取属性.
     * @param attrNbr
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    Object readAttr(String attrNbr);

    /**
     *
     * 方法功能:
     *  读取属性.
     * @param attrId
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    Object readAttrByBusiObjAttrId(Long attrId);

    /**
     *
     * 方法功能:
     *  读取属性.
     * @param attrId
     * @return
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    Object readAttrByAttrSpecId(Long attrId);

    /**
     * 获取属性名称
     * @param attrId
     * @return
     */
    String readAttrNameByBusiObjAttrId(Long attrId);

    /**
     * 获取属性名称
     * @param attrNbr
     * @return
     */
    String readAttrName(String attrNbr);

    String readAttrNameByBusiObjAttr(IBusiObjAttr attr);

    String readAttrNameByAttrSpec(IAttrSpec2 attr);

    String readAttrNameByAttrSpecId(Long attrSpecId);

    /**
     *
     * 方法功能:
     *  写入属性,并进行校验.
     * @param attrNbr
     * @param value
     * @param check
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    RetVo writeAttr(String attrNbr, Object value, boolean check);

    /**
     *
     * 方法功能:
     *  写入属性.
     * @param attrNbr
     * @param value
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    RetVo writeAttr(String attrNbr, Object value);

    /**
     *
     * 方法功能:
     *  写入属性.
     * @param value
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    RetVo writeAttrByBusiObjAttrId(Long attrId, Object value);

    /**
     *
     * 方法功能:
     *  写入属性,并进行校验.
     * @param attrId
     * @param value
     * @param check
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    RetVo writeAttrByBusiObjAttrId(Long attrId, Object value, boolean check);

    /**
     *
     * 方法功能:
     *  写入属性.
     * @param value
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    RetVo writeAttrByAttrSpecId(Long attrId, Object value);

    /**
     *
     * 方法功能:
     *  写入属性,并进行校验.
     * @param attrId
     * @param value
     * @param check
     * @author: linzq
     * @修改记录：
     * ==============================================================<br>
     * 日期:2016年1月13日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    RetVo writeAttrByAttrSpecId(Long attrId, Object value, boolean check);

    /**
     * 获取Entity编码
     * @return
     */
    String getEntityName();

    /**
     * 主表标记
     * @return
     */
    String getTableName();

    /**
     * 获取Entity编码
     * @return
     */
    void setEntityName(String entityName);

    /**
     * 主表标记
     * @return
     */
    void setTableName(String tableName);

    /**
     * map转换为Entity
     * @param map
     */
    public void fillEntityFromMap(Map<String, Object> map);

    public ID getId();

    /**
     * 定义是否使用主数据.
     * @return
     */
    public boolean isUseMeta();

}

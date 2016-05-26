package com.ffcs.crmd.platform.meta.entity.impl;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.data.entity.impl.CrmBaseEntityImpl;
import com.ffcs.crmd.platform.meta.exception.MetaException;
import com.ffcs.crmd.platform.meta.intf.IAttrSpec2;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.service.MetaServiceFactory;
import com.ffcs.crmd.platform.meta.util.BeanPropUtils;
import com.ffcs.crmd.platform.meta.util.MetaConfig;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.apache.commons.beanutils.PropertyUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseMetaEntityImpl<ID extends Serializable>
    extends CrmBaseEntityImpl<ID> implements IMetaEntity<ID> {

    protected transient ILogger logger = LoggerFactory.getLogger(this.getClass());

    private String entityName = "";

    private String tableName = "";

    protected List<Long> attrIds = new ArrayList<Long>();

    protected Object[] data = new Object[0];

    private Long pkAttrId = null;

    public Long getPkAttrId() {
        return pkAttrId;
    }

    public void setPkAttrId(Long pkAttrId) {
        this.pkAttrId = pkAttrId;
    }

    @Override
    public ID getId() {

        try {
            ID id = (ID) (readAttrByBusiObjAttrId(pkAttrId));
            return id;
        } catch (Exception e) {
            logger.error("could not get the id");
            //return null
        }
        return null;
    }

    @Override
    public void setId(ID id) {
        writeAttrByBusiObjAttrId(pkAttrId, id);
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public List<Long> getAttrIds() {
        return attrIds;
    }

    public void setAttrIds(List<Long> attrIds) {
        this.attrIds = attrIds;
    }

    @Override
    public IBusiObj readBusiObj() {
        return MetaServiceFactory.getMetaService().getBusiObj(this);
    }

    @Override
    public IBusiType readBusiType() {
        return MetaServiceFactory.getMetaService().getBusiTypeByEntityName(getEntityName());

    }

    @Override
    public ITableMetaData readTableMeta() {
        IBusiObj busiObj = readBusiObj();
        if (busiObj == null) {
            ExceptionUtils.throwEx(new MetaException("no BusiObj operation"));
        }
        ITableMetaData tableMetaData = MetaServiceFactory.getMetaService()
            .getTableMetaDataByBusiObjIdAndTableName(busiObj.getId(), this.getTableName());
        if (tableMetaData == null) {
            ExceptionUtils.throwEx(new MetaException("no tableMetaData"));
        }
        return tableMetaData;
    }

    @Override
    public List<IBusiObjAttr> readAllBusiObjAttrs() {
        return MetaServiceFactory.getMetaService().getAllBusiObjAttrs(this);
    }

    @Override
    public IBusiObjAttr readBusiObjAttrByCode(String code) {
        List<IBusiObjAttr> attrs = readAllBusiObjAttrs();
        if (attrs != null && !attrs.isEmpty()) {
            for (IBusiObjAttr attr : attrs) {
                if (code.equals(attr.readAttrNbr())) {
                    return attr;
                }
            }
        }
        return null;
    }

    @Override
    public IBusiObjAttr readBusiObjAttrByBusiObjAttrId(Long attrId) {
        List<IBusiObjAttr> attrs = readAllBusiObjAttrs();
        if (attrs != null && !attrs.isEmpty()) {
            for (IBusiObjAttr attr : attrs) {
                if (attrId.equals(attr.getId())) {
                    return attr;
                }
            }
        }
        return null;
    }

    @Override
    public IBusiObjAttr readBusiObjAttrByAttrSpecId(Long attrId) {
        List<IBusiObjAttr> attrs = readAllBusiObjAttrs();
        if (attrs != null && !attrs.isEmpty()) {
            for (IBusiObjAttr attr : attrs) {
                if (attrId.equals(attr.getAttrId())) {
                    return attr;
                }
            }
        }
        return null;
    }

    @Override
    public Object readAttr(String attrNbr) {
        if (BeanPropUtils.isWriteable(this.getClass(), attrNbr)) {
            try {
                return PropertyUtils.getProperty(this, attrNbr);
            } catch (Exception e) {
                logger.error("read Attr error", e);
                ExceptionUtils.throwEx(e);
            }
        } else {
            IBusiObjAttr attr = readBusiObjAttrByCode(attrNbr);
            return readAttrByBusiObjAttr(attr);
        }
        return null;
    }

    protected Object readAttrByBusiObjAttr(IBusiObjAttr attr) {
        int index = attrIds.indexOf(attr.getId());
        return data[index];
    }

    protected Object readField(String attrNbr) {
        try {
            return PropertyUtils.getProperty(this, attrNbr);
        } catch (Exception e) {
            logger.error("read Fields error.", e);
            ExceptionUtils.throwEx(e);
        }
        return null;
    }

    @Override
    public Object readAttrByBusiObjAttrId(Long attrId) {
        IBusiObjAttr attr = readBusiObjAttrByBusiObjAttrId(attrId);
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException(attrId + " not config AttrSpec"));
        }
        if (BeanPropUtils.isReadable(this.getClass(), attr.readAttrNbr())) {
            return readField(attr.readAttrNbr());
        } else {
            return readAttrByBusiObjAttr(attr);
        }
    }

    @Override
    public Object readAttrByAttrSpecId(Long attrId) {
        IBusiObjAttr attr = readBusiObjAttrByAttrSpecId(attrId);
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException(attrId + " not config AttrSpec"));
        }
        if (BeanPropUtils.isReadable(this.getClass(), attr.readAttrNbr())) {
            return readField(attr.readAttrNbr());
        } else {
            return readAttrByBusiObjAttr(attr);
        }
    }

    @Override
    public String readAttrName(String attrNbr) {
        IBusiObjAttr attr = readBusiObjAttrByCode(attrNbr);
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException(attrNbr + "attr Not exists"));
        }
        return readAttrNameByBusiObjAttr(attr);
    }

    @Override
    public String readAttrNameByBusiObjAttrId(Long attrId) {
        IBusiObjAttr attr = readBusiObjAttrByBusiObjAttrId(attrId);
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException(attrId + "attr Not exists"));
        }
        return readAttrNameByBusiObjAttr(attr);
    }

    @Override
    public String readAttrNameByAttrSpec(IAttrSpec2 attr) {
        IBusiObjAttr busiObjAttr = readBusiObjAttrByAttrSpecId(attr.getId());
        if (busiObjAttr == null) {
            ExceptionUtils
                .throwEx(new MetaException(attr.getAttrNbr() + "attr Not exists BusiObjAttr"));
        }
        return readAttrNameByBusiObjAttr(busiObjAttr);
    }

    @Override
    public String readAttrNameByAttrSpecId(Long attrSpecId) {
        IBusiObjAttr busiObjAttr = readBusiObjAttrByAttrSpecId(attrSpecId);
        if (busiObjAttr == null) {
            ExceptionUtils
                .throwEx(new MetaException(attrSpecId + "attrSpec Not exists busiObjAttr"));
        }
        return readAttrNameByBusiObjAttr(busiObjAttr);
    }

    @Override
    public String readAttrNameByBusiObjAttr(IBusiObjAttr attr) {
        return MetaServiceFactory.getMetaService()
            .getAttrValueNameByValue(readBusiObj(), attr.readAttrNbr(),
                readAttrByBusiObjAttr(attr));
    }

    @Override
    public RetVo writeAttr(String attrNbr, Object value, boolean check) {
        if (BeanPropUtils.isWriteable(this.getClass(), attrNbr)) {
            return writeField(attrNbr, value);
        } else {
            IBusiObjAttr attr = readBusiObjAttrByCode(attrNbr);
            if (attr == null) {
                ExceptionUtils.throwEx(new MetaException(attrNbr + " not config BusiObjAttr"));
            }
            return writeAttrByBusiObjAttr(attr, value);
        }
    }

    @Override
    public RetVo writeAttr(String attrNbr, Object value) {
        return writeAttr(attrNbr, value, false);
    }

    @Override
    public RetVo writeAttrByBusiObjAttrId(Long attrId, Object value) {
        return writeAttrByBusiObjAttrId(attrId, value, false);
    }

    @Override
    public RetVo writeAttrByBusiObjAttrId(Long attrId, Object value, boolean check) {
        if (attrId == null) {
            logger.warn("attrIdSpec is null");
            RetVo vo = new RetVo(false);
            vo.addMsgDetail("attrIdSpec is null");
            return vo;
        }
        IBusiObjAttr attr = readBusiObjAttrByBusiObjAttrId(attrId);
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException(attrId + " not config BusiObjAttr"));
        }
        if (BeanPropUtils.isWriteable(this.getClass(), attr.readAttrNbr())) {
            return writeField(attr.readAttrNbr(), value);
        } else {
            return writeAttrByBusiObjAttr(attr, value);
        }
    }

    @Override
    public RetVo writeAttrByAttrSpecId(Long attrId, Object value) {
        return writeAttrByAttrSpecId(attrId, value, false);
    }

    @Override
    public RetVo writeAttrByAttrSpecId(Long attrId, Object value, boolean check) {
        if (attrId == null) {
            logger.warn("attrIdSpec is null");
            RetVo vo = new RetVo(false);
            vo.addMsgDetail("attrIdSpec is null");
            return vo;
        }
        IBusiObjAttr attr = readBusiObjAttrByAttrSpecId(attrId);
        if (attr == null) {
            ExceptionUtils.throwEx(new MetaException(attrId + " not config AttrSpec"));
        }
        if (BeanPropUtils.isWriteable(this.getClass(), attr.readAttrNbr())) {
            return writeField(attr.readAttrNbr(), value);
        } else {
            return writeAttrByBusiObjAttr(attr, value);
        }
    }

    protected RetVo writeField(String attrNbr, Object value) {
        try {
            PropertyUtils.setProperty(this, attrNbr, value);
        } catch (Exception e) {
            logger.error("write Fields Error.", e);
            ExceptionUtils.throwEx(e);
        }
        return new RetVo(true);
    }

    protected RetVo writeAttrByBusiObjAttr(IBusiObjAttr attr, Object value) {
        int index = attrIds.indexOf(attr.getId());
        data[index] = value;
        return new RetVo(true);
    }

    @Override
    public String getEntityName() {
        if (!StringUtils.isNullOrEmpty(entityName)) {
            return entityName;
        }
        String className = this.getClass().getName();
        return StringUtils.substringAfterLast(className, ".");
    }

    @Override
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String getTableName() {
        if (!StringUtils.isNullOrEmpty(tableName)) {
            return tableName;
        }
        return StringUtils.parsePropertyName2ColumnName(getEntityName()).toUpperCase();
    }

    @Override
    public void fillEntityFromMap(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String attrNbr = StringUtils.parseColumnName2PropertyName(entry.getKey());
            writeAttr(attrNbr, entry.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("super:" + super.toString() + ";");
        builder.append("className:" + this.getClass().getName());
        builder.append("entityName:" + getEntityName() + ";");
        builder.append("id:" + getId());
        builder.append("]");

        return builder.toString();
    }

    @Override
    public boolean isUseMeta() {
        return MetaConfig.isUseMeta();
    }
}

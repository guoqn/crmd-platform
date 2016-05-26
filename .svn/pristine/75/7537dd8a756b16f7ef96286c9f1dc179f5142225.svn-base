package com.ffcs.crmd.platform.core.ddd.entity.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.container.BeanLoader;
import com.ctg.udal.ddl.api.IDdlService;
import com.ffcs.crmd.platform.core.ddd.entity.ICrmDomBaseEntity;
import com.ffcs.crmd.platform.core.ddd.entity.OpType;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;
import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class AbstractCrmDomBaseEntityImpl<ID extends Serializable>
    extends CrmBaseMetaEntityImpl<ID> implements ICrmDomBaseEntity<ID> {

    protected transient ILogger logger = LoggerFactory.getLogger(this.getClass());

    private OpType enttOpType;

    private Set<String> loadedProperty = new HashSet<String>();

    public String getGlobalSeqName() {
        return CrmEntityUtils.getGlobalSeqName(this);
    }

    public AbstractCrmDomBaseEntityImpl() {
        super();

    }

    public AbstractCrmDomBaseEntityImpl(boolean genId) {
        super();
        String seq = this.getGlobalSeqName();
        Long id = CrmEntityUtils.getSeq(seq);
        setId((ID) id);
    }

    public boolean isLoaded(String propertyName) {
        return loadedProperty.contains(propertyName);
    }

    public void Loaded(String propertyName) {
        loadedProperty.add(propertyName);
    }

    public ID genEnttId() {
        Long id = CrmEntityUtils.getSeq(this.getGlobalSeqName());
        return (ID) id;
    }

    public ICrmDomBaseRepository defaultRepository() {
        ICrmDomBaseRepository defRepository = RepositoryRegister.getInstance()
            .getDefaultRepository();
        return defRepository;
    }

    @SuppressWarnings("unchecked")
    public int save() {
        return defaultRepository().insert(this);
    }

    @SuppressWarnings("unchecked")
    public int update() {
        return defaultRepository().updateByPrimaryKey(this);
    }

    @SuppressWarnings("unchecked")
    public int remove() {
        return defaultRepository().deleteByPrimaryKey(this);
    }

    public Object getProperty(String propertyName) {
        try {
            return PropertyUtils.getProperty(this, propertyName);
        } catch (Exception e) {
            logger.error("获取属性失败", e);
            e.printStackTrace();
            return null;
        }
    }

    public void setProperty(String propertyName, Object val) {
        try {
            PropertyUtils.setProperty(this, propertyName, val);
            // } catch (RuleRuntimeException e) {
            // throw e;
        } catch (IllegalAccessException e) {
            logger.error("setPropertyError", e);
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            // if (e.getTargetException() instanceof RuleRuntimeException) {
            // throw (RuleRuntimeException) e.getTargetException();
            // }
            logger.error("setPropertyError", e);
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            logger.error("setPropertyError", e);
            throw new RuntimeException(e);
        }
    }

    public OpType getEnttOpType() {
        return enttOpType;
    }

    public void setEnttOpType(OpType type) {
        // 重置动作:删除 + 新增（值不变）
        // edit by hehuang
        // 2014/11/29
        if (type == null) {
            this.enttOpType = null;
        } else if (enttOpType == null) {
            this.enttOpType = type;
        } else {
            if (OpType.ADD.equals(enttOpType)) {
                if (OpType.MOD.equals(type)) {
                    this.enttOpType = OpType.ADD;
                } else if (OpType.DEL.equals(type)) {
                    this.enttOpType = OpType.DEL;
                }
            } else if (OpType.MOD.equals(enttOpType)) {
                if (OpType.ADD.equals(type)) {
                    this.enttOpType = OpType.MOD;
                } else if (OpType.DEL.equals(type)) {
                    this.enttOpType = OpType.DEL;
                }
            } else if (OpType.DEL.equals(enttOpType)) {
                if (OpType.ADD.equals(type)) {
                    this.enttOpType = OpType.ADD;
                } else if (OpType.MOD.equals(type)) {
                    this.enttOpType = OpType.MOD;
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (getId() != null) {
            if (obj instanceof AbstractCrmDomBaseEntityImpl) {
                AbstractCrmDomBaseEntityImpl<?> ent = (AbstractCrmDomBaseEntityImpl<?>) obj;
                return getId().equals(ent.getId()) && // getClass().equals(ent.getClass());
                    (ent.getClass().isInstance(this) || this.getClass().isInstance(ent));
            } else {
                return false;
            }
        }
        return super.equals(obj);
    }

}

package com.ffcs.crmd.platform.idempotency.core.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;

public abstract class AbstractIdempotencyEntity<ID extends Serializable>
    extends AbstractCrmDomBaseEntityImpl<ID> {
    
    private static final long serialVersionUID = 775926601711432151L;
    
    public abstract void setStatusCd(String statusCd);
    
    public abstract void setStatusDate(Timestamp statusDate);
    
    /**
     * 是否新增对象
     */
    private boolean isNewEnttity = false;
    
    /**
     * 是否已存储过
     */
    private boolean isSaved      = false;
    
    public boolean isNewEnttity() {
        return isNewEnttity;
    }
    
    public void setNewEnttity(boolean isNewEnttity) {
        this.isNewEnttity = isNewEnttity;
    }
    
    @Override
    public ID genEnttId() {
        //使用ID生成时候，默认为新增对象
        this.setNewEnttity(true);
        return super.genEnttId();
    }
    
    /**
     * 
     * 更新状态.
     * 
     * @param statusCd
     */
    public void updateStatusCd(String statusCd) {
        this.setStatusCd(statusCd);
        this.setStatusDate(Timestamp.valueOf(DateUtils.getCurDate()));
        this.update();
    }
    
    /**
     * 
     * 更新时是否存储日记.
     * 
     * @return
     */
    public boolean isLogHisOnUpdate() {
        return false;
    }
    
    /**
     * 
     * 删除时是否存储日记.
     * 
     * @return
     */
    public boolean isLogHisOnDelete() {
        return false;
    }
    
    @Override
    public int save() {
        //存储过后，打标为已存储
        this.setSaved(true);
        return super.save();
    }
    
    public boolean isSaved() {
        return isSaved;
    }
    
    public void setSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }
}

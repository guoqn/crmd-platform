package com.ffcs.crmd.platform.idempotency.core.vo;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;

/**
 * 
 * 分布式事务变更对象与其操作类型.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author chenye
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2015年12月1日
 * @功能说明：
 *
 */
public class SysWorkItemObjVo {
    
    private AbstractCrmDomBaseEntityImpl<?> entt;
    
    private String                          operType;
    
    public AbstractCrmDomBaseEntityImpl<?> getEntt() {
        return entt;
    }
    
    public void setEntt(AbstractCrmDomBaseEntityImpl<?> entt) {
        this.entt = entt;
    }
    
    public String getOperType() {
        return operType;
    }
    
    public void setOperType(String operType) {
        this.operType = operType;
    }
    
    public String getVoName() {
        StringBuffer str = new StringBuffer();
        if (this.getEntt() == null) {
            throw new RtManagerException("Entt不能为空");
        }
        str.append("{").append(this.getOperType()).append(":")
            .append(this.getEntt().getClass().getSimpleName()).append(":")
            .append(this.getEntt().getId()).append("};");
        return str.toString();
    }
}

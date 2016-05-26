package com.ffcs.crmd.platform.pub.convert;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.pub.bean.annotation.Convert;
import com.ffcs.crmd.platform.pub.bean.provider.AbstractBeanConvert;
import com.ffcs.crmd.platform.pub.entity.Cust;
import com.ffcs.crmd.platform.pub.entity.CustDTO;

@Convert
public class CustConvert extends AbstractBeanConvert {
    
    @Override
    public Class<?> getSourceClass() {
        return Cust.class;
    }
    
    @Override
    public Class<?> getDestClass() {
        return CustDTO.class;
    }
    
    @Override
    public void sourceTypeToDestType(Object source, Object dest, boolean isOnlyCopyNotNull) {
        Cust cust = (Cust) source;
        CustDTO dto = (CustDTO) dest;
        if ((!isOnlyCopyNotNull && !StringUtils.isNullOrEmpty(cust.getCustName()))
            || isOnlyCopyNotNull) {
            dto.setCustName(cust.getCustName() + "dto");
        }
    }
    
    @Override
    public void destTypeToSourceType(Object source, Object dest, boolean isOnlyCopyNotNull) {
        Cust cust = (Cust) dest;
        CustDTO dto = (CustDTO) source;
        if ((!isOnlyCopyNotNull && !StringUtils.isNullOrEmpty(dto.getCustName()))
            || isOnlyCopyNotNull) {
            cust.setCustName(dto.getCustName() + "Entity");
        }
    }
    
}

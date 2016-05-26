package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrValue2;
import com.ffcs.crmd.platform.meta.repository.IAttrValue2Repository;
import com.ffcs.crmd.platform.meta.service.IAttrValueService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attrValueService2")
public class AttrValueServiceImpl2 extends AbstractCrmDomGenericService<AttrValue2, Long>
    implements IAttrValueService2 {

    @Autowired
    IAttrValue2Repository attrValueRepository2;

    @Override
    public PageInfo<AttrValue2> qryAttrValuePageByAttrId(Long attrId, Long parentValueId, int pageNum,
        int pageSize) {
        return AttrValue2.repository()
            .qryAttrValuePageByAttrId(attrId, parentValueId, pageNum, pageSize);
    }
}

package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrSpec2;
import com.ffcs.crmd.platform.meta.repository.IAttrSpec2Repository;
import com.ffcs.crmd.platform.meta.service.IAttrSpecService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attrSpecService2")
public class AttrSpecServiceImpl2 extends AbstractCrmDomGenericService<AttrSpec2, Long>
    implements IAttrSpecService2 {

    @Autowired
    IAttrSpec2Repository attrSpecRepository2;

    @Override
    public PageInfo<AttrSpec2> qryAttrSpecPageByTypeId(Long busiTypeId, Long parAttrId, int pageNum,
        int pageSize) {
        return AttrSpec2.repository()
            .qryAttrSpecPageByTypeId(busiTypeId, parAttrId, pageNum, pageSize);
    }
}

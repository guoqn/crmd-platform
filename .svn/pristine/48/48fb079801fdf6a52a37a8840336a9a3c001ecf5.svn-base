package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.BusiType;
import com.ffcs.crmd.platform.meta.repository.IBusiTypeRepository;
import com.ffcs.crmd.platform.meta.service.IBusiTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiTypeService")
public class BusiTypeServiceImpl extends AbstractCrmDomGenericService<BusiType, Long>
    implements IBusiTypeService {

    @Autowired
    IBusiTypeRepository busiTypeRepository;

    @Override
    public PageInfo<BusiType> qrySysTypesPageByDomainId(Long domainId, int pageNum, int pageSize) {
        return BusiType.repository().qrySysTypesPageByDomainId(domainId, pageNum, pageSize);
    }
}

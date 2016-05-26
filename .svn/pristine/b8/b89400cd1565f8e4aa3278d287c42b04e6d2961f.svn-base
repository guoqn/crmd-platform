package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysDomain;
import com.ffcs.crmd.platform.meta.repository.ISysDomainRepository;
import com.ffcs.crmd.platform.meta.service.ISysDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysDomainService")
public class SysDomainServiceImpl extends AbstractCrmDomGenericService<SysDomain, Long>
    implements ISysDomainService {

    @Autowired
    ISysDomainRepository sysDomainRepository;

    @Override
    public PageInfo<SysDomain> qrySysTablePage(int pageNum, int pageSize) {
        return SysDomain.repository().qrySysTablePage(pageNum, pageSize);
    }
}

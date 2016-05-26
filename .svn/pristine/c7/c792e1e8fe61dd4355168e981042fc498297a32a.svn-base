package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.SysDomain;
import com.ffcs.crmd.platform.meta.repository.ISysDomainRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("sysDomainRepository")
public class SysDomainRepositoryImpl extends AbstractCrmDomBaseRepository<SysDomain, Long>
    implements ISysDomainRepository {

    public SysDomainRepositoryImpl() {
        super(SysDomain.class);
    }

    @Override
    public PageInfo<SysDomain> qrySysTablePage(int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        return this.jdbcFindPageInfoByName("sysDomainRepository.qrySysTablePage", SysDomain.class, params, pageNum, pageSize);
    }
}

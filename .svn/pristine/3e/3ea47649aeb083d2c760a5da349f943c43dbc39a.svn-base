package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.BusiType;

import java.util.List;

public interface IBusiTypeRepository extends ICrmDomBaseRepository<BusiType, Long> {

    PageInfo<BusiType> qrySysTypesPageByDomainId(Long domainId, int pageNum, int pageSize);

    List<BusiType> qryTypeByNbr(String nbr);
}

package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.RelSpec;

public interface IRelSpecRepository extends ICrmDomBaseRepository<RelSpec, Long> {

    PageInfo<RelSpec> qryPageByAObjId(Long busiObjId, int pageNum, int pageSize);

    PageInfo<RelSpec> qryPageByZObjId(Long busiObjId, int pageNum, int pageSize);
}

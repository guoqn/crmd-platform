package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.RelSpecAttr;

public interface IRelSpecAttrRepository extends ICrmDomBaseRepository<RelSpecAttr, Long> {

    PageInfo<RelSpecAttr> qryPageByRelSpecId(Long relSpecId, int pageNum, int pageSize);

    PageInfo<RelSpecAttr> qryPageByAttrId(Long attrId, int pageNum, int pageSize);
}

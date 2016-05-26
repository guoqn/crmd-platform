package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.AttrSpec2;

public interface IAttrSpec2Repository extends ICrmDomBaseRepository<AttrSpec2, Long> {

    PageInfo<AttrSpec2> qryAttrSpecPageByTypeId(Long busiTypeId, Long parAttrId, int pageNum, int pageSize);
}

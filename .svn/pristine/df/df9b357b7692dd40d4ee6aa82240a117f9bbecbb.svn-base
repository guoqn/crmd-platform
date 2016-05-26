package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttrValue;

import java.util.List;

public interface IBusiObjAttrValueRepository extends ICrmDomBaseRepository<BusiObjAttrValue, Long> {

    PageInfo qryBusiObjAttrValPageByBusiObjAttrId(Long busiObjAttrId, int pageNum, int pageSize);

    List<BusiObjAttrValue> qryBusiObjAttrValuesByBusiObjAttrId(Long busiObjAttrId);

}

package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttr;

import java.util.List;

public interface IBusiObjAttrRepository extends ICrmDomBaseRepository<BusiObjAttr, Long> {

    PageInfo<BusiObjAttr> qryBusiObjAttrPageByObjId(Long busiObjId, int pageNum, int pageSize);

    List<BusiObjAttr> queryBusiObjAttrByObjId(Long busiObjId);
}

package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.RelSpec;

public interface IRelSpecService extends ICrmDomGenericService<RelSpec, Long> {

    PageInfo<RelSpec> qryPageByAObjId(Long busiObjId, int pageNum, int pageSize);

    PageInfo<RelSpec> qryPageByZObjId(Long busiObjId, int pageNum, int pageSize);
}

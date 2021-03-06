package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.BusiType;

public interface IBusiTypeService extends ICrmDomGenericService<BusiType, Long> {

    PageInfo<BusiType> qrySysTypesPageByDomainId(Long domainId, int pageNum, int pageSize);
}

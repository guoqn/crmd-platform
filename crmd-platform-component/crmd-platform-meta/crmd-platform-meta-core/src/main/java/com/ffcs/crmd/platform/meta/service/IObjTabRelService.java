package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.ObjTabRel;

public interface IObjTabRelService extends ICrmDomGenericService<ObjTabRel, Long> {

    PageInfo<ObjTabRel> qryPageByTabId(Long tabId, int pageNum, int pageSize);
}

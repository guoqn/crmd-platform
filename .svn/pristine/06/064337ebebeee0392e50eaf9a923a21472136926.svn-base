package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.BusiObj;

public interface IBusiObjService extends ICrmDomGenericService<BusiObj, Long> {

    PageInfo<BusiObj> qryBusiObjPageByTypeId(Long typeId, int pageNum, int pageSize);

    PageInfo<BusiObj> qryBusiObjPageByAObjId(Long busiObjId, int pageNum, int pageSize);

    PageInfo<BusiObj> qryBusiObjPageByZObjId(Long busiObjId, int pageNum, int pageSize);

    void addBusiObj(BusiObj busiObj, Long tabId, String objType);

    PageInfo<BusiObj> qryBusiObjPageByTabId(Long tabId, String objType, int pageNum, int pageSize);
}

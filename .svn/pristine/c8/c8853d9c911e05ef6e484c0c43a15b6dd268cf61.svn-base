package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.BusiObj;

import java.util.List;

public interface IBusiObjRepository extends ICrmDomBaseRepository<BusiObj, Long> {

    PageInfo qryBusiObjPageByTypeId(Long typeId, int pageNum, int pageSize);

    PageInfo qryBusiObjPageByAObjId(Long busiObjId, int pageNum, int pageSize);

    PageInfo qryBusiObjPageByZObjId(Long busiObjId, int pageNum, int pageSize);

    PageInfo<BusiObj> qryBusiObjPageByTabId(Long tabId, String objType, int pageNum, int pageSize);

    List<BusiObj> queryBusiObjByTypeId(Long typeId);

    List<BusiObj> queryBusiObjByBusiObjNbrAndStatusCd(String busiObjNbr);

}

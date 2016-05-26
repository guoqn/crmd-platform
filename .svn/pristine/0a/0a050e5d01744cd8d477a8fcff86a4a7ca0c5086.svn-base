package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiObjDTO;

public interface IBusiObjFacade extends ICrmBaseFacade {

    void add(BusiObjDTO dto);

    int update(BusiObjDTO dto);

    int delete(BusiObjDTO dto);

    PageInfo<BusiObjDTO> qryBusiObjPageByTypeId(Long domainId, int pageNum, int pageSize);

    PageInfo<BusiObjDTO> qryBusiObjPageByAObjId(Long busiObjId, int pageNumber, int pageSize);

    PageInfo<BusiObjDTO> qryBusiObjPageByZObjId(Long busiObjId, int pageNumber, int pageSize);

    PageInfo<BusiObjDTO> qryBusiObjPageByTabId(Long tabId, String objType, int pageNumber,
        int pageSize);
}

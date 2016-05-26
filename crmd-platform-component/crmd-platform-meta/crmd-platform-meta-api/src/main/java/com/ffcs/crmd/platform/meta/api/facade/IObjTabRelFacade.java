package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.ObjTabRelDTO;

public interface IObjTabRelFacade extends ICrmBaseFacade {

    void add(ObjTabRelDTO dto);

    int update(ObjTabRelDTO dto);

    int delete(ObjTabRelDTO dto);

    PageInfo<ObjTabRelDTO> qryPageByTabId(Long tabId, int pageNumber, int pageSize);
}

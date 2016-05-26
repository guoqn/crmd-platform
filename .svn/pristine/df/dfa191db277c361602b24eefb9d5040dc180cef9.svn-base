package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiObjAttrDTO;

public interface IBusiObjAttrFacade extends ICrmBaseFacade {

    int update(BusiObjAttrDTO dto);

    void add(BusiObjAttrDTO dto);

    int delete(BusiObjAttrDTO dto);

    PageInfo<BusiObjAttrDTO> qryBusiObjAttrPageByObjId(Long busiObjId, int pageNum, int pageSize);
}

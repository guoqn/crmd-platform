package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiObjAttrValueDTO;

public interface IBusiObjAttrValueFacade extends ICrmBaseFacade {

    void add(BusiObjAttrValueDTO dto);

    int update(BusiObjAttrValueDTO dto);

    int delete(BusiObjAttrValueDTO dto);

    PageInfo<BusiObjAttrValueDTO> qryBusiObjAttrValPageByBusiObjAttrId(Long busiObjAttrId, int pageNum,
        int pageSize);
}

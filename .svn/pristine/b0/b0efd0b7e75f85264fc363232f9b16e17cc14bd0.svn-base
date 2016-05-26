package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.AttrValueDTO;

public interface IAttrValueFacade extends ICrmBaseFacade {

    void add(AttrValueDTO dto);

    int update(AttrValueDTO dto);

    int delete(AttrValueDTO dto);

    PageInfo<AttrValueDTO> qryAttrValuePageByAttrId(Long attrId, Long parentValueId, int pageNumber,
        int pageSize);
}

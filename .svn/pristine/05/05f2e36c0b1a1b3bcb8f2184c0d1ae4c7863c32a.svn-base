package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.AttrSpecDTO;

public interface IAttrSpecFacade extends ICrmBaseFacade {

    void add(AttrSpecDTO dto);

    int update(AttrSpecDTO dto);

    int delete(AttrSpecDTO dto);

    PageInfo<AttrSpecDTO> qryAttrSpecPageByTypeId(Long busiTypeId, Long parAttrId, int pageNum,
        int pageSize);
}

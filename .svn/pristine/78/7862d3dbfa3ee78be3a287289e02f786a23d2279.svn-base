package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiTypeDTO;

public interface IBusiTypeFacade extends ICrmBaseFacade {

    void add(BusiTypeDTO dto);

    int update(BusiTypeDTO dto);

    int delete(BusiTypeDTO dto);

    PageInfo<BusiTypeDTO> qrySysTypesPageByDomainId(Long domainId, int pageNum, int pageSize);
}

package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.RelSpecDTO;

public interface IRelSpecFacade extends ICrmBaseFacade {

    void add(RelSpecDTO dto);

    int update(RelSpecDTO dto);

    int delete(RelSpecDTO dto);

    PageInfo<RelSpecDTO> qryPageByAObjId(Long busiObjId, int pageNum, int pageSize);

    PageInfo<RelSpecDTO> qryPageByZObjId(Long busiObjId, int pageNum, int pageSize);
}

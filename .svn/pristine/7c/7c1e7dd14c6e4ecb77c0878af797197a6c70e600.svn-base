package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.RelSpecAttrDTO;

public interface IRelSpecAttrFacade extends ICrmBaseFacade {

    void add(RelSpecAttrDTO dto);

    int update(RelSpecAttrDTO dto);

    int delete(RelSpecAttrDTO dto);

    PageInfo<RelSpecAttrDTO> qryPageByRelSpecId(Long relSpecId, int pageNumber, int pageSize);

    PageInfo<RelSpecAttrDTO> qryPageByAttrId(Long attrId, int pageNumber, int pageSize);
}

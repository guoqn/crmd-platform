package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.SysColumnDTO;

import java.util.List;

public interface ISysColumnFacade extends ICrmBaseFacade {

    /**
     *
     * @param tabId
     * @return
     */
    List<SysColumnDTO> qrySysColumnsListByTabId(Long tabId);

    PageInfo<SysColumnDTO> qrySysColumnsPageByTabId(Long tabId, int pageNum, int pageSize);

    void add(SysColumnDTO dto);

    int delete(SysColumnDTO dto);

    int update(SysColumnDTO dto);
}

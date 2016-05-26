package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.SysColumn;

import java.util.List;

public interface ISysColumnRepository extends ICrmDomBaseRepository<SysColumn, Long> {

    List<SysColumn> qrySysColumnsListByTabId(Long tabId);

    PageInfo<SysColumn> qrySysColumnsPageByTabId(Long tabId, int pageNum, int pageSize);

    List<SysColumn> qrySysColumnsListByTabIdAndStatusCd(Long tabId);

}

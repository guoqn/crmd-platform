package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysColumn;

import java.util.List;

public interface ISysColumnService extends ICrmDomGenericService<SysColumn, Long> {

    List<SysColumn> qrySysColumnsListByTabId(Long tabId);

    PageInfo<SysColumn> qrySysColumnsPageByTabId(Long tabId, int pageNum, int pageSize);
}

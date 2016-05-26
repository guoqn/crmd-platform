package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.RelSpecAttr;

public interface IRelSpecAttrService extends ICrmDomGenericService<RelSpecAttr, Long> {

    PageInfo<RelSpecAttr> qryPageByRelSpecId(Long relSpecId, int pageNum, int pageSize);

    PageInfo<RelSpecAttr> qryPageByAttrId(Long attrId, int pageNum, int pageSize);
}

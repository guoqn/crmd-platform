package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrSpec2;

public interface IAttrSpecService2 extends ICrmDomGenericService<AttrSpec2, Long> {

    PageInfo<AttrSpec2> qryAttrSpecPageByTypeId(Long busiTypeId, Long parAttrId, int pageNum, int pageSize);
}

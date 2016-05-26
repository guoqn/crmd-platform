package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrValue2;

public interface IAttrValueService2 extends ICrmDomGenericService<AttrValue2, Long> {

    PageInfo<AttrValue2> qryAttrValuePageByAttrId(Long attrId, Long parentValueId, int pageNum, int pageSize);
}

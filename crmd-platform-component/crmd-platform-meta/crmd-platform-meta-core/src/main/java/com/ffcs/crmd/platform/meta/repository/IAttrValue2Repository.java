package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.AttrValue2;

public interface IAttrValue2Repository extends ICrmDomBaseRepository<AttrValue2, Long> {

	PageInfo<AttrValue2> qryAttrValuePageByAttrId(Long attrId, Long parentValueId, int pageNum, int pageSize);

	/**
	 * 根据属性ID获取属性值
	 * 
	 * @param attrId
	 * @return
	 */
	public List<AttrValue2> qryAttrValuesByAttrId(Long attrId);
}

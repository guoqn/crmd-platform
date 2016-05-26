package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.DynamicPart;

public interface IDynamicPartRepository extends ICrmDomBaseRepository<DynamicPart, Long> {

	/**
	 * 获取构件
	 * 
	 * @return
	 */
	public List<DynamicPart> qryParts();

	/**
	 * 获取分页构件
	 * 
	 * @return
	 */
	public PageInfo<DynamicPart> qryPageInfoPart(DynamicPart part, int page, int pageSize);

	/**
	 * 获取组件
	 * 
	 * @param code
	 * @return
	 */
	public DynamicPart getDynamicPartByCode(String code);

}

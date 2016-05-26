package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.AttrValue;

public interface IAttrValueRepository extends ICrmDomBaseRepository<AttrValue, Long> {
	/**
	 * 获取主数据下拉框的数据
	 * 
	 * @param clsCode
	 * @param javaCode
	 * @return
	 */
	public List<AttrValue> getAttrValuesByCode(String clsCode, String javaCode);

}

package com.ffcs.crmd.platform.meta.service;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrValue;

/**
 * @author LAIYONGMIN
 *
 */
public interface IAttrValueService extends ICrmDomGenericService<AttrValue, Long> {
	/**
	 * 获取主数据下拉框的数据
	 * 
	 * @param javaCode
	 * @return
	 */
	public List<AttrValue> getAttrValuesByCode(String clsCode, String javaCode);
	
	
	/**
	 * @param attrValueId
	 * @return
	 */
	public AttrValue getById(Long attrValueId);

}

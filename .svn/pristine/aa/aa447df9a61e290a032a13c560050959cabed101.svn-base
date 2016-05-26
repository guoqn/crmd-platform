package com.ffcs.crmd.platform.meta.service;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;

public interface IAttrSpecService extends ICrmDomGenericService<AttrSpec, Long> {

	/**
	 * classId获取属性
	 * 
	 * @param classId
	 * @return
	 */
	public List<AttrSpec> getAttrSpecsByClassId(Long classId);
	
	
	/**
	 * @param clsCode
	 * @param javaCode
	 * @return
	 */
	public List<AttrSpec> getAttrSpecsByCode(String clsCode, String javaCode);
	
	
	/**
	 * @param attrId
	 * @return
	 */
	public AttrSpec getById(Long attrId);
}

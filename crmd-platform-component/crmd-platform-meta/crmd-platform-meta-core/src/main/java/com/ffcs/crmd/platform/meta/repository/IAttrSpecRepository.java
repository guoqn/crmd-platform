package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;

/**
 * @author LAIYONGMIN
 *
 */
public interface IAttrSpecRepository extends ICrmDomBaseRepository<AttrSpec, Long> {

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
	public List<AttrSpec> getAttrSpecsByCode(String clsCode,String javaCode);

}

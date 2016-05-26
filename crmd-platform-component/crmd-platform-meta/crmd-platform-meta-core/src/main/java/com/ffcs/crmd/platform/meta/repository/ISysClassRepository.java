package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.SysClass;

/**
 * @author LAIYONGMIN
 *
 */
public interface ISysClassRepository extends ICrmDomBaseRepository<SysClass, Long> {
	
	
	/**
	 * @param clsCode
	 * @return
	 */
	public List<SysClass> getSysClssByCode(String clsCode);
}

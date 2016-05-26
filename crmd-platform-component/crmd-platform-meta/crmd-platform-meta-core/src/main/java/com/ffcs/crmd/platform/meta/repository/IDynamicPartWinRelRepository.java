package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.DynamicPartWinRel;

/**
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicPartWinRelRepository extends ICrmDomBaseRepository<DynamicPartWinRel, Long> {

	/**
	 * 获取构件的所有关联关系
	 * 
	 * @param partId
	 * @return
	 */
	public List<DynamicPartWinRel> qryRelsByPartId(Long partId);

}

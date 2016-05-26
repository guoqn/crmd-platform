package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.DynamicTempPartRel;

/**
 * 模版构件关联关系
 * 
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicTempPartRelRepository extends ICrmDomBaseRepository<DynamicTempPartRel, Long> {

	/**
	 * 根据模版ID获取配置构件
	 * 
	 * @param tplId
	 * @return
	 */
	public List<DynamicTempPartRel> qryTplPartRels(Long tplId);
}

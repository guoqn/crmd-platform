package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.DynamicTemplate;

/**
 * 获取模版
 * 
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicTemplateRepository extends ICrmDomBaseRepository<DynamicTemplate, Long> {

	/**
	 * 获取分页模版
	 * 
	 * @param tpl
	 * @return
	 */
	public PageInfo<DynamicTemplate> qryTplPageInfo(DynamicTemplate tpl, int page, int pageSize);

	/**
	 * 根据 编码获取模版
	 * 
	 * @param code
	 * @return
	 */
	public DynamicTemplate getTplByCode(String code);

	/**
	 * 根据类型获取模块
	 * 
	 * @param type
	 * @return
	 */
	public List<DynamicTemplate> qryTplListsByType(String type);

}

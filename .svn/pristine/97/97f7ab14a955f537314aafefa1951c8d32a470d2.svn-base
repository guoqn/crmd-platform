package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicTemplate;

/**
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicTemplateService extends ICrmDomGenericService<DynamicTemplate, Long> {
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
	 * 根据类型保存模版
	 * 
	 * @param tpl
	 */
	public void saveTpl(DynamicTemplate tpl);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void delTpl(Long id);
}

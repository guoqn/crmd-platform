package com.ffcs.crmd.platform.meta.service;

import java.util.List;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicPart;
import com.ffcs.crmd.platform.meta.entity.DynamicWindow;

/**
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicPartService extends ICrmDomGenericService<DynamicPart, Long> {
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
	 * 保存构件，和窗体及关联
	 * 
	 * @param part
	 */
	public void savePart(DynamicPart part);

	/**
	 * 删除构件、关联、窗体以及窗体组件和样式
	 * 
	 * @param partId
	 */
	public void deletePart(Long partId);

	/**
	 * 获取窗体列表
	 * 
	 * @param partId
	 * @return
	 */
	public List<DynamicWindow> qryWindowByPartId(Long partId);

}

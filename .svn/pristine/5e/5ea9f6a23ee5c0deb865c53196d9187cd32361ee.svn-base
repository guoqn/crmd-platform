package com.ffcs.crmd.platform.meta.service;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicStyle;

/**
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicStyleService extends ICrmDomGenericService<DynamicStyle, Long> {
	/**
	 * 获取主题样式类型数据
	 * 
	 * @param styleType
	 * @return
	 */
	public List<DynamicStyle> qryThemeStyles();

	/**
	 * 根据父节点获取子节点样式数据
	 * 
	 * @param styleId
	 * @return
	 */
	public List<DynamicStyle> qryChildStylesByPId(Long pId);

	/**
	 * 获取孩子记录数
	 * 
	 * @param pId
	 * @return
	 */
	public int qryCountByPId(Long pId);

	/**
	 * 保存
	 * 
	 * @param event
	 * @return
	 */
	public int insertDyStyle(DynamicStyle style);

	/**
	 * 修改
	 * 
	 * @param event
	 * @return
	 */
	public int updateDyStyle(DynamicStyle style);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteDyStyle(Long id);

	/**
	 * @return
	 */
	public List<DynamicStyle> qryAllStyleTreeData();

	/**
	 * 批量操作
	 * 
	 * @param styles
	 */
	public void batchInsertStyle(List<DynamicStyle> styles);

	/**
	 * 批量删除样式
	 * 
	 * @param ids
	 */
	public void batchDelSyles(List<Long> ids);

	/**
	 * 获取组件样式
	 * 
	 * @param componentId
	 * @return
	 */
	public List<DynamicStyle> qryStylesByComponentId(Long componentId);
}

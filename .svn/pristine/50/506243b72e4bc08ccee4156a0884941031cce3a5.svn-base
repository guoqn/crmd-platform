package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.DynamicStyle;

public interface IDynamicStyleRepository extends ICrmDomBaseRepository<DynamicStyle, Long> {

	/**
	 * 获取样式
	 * 
	 * @param componentId
	 * @param styleType
	 * @return
	 */
	public List<DynamicStyle> qryDynamicStyleByCompId(Long componentId, String styleType);

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
	 * 获取字节点数量
	 * 
	 * @param pId
	 * @return
	 */
	public int qryCountByPId(Long pId);

	/**
	 * 获取ztree 标准结构配置样式数据
	 * 
	 * @return
	 */
	public List<DynamicStyle> qryAllStyleTreeData();

	/**
	 * 获取组件样式
	 * 
	 * @param componentId
	 * @return
	 */
	public List<DynamicStyle> qryStylesByComponentId(Long componentId);

}

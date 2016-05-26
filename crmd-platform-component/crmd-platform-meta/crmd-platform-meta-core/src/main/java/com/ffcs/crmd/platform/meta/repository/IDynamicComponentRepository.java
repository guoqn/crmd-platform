package com.ffcs.crmd.platform.meta.repository;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.DynamicComponent;

public interface IDynamicComponentRepository extends ICrmDomBaseRepository<DynamicComponent, Long> {

	/**
	 * 获取父组件对象
	 * 
	 * @param winId
	 * @return
	 */
	public DynamicComponent getRootComponentByWinId(Long winId);

	/**
	 * 获取孩子节点
	 * 
	 * @param pId
	 * @return
	 */
	public List<DynamicComponent> qryChildComponentByPId(Long pId);

	/**
	 * 获取配置的所有组件
	 * 
	 * @param windowId
	 * @return
	 */
	public List<DynamicComponent> qryComponentsByWinId(Long windowId);

}

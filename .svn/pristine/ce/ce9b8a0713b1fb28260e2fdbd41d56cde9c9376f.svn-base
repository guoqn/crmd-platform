package com.ffcs.crmd.platform.meta.service;

import java.util.List;

import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicComponent;

public interface IDynamicComponentService extends ICrmDomGenericService<DynamicComponent, Long> {

	/**
	 * 窗体序号获取组件信息
	 * 
	 * @param winId
	 * @return
	 */
	public DynamicComponent getRootComponent(Long winId);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	public int deleteByIds(List<Long> ids);

	/**
	 * 删除组件
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Long id);

	/**
	 * 保存
	 * 
	 * @param comp
	 * @return
	 */
	public int insertComponent(DynamicComponent comp);

	/**
	 * 批量
	 * 
	 * @param comps
	 */
	public void batchInsert(List<DynamicComponent> comps);

	/**
	 * 更新
	 * 
	 * @param comp
	 * @return
	 */
	public int updateComponent(DynamicComponent comp);

	/**
	 * 批量更新
	 * 
	 * @param comps
	 */
	public void batchUpdate(List<DynamicComponent> comps);

	/**
	 * 根据窗体ID获取组件
	 * 
	 * @param windowId
	 * @return
	 */
	public List<DynamicComponent> qryComponentsByWinId(Long windowId);

}

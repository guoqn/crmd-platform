package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicWindow;

/**
 * 窗体
 * 
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicWindowService extends ICrmDomGenericService<DynamicWindow, Long> {

	/**
	 * 编码获取窗体
	 * 
	 * @param winCode
	 * @return
	 */
	public DynamicWindow getDynamicWindow(String winCode);

	/**
	 * 根据条件获取窗体
	 * 
	 * @param winCode
	 * @return
	 */
	public DynamicWindow getDynamicWindow(Long busSpec, Long busService, Long busRegion, Long busChannel);

	/**
	 * 根据事件获取窗体
	 * 
	 * @param eventId
	 * @return
	 */
	public DynamicWindow getDynamicWindowByEventId(Long eventId);

	/**
	 * @param window
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageInfo<DynamicWindow> qryWindowPageInfo(DynamicWindow window, int page, int pageSize);

	/**
	 * @param winId
	 * @return
	 */
	public DynamicWindow getSimpleWindow(Long winId);

	/**
	 * 删除 窗体、组件、样式
	 * 
	 * @param windowId
	 */
	public void deleteWindow(Long windowId);

	/**
	 * 保存类型窗体
	 * 
	 * @param objId
	 * @param objType
	 * @return
	 */
	public DynamicWindow saveTypeWindow(Long objId, String objType);

}

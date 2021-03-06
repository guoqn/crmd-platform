package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicEvent;

/**
 * 事件服务接口
 * 
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicEventService extends ICrmDomGenericService<DynamicEvent, Long> {

	/**
	 * 规格获取配置事件信息
	 * 
	 * @param busSpec
	 * @return
	 */
	public PageInfo<DynamicEvent> queryEventsByBusspec(Long busSpec, int page, int pageSize);

	/**
	 * @param busType
	 * @param busSpec
	 * @param busObjId
	 * @param busRegion
	 * @param busService
	 * @param busChannel
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageInfo<DynamicEvent> queryPageInfoEvents(String busType, Long busSpec, Long busObjId, Long busRegion,
			Long busService, Long busChannel, int page, int pageSize);

	/**
	 * 保存
	 * 
	 * @param event
	 * @return
	 */
	public int insertDyEvent(DynamicEvent event);

	/**
	 * 修改
	 * 
	 * @param event
	 * @return
	 */
	public int updateDyEvent(DynamicEvent event);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteDyEvent(Long id);

}

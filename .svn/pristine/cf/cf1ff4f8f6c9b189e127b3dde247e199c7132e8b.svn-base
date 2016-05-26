package com.ffcs.crmd.platform.meta.repository;

import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.DynamicEvent;

/**
 * 业务事件（筛选条件）
 * 
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicEventRepository extends ICrmDomBaseRepository<DynamicEvent, Long> {

	/**
	 * 获取事件List
	 * 
	 * @param param
	 * @return
	 */
	public List<DynamicEvent> qryDynamicEventByBusParam(Map<String, Object> param);

	/**
	 * 获取分页
	 * 
	 * @param param
	 * @return
	 */
	public PageInfo<DynamicEvent> qryDynamicEventPageInfoByBusParam(Map<String, Object> param, int page, int pageSize);

	/**
	 * 获取事件
	 * 
	 * @param busType
	 * @param busSpec
	 * @param busObjId
	 * @param busRegion
	 * @param busService
	 * @param busChannel
	 * @return
	 */
	public DynamicEvent getDynmaicEvent(String busType, Long busSpec, Long busObjId, Long busRegion, Long busService,
			Long busChannel);

	/**
	 * 获取 事件
	 * 
	 * @param busSpec
	 * @param busService
	 * @param busRegion
	 * @param busChannel
	 * @return
	 */
	public DynamicEvent getDynamicEvent(Long busSpec, Long busService, Long busRegion, Long busChannel);

}

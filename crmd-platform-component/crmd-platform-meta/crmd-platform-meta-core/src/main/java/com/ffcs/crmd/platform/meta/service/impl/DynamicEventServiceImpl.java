package com.ffcs.crmd.platform.meta.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicEvent;
import com.ffcs.crmd.platform.meta.repository.IDynamicEventRepository;
import com.ffcs.crmd.platform.meta.service.IDynamicEventService;

@Service("dynamicEventService")
public class DynamicEventServiceImpl extends AbstractCrmDomGenericService<DynamicEvent, Long>
		implements IDynamicEventService {

	@Autowired
	IDynamicEventRepository dynamicEventRepository;

	@Override
	public PageInfo<DynamicEvent> queryEventsByBusspec(Long busSpec, int page, int pageSize) {
		Map<String, Object> param = new HashMap<String, Object>();
		if (busSpec == null || busSpec == 0) {
			return null;
		}
		param.put("busSpec", busSpec);
		return dynamicEventRepository.qryDynamicEventPageInfoByBusParam(param, page, pageSize);
	}

	@Override
	public int insertDyEvent(DynamicEvent event) {
		return this.save(event);
	}

	@Override
	public int updateDyEvent(DynamicEvent event) {
		return this.update(event);
	}

	@Override
	public int deleteDyEvent(Long id) {
		DynamicEvent e = this.get(id);
		return this.remove(e);
	}

	@Override
	public PageInfo<DynamicEvent> queryPageInfoEvents(String busType, Long busSpec, Long busObjId, Long busRegion,
			Long busService, Long busChannel, int page, int pageSize) {
		Map<String, Object> param = new HashMap<String, Object>();
		// 类型
		if (!StringUtils.isNullOrEmpty(busType)) {
			param.put("busType", busType);
		}
		// 规格
		if (busSpec != null) {
			param.put("busSpec", busSpec);
		}
		// 对象
		if (busObjId != null) {
			param.put("busObjId", busObjId);
		}
		// 区域
		if (busRegion != null) {
			param.put("busRegion", busRegion);
		}
		// 服务
		if (busService != null) {
			param.put("busService", busService);
		}
		// 渠道
		if (busChannel != null) {
			param.put("busChannel", busChannel);
		}
		return dynamicEventRepository.qryDynamicEventPageInfoByBusParam(param, page, pageSize);
	}
}

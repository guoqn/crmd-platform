package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicEvent;
import com.ffcs.crmd.platform.meta.repository.IDynamicEventRepository;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

@Repository("dynamicEventRepository")
public class DynamicEventRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicEvent, Long>
		implements IDynamicEventRepository {

	public DynamicEventRepositoryImpl() {
		super(DynamicEvent.class);
	}

	@Override
	public List<DynamicEvent> qryDynamicEventByBusParam(Map<String, Object> params) {
		// 固定条件
		params.put("statusCd", MetaConstants.STATUS.META_STATUS_VALID);
		return this.queryListByName("dynamicEventRepository.qryDynamicEventByBusParam", DynamicEvent.class, params);
	}

	public PageInfo<DynamicEvent> qryDynamicEventPageInfoByBusParam(Map<String, Object> params, int page,
			int pageSize) {
		// 固定条件
		params.put("statusCd", MetaConstants.STATUS.META_STATUS_VALID);
		return this.queryPageInfoByName("dynamicEventRepository.qryDynamicEventByBusParam", DynamicEvent.class, params,
				page, pageSize);
	}

	@Override
	public DynamicEvent getDynamicEvent(Long busSpec, Long busService, Long busRegion, Long busChannel) {
		Map<String, Object> params = new HashMap<String, Object>();
		// 必备条件
		if (busSpec != null) {
			params.put("busSpec", busSpec);
		}
		if (busService != null) {
			params.put("busService", busService);
		}
		if (busRegion != null) {
			params.put("busRegion", busRegion);
		}
		if (busChannel != null) {
			params.put("busChannel", busChannel);
		}

		List<DynamicEvent> lists = qryDynamicEventByBusParam(params);

		if (lists != null && lists.size() > 0) {
			return lists.get(0);
		}
		return null;
	}

	@Override
	public DynamicEvent getDynmaicEvent(String busType, Long busSpec, Long busObjId, Long busRegion, Long busService,
			Long busChannel) {
		Map<String, Object> params = new HashMap<String, Object>();
		// 类型
		if (!StringUtils.isNullOrEmpty(busType)) {
			params.put("busType", busType);
		}
		// 规格
		if (busSpec != null) {
			params.put("busSpec", busSpec);
		}
		// 对象
		if (busObjId != null) {
			params.put("busObjId", busObjId);
		}
		// 区域
		if (busRegion != null) {
			params.put("busRegion", busRegion);
		}
		// 服务
		if (busService != null) {
			params.put("busService", busService);
		}
		// 渠道
		if (busChannel != null) {
			params.put("busChannel", busChannel);
		}
		List<DynamicEvent> lists = qryDynamicEventByBusParam(params);
		if (lists != null && lists.size() > 0) {
			if (lists.size() > 1) {
				ExceptionUtils.throwEx(new RtManagerException("配置异常，查出多个配置事件记录。请检测配置是否合法！"));
			} else {
				return lists.get(0);
			}
		}
		return null;
	}
}

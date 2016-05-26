package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicEvent;
import com.ffcs.crmd.platform.meta.entity.DynamicTemplate;
import com.ffcs.crmd.platform.meta.entity.DynamicWindow;
import com.ffcs.crmd.platform.meta.repository.IDynamicEventRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicTemplateRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicWindowRepository;

@Repository("dynamicWindowRepository")
public class DynamicWindowRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicWindow, Long>
		implements IDynamicWindowRepository {

	@Autowired
	IDynamicEventRepository eventRepository;

	@Autowired
	IDynamicTemplateRepository tplRepository;

	public DynamicWindowRepositoryImpl() {
		super(DynamicWindow.class);
	}

	@Override
	public DynamicWindow getDynamicWindowByWinCode(String winCode) {
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.isNullOrEmpty(winCode)) {
			return null;
		}
		params.add(winCode);
		// 有效状态
		params.add(MetaConstants.STATUS.META_STATUS_VALID);

		List<DynamicWindow> lists = this.jdbcFindListByName("dynamicWindowRepository.getDynamicWindowByWinCode",
				DynamicWindow.class, params);
		// 获取对象
		if (lists != null && lists.size() == 1) {
			return lists.get(0);
		}
		return null;
	}

	@Override
	public DynamicWindow getDynamicWindowByEventId(Long eventId) {
		List<Object> params = new ArrayList<Object>();
		if (eventId == 0) {
			return null;
		}
		params.add(eventId);
		// 有效状态
		params.add(MetaConstants.STATUS.META_STATUS_VALID);

		List<DynamicWindow> lists = this.jdbcFindListByName("dynamicWindowRepository.getDynamicWindowByEventId",
				DynamicWindow.class, params);
		// 获取对象
		if (lists != null && lists.size() == 1) {
			return lists.get(0);
		}
		return null;
	}

	@Override
	public DynamicWindow getDynamicWindow(Long busSpec, Long busService, Long busRegion, Long busChannel) {
		// 获取事件ID
		DynamicEvent event = eventRepository.getDynamicEvent(busSpec, busService, busRegion, busChannel);
		// 获取
		if (event != null) {
			return this.getDynamicWindowByEventId(event.getEventId());
		}
		return null;
	}

	@Override
	public PageInfo<DynamicWindow> qryWindowPageInfo(DynamicWindow window, int page, int pageSize) {

		Map<String, Object> params = new HashMap<String, Object>();

		// 类型
		if (!StringUtils.isNullOrEmpty(window.getWindowType())) {
			params.put("windowType", window.getWindowType());
		}
		// 编码
		if (!StringUtils.isNullOrEmpty(window.getWindowCode())) {
			params.put("windowCode", window.getWindowCode());
		}
		// 名称
		if (!StringUtils.isNullOrEmpty(window.getWindowName())) {
			params.put("windowName", window.getWindowName());
		}
		// 必须条件
		params.put("statusCd", MetaConstants.STATUS.META_STATUS_VALID);

		return this.queryPageInfoByName("dynamicWindowRepository.qryWindowPageInfo", DynamicWindow.class, params, page,
				pageSize);
	}

	@Override
	public DynamicWindow getSimpleWindow(Long winId) {
		List<Object> params = new ArrayList<Object>();
		params.add(winId);
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		List<DynamicWindow> windows = this.jdbcFindListByName("dynamicWindowRepository.getDynamicWindowByWinId",
				DynamicWindow.class, params);
		if (windows != null && windows.size() > 0) {
			return windows.get(0);
		}
		return null;
	}

	@Override
	public DynamicWindow getDynamicWindowByTplId(Long tplId) {
		List<Object> params = new ArrayList<Object>();
		if (tplId == 0) {
			return null;
		}
		params.add(tplId);
		// 有效状态
		params.add(MetaConstants.STATUS.META_STATUS_VALID);

		List<DynamicWindow> lists = this.jdbcFindListByName("dynamicWindowRepository.getDynamicWindowByTplId",
				DynamicWindow.class, params);
		// 获取对象
		if (lists != null && lists.size() == 1) {
			return lists.get(0);
		}
		return null;
	}

	@Override
	public DynamicWindow getDynamicWindowByTplCode(String code) {
		DynamicTemplate tpl = tplRepository.getTplByCode(code);
		if (tpl != null) {
			return this.getDynamicWindowByTplId(tpl.getTemplateId());
		}
		return null;
	}

	@Override
	public DynamicWindow getDynamicWindow(String busType, Long busSpec, Long busObjId, Long busRegion, Long busService,
			Long busChannel) {
		DynamicEvent event = eventRepository.getDynmaicEvent(busType, busSpec, busObjId, busRegion, busService,
				busChannel);
		// 获取
		if (event != null) {
			return this.getDynamicWindowByEventId(event.getEventId());
		}
		return null;
	}

}

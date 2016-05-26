package com.ffcs.crmd.platform.meta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.constants.DyPageConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicComponent;
import com.ffcs.crmd.platform.meta.entity.DynamicStyle;
import com.ffcs.crmd.platform.meta.entity.DynamicWindow;
import com.ffcs.crmd.platform.meta.repository.IDynamicWindowRepository;
import com.ffcs.crmd.platform.meta.service.IDynamicComponentService;
import com.ffcs.crmd.platform.meta.service.IDynamicStyleService;
import com.ffcs.crmd.platform.meta.service.IDynamicWindowService;

@Service("dynamicWindowService")
public class DynamicWindowServiceImpl extends AbstractCrmDomGenericService<DynamicWindow, Long>
		implements IDynamicWindowService {

	@Autowired
	IDynamicWindowRepository dynamicWindowRepository;

	@Autowired
	IDynamicComponentService componentService;
	@Autowired
	IDynamicStyleService styleService;

	@Override
	public DynamicWindow getDynamicWindow(String winCode) {
		// 获取窗体
		DynamicWindow dynamicWindow = dynamicWindowRepository.getDynamicWindowByWinCode(winCode);
		// 获取窗体主键
		if (dynamicWindow != null) {
			dynamicWindow.setComponent(componentService.getRootComponent(dynamicWindow.getWindowId()));
			return dynamicWindow;
		}
		return null;
	}

	@Override
	public DynamicWindow getDynamicWindow(Long busSpec, Long busService, Long busRegion, Long busChannel) {
		// 获取具体的窗体
		DynamicWindow dynamicWindow = dynamicWindowRepository.getDynamicWindow(busSpec, busService, busRegion,
				busChannel);
		// 获取窗体主键
		if (dynamicWindow != null) {
			dynamicWindow.setComponent(componentService.getRootComponent(dynamicWindow.getWindowId()));
			return dynamicWindow;
		}
		return null;
	}

	@Override
	public DynamicWindow getDynamicWindowByEventId(Long eventId) {
		return dynamicWindowRepository.getDynamicWindowByEventId(eventId);
	}

	@Override
	public PageInfo<DynamicWindow> qryWindowPageInfo(DynamicWindow window, int page, int pageSize) {
		return dynamicWindowRepository.qryWindowPageInfo(window, page, pageSize);
	}

	@Override
	public DynamicWindow getSimpleWindow(Long winId) {
		return dynamicWindowRepository.getSimpleWindow(winId);
	}

	@Override
	public void deleteWindow(Long windowId) {
		DynamicWindow dynamicWindow = dynamicWindowRepository.getSimpleWindow(windowId);
		if (dynamicWindow != null) {
			// 获取配置的所有组件
			List<DynamicComponent> comps = componentService.qryComponentsByWinId(windowId);
			if (comps != null && comps.size() > 0) {
				for (DynamicComponent comp : comps) {
					List<DynamicStyle> styles = styleService.qryStylesByComponentId(comp.getComponentId());
					if (styles != null && styles.size() > 0) {
						for (DynamicStyle style : styles) {
							style.remove();// 清除样式
						}
					}
					comp.remove();// 清除组件
				}
			}
			dynamicWindow.remove();// 删除窗体
		}

	}

	@Override
	public DynamicWindow saveTypeWindow(Long objId, String objType) {
		DynamicWindow window = new DynamicWindow(true);
		switch (objType) {
		case "event":
			window.setEventId(objId);
			// 保存事件类型窗体
			window.setWindowType(DyPageConstants.WIN_TYPE_EVENT_WIN.getValue() + "");
			window.setWindowCode("WIN_EVENT_" + window.getWindowId());
			break;
		case "part":
			// 保存构件类型窗体
			window.setWindowType(DyPageConstants.WIN_TYPE_PART_WIN.getValue() + "");
			window.setWindowCode("WIN_PART_" + window.getWindowId());
			break;
		case "tpl":
			// 模版窗体
			window.setTemplateId(objId);
			window.setWindowType(DyPageConstants.WIN_TYPE_TPL_WIN.getValue() + "");
			window.setWindowCode("WIN_TPL_" + window.getWindowId());
			break;
		default:
			return null;
		}
		window.setShardingId(window.getWindowId());
		window.setStatusCd("1000");
		window.save();
		return window;
	}

}

package com.ffcs.crmd.platform.meta.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.AttrSpecDTO;
import com.ffcs.crmd.platform.meta.api.dto.AttrValueDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicComponentDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicEventDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicPartDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicStyleDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicTemplateDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicWindowDTO;
import com.ffcs.crmd.platform.meta.api.facade.IDynamicPageFacade;
import com.ffcs.crmd.platform.meta.constants.DyPageConstants;
import com.ffcs.crmd.platform.meta.entity.AttrValue2;
import com.ffcs.crmd.platform.meta.entity.DynamicComponent;
import com.ffcs.crmd.platform.meta.entity.DynamicEvent;
import com.ffcs.crmd.platform.meta.entity.DynamicPart;
import com.ffcs.crmd.platform.meta.entity.DynamicStyle;
import com.ffcs.crmd.platform.meta.entity.DynamicTemplate;
import com.ffcs.crmd.platform.meta.entity.DynamicWindow;
import com.ffcs.crmd.platform.meta.repository.IDynamicEventRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicPartRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicTemplateRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicWindowRepository;
import com.ffcs.crmd.platform.meta.service.IAttrValueService2;
import com.ffcs.crmd.platform.meta.service.IDynamicComponentService;
import com.ffcs.crmd.platform.meta.service.IDynamicEventService;
import com.ffcs.crmd.platform.meta.service.IDynamicPartService;
import com.ffcs.crmd.platform.meta.service.IDynamicStyleService;
import com.ffcs.crmd.platform.meta.service.IDynamicTemplateService;
import com.ffcs.crmd.platform.meta.service.IDynamicWindowService;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

@Service("dynamicWindowFacade")
public class DynamicPageFacadeImpl extends AbstractCrmDomFacade implements IDynamicPageFacade {
	@Autowired
	IDynamicWindowService dynamicWindowService;
	@Autowired
	IAttrValueService2 ValueService;
	@Autowired
	IDynamicEventService eventService;
	@Autowired
	IDynamicStyleService styleService;
	@Autowired
	IDynamicComponentService componentService;
	@Autowired
	IDynamicPartService partService;
	@Autowired
	IDynamicTemplateRepository tplRepository;
	@Autowired
	IDynamicTemplateService tplService;
	@Autowired
	IDynamicWindowRepository windowRepository;
	@Autowired
	IDynamicPartRepository partRepository;
	@Autowired
	IDynamicEventRepository eventRepository;

	private static final String ACT_ADD = "add";
	private static final String ACT_DEL = "del";
	private static final String ACT_EDIT = "edit";

	@Override
	public DynamicWindowDTO getDynamicWindowDTO(String winCode) {

		DynamicWindowDTO dynamicWindowDTO = null;
		// 获取窗体
		DynamicWindow dynamicWindow = dynamicWindowService.getDynamicWindow(winCode);

		if (dynamicWindow != null) {
			// 对象拷贝
			dynamicWindowDTO = new DynamicWindowDTO();
			CrmBeanUtils.applyIf(dynamicWindowDTO, dynamicWindow);
			DynamicComponent component = dynamicWindow.getComponent();
			if (component != null) {
				// 拷贝组件
				DynamicComponentDTO componentDto = new DynamicComponentDTO();
				CrmBeanUtils.applyIf(componentDto, component);
				// setZtree(componentDto);
				// setComponetTpl(componentDto);
				// 设置组件属性信息
				componentDto = setComponentAttrs(componentDto, component);
				dynamicWindowDTO.setComponentDto(componentDto);
			}
		}

		return dynamicWindowDTO;
	}

	public DynamicComponentDTO setZtree(DynamicComponentDTO dto) {
		dto.setId(dto.getComponentId());
		dto.setpId(dto.getpComponentId());
		dto.setName(dto.getComponentName());
		return dto;
	}

	// 设置模版 201则为构件类型
	public void setCompTpl(DynamicComponentDTO dto) {
		if (!StringUtils.isNullOrEmpty(dto.getGroupCode()) && !"201".equals(dto.getComponentType())) {
			DynamicWindowDTO wDto = getDynamicWindowByTplCode(dto.getGroupCode());
			if (wDto != null) {
				dto.setTpl(getDynamicWindowDTO(wDto.getWindowCode()));
			}
		}
	}

	// 设置构件201则为构件类型
	public void setCompPart(DynamicComponentDTO dto) {
		if (!StringUtils.isNullOrEmpty(dto.getGroupCode()) && "201".equals(dto.getComponentType())) {
			DynamicPart part = partRepository.getDynamicPartByCode(dto.getGroupCode());
			if (part != null) {
				List<DynamicWindowDTO> wDtos = qrySimpleWindowByPartId(part.getPartId());
				if (wDtos != null && wDtos.size() > 0) {
					dto.setPart(getDynamicWindowDTO(wDtos.get(0).getWindowCode()));
				}
			}
		}
	}

	/**
	 * 设置(拷贝)样式，属性对象，属性值对象
	 * 
	 * @param dto
	 * @param component
	 * @return
	 */
	public DynamicComponentDTO setComponentAttrs(DynamicComponentDTO dto, DynamicComponent component) {

		// 拷贝子组件
		List<DynamicComponent> componentLists = component.getChildComponents();
		if (componentLists != null && componentLists.size() > 0) {
			dto.getChildren().addAll(recursionComponentDto(componentLists));
		}
		// 拷贝样式
		List<DynamicStyle> styleLists = component.getDynamicStyles();
		if (styleLists != null && styleLists.size() > 0) {
			List<DynamicStyleDTO> sDtoLists = CrmBeanUtils.copyList(styleLists, DynamicStyleDTO.class);
			dto.getDynamicStyleDtos().addAll(sDtoLists);
		}
		// 拷贝属性对象
		if (component.getAttrSpec2() != null) {
			AttrSpecDTO specDto = new AttrSpecDTO();
			CrmBeanUtils.applyIf(specDto, component.getAttrSpec2());
			dto.setAttrSpecDto(specDto);
		}
		// 拷贝属性值对象
		List<AttrValue2> value2s = component.getAttrValue2s();

		if (value2s != null && value2s.size() > 0) {
			List<AttrValueDTO> valueDtos = new ArrayList<AttrValueDTO>();
			if (value2s != null && value2s.size() > 0) {
				valueDtos = CrmBeanUtils.copyList(value2s, AttrValueDTO.class);
				dto.getAttrValueDtos().addAll(valueDtos);
			}
		}
		// 设置模版
		setCompTpl(dto);
		// 拷贝属性值对象
		setZtree(dto);
		// 设置构件
		setCompPart(dto);
		return dto;
	}

	/**
	 * 递归-数据
	 * 
	 * @param objs
	 * @return
	 */
	public List<DynamicComponentDTO> recursionComponentDto(List<DynamicComponent> objs) {
		List<DynamicComponentDTO> dtos = null;
		if (objs != null && objs.size() > 0) {
			dtos = CrmBeanUtils.copyList(objs, DynamicComponentDTO.class);
			for (int i = 0; i < dtos.size(); i++) {
				DynamicComponent comp = objs.get(i);
				DynamicComponentDTO dto = dtos.get(i);
				dto = setComponentAttrs(dto, comp);
			}
		}
		return dtos;
	}

	@Override
	public DynamicWindowDTO getMKTDynamicWindowDTO(Long busSpec, Long busService, Long busRegion) {
		// 获取窗体
		DynamicWindow dynamicWindow = dynamicWindowService.getDynamicWindow(busSpec, busService, busRegion, 0L);
		return dynamicWindow != null ? getDynamicWindowDTO(dynamicWindow.getWindowCode()) : null;
	}

	@Override
	public PageInfo<DynamicEventDTO> queryEventByBusspec(Long busSpec, int page, int pageSize) {
		PageInfo<DynamicEventDTO> pageInfoDto = new PageInfo<DynamicEventDTO>();
		// 获取事件配置信息
		PageInfo<DynamicEvent> pageInfo = eventService.queryEventsByBusspec(busSpec, page, pageSize);
		if (pageInfo != null) {
			CrmBeanUtils.applyIf(pageInfoDto, pageInfo);
			pageInfoDto.setTotal((int) pageInfo.getTotal());
			List<DynamicEventDTO> eventDtos = CrmBeanUtils.copyList(pageInfo.getList(), DynamicEventDTO.class);
			if (eventDtos != null && eventDtos.size() > 0) {
				pageInfoDto.setList(eventDtos);
			}
			return pageInfoDto;
		}
		return null;
	}

	@Override
	public int insertDyEvent(DynamicEventDTO eventDto) {
		DynamicEvent e = new DynamicEvent(true);
		Long id = e.getEventId();
		CrmBeanUtils.applyIf(e, eventDto);
		// 设置组件和分片建
		e.setEventId(id);
		e.setShardingId(id);
		// 保存默认窗体
		dynamicWindowService.saveTypeWindow(id, "event");

		return eventService.insertDyEvent(e);
	}

	@Override
	public int updateDyEvent(DynamicEventDTO eventDto) {
		DynamicEvent e = eventService.get(eventDto.getEventId());
		CrmBeanUtils.applyIf(e, eventDto);
		return eventService.updateDyEvent(e);
	}

	@Override
	public int deleteByEvent(Long id) {
		DynamicWindow window = dynamicWindowService.getDynamicWindowByEventId(id);
		// 删除窗体
		if (window != null) {
			dynamicWindowService.deleteWindow(window.getWindowId());
		}
		// 删除事件
		return eventService.deleteDyEvent(id);
	}

	@Override
	public DynamicEventDTO getDyEventById(Long eventId) {
		DynamicEvent e = eventService.get(eventId);
		if (e != null) {
			DynamicEventDTO dto = new DynamicEventDTO();
			CrmBeanUtils.applyIf(dto, e);
			return dto;
		}
		return null;
	}

	@Override
	public List<DynamicStyleDTO> qryDynamicStyles(Long id, String type) {
		List<DynamicStyle> styles = null;
		// 获取主题
		if (type != null && type.equals(DyPageConstants.STYLE_TYPE_THEME.getValue())) {
			styles = styleService.qryThemeStyles();
			// 获取子节点
		} else if (StringUtils.isNullOrEmpty(type) || (type != null && type.equals("table"))) {
			styles = styleService.qryChildStylesByPId(id);
		}
		if (styles != null && styles.size() > 0) {
			List<DynamicStyleDTO> dtos = new ArrayList<DynamicStyleDTO>();
			dtos = CrmBeanUtils.copyList(styles, DynamicStyleDTO.class);
			if (!type.equals("table")) {
				if (dtos != null && dtos.size() > 0) {
					for (DynamicStyleDTO dto : dtos) {
						// 是否存在孩子节点
						int i = styleService.qryCountByPId(dto.getStyleId());
						if (i > 0) {
							dto.setIsParent(true);
						}
					}
				}
			}
			return dtos;
		}

		return null;
	}

	@Override
	public int insertDyStyle(DynamicStyleDTO styleDto) {
		DynamicStyle style = new DynamicStyle(true);
		Long id = style.getStyleId();
		CrmBeanUtils.applyIf(style, styleDto);
		style.setStyleId(id);
		style.setShardingId(id);
		return styleService.insertDyStyle(style);
	}

	@Override
	public int updateDyStyle(DynamicStyleDTO styleDto) {
		DynamicStyle style = styleService.get(styleDto.getStyleId());
		CrmBeanUtils.applyIf(style, styleDto);
		return styleService.updateDyStyle(style);
	}

	@Override
	public int deleteDyStyle(Long id) {
		// 存在孩子节点，则不允许删除
		if (styleService.qryCountByPId(id) > 0) {
			return 0;
		} else {
			return styleService.deleteDyStyle(id);
		}
	}

	@Override
	public DynamicStyleDTO getDyStyleById(Long id) {
		DynamicStyle style = styleService.get(id);
		if (style != null) {
			DynamicStyleDTO styleDto = new DynamicStyleDTO();
			CrmBeanUtils.applyIf(styleDto, style);
			return styleDto;
		}
		return null;
	}

	@Override
	public List<DynamicStyleDTO> qryAllStyleTreeData() {
		List<DynamicStyle> styles = styleService.qryAllStyleTreeData();
		if (styles != null && styles.size() > 0) {
			List<DynamicStyleDTO> dtos = new ArrayList<DynamicStyleDTO>();
			dtos = CrmBeanUtils.copyList(styles, DynamicStyleDTO.class);
			// 设置父节点
			for (DynamicStyleDTO dto : dtos) {
				dto.setId(dto.getStyleId());
				dto.setpId(dto.getpStyleId());
				dto.setName(dto.getStyleName());
			}
			return dtos;
		}
		return null;
	}

	@Override
	public DynamicWindowDTO getDynamicWindowDtoByEventId(Long eventId) {
		DynamicWindow dynamicWindow = dynamicWindowService.getDynamicWindowByEventId(eventId);
		if (dynamicWindow != null) {
			return getDynamicWindowDTO(dynamicWindow.getWindowCode());
		}
		return null;
	}

	@Override
	public void handlePageData(DynamicComponentDTO handleData) {
		// 是否设置win
		// （事件类型）新窗体则，都是新增
		boolean isNewWin = false;
		if (handleData != null) {
			List<Long> dels = null;
			// 校验是否存在窗体--事件条件
			DynamicWindowDTO win = null;
			if ("event".equals(handleData.getObjType())) {
				win = getDynamicWindowDtoByEventId(handleData.getObjId());
			} else if ("window".equals(handleData.getObjType())) {
				// 窗体
				win = getSimpleWindow(handleData.getObjId());
			} else if ("part".equals(handleData.getObjType())) {
				List<DynamicWindowDTO> dtos = qrySimpleWindowByPartId(handleData.getObjId());
				if (!dtos.isEmpty()) {
					win = dtos.get(0);
				}
			} else if ("tpl".equals(handleData.getObjType())) {
				// 模版窗体
				win = getDynamicWindowByTplId(handleData.getObjId());
			}
			// 不存在保存--目前保存事件时默认保存一个事件窗体
			DynamicWindow window = null;
			if (win == null) {
				// 不存在保存
				window = new DynamicWindow(true);
				if (handleData.getObjType().equals("event")) {
					window.setEventId(handleData.getObjId());
					window.setWindowCode("WIN_EVENT_" + handleData.getObjId());
					window.setWindowName("WIN_EVENT_" + handleData.getObjId());
					// 保存事件类型窗体
					window.setWindowType(DyPageConstants.WIN_TYPE_EVENT_WIN.getValue() + "");
				} // 条件
				window.setShardingId(window.getWindowId());
				window.setStatusCd("1000");
				window.save();
				isNewWin = true;
			} else {
				window = DynamicWindow.repository().getById(win.getWindowId());
			}
			// 删除节点处理
			if (handleData.getDelCompents() != null && handleData.getDelCompents().size() > 0) {
				dels = new ArrayList<Long>();
				// 获取删除节点的信息和样式信息
				handleDelComponents(handleData.getDelCompents(), dels);
				componentService.deleteByIds(dels);
			}
			if (handleData.getChildren() != null && handleData.getChildren().size() > 0) {
				List<DynamicComponent> adds = new ArrayList<DynamicComponent>();
				List<DynamicComponent> edits = new ArrayList<DynamicComponent>();
				List<DynamicStyle> sadds = new ArrayList<DynamicStyle>();
				List<Long> sdels = new ArrayList<Long>();
				// 解析组件
				handleOpComponents(handleData.getChildren(), adds, edits, window, isNewWin, null);
				// 批量新增
				componentService.batchInsert(adds);
				// 批量更新
				componentService.batchUpdate(edits);
				// 解析样式
				handleOpStyles(handleData.getChildren(), sadds, sdels);
				// 批量新增颜色
				styleService.batchInsertStyle(sadds);
				// 批量删除样式
				styleService.batchDelSyles(sdels);
			}
		}
	}

	/**
	 * 处理删除节点信息-(统计所有删除的节点)
	 * 
	 * @param datas
	 */
	public void handleDelComponents(List<DynamicComponentDTO> dtos, List<Long> dels) {
		for (DynamicComponentDTO dto : dtos) {
			dels.add(dto.getComponentId());
			if (dto.getChildren() != null && dto.getChildren().size() > 0) {
				handleDelComponents(dto.getChildren(), dels);
			}
		}
	}

	/**
	 * 分离出要处理的组件数据
	 * 
	 * @param dtos
	 * @param adds
	 * @param edits
	 */
	public void handleOpComponents(List<DynamicComponentDTO> dtos, List<DynamicComponent> adds,
			List<DynamicComponent> edits, DynamicWindow window, boolean isNewWin, DynamicComponentDTO parent) {
		for (DynamicComponentDTO dto : dtos) {
			// 新增节点
			if (ACT_ADD.equals(dto.getOpType()) || isNewWin || dto.getComponentId() == -1) {
				DynamicComponent comp = new DynamicComponent(true);
				Long compId = comp.getComponentId();
				CrmBeanUtils.applyIf(comp, dto);
				comp.setWindowId(window.getWindowId());
				comp.setComponentId(compId);
				if ((isNewWin || dto.getComponentId() == -1) && parent != null) {
					comp.setpComponentId(parent.getComponentId());
				}
				// 回填(组件编号，提供给样式保存)
				dto.setComponentId(compId);
				adds.add(comp);
			} else if (ACT_EDIT.equals(dto.getOpType())) {
				DynamicComponent comp = new DynamicComponent();
				CrmBeanUtils.applyIf(comp, dto);
				// 没有挂在父节点下，则进行设置
				if (comp.getpComponentId() == null) {
					// 没有父节点，设置本事为父节点
					comp.setpComponentId(null);
				} else if (comp.getpComponentId() != null && Long.compare(comp.getpComponentId(), -1L) == 0) {
					// 父节点为新增节点
					comp.setpComponentId(parent.getComponentId());
				}
				edits.add(comp);
			}
			// 是否存在孩子节点
			if (dto.getChildren() != null && dto.getChildren().size() > 0) {
				// 递归处理
				handleOpComponents(dto.getChildren(), adds, edits, window, isNewWin, dto);
			}
		}
	}

	/**
	 * 分离出要处理的样式数据
	 * 
	 * @param dtos
	 * @param adds
	 * @param dels
	 */
	public void handleOpStyles(List<DynamicComponentDTO> dtos, List<DynamicStyle> adds, List<Long> dels) {
		for (DynamicComponentDTO dto : dtos) {
			if (dto.getDynamicStyleDtos() != null && dto.getDynamicStyleDtos().size() > 0) {
				for (DynamicStyleDTO style : dto.getDynamicStyleDtos()) {
					if (ACT_ADD.equals(style.getOpType())) {
						DynamicStyle s = new DynamicStyle(true);
						Long styleId = s.getStyleId();
						CrmBeanUtils.applyIf(s, style);
						s.setShardingId(styleId);
						s.setStyleId(styleId);
						// 组件和样式同时新增时，捞取组件创建对象时返回的ID；
						if (s.getComponentId() == -1) {
							s.setComponentId(dto.getComponentId());
						}
						adds.add(s);
					} else if (ACT_DEL.equals(style.getOpType())) {
						dels.add(style.getStyleId());
					}
				}

			}
			// 是否存在孩子节点，递归处理
			if (dto.getChildren() != null && dto.getChildren().size() > 0) {
				handleOpStyles(dto.getChildren(), adds, dels);
			}
		}
	}

	@Override
	public PageInfo<DynamicWindowDTO> qryWindowPageInfoByWin(DynamicWindowDTO dto, int page, int pageSize) {
		// 普通窗体
		dto.setWindowType(DyPageConstants.WIN_TYPE_WIN_WIN.getValue() + "");
		DynamicWindow window = new DynamicWindow();
		CrmBeanUtils.applyIf(window, dto);
		PageInfo<DynamicWindow> info = dynamicWindowService.qryWindowPageInfo(window, page, pageSize);
		if (info != null) {
			PageInfo<DynamicWindowDTO> infoDto = new PageInfo<DynamicWindowDTO>();
			CrmBeanUtils.applyIf(infoDto, info);
			infoDto.setList(CrmBeanUtils.copyList(info.getList(), DynamicWindowDTO.class));
			return infoDto;
		}
		return null;
	}

	@Override
	public int saveSimpleWindow(DynamicWindowDTO dto) {
		int ret = 0;
		if (dto.getWindowId() == null) {
			DynamicWindow window = new DynamicWindow(true);
			Long windowId = window.getWindowId();
			CrmBeanUtils.applyIf(window, dto);
			window.setWindowId(windowId);
			window.setShardingId(windowId);
			window.setStatusCd("1000");
			window.setWindowCode("WIN-" + windowId);
			ret = dynamicWindowService.save(window);// 保存
		} else {
			DynamicWindow window = dynamicWindowService.get(dto.getWindowId());
			CrmBeanUtils.applyIf(window, dto);
			ret = dynamicWindowService.update(window);// 更新
		}
		return ret;
	}

	@Override
	public DynamicWindowDTO getSimpleWindow(Long winId) {
		DynamicWindow window = dynamicWindowService.getSimpleWindow(winId);
		if (window != null) {
			DynamicWindowDTO dto = new DynamicWindowDTO();
			CrmBeanUtils.applyIf(dto, window);
			return dto;
		}
		return null;
	}

	@Override
	public void deleteWindow(Long windowId) {
		dynamicWindowService.deleteWindow(windowId);
	}

	@Override
	public List<DynamicPartDTO> qryParts() {
		List<DynamicPart> parts = partService.qryParts();
		if (parts != null && parts.size() > 0) {
			List<DynamicPartDTO> dtos = CrmBeanUtils.copyList(parts, DynamicPartDTO.class);
			return dtos;
		}
		return null;
	}

	@Override
	public PageInfo<DynamicPartDTO> qryPageInfoPart(DynamicPartDTO dto, int page, int pageSize) {
		if (dto != null) {
			DynamicPart part = new DynamicPart();
			CrmBeanUtils.applyIf(part, dto);
			PageInfo<DynamicPart> infos = partService.qryPageInfoPart(part, page, pageSize);
			PageInfo<DynamicPartDTO> pageInfo = new PageInfo<DynamicPartDTO>();
			if (infos != null) {
				CrmBeanUtils.applyIf(pageInfo, infos);
				if (infos.getList() != null && infos.getList().size() > 0) {
					List<DynamicPartDTO> dtos = CrmBeanUtils.copyList(infos.getList(), DynamicPartDTO.class);
					pageInfo.setList(dtos);
					return pageInfo;
				}
			}
		}
		return null;
	}

	@Override
	public void savePart(DynamicPartDTO dto) {
		if (dto.getPartId() == null) {
			// 保存
			DynamicPart part = new DynamicPart(true);
			Long partId = part.getPartId();
			CrmBeanUtils.applyIf(part, dto);
			part.setPartId(partId);
			part.setShardingId(partId);
			part.setStatusCd("1000");
			// 自动生成编码
			part.setPartCode("part-" + part.getPartId());
			partService.savePart(part);
		} else {
			// 更新
			DynamicPart part = partService.getByIdAndShardingId(dto.getPartId(), dto.getPartId());
			if (part != null) {
				CrmBeanUtils.applyIf(part, dto);
				part.setPartCode("g-" + part.getPartType());
				part.update();
			}
		}
	}

	@Override
	public void deletePart(Long partId) {
		partService.deletePart(partId);
	}

	@Override
	public DynamicPartDTO getSimplePart(Long partId) {
		DynamicPart part = partService.getByIdAndShardingId(partId, partId);
		if (part != null) {
			DynamicPartDTO dto = new DynamicPartDTO();
			CrmBeanUtils.applyIf(dto, part);
			return dto;
		}
		return null;
	}

	@Override
	public List<DynamicWindowDTO> qrySimpleWindowByPartId(Long partId) {
		List<DynamicWindow> windows = partService.qryWindowByPartId(partId);
		if (windows != null && windows.size() > 0) {
			return CrmBeanUtils.copyList(windows, DynamicWindowDTO.class);
		}
		return null;
	}

	@Override
	public PageInfo<DynamicTemplateDTO> qryTplPageInfo(DynamicTemplateDTO tpl, int page, int pageSize) {
		PageInfo<DynamicTemplateDTO> pageInfoDto = new PageInfo<DynamicTemplateDTO>();
		// 获取模版
		DynamicTemplate param = new DynamicTemplate();
		if (tpl != null) {
			CrmBeanUtils.applyIf(param, tpl);
		}
		PageInfo<DynamicTemplate> pageInfo = tplRepository.qryTplPageInfo(param, page, pageSize);
		if (pageInfo != null) {
			CrmBeanUtils.applyIf(pageInfoDto, pageInfo);
			pageInfoDto.setTotal((int) pageInfo.getTotal());
			List<DynamicTemplateDTO> tpls = CrmBeanUtils.copyList(pageInfo.getList(), DynamicTemplateDTO.class);
			if (tpls != null && tpls.size() > 0) {
				pageInfoDto.setList(tpls);
			}
			return pageInfoDto;
		}
		return null;

	}

	@Override
	public DynamicTemplateDTO getTplByCode(String code) {
		DynamicTemplate tpl = tplRepository.getTplByCode(code);
		if (tpl != null) {
			DynamicTemplateDTO dto = new DynamicTemplateDTO();
			CrmBeanUtils.applyIf(dto, tpl);
			return dto;
		}
		return null;
	}

	@Override
	public void saveTpl(DynamicTemplateDTO tplDto) {
		if (tplDto != null && tplDto.getTemplateId() == null) {
			DynamicTemplate tpl = new DynamicTemplate(true);
			long id = tpl.getTemplateId();
			CrmBeanUtils.applyIf(tpl, tplDto);
			tpl.setTemplateId(id);
			tpl.setShardingId(id);
			tpl.setTemplateCode(tplDto.getTemplateType() + "-" + id);
			tplService.saveTpl(tpl);
		} else {
			this.updateTpl(tplDto);
		}

	}

	@Override
	public void delTpl(Long id) {
		tplService.delTpl(id);
	}

	@Override
	public void updateTpl(DynamicTemplateDTO tplDto) {
		DynamicTemplate tpl = new DynamicTemplate();
		DynamicTemplate tp = DynamicTemplate.repository().getByIdAndShardingId(tplDto.getTemplateId(),
				tplDto.getTemplateId());
		if (!tplDto.getTemplateType().equals(tp.getTemplateType())) {
			// 抛异常
			ExceptionUtils.throwEx(new BaseAppException("不允许更改类型!"));
		}
		CrmBeanUtils.applyIf(tpl, tplDto);
		tpl.update();
	}

	@Override
	public DynamicTemplateDTO getTplById(Long id) {
		DynamicTemplate tpl = DynamicTemplate.repository().getByIdAndShardingId(id, id);
		if (tpl != null) {
			DynamicTemplateDTO dto = new DynamicTemplateDTO();
			CrmBeanUtils.applyIf(dto, tpl);
			return dto;
		}
		return null;
	}

	@Override
	public DynamicWindowDTO getDynamicWindowByTplId(Long tplId) {
		DynamicWindow window = windowRepository.getDynamicWindowByTplId(tplId);
		if (window != null) {
			DynamicWindowDTO dto = new DynamicWindowDTO();
			CrmBeanUtils.applyIf(dto, window);
			return dto;
		}
		return null;
	}

	@Override
	public List<DynamicTemplateDTO> qryTplListsByType(String type) {
		List<DynamicTemplate> tpls = tplRepository.qryTplListsByType(type);
		if (!tpls.isEmpty()) {
			return CrmBeanUtils.copyList(tpls, DynamicTemplateDTO.class);
		}
		return null;
	}

	@Override
	public DynamicWindowDTO getDynamicWindowByTplCode(String code) {
		DynamicWindow window = windowRepository.getDynamicWindowByTplCode(code);
		if (window != null) {
			DynamicWindowDTO dto = new DynamicWindowDTO();
			CrmBeanUtils.applyIf(dto, window);
			return dto;
		}
		return null;

	}

	@Override
	public DynamicWindowDTO getDynamicWindowDto(String busType, Long busSpec, Long busObjId, Long busRegion,
			Long busService, Long busChannel) {
		DynamicWindow win = windowRepository.getDynamicWindow(busType, busSpec, busObjId, busRegion, busService,
				busChannel);
		if (win != null) {
			return getDynamicWindowDTO(win.getWindowCode());
		}
		return null;
	}

	@Override
	public PageInfo<DynamicEventDTO> queryPageInfoEvents(String busType, Long busSpec, Long busObjId, Long busRegion,
			Long busService, Long busChannel, int page, int pageSize) {
		PageInfo<DynamicEvent> pageInfo = eventService.queryPageInfoEvents(busType, busSpec, busObjId, busRegion,
				busService, busChannel, page, pageSize);
		if (pageInfo != null) {
			PageInfo<DynamicEventDTO> pageInfoDto = new PageInfo<DynamicEventDTO>();
			CrmBeanUtils.applyIf(pageInfoDto, pageInfo);
			pageInfoDto.setTotal((int) pageInfo.getTotal());
			List<DynamicEventDTO> tpls = CrmBeanUtils.copyList(pageInfo.getList(), DynamicEventDTO.class);
			if (tpls != null && tpls.size() > 0) {
				pageInfoDto.setList(tpls);
			}
			return pageInfoDto;
		}

		return null;
	}
}

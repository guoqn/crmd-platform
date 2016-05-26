package com.ffcs.crmd.platform.meta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrSpec2;
import com.ffcs.crmd.platform.meta.entity.AttrValue2;
import com.ffcs.crmd.platform.meta.entity.DynamicComponent;
import com.ffcs.crmd.platform.meta.entity.DynamicStyle;
import com.ffcs.crmd.platform.meta.repository.IAttrSpec2Repository;
import com.ffcs.crmd.platform.meta.repository.IAttrValue2Repository;
import com.ffcs.crmd.platform.meta.repository.IDynamicComponentRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicEventRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicStyleRepository;
import com.ffcs.crmd.platform.meta.service.IDynamicComponentService;

@Service("dynamicComponentService")
public class DynamicComponentServiceImpl extends AbstractCrmDomGenericService<DynamicComponent, Long>
		implements IDynamicComponentService {

	@Autowired
	IDynamicComponentRepository dynamicComponentRepository;
	@Autowired
	IDynamicStyleRepository styleRepository;
	@Autowired
	IDynamicEventRepository eventRepository;
	@Autowired
	IAttrSpec2Repository specRepository;
	@Autowired
	IAttrValue2Repository valueRepository;

	@Override
	public DynamicComponent getRootComponent(Long winId) {
		// 获取父节点组件
		DynamicComponent pComponent = dynamicComponentRepository.getRootComponentByWinId(winId);
		// 判定元数据
		pComponent = setComponentAttr(pComponent);
		return getChildComponents(pComponent);
	}

	/**
	 * 获取子集组件(递归获取所以节点)
	 * 
	 * @param pId
	 * @return
	 */
	public DynamicComponent getChildComponents(DynamicComponent component) {
		if (component != null) {
			List<DynamicComponent> childComponents = dynamicComponentRepository
					.qryChildComponentByPId(component.getComponentId());
			if (childComponents != null && childComponents.size() > 0) {
				for (DynamicComponent chcomponent : childComponents) {
					// 判定元数据
					chcomponent = setComponentAttr(chcomponent);
					component.getChildComponents().add(getChildComponents(chcomponent));
				}
			}
		}
		return component;
	}

	/**
	 * 获取元数据信息
	 * 
	 * @param component
	 * @return
	 */
	public DynamicComponent setComponentAttr(DynamicComponent component) {
		// 判定元数据
		if (component != null && component.getBusAttrId() != null) {
			/** 获取主数据 */
			AttrSpec2 attrSpec = specRepository.getById(component.getBusAttrId());
			if (attrSpec != null) {
				component.setAttrSpec2(attrSpec);
				List<AttrValue2> values = valueRepository.qryAttrValuesByAttrId(attrSpec.getAttrId());
				if (values != null && values.size() > 0) {
					component.getAttrValue2s().addAll(values);
				}
			}
		}
		if (component != null) {
			// 设置父节点样式
			List<DynamicStyle> styles = styleRepository.qryDynamicStyleByCompId(component.getComponentId(), "");
			if (styles != null && styles.size() > 0) {
				// 设置样式
				component.getDynamicStyles().addAll(styles);
			}
		}
		return component;
	}

	@Override
	public int deleteById(Long id) {
		DynamicComponent component = dynamicComponentRepository.getById(id);
		List<DynamicStyle> styles = styleRepository.qryDynamicStyleByCompId(component.getComponentId(), "");
		// 查找样式，并一并删除
		if (styles != null && styles.size() > 0) {
			for (DynamicStyle s : styles) {
				s.remove();
			}
		}
		return this.remove(component);
	}

	@Override
	public int deleteByIds(List<Long> ids) {
		if (ids != null && ids.size() > 0) {
			for (Long id : ids) {
				deleteById(id);
			}
		}
		return 1;
	}

	@Override
	public int insertComponent(DynamicComponent comp) {
		return this.save(comp);
	}

	@Override
	public void batchInsert(List<DynamicComponent> comps) {
		if (comps != null && comps.size() > 0) {
			for (DynamicComponent comp : comps) {
				comp.setStatusCd("1000");
				comp.setShardingId(comp.getComponentId());
				insertComponent(comp);
			}
		}

	}

	@Override
	public int updateComponent(DynamicComponent comp) {
		return this.update(comp);
	}

	@Override
	public void batchUpdate(List<DynamicComponent> comps) {
		if (comps != null && comps.size() > 0) {
			for (DynamicComponent comp : comps) {
				updateComponent(comp);
			}
		}
	}

	@Override
	public List<DynamicComponent> qryComponentsByWinId(Long windowId) {
		return dynamicComponentRepository.qryComponentsByWinId(windowId);
	}

}

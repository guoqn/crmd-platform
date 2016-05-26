package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.DyPageConstants;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicStyle;
import com.ffcs.crmd.platform.meta.repository.IDynamicStyleRepository;

@Repository("dynamicStyleRepository")
public class DynamicStyleRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicStyle, Long>
		implements IDynamicStyleRepository {

	public DynamicStyleRepositoryImpl() {
		super(DynamicStyle.class);
	}

	@Override
	public List<DynamicStyle> qryDynamicStyleByCompId(Long componentId, String styleType) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (componentId == 0) {
			return null;
		}
		params.put("componentId", componentId);
		if (!StringUtils.isNullOrEmpty(styleType)) {
			params.put("styleType", styleType);
		}
		// 有效状态
		params.put("statusCd", MetaConstants.STATUS.META_STATUS_VALID);
		return this.queryListByName("dynamicStyleRepository.qryDynamicStyleByCompId", DynamicStyle.class, params);
	}

	@Override
	public List<DynamicStyle> qryThemeStyles() {
		List<Object> params = new ArrayList<Object>();
		// 主题样式
		params.add(DyPageConstants.STYLE_TYPE_THEME.getValue());
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicStyleRepository.qryThemeStyles", DynamicStyle.class, params);
	}

	@Override
	public List<DynamicStyle> qryChildStylesByPId(Long pId) {
		List<Object> params = new ArrayList<Object>();
		// 子节点
		params.add(pId);
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicStyleRepository.quryChildStylesByPId", DynamicStyle.class, params);

	}

	@Override
	public int qryCountByPId(Long pId) {
		return this.jdbcQueryForIntByName("dynamicStyleRepository.qryCountByPId", pId,
				MetaConstants.STATUS.META_STATUS_VALID);
	}

	@Override
	public List<DynamicStyle> qryAllStyleTreeData() {
		List<Object> params = new ArrayList<Object>();
		// 有效
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicStyleRepository.qryAllStyleTreeData", DynamicStyle.class, params);
	}

	@Override
	public List<DynamicStyle> qryStylesByComponentId(Long componentId) {
		List<Object> params = new ArrayList<Object>();
		// 有效
		params.add(componentId);
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicStyleRepository.qryStylesByComponentId", DynamicStyle.class, params);
	}

}

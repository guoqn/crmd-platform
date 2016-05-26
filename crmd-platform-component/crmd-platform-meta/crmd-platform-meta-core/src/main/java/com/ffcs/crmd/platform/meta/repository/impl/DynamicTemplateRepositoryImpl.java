package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicTemplate;
import com.ffcs.crmd.platform.meta.repository.IDynamicTemplateRepository;

@Repository("dynamicTemplateRepository")
public class DynamicTemplateRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicTemplate, Long>
		implements IDynamicTemplateRepository {

	public DynamicTemplateRepositoryImpl() {
		super(DynamicTemplate.class);
	}

	@Override
	public PageInfo<DynamicTemplate> qryTplPageInfo(DynamicTemplate tpl, int page, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();

		if (!StringUtils.isNullOrEmpty(tpl.getTemplateName())) {
			params.put("templateName", tpl.getTemplateName());
		}
		if (!StringUtils.isNullOrEmpty(tpl.getTemplateCode())) {
			params.put("templateCode", tpl.getTemplateCode());
		}
		// 有效状态
		params.put("statusCd", MetaConstants.STATUS.META_STATUS_VALID);
		return this.queryPageInfoByName("dynamicTemplateRepository.qryTplPageInfo", DynamicTemplate.class, params, page,
				pageSize);
	}

	@Override
	public DynamicTemplate getTplByCode(String code) {
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isNullOrEmpty(code)) {
			params.add(code);
			params.add(MetaConstants.STATUS.META_STATUS_VALID);
			List<DynamicTemplate> tpls = this.jdbcFindListByName("dynamicTemplateRepository.getTplByCode",
					DynamicTemplate.class, params);
			if (tpls != null && tpls.size() > 0) {
				return tpls.get(0);
			}
		}
		return null;
	}

	@Override
	public List<DynamicTemplate> qryTplListsByType(String type) {
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isNullOrEmpty(type)) {
			params.add(type);
			params.add(MetaConstants.STATUS.META_STATUS_VALID);
			return this.jdbcFindListByName("dynamicTemplateRepository.qryTplListsByType", DynamicTemplate.class,
					params);
		}
		return null;
	}

}

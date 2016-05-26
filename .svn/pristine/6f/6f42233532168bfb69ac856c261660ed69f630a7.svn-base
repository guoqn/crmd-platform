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
import com.ffcs.crmd.platform.meta.entity.DynamicPart;
import com.ffcs.crmd.platform.meta.repository.IDynamicPartRepository;

@Repository("dynamicPartRepository")
public class DynamicPartRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicPart, Long>
		implements IDynamicPartRepository {

	public DynamicPartRepositoryImpl() {
		super(DynamicPart.class);
	}

	@Override
	public List<DynamicPart> qryParts() {
		List<Object> params = new ArrayList<Object>();
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicPartRepository.qryParts", DynamicPart.class, params);
	}

	@Override
	public PageInfo<DynamicPart> qryPageInfoPart(DynamicPart part, int page, int pageSize) {
		if (part != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			if (!StringUtils.isNullOrEmpty(part.getPartName())) {
				params.put("partName", part.getPartName());
			}
			if (!StringUtils.isNullOrEmpty(part.getPartType())) {
				params.put("partType", part.getPartType());
			}
			params.put("statusCd", MetaConstants.STATUS.META_STATUS_VALID);

			return this.queryPageInfoByName("dynamicPartRepository.qryPageInfoPart", DynamicPart.class, params, page,
					pageSize);
		}
		return null;
	}

	@Override
	public DynamicPart getDynamicPartByCode(String code) {
		if (StringUtils.isNullOrEmpty(code)) {
			return null;
		}
		List<Object> params = new ArrayList<Object>();
		params.add(code);
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		List<DynamicPart> lists = this.jdbcFindListByName("dynamicPartRepository.getDynamicPartByCode",
				DynamicPart.class, params);
		return (!lists.isEmpty()) ? lists.get(0) : null;
	}

}

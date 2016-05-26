package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicTempPartRel;
import com.ffcs.crmd.platform.meta.repository.IDynamicTempPartRelRepository;

@Repository("dynamicTempPartRelRepository")
public class DynamicTempPartRelRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicTempPartRel, Long>
		implements IDynamicTempPartRelRepository {

	public DynamicTempPartRelRepositoryImpl() {
		super(DynamicTempPartRel.class);
	}

	@Override
	public List<DynamicTempPartRel> qryTplPartRels(Long tplId) {
		if (tplId == 0) {
			return null;
		}
		List<Object> params = new ArrayList<Object>();
		params.add(tplId);
		// 有效状态
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicTempPartRelRepository.qryTplPartRels", DynamicTempPartRel.class, params);
	}

}

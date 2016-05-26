package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicPartWinRel;
import com.ffcs.crmd.platform.meta.repository.IDynamicPartWinRelRepository;

@Repository("dynamicPartWinRelRepository")
public class DynamicPartWinRelRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicPartWinRel, Long>
		implements IDynamicPartWinRelRepository {

	public DynamicPartWinRelRepositoryImpl() {
		super(DynamicPartWinRel.class);
	}

	@Override
	public List<DynamicPartWinRel> qryRelsByPartId(Long partId) {
		List<Object> params = new ArrayList<Object>();
		if (partId == null || partId == 0) {
			return null;
		}
		params.add(partId);
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicPartWinRelRepository.qryRelsByPartId", DynamicPartWinRel.class, params);
	}

}

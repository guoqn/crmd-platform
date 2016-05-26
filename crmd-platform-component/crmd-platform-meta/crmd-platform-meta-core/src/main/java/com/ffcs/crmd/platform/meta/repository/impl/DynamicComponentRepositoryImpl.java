package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.DynamicComponent;
import com.ffcs.crmd.platform.meta.repository.IDynamicComponentRepository;

@Repository("dynamicComponentRepository")
public class DynamicComponentRepositoryImpl extends AbstractCrmDomBaseRepository<DynamicComponent, Long>
		implements IDynamicComponentRepository {

	public DynamicComponentRepositoryImpl() {
		super(DynamicComponent.class);
	}

	@Override
	public DynamicComponent getRootComponentByWinId(Long winId) {
		List<Object> params = new ArrayList<Object>();
		if (winId == 0) {
			return null;
		}
		params.add(winId);
		// 有效状态
		params.add(MetaConstants.STATUS.META_STATUS_VALID);

		List<DynamicComponent> results = this.jdbcFindListByName("dynamicComponentRepository.getRootComponentByWinId",
				DynamicComponent.class, params);

		if (results != null && results.size() == 1) {
			return results.get(0);
		}

		return null;
	}

	@Override
	public List<DynamicComponent> qryChildComponentByPId(Long pId) {
		List<Object> params = new ArrayList<Object>();
		if (pId == 0) {
			return null;
		}
		params.add(pId);
		// 有效状态
		params.add(MetaConstants.STATUS.META_STATUS_VALID);

		List<DynamicComponent> results = this.jdbcFindListByName("dynamicComponentRepository.qryChildComponentByPId",
				DynamicComponent.class, params);

		return results;
	}

	@Override
	public List<DynamicComponent> qryComponentsByWinId(Long windowId) {
		List<Object> params = new ArrayList<Object>();
		if (windowId == 0) {
			return null;
		}
		params.add(windowId);
		// 有效状态
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("dynamicComponentRepository.qryComponentsByWinId", DynamicComponent.class,
				params);
	}

}

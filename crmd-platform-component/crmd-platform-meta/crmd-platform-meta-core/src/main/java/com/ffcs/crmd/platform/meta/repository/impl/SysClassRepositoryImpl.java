package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.SysClass;
import com.ffcs.crmd.platform.meta.repository.ISysClassRepository;

@Repository("sysClassRepository")
public class SysClassRepositoryImpl extends AbstractCrmDomBaseRepository<SysClass, Long>
		implements ISysClassRepository {

	public SysClassRepositoryImpl() {
		super(SysClass.class);
	}

	@Override
	public List<SysClass> getSysClssByCode(String clsCode) {
		List<Object> params = new ArrayList<Object>();
		params.add(clsCode);
		// 有效
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("sysClassRepository.getSysClssByCode", SysClass.class, params);
	}

}

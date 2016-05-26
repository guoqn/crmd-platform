package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.SysClass;
import com.ffcs.crmd.platform.meta.repository.IAttrSpecRepository;
import com.ffcs.crmd.platform.meta.repository.ISysClassRepository;

@Repository("attrSpecRepository")
public class AttrSpecRepositoryImpl extends AbstractCrmDomBaseRepository<AttrSpec, Long>
		implements IAttrSpecRepository {

	@Autowired
	ISysClassRepository classRepository;

	public AttrSpecRepositoryImpl() {
		super(AttrSpec.class);
	}

	@Override
	public List<AttrSpec> getAttrSpecsByClassId(Long classId) {
		List<Object> params = new ArrayList<Object>();
		params.add(classId);
		// 有效
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("attrSpecRepository.getAttrSpecsByClassId", AttrSpec.class, params);
	}

	@Override
	public List<AttrSpec> getAttrSpecsByCode(String clsCode, String javaCode) {
		List<Object> params = new ArrayList<Object>();
		List<SysClass> clss = classRepository.getSysClssByCode(clsCode);
		if (clss != null && clss.size() > 0) {
			params.add(clss.get(0).getClassId());
		} else {
			return null;
		}
		params.add(javaCode);
		// 有效
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("attrSpecRepository.getAttrSpecsByCode", AttrSpec.class, params);

	}
}

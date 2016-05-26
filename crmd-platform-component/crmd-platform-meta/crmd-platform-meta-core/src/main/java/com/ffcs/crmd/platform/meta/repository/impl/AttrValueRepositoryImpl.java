package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.meta.repository.IAttrSpecRepository;
import com.ffcs.crmd.platform.meta.repository.IAttrValueRepository;

@Repository("attrValueRepository")
public class AttrValueRepositoryImpl extends AbstractCrmDomBaseRepository<AttrValue, Long>
		implements IAttrValueRepository {

	@Autowired
	IAttrSpecRepository attrSpecRepository;

	public AttrValueRepositoryImpl() {
		super(AttrValue.class);
	}

	@Override
	public List<AttrValue> getAttrValuesByCode(String clsCode, String javaCode) {
		List<Object> params = new ArrayList<Object>();
		List<AttrSpec> specs = attrSpecRepository.getAttrSpecsByCode(clsCode, javaCode);
		if (specs != null && specs.size() > 0) {
			params.add(specs.get(0).getAttrId());
		} else {
			return null;
		}
		// 有效
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("attrValueRepository.getAttrValuesByCode", AttrValue.class, params);
	}

}

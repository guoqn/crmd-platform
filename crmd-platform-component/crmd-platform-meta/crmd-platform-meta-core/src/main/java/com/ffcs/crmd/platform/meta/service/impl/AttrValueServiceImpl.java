package com.ffcs.crmd.platform.meta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.meta.repository.IAttrValueRepository;
import com.ffcs.crmd.platform.meta.service.IAttrValueService;

@Service("attrvalueService")
public class AttrValueServiceImpl extends AbstractCrmDomGenericService<AttrValue, Long> implements IAttrValueService {

	@Autowired
	IAttrValueRepository attrValueRepository;

	@Override
	public List<AttrValue> getAttrValuesByCode(String clsCode, String javaCode) {
		return attrValueRepository.getAttrValuesByCode(clsCode, javaCode);
	}

	@Override
	public AttrValue getById(Long attrValueId) {
		return attrValueRepository.getById(attrValueId);
	}

}

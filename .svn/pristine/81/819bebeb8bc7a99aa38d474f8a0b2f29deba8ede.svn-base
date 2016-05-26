package com.ffcs.crmd.platform.meta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.repository.IAttrSpecRepository;
import com.ffcs.crmd.platform.meta.service.IAttrSpecService;

@Service("attrspecService")
public class AttrSpecServiceImpl extends AbstractCrmDomGenericService<AttrSpec, Long> implements IAttrSpecService {

	@Autowired
	IAttrSpecRepository attrSpecRepository;

	@Override
	public List<AttrSpec> getAttrSpecsByClassId(Long classId) {
		return attrSpecRepository.getAttrSpecsByClassId(classId);
	}

	@Override
	public List<AttrSpec> getAttrSpecsByCode(String clsCode, String javaCode) {
		return attrSpecRepository.getAttrSpecsByCode(clsCode, javaCode);
	}

	@Override
	public AttrSpec getById(Long attrId) {
		return attrSpecRepository.getById(attrId);
	}

}

package com.ffcs.crmd.platform.meta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysClass;
import com.ffcs.crmd.platform.meta.repository.ISysClassRepository;
import com.ffcs.crmd.platform.meta.service.ISysClassService;

@Service("sysClassService")
public class SysClassServiceImpl extends AbstractCrmDomGenericService<SysClass, Long> implements ISysClassService {

	@Autowired
	ISysClassRepository sysClassRepository;

	@Override
	public List<SysClass> getSysClssByCode(String clsCode) {
		return sysClassRepository.getSysClssByCode(clsCode);
	}

	@Override
	public SysClass getById(Long classId) {
		return sysClassRepository.getById(classId);
	}

}

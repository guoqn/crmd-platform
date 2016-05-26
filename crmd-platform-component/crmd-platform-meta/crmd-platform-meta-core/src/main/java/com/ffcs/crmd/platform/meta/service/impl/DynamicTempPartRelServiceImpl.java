package com.ffcs.crmd.platform.meta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicTempPartRel;
import com.ffcs.crmd.platform.meta.repository.IDynamicTempPartRelRepository;
import com.ffcs.crmd.platform.meta.service.IDynamicTempPartRelService;

@Service("dynamicTempPartRelService")
public class DynamicTempPartRelServiceImpl extends AbstractCrmDomGenericService<DynamicTempPartRel, Long>
    implements IDynamicTempPartRelService {

   	@Autowired
	IDynamicTempPartRelRepository dynamicTempPartRelRepository;
}

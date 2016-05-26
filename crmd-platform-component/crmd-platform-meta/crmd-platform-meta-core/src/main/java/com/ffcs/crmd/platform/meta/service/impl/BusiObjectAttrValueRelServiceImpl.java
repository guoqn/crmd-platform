package com.ffcs.crmd.platform.meta.service.impl;

import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.BusiObjectAttrValueRel;
import com.ffcs.crmd.platform.meta.repository.IBusiObjectAttrValueRelRepository;
import com.ffcs.crmd.platform.meta.service.IBusiObjectAttrValueRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjectAttrValueRelService")
public class BusiObjectAttrValueRelServiceImpl
    extends AbstractCrmDomGenericService<BusiObjectAttrValueRel, Long>
    implements IBusiObjectAttrValueRelService {

    @Autowired
    IBusiObjectAttrValueRelRepository busiObjectAttrValueRelRepository;
}

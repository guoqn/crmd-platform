package com.ffcs.crmd.platform.meta.facade.impl;

import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.facade.IBusiObjAttrRelFacade;
import com.ffcs.crmd.platform.meta.service.IBusiObjAttrRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjAttrRelFacade")
public class BusiObjAttrRelFacadeImpl extends AbstractCrmDomFacade
    implements IBusiObjAttrRelFacade {
    @Autowired
    IBusiObjAttrRelService busiObjAttrRelService;
}

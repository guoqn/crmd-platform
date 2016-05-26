package com.ffcs.crmd.platform.core.dao.facade.impl;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

public abstract class AbstractCrmFacade implements ICrmBaseFacade {
    protected ILogger logger = LoggerFactory.getLogger(this.getClass());
    
    protected CrmSessionContext getContext() {
        return CrmSessionContext.getContext();
    }
}

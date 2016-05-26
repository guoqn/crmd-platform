package com.ffcs.crmd.platform.core.ddd.facade.impl;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.core.ddd.api.facade.IDomBaseFacade;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

public class AbstractCrmDomFacade implements IDomBaseFacade {
    protected ILogger logger = LoggerFactory.getLogger(this.getClass());
    
    protected CrmSessionContext getContext() {
        return CrmSessionContext.getContext();
    }

}

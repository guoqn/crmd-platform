package com.ffcs.crmd.platform.core.ddd.repository;

import java.io.Serializable;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;

@SuppressWarnings("rawtypes")
public class RepositoryRegister {
    public static final String   PLATFORM_DEFAULT_REPO = "platformDefaultRepository";
    
    public static final String   DEFAULT_REPO          = "defaultRepository";
    
    private static final ILogger LOG                   = LoggerFactory
                                                           .getLogger(RepositoryFactory.class);
    
    private static class RepositoryRegisterHolder {
        private static RepositoryRegister INSTANCE = new RepositoryRegister();
    }
    
    public static RepositoryRegister getInstance() {
        return RepositoryRegisterHolder.INSTANCE;
    }
    
    private RepositoryFactory factory;
    
    private RepositoryRegister() {
        factory = new RepositoryFactory();
    }
    
    public <T extends AbstractCrmDomBaseEntityImpl<I>, I extends Serializable> ICrmDomBaseRepository<T, I> getRepository(
        final Class<T> c) {
        return factory.getRepository(c);
    }
    
    public ICrmDomBaseRepository getDefaultRepository() {
        if (ApplicationContextUtil.containsBean(DEFAULT_REPO)) {
            return ApplicationContextUtil.getBean(DEFAULT_REPO);
        } else if (ApplicationContextUtil.containsBean(PLATFORM_DEFAULT_REPO)) {
            return ApplicationContextUtil.getBean(PLATFORM_DEFAULT_REPO);
        }
        LOG.error("defaultRepository没有注入");
        return null;
    }
}

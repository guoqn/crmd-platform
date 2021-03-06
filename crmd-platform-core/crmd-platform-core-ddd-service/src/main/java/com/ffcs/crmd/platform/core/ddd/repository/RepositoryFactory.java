package com.ffcs.crmd.platform.core.ddd.repository;

import java.io.Serializable;

import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.pub.dats.DataServiceUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.StringUtils;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;

public class RepositoryFactory {

    private static final ILogger LOG = LoggerFactory.getLogger(RepositoryFactory.class);

    public <T extends AbstractCrmDomBaseEntityImpl<I>, I extends Serializable> ICrmDomBaseRepository<T, I> getRepository(
        Class<T> c) {
        ICrmDomBaseRepository<T, I> rep = null;

        // 0. 从Spring上下文中获取
        String repositoryName = StringUtils.uncapitalize(c.getSimpleName() + "Repository");

        String proxyRepositoryName = repositoryName + "Proxy";

        try {
            if (DataServiceUtils.isOpenDataService() && ApplicationContextUtil
                .containsBean(proxyRepositoryName)) {
                rep = ApplicationContextUtil.getBean(proxyRepositoryName);
            } else {
                rep = ApplicationContextUtil.getBean(repositoryName);
            }
            return rep;
        } catch (BeansException nb) {
            LOG.debug("Spring上下文中未配置仓库：" + repositoryName);
        }

        // 4. 获得默认工厂
        rep = this.getDefaultRepository(c);
        return rep;
    }

    protected <T extends AbstractCrmDomBaseEntityImpl<I>, I extends Serializable> ICrmDomBaseRepository<T, I> getDefaultRepository(
        final Class<T> c) {
        //        IBaseRepository<T, I> result = ApplicationContextUtil.getBean("defaultRepository");
        ICrmDomBaseRepository<T, I> result = RepositoryRegister.getInstance()
            .getDefaultRepository();
        result.setRepositoryClass(c);
        return result;
    }

}

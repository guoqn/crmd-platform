package com.ffcs.crmd.platform.core.ddd.repository.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ctg.itrdc.platform.pub.sqlext.SqlRegister;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegisterFactory;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;

@SuppressWarnings("rawtypes")
@Repository("defaultRepository")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CrmDefaultDomRepository extends AbstractCrmDomBaseRepository<AbstractCrmDomBaseEntityImpl, Long> {

	protected SqlRegister sqlRegister = SqlRegisterFactory.getSqlRegister();

	public CrmDefaultDomRepository() {
		super(AbstractCrmDomBaseEntityImpl.class);
	}

	public CrmDefaultDomRepository(Class<AbstractCrmDomBaseEntityImpl> repositoryClass) {
		super(repositoryClass);
	}

}

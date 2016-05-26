package com.ffcs.crmd.platform.idempotency.core.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.ProdInst;
import com.ffcs.crmd.platform.idempotency.core.repository.IProdInstRepository;

@Repository("prodInstRepository")
public class ProdInstRepositoryImpl extends AbstractCrmDomBaseRepository<ProdInst, Long>
    implements IProdInstRepository {
    
    public ProdInstRepositoryImpl() {
        super(ProdInst.class);
    }
    
}

package com.ffcs.crmd.platform.idempotency.core.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.Cust;
import com.ffcs.crmd.platform.idempotency.core.repository.ICustRepository;

@Repository("custRepository")
public class CustRepositoryImpl extends AbstractCrmDomBaseRepository<Cust, Long>
    implements ICustRepository {
    
    public CustRepositoryImpl() {
        super(Cust.class);
    }
    
}

package com.ffcs.crmd.platform.idempotency.core.repository;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.ProdInst;

public interface IProdInstRepository extends ICrmDomBaseRepository<ProdInst, Long> {
    
}

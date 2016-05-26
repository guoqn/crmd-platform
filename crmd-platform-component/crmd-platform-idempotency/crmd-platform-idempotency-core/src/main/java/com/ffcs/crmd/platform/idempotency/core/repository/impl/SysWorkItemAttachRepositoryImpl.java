package com.ffcs.crmd.platform.idempotency.core.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkItemAttach;
import com.ffcs.crmd.platform.idempotency.core.repository.ISysWorkItemAttachRepository;

@Repository("sysWorkItemAttachRepository")
public class SysWorkItemAttachRepositoryImpl
    extends AbstractCrmDomBaseRepository<SysWorkItemAttach, Long>
    implements ISysWorkItemAttachRepository {
    
    public SysWorkItemAttachRepositoryImpl() {
        super(SysWorkItemAttach.class);
    }
    
}

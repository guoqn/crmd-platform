package com.ffcs.crmd.platform.meta.repository.impl;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.BusiObjectAttrValueRel;
import com.ffcs.crmd.platform.meta.repository.IBusiObjectAttrValueRelRepository;
import org.springframework.stereotype.Repository;

@Repository("busiObjectAttrValueRelRepository")
public class BusiObjectAttrValueRelRepositoryImpl
    extends AbstractCrmDomBaseRepository<BusiObjectAttrValueRel, Long>
    implements IBusiObjectAttrValueRelRepository {

    public BusiObjectAttrValueRelRepositoryImpl() {
        super(BusiObjectAttrValueRel.class);
    }

}

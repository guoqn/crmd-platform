package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.RelSpec;
import com.ffcs.crmd.platform.meta.repository.IRelSpecRepository;
import com.ffcs.crmd.platform.meta.service.IRelSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("relSpecService")
public class RelSpecServiceImpl extends AbstractCrmDomGenericService<RelSpec, Long>
    implements IRelSpecService {

    @Autowired
    IRelSpecRepository relSpecRepository;

    @Override
    public PageInfo<RelSpec> qryPageByAObjId(Long busiObjId, int pageNum, int pageSize) {
        return RelSpec.repository().qryPageByAObjId(busiObjId, pageNum, pageSize);
    }

    @Override
    public PageInfo<RelSpec> qryPageByZObjId(Long busiObjId, int pageNum, int pageSize) {
        return RelSpec.repository().qryPageByZObjId(busiObjId, pageNum, pageSize);
    }
}

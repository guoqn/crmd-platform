package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.RelSpec;
import com.ffcs.crmd.platform.meta.repository.IRelSpecRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("relSpecRepository")
public class RelSpecRepositoryImpl extends AbstractCrmDomBaseRepository<RelSpec, Long>
    implements IRelSpecRepository {

    public RelSpecRepositoryImpl() {
        super(RelSpec.class);
    }

    @Override
    public PageInfo<RelSpec> qryPageByAObjId(Long busiObjId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjId);
        return this
            .jdbcFindPageInfoByName("relSpecRepository.qryPageByAObjId", RelSpec.class, params,
                pageNum, pageSize);
    }

    @Override
    public PageInfo<RelSpec> qryPageByZObjId(Long busiObjId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjId);
        return this
            .jdbcFindPageInfoByName("relSpecRepository.qryPageByZObjId", RelSpec.class, params,
                pageNum, pageSize);
    }
}

package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.RelSpecAttr;
import com.ffcs.crmd.platform.meta.repository.IRelSpecAttrRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("relSpecAttrRepository")
public class RelSpecAttrRepositoryImpl extends AbstractCrmDomBaseRepository<RelSpecAttr, Long>
    implements IRelSpecAttrRepository {

    public RelSpecAttrRepositoryImpl() {
        super(RelSpecAttr.class);
    }

    @Override
    public PageInfo<RelSpecAttr> qryPageByRelSpecId(Long relSpecId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(relSpecId);
        return this
            .jdbcFindPageInfoByName("relSpecAttrRepository.qryPageByRelSpecId", RelSpecAttr.class,
                params, pageNum, pageSize);
    }

    @Override
    public PageInfo<RelSpecAttr> qryPageByAttrId(Long attrId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(attrId);
        return this
            .jdbcFindPageInfoByName("relSpecAttrRepository.qryPageByAttrId", RelSpecAttr.class,
                params, pageNum, pageSize);
    }
}

package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.AttrSpec2;
import com.ffcs.crmd.platform.meta.repository.IAttrSpec2Repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("attrSpec2Repository")
public class AttrSpec2RepositoryImpl extends AbstractCrmDomBaseRepository<AttrSpec2, Long>
    implements IAttrSpec2Repository {

    public AttrSpec2RepositoryImpl() {
        super(AttrSpec2.class);
    }

    @Override
    public PageInfo<AttrSpec2> qryAttrSpecPageByTypeId(Long busiTypeId, Long parAttrId, int pageNum,
        int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(busiTypeId);
        params.add(parAttrId);
        return this
            .jdbcFindPageInfoByName("attrSpec2Repository.getAttrSpecByTypeId", AttrSpec2.class,
                params, pageNum, pageSize);
    }
}

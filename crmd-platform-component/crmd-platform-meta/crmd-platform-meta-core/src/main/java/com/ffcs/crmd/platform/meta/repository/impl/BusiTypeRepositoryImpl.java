package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.BusiType;
import com.ffcs.crmd.platform.meta.repository.IBusiTypeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("busiTypeRepository")
public class BusiTypeRepositoryImpl extends AbstractCrmDomBaseRepository<BusiType, Long>
    implements IBusiTypeRepository {

    public BusiTypeRepositoryImpl() {
        super(BusiType.class);
    }

    @Override
    public PageInfo<BusiType> qrySysTypesPageByDomainId(Long domainId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(domainId);
        return this
            .jdbcFindPageInfoByName("busiTypeRepository.qrySysTypesPageByDomainId", BusiType.class,
                params, pageNum, pageSize);
    }

    @Override
    public List<BusiType> qryTypeByNbr(String nbr) {
        List<Object> params = new ArrayList<Object>();
        params.add(nbr);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        List<BusiType> res = this.jdbcFindListByName("busiTypeRepository.qryBusiTypeByNbr", BusiType.class, params);
        return res;
    }
}

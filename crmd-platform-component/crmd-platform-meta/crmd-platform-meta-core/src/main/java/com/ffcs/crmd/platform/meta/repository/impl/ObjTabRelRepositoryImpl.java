package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.ObjTabRel;
import com.ffcs.crmd.platform.meta.repository.IObjTabRelRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("objTabRelRepository")
public class ObjTabRelRepositoryImpl extends AbstractCrmDomBaseRepository<ObjTabRel, Long>
    implements IObjTabRelRepository {

    public ObjTabRelRepositoryImpl() {
        super(ObjTabRel.class);
    }

    @Override
    public PageInfo<ObjTabRel> qryPageByTabId(Long tabId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(tabId);
        return this
            .jdbcFindPageInfoByName("objTabRelRepository.qryPageByTabId", ObjTabRel.class, pageNum,
                pageSize);
    }
}

package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.ObjTabRel;
import com.ffcs.crmd.platform.meta.repository.IObjTabRelRepository;
import com.ffcs.crmd.platform.meta.service.IObjTabRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("objTabRelService")
public class ObjTabRelServiceImpl extends AbstractCrmDomGenericService<ObjTabRel, Long>
    implements IObjTabRelService {

    @Autowired
    IObjTabRelRepository objTabRelRepository;

    @Override
    public PageInfo<ObjTabRel> qryPageByTabId(Long tabId, int pageNum, int pageSize) {
        return ObjTabRel.repository().qryPageByTabId(tabId, pageNum, pageSize);
    }
}

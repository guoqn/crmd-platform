package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttr;
import com.ffcs.crmd.platform.meta.repository.IBusiObjAttrRepository;
import com.ffcs.crmd.platform.meta.service.IBusiObjAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjAttrService")
public class BusiObjAttrServiceImpl extends AbstractCrmDomGenericService<BusiObjAttr, Long>
    implements IBusiObjAttrService {

    @Autowired
    IBusiObjAttrRepository busiObjAttrRepository;

    @Override
    public PageInfo<BusiObjAttr> qryBusiObjAttrPageByObjId(Long busiObjId, int pageNum, int pageSize) {
        return BusiObjAttr.repository().qryBusiObjAttrPageByObjId(busiObjId, pageNum, pageSize);
    }
}

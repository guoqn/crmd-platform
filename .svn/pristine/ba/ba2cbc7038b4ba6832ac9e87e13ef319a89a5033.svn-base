package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttrValue;
import com.ffcs.crmd.platform.meta.repository.IBusiObjAttrValueRepository;
import com.ffcs.crmd.platform.meta.service.IBusiObjAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjAttrValueService")
public class BusiObjAttrValueServiceImpl
    extends AbstractCrmDomGenericService<BusiObjAttrValue, Long>
    implements IBusiObjAttrValueService {

    @Autowired
    IBusiObjAttrValueRepository busiObjAttrValueRepository;

    @Override
    public PageInfo<BusiObjAttrValue> qryBusiObjAttrValPageByBusiObjAttrId(Long busiObjAttrId, int pageNum,
        int pageSize) {
        return BusiObjAttrValue.repository()
            .qryBusiObjAttrValPageByBusiObjAttrId(busiObjAttrId, pageNum, pageSize);
    }
}

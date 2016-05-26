package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.RelSpecAttr;
import com.ffcs.crmd.platform.meta.repository.IRelSpecAttrRepository;
import com.ffcs.crmd.platform.meta.service.IRelSpecAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("relSpecAttrService")
public class RelSpecAttrServiceImpl extends AbstractCrmDomGenericService<RelSpecAttr, Long>
    implements IRelSpecAttrService {

    @Autowired
    IRelSpecAttrRepository relSpecAttrRepository;

    @Override
    public PageInfo<RelSpecAttr> qryPageByRelSpecId(Long relSpecId, int pageNum, int pageSize) {
        return RelSpecAttr.repository().qryPageByRelSpecId(relSpecId, pageNum, pageSize);
    }

    @Override
    public PageInfo<RelSpecAttr> qryPageByAttrId(Long attrId, int pageNum, int pageSize) {
        return RelSpecAttr.repository().qryPageByAttrId(attrId, pageNum, pageSize);
    }
}

package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttr;
import com.ffcs.crmd.platform.meta.entity.ObjTabRel;
import com.ffcs.crmd.platform.meta.repository.IBusiObjAttrRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("busiObjAttrRepository")
public class BusiObjAttrRepositoryImpl extends AbstractCrmDomBaseRepository<BusiObjAttr, Long>
    implements IBusiObjAttrRepository {

    public BusiObjAttrRepositoryImpl() {
        super(BusiObjAttr.class);
    }

    @Override
    public PageInfo<BusiObjAttr> qryBusiObjAttrPageByObjId(Long busiObjId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjId);
        return this.jdbcFindPageInfoByName("busiObjAttrRepository.qryBusiObjAttrPageByObjId", BusiObjAttr.class,
            params, pageNum, pageSize);
    }

    @Override
    public List<BusiObjAttr> queryBusiObjAttrByObjId(Long busiObjId) {
        List<Object> params = new ArrayList<Object>();
        params.add(busiObjId);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        return this.jdbcFindListByName("busiObjAttrRepository.qryBusiObjAttrByObjIdAndStatusCd",BusiObjAttr.class,params);
    }
}
